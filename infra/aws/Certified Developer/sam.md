SAM Serverless Application Model

- SAM = Serverless Application Model
- Framework for developing and deploying serverless applications
- All the configuration is YAML code
- Generate complex CloudFormation from simple SAM YAML file
- Supports anything from CloudFormation: Outputs, Mappings, Parameters, Resources…
- SAM can use CodeDeploy to deploy Lambda functions
- SAM can help you to run Lambda, API Gateway, DynamoDB locally

SAM — Recipe

- Transform Header indicates it’s SAM template
    - Transform: ‘AWS::Serverless-2016-10-31’
- Write code:
    - AWS::Serverless::Function
    - AWS::Serverless::Api
    - AWS::Serverless::SimpleTable
- Package & Deploy: sam deploy (optionally preceded by “sam package”)
- Quickly sync local changes to AWS Lambda (SAM Accelerate): sam sync —watch

SAM Template -> CloudFormation Template -> S3 -> CloudFormation

SAM Accelerate

- SAM Accelerate is a set of features to reduce latency while deploying resources to AWS
- Sam sync
    - synchronizes your project declared in SAM templates to AWS
    - Synchronizes code changes to AWS without updating infrastructure (uses service APIs & bypass CloudFormation)

- sam sync (no options)
    - Synchronise code and infrastructure
- sam sync —code
    - Synchronize code changes without update infrastructure (bypass CloudFormation, update in seconds)
- sam sync —code —resource AWS::Serverless::Function
    - Synchronise only. All Lambda functions and their dependencies
- sam sync —code —resource-id HelloWorldLambdaFunction
    - Syncrhonize only a specific resource by its id
- sam sync —watch
    - Monitor for file changes and automatically synchonize when changes are detected
    - If changes include configuration, it uses sam sync
    - If changes are code only, it uses sam sync —code

Initialise a project

sam init

src/
	app.py

template.yaml
commands.sh

aws s3 mb s3 ://foo-bar
aws cloudformation package —s3-bucket foo-bar —template-file template.yaml —output-tempalte-file gen/template-generated.yaml

sam package ^same

aws cloudformation deploy —template-file gen/template-generated.yaml —stack-name hello-world-lambda --capabilities CAPABILITY_IAM

SAM Policy Templates

- List of templates to apply permissions to your Lambda Functions
- Important examples:
    - S3ReadPolicy: Gives read only permissions to objects in S3
    - SQSPollerPolicy Allows to poll an SQS queue
    - DynamoDBCrudPolicy: CRUD = create read update delete

https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-policy-templates.html#serverless-policy-template-table

Policies:
	- SQSPollerPolicy:
		QueueName:
			!GetAtt MyQueue.QueueName

SAM 

- SAM framework natively uses CodeDeploy to update Lambda functions
- Traffic Shifting feature
- Pre and Post traffic hooks features to validate deployment (before the traffic shift starts and after it ends)
- Easy & automated rollback using CloudWatch Alarms

AutoPublishAlias: live
DepoloymentPreference:
	Canary10Percent10Minutes
Alarms:
	- !Ref AliasErrorMetricGreaterThanZeroAlarm
	- !Ref LatestVersionErrorMetricGreaterThanZeroAlarm
Hooks:
	PreTraffic: !Ref PreTrafficLambdaFunction
	PostTraffic: !Ref PostTrafficLambdaFunction

- AutoPublishAlias
    - Detects when new code is being deployed
    - Create and publishes an updated version of that function with the latest code
    - Points the alias to the updated version of the Lambda function
- DeploymentPreference
    - Canary, Linear, AllAtOnce
- Alarms
    - Alarms that can trigger a rollback
- Hooks
    - Pre and post traffic shifting Lambda functions to test your deployment

sam init —runtime python3.7

Local Capabilities

- Locally start AWS Lambda
    - sam local start-lambda
    - Starts a local endpoint that emulates this local endpoint
    - Can run automated tests against this endpoint
- Locally invoke Lambda function
    - sam local invoke
    - Invoke Lambda function with payload once and quit after invocation completes
    - Helpful for generating test cases
    - If the function make API calls to AWS make sure you are using the correct —profile option
- Locally start an API Gateway Endpoint
    - sam local start-api
    - Starts a local HTTO server that hosts all your functions
    - Changes to functions are automatically reloaded
- Generate AWS Events for Lambda Functions
    - sam local generate-event
    - Generate sample payloads for event sources
    - S3, API Gateway, SNS, Kinesis, DynamoDB…

sam local generate-event s3 put —bucket <bucket> —key <key> \
sam local invoke -e <function id> 

Multiple Environments

samconfig.toml

[dev.deploy.parameters]
stack_name = "my-dev-stack”
s3_bucket = ""
s3_prefix = ""
region = "us-east-1”
capabilities  = "CAPABILITY_IAM”
parameter_overrides = "Environment=Development”

[dev.sync.parameters]
Watch = true

[prod.deploy.parameters]
…

sam deploy —config-env dev

FOO
