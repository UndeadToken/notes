AWS Serverless: Lambda

- Serverless is a new paradigm in which developers don’t have to manage infrastructure anymore
- They just deploy code
- They just deploy functions
- Initially Serverless meant FaaS (Function as a Service)
- Serverless was pioneered by AWS Lambda but now includes anything that’s managed : databases, messaging, storage.
- Serverless does not mean there are no servers
- It means you don’t manage, provision or see them

Serverless in AWS

- AWS Lambda
- DynamoDB
- AWS Cognito
- AWS API Gateway
- Amazon S3
- AWS SNS & SQS
- AWS Kinesis Data Firehose
- Aurora Serverless
- Step Functions
- Fargate

- Virtual functions 
- no servers to manage
- Limited by time, short executions
- Run on-demand
- Scaling is automated

Easy pricing:
- Pay per request & compute time
- Free tier: 1,000,000 AWS Lambda requests & 400,000 GB Lambda compute time

- Integrated with the whole AWS suite of services
- Integrated with many programming languages
- Easy monitoring through AWS CloudWatch
- Easy to get more resources per functions (up to 10gb of ram)
- Increasing RAM will also improve CPU and network

Lambda container image: the container must implement the lambda runtime api
ECS / Fargate is preferred for running arbitrary docker images

aws.amazon.com/lambda/pricing

Pay per calls:
- First 1,000,000 requests are free then $0.20 per 1,000,000 requests thereafter $0.0000002 per request
- Pay per duration (in increment of 1 ms) 400,000GBs of compute time per month for free
- == 400,000s if function has 1gb of ram

Lambda Synchronous Invocations

- Synchronous: CLI, SDK, API Gateway, Application Load Balancer
    - Results is returned right away
    - Error handling must happen client side (exponential backoff etc…) 

CLI/SDK -> <invoke> -> Lambda 
           <- <response> <-

Client -> <invoke> -> API Gateway -> <proxy> -> Lambda 
                       <- <response> <-  API Gateway <- <response> <-

Lambda - Synchronous invocations - Services

- User Invoked
    - Elastic Load Balancing (ALB)
    - Amazon API Gateway
    - Amazon CloudFront (Lambda@Edge)
    - Amazon S3 Batch
- Services invoked
    - Amazon cognito
    - AWS Step functions
- Other services
    - Amazon lex
    - Amazon Alexa
    - Amazon Kinesis Data Firehose

CLI

Lambda

aws lambda list-functions
aws lambda invoke —function-name hello-world —cli-binary-format raw-in-base64-out —payload ‘{“key”: “value”}’ —region eu-west-2 response.json

Lambda Integration with ALB

- To expose the lambda as an HTTP(S) endpoint…
- You can use the application load balancer or API Gateway
- The lambda function must be registered in a target group

Client -> ALB -> <Invoke sync> Target Group

ALB can support multi-value headers. When you enable multi-value headers. HTTP headers and query string parameters that are sent with multiple values are shown as arrays within the AWS Lambda event and response objects.

Expected and required response format for ALB.
{   “statusCode”: 200,
  “statusDescription”: “200 OK”,
  “isBase64Encoded”: false,
   ”headers”: {        “Content-Type”: “application/json”    },
   “body”: “”
}

Lambda Asynchronous Invocations

- S3, SNS, CloudWatch Events…
- The events are placed in an event queue
- Lambda attempts retries on errors
    - 3 tries in total: 1 minute wait after first, 2 minutes wait after 2nd
- Make sure processing is idempotent in case of retries
- Can define a DLQ, dead letter queue, SNS or SQS for failed processing (need correct IAM permissions)

Works with:

- S3, SNS, EventBridge, CloudWatch Events, CodeCommit, CodePipeline, …

Cloud Watch Events — EventBridge

- CRON or Rate EventBridge Rule
- CodePipeline EventBridge Rule

S3 Event Notifications

- S3:ObjectCreated
- S3:ObjectRemoved
- S3:ObjectRestore
- S3:Replication

- Object name filtering possible (*.jpg)
- S3 event notifications typically deliver in seconds but sometimes can take longer
- If two writes are made to a single non versioned object at the same time it is possible that only a single notification event will be sent
- If you want to ensure that an event notification is sent for every successful write, you can enable versioning on the bucket

e.g.

Event -> S3 -> SNS -> <fanout> SQS, SQS, …

Event -> S3 -> SQS -> Lambda

Event -> S3 -> <async> Lambda -> DLQ (SQS)

Simple S3 Event Pattern - Meta Sync

S3 (new file event) -> Lambda (update metadata table) -> DynamoDB table, table in RDS

Lambda - Event Source Mapping

- Kinesis Data Streams
- SQS & SQS FIFO queue
- DynamoDB streams

- Common denominator: records ned to be polled from the source
- Your lambda function is invoked synchronously

Lambda (Poll) -> Kinesis (Return batch) -> Lambda (Invoke with Event Batch — Event Source Mapping)

Streams & Lambda (Kinesis & DynamoDB)

- An Event Source Mapping creates an iterator for each shard, processes items in order
- Start with new items, from the beginning, or from timestamp
- Processed items aren’t removed from the stream (other consumers can read them)
- Low traffic: use batch window to accumulate records before processing
- You can process multiple batches in parallel
    - Up to 10 batches per shard
    - In-order processing is still guaranteed for each partition key

Streams & Lambda. — Error handling

- By default if your function returns an error the entire batch is reprocessed until the function succeeds or items in the batch expire
- To ensure in-order processing, processing for the affected shard is paused until the error is resolved
- You can configure the event source mapping to:
    - Discard old events
    - Restrict the number of retries
    - Split the batch on error (to work around lambda timeout issues)
- Discarded events can go to a Destination

Lambda Event Source Mapping - SQS & SQS FIFO

- Event Source Mapping will Poll SQS (Long Polling)
- Specify batch size (1-10 messages)
- Recommended: Set the queue visibility timeout to 6x the timeout of your lambda function 
- To use DLQ
    - Setup on the SQS queue, not Lambda, (DLQ for Lambda is only for asynchronous invocations)
    - Or use a lambda destination for failures

Lambda Event Source Mapper Scaling

- Kinesis Data Streams & DynamoDB Streams
    - One Lambda invocation per stream shard
    - If you use paralleization, up to 10 batches processed, per shard simultaneously
- SQS Standard
    - Lambda adds 60 more instances per minute to scale up
    - Up to 1000 batches to be processed simultaneously
- SQS FIFO
    - Messages with the same GroupID will be processed in order
    - The lambda function scales to the number of active group messages

AWSLambdaSQSQueueExecutionRole

Lambda Event & Context Objects

Event Object

- JSON-formatted document contains data for the function to process
- Contains information from the invoking service (e.g. EventBridge, custom, …)
- Lambda runtime converts the event to an object (e.g. dict type in Python)
- Example: input arguments, invoking service arguments, …

Context Object

- Provides methods and properties that provide information about the invocation, function and runtime environment
- Passed to your function by Lambda at runtime
- Example: aws_request_id, function_name, memory_limit_in_mb, …

Lambda — Destinations

- Can configure to send result to a destination
- Asynchronous invocations - can define destinations for successful and Dailed event
    - SQS, SNS, Lambda, EventBridge bus
- Note: AWS recommends to use detonations instead of DLQ now (but both can be used at the same time)
- Event Source Mapping: for discarded event batches
    - SQS, SNS

Lambda Execution Role (IAM Role)

- Grants the Lambda function permissions to AWS services / resources
- Sample managed policies for Lambda:
    - AWSLambdaBasicExecutionRole — Upload logs to CloudWatch
    - AWSLambdaKinesisExecutionRole — Read from Kinesis
    - AWSLambdaDynamoDBExecutionRole — Read from DynamoDB Streams
    - AWSLambdaSQSQueueExecutionRole — Read from SQS
    - AWSLambdaVPCAccessExecutionRole — Deploy Lambda function in VPC
    - AWSXRayDaemonWriteAccess — Upload trace data to X-Ray
- When you use an event source mapping to invoke your function, Lambda uses the execution role to read event data
- Best practice: create one Lambda execution Role per function

Lambda Resource Based Policies

- Use resource-based policies to give other accounts and AWS services permission to use your Lambda resources
- Similar to S3 bucket policies for S3 bucket
- An IAM principle can access Lambda:
    - If the IAM policy attached to the principle authorises it (e.g. user access)
    - OR if the resource-based policy authorises (e.g. service access)
- When an AWS service like Amazon S3 calls your Lambda function, the resource-based policy gives it access

Lambda Environment Variables

- Environment variable = key / value pair in “String”
- Adjust the function behaviour without updating code
- The environment variables are available to your code
- Lambda Service adds its own system environment variables as well

- Helpful to store secrets (encrypted by KMS)
- Secrets can be encrypted by the Lambda service key, or your own CMK

Lambda Logging & Monitoring

- CloudWatch Logs:
    - AWS Lambda execution logs are stored in AWS CloudWatch Logs
    - Make sure your AWS Lambda function has an execution role with an IAM policy that authorises writes to CloudWatch Logs
- CloudWatch Metrics:
    - AWS Lambda metrics are displayed in AWS CloudWatch Metrics
    - Invocations, Durations, Concurrent Executions
    - Error count, Success Rates, Throttles
    - Async Delivery Failures
    - Iterator Age (Kinesis & DynamoDB Streams)

Lambda Tracing with X-Ray

- Enable in Lambda configuration (Active Tracing)
- Runs the X-Ray daemon for you
- Use AWS X-Ray SDK in Code
- Ensure Lambda Function has a correct IAM Execution Role
    - The managed policy is called AWSXRayDaemonWriteAccess
- Environment variables to communicate with X-Ray
    - _X_AMZN_TRACE_ID: contains the tracing header
    - AWS_XRAY_CONTEXT_MISSING: by default, LOG_ERROR
    - AWS_XRAY_DAEMON_ADDRESS: the X-Ray Daemon IP_ADDRESS:PORT

Customisation  At The Edge

- Many modern applications execute some form of the logic at the edge
- Edge Function:
    - A code that you write and attach to CloudFront distributions
    - Runs close to your users to minimise latency
- CloudFront provides two types: CloudFront Functions & Lambda@Edge
- You don’t have to manage any servers, deployed globally
- Use case: customise the CDN content
- Pay only for what you use
- Fully serverless

CloudFront Functions & Lambda@Edge Use Cases

- Website Security and Privacy
- Dynamic Web Application at the Edge
- Search Engine Optimisation (SEO)
- Intelligently Route Across Origins and Data centres
- Bot Mitigation at the Edge
- Real-time Image Transformation
- A/B Testing
- User Authentication and Authorisation
- User Priorization
- User Tracking and Analytics

CloudFront Functions

- Lightweight functions written in JavaScript
- For high-scale, latency-sensitive CDN customisations
- Sub-ms startup times, millions of requests/second
- Used to change Viewer requests and responses
    - Viewer Request: after CloudFront receives a request from a viewer
    - Viewer Response: before CloudFront forwards the response to the viewer
    - Native feature of CloudFront (manage code entirely within CloudFront)

- Cache key normalisation
    - Transform request attributes (headers, cookies, query strings, URL) to create an optimal key
- Header manipulation
    - Insert/modify/delete HTTP headers in the request or response
- URL rewrites or redirects
- Request authentication & Authorisation
    - Create and validate user-generated tokens (e.g. JWT) to allow/deny requests

Lambda@Edge

- Lambda functions written in NodeJS or Python
- Scales to 1000s of requests/second
- Used to change CloudFront requests and responses
    - Viewer Request — after CloudFront receives a request from a viewer
    - Origin Request — before CLoudFront forwards the request to the origin
    - Origin Response — after CloudFront receives the response from the origin
    - Viewer Response — before CloudFront forwards the response to the viewer
- Author your functions in one AWS Region (us-east-1), then CloudFront replicates to its locations

- Longer execution time (several ms)
- Adjustable CPU or memory
- Your code depends on a 3rd libraries (e.g. AWS SDK to access other AWS services)
- Network access to use external services for processing
- File system access or access to the body of HTTP requests

Lambda VPC

Lambda By Default

- By default, your lambda function is launched outside your own VPC (in an AWS-owned VPC)
- Therefore it cannot access resources in your VPC (RDS, ElastiCache, internal ELB…)

Lambda in VPC

- You must define the VPC ID, the Subnets and the Security Groups
- Lambda will create an ENI (Elastic Network Interface) in your subnets
- AWSLambdaVPCAccessExecutionRole
- A Lambda function in your VPC does not have internet access
- Deploying a Lambda function in a public subnet does not give it internet access or public IP 
- Deploying a Lambda function in a private subnet gives it internet access if you have a NAT Gateway / Instance
- You can use VPC endpoints to privately access AWS services without a NAT

(RDS -> Lambda In Private	 Subnet) -> (NAT -> IGW In Public Subnet) -> External API

DynamoDB can be used within a Public subnet (or In AWS Cloud?) or VPC endpoint

Note: Lambda - CloudWatch logs works even without endpoint or NAT Gateway

AWSLambdaENIManagementAccess

Lambda Function Performance

- RAM:
    - From 128MB to 10GB in 1MB increments
    - The more RAM you add, the more vCPU credits you get
    - At 1,792 MB a function has the equivalent of one full vCPU
    - After 1,792 MB, you get more than one CPU, and need to use multi-threading in your code to benefit from it
- If your application is CPU-bound (computation heavy), increase RAM
- Timeout: default 3 seconds, maximum is 900 seconds (15 minutes)

Lambda Execution Context

- The execution is a temporary runtime environment that initialises any external dependencies of your lambda code
- Great for database connections, HTTP clients, SDK clients…
- The execution context is maintained for some time in anticipation of another Lambda function invocation
- The next function invocation can “re-use” the context to execution time and save time in initialising connections objects
- The execution context includes the /tmp directory

Lambda Functions /tmp space

- If your Lambda function needs to download a big file to work…
- If your Lambda function needs disk space to perform operations…
- You can use the /tmp directory
- Max size is 10GB
- The directory content remains when the execution context is frozen, providing transient cache that can be used for multiple invocations (helpful to checkpoint your work)
- For permanent persistence of object use s3
- To encrypt content on /tmp, you must generate KMS Data Keys

Lambda Layers

- Custom Runtimes
    - Ex: C++ https://github.com/awslabs/aws-lambda-cpp
    - Ex: Rust https://github.com/awslabs/aws-lambda-rust-runtime
- Externalise Dependencies to re-use them
- 5 layers per function up to 250mb

Lambda — File Systems Mounting

- Lambda functions can access EFS file systems if they are running in a VPC
- Configure Lambda to mount EFS file systems to local directory during initialisation
- Must leverage EFS Access Points
- Limitations: watch out for the EFS connection limits (one function instance = one connection) and connection burst limits

Lambda Concurrency and Throttling

- Concurrency limit: up to 1000 concurrent executions
- Can set a “reserved concurrency” at the function level (=limit)
- Each invocation over the concurrency limit will trigger a ‘Throttle’
- Throttle Behaviour
    - If synchronous invitation -> return ThrottleError - 249
    - If asynchronous invitation -> retry automatically and then go to DLQ
- If you need a higher limit, open a support ticket
- If you don’t reserve (=limit) concurrency, the following can happen
    - Other functions may get throttled

Concurrency and Asynchronous Invocations

- If the function doesn’t have enough concurrency available to process all events, additional requests are throttled
- For throttling errors (429) and system errors (500-series) Lambda returns the event to the queue and attempts to run the function again for up to 6 hours
- The retry interval increases exponentially from 1 second after the first attempt to a maximum of 5 minutes

Cold Starts & Provisioned Concurrency

- Cold Start:
    - New instance => code is loaded and code outside the handler (init)
    - If the init is large (code, dependencies, SDK…) this process can take some time
    - First request served by new instances has higher latency than the rest
- Provisioned Concurrency:
    - Concurrency is allocated before the function is invoked (in advance)
    - So the cold start never happens and all invocations have low latency
    - Application Auto Scaling can manage concurrency (scheduled or target utilization)
    - Note:
        - Cold starts in VPC have been dramatically reduced in Oct & Nov 2019
        - https://aws.amazon.com/blogs/compute/announcing-improved-vpc-networking-for-aws-lambda-functions/

Lambda Function Dependencies

- If your lambda function depends on external libraries you need to install the package alongside your code and zip it together
- Upload the zip straight to lambda if less than 50mb else to s3 first
- Native libraries work: they need to be compiled on Amazon Linux
- AWS sdk comes by default with every lambda function

Lambda and Cloud Formation

Inline

- Inline functions are very simple
- Use the Code.ZipFile property
- You cannot include function dependencies with inline functions

AWSTemplateFormatVersion: ‘2010-09-09’
Description: Lambda function inline
Resources:
	primer:
		Type: AWS::Lambda::Function
		Properties:
			Runtime: python3.x
			Role: arn:aws:iam:123456789012:role/lambda-role
			Handler: index.handler
			Code:
				ZipFile: |
					def handler(event, context):
						return {…}

S3

- You must store the Lambda zip in S3
- You must refer the S3 zip location in the CloudFormation code
    - S3Bucket
    - S3Key: full path to zip
    - S3ObjectVersion: if versioned bucket
- If you update the code in S3, but don’t update S3Bucket, S3Key or S3ObjectVersion CloudFormation won’t update your function

AWSTemplateFormatVersion: ‘2010-09-09’
Description: Lambda function S3
Resources:
	primer:
		Type: AWS::Lambda::Function
		Properties:
			Runtime: nodejs12.x
			Role: arn:aws:iam:123456789012:role/lambda-role
			Handler: index.handler
			Code:
				S3Bucket: my-bucket
				S3Key: function.zip
				S3ObjectVersion: String

Lambda Container Images

- Deploy Lambda function as container images of up to 10GB from ECR
- Pack complex dependencies, large dependencies in a container
- Base images are available for Python, Node.js, Java, .NET, Go, Ruby
- Can create your own image as long as it implements the Lambda Runtime API
- Test the containers locally using the Lambda Runtime Interface Emulator
- Unified workflow to build apps

FROM amazon/aws-lambda-nodejs:12

COPY app.js package*.json ./

RUN nom install

CMD [ ”app.lambdaHandler” ]

- Strategies for optimising container images:
    - Use AWS-provided Base Images
        - Stable, Built on Amazon Linux 2, cached by Lambda service
    - Use Multi-Stage Builds
        - Build your code in larger preliminary images, copy only the artefacts you need in your final container image, discard the preliminary steps
    - Build from Stable to Frequently Changing
        - Make your most frequently occurring changes as late in your Dockerfile as possible
    - Use Single Repository for Functions with Large Layers
        - ECR compares each layer of a container image when it is pushed to avoid upload and storing duplicates
    - Use them to upload Large Lambda Functions (up to 10GB)

AWS Lambda Versions

- When you work on a Lambda function, we work on $LATEST
- When we’re ready to publish a Lambda function, we create a version
- Versions are immutable
- Versions have increasing version numbers
- Versions get their own ARN (Amazon Resource Name)
- Version = code + configuration (nothing can be changed — immutable)
- Each version of the lambda function can be accessed

AWS Lambda Aliases

- Aliases are “pointers” to Lambda function versions
- We can define a “dev”, “test”, “prod” aliases and have them point at different lambda versions
- Aliases are mutable
- Aliases enable canary deployment by assigning weights to lambda functions (95% to v1, 5% to v2)
- Aliases enable stable configuration of our event triggers . Destinations
- Aliases have their own ARN
- Aliases cannot reference aliases

Lambda & CodeDeploy

- CodeDeploy can help you automate traffic for Lambda aliases
- Feature is integrated within the SAM framework
- Linear: grow traffic every N minutes until 100%
    - Linear10PercentEvery3Minutes
    - Linear10PercentEvery10Minutes
- Canary: try X percent then 100%
    - Canary10Percent5Minutes
    - Canary10Percent30Minutes
- AllAtOnce: immediate
- Can create Pre & Post Traffic hooks to check the health of the Lambda function

AppSpec.yml

Version: 0.0

Resources:
	- myLambdaFunction:
		Type: AWS::Lambda::Function
		Properties: 
			Name: myLambdaFunction
			Alias: myLambdaFunctionAlias
			CurrentVersion: 1
			TargetVersion: 2

- Name: the name of the lambda function to deploy
- Alias: the name of the alias to the Lambda function
- CurrentVersion: the version of the Lambda function traffic currently points to
- TargetVersion: the version of the Lambda function traffic is shifted to

Lambda Function URL

- Dedicated HTTP(s) endpoint for your Lambda function
- A unique URL endpoint is generate for you (never changes)
    - https://<url-id>.lambda-url.<region>.on.aws (dual-stack IPv4 & IPv6)
- Supports Resource-based Policies & CORS configurations
- Can be applied to any function alias or to $LATEST (can’t be applied to other function versions)
- Create and Configure using AWS Console or AWS API


Lambda Function URL Security

- Resource-based Policy
    - Authorise other accounts / specific CIDR / IAM principles
- Cross-Origin Resource Sharing (CORS)
    - If you call your Lambda function URL from a different domain
- AuthType NONE — allow public and unauthenticated access
    - Resource-based Policy is always in effect (must grant public access)

Resource Based Policy:

{
  Version: 2012-10-17,
  Statement: [
    {
      Effect: Allow,
     Principle: *
     Action: lambda:InvokeFunctionUrl,
     Resource: function-are…
     Condition: {         StringEquals: {             lambda:FunctionUrlAuthType: NONE } }
    }
]
}

Identity based policy:


{
  Version: 2012-10-17,
  Statement: [
    {
      Effect: Allow,
     Action: lambda:InvokeFunctionUrl,
     Resource: function-are… }
    }
]
}

- AuthType AWS_IAM is used to authenticate and authorise requests
    - Both Principles identity-based Policy & Resource based policy are evaluated
    - Principles must have lambda:InvokeFunctionUrl permissions
    - Same account — identity-based policy OR resource-based policy as ALLOW
    - Cross-account identity-based policy AND resource based policy as ALLOW

Lambda CodeGuru Profiling

- Gain insights into runtime performance of your Lambda functions using CodeGuru Profiler
- CodeGuru creates a Profiler Group for your Lambda function
- Supported for Java and Python runtimes
- Activated form AWS Lambda Console
- When activated, Lambda adds:
    - CodeGuru Profiler layer to your function
    - Environment variables to your function
    - AmazonCodeGuruProfilderAgentAccess policy to your function

Lambda Limits (per region)

- Execution
    - Memory allocation: 128MB — 10GB (1MB increments)
    - Maximum execution time: 900 seconds (15 minutes)
    - Environment variables 94kb)
    - Disk capacity in the “function container” in (/tmp): 512mb to 10gb
    - Concurrency executions: 1000 (can be increased)
- Deployment:
    - Lambda function deployment size (compressed .zip): 50MB
    - Size of uncompressed deployment (code + dependencies): 250MB
    - Can use the /tmp directory to load other files at startup
    - Size of environment variables: 4KB

AWS Lambda Best Practices

- Perform heavy-duty work outside of your function handler
    - Connect to database outside your function handler
    - Initialise the AWS SDK outside of your function handler
    - Pull in dependencies or datasets outside of your function handler
- Use environment variables for:
    - Database connection strings, s3 bucket, etc… 
    - Passwords, sensitive values can be encrypted with KMS
- Minimise your deployment package size to its runtime necessities
    - Break down the function if need be
    - Remember the AWS Lambda limits
    - Use Layers where necessary
- Avoid using recursive code, never have a Lambda function call itself
	
