### 1. What is the maximum execution timeout for an AWS Lambda function?
A. 5 minutes
B. 10 minutes
C. 15 minutes
D. 30 minutes

**Answer:** C
**Explanation:** Lambda functions have a maximum timeout of 900 seconds (15 minutes).

---

### 2. A Lambda function needs to access resources in a private VPC subnet. What must be configured?
A. Lambda Layers
B. VPC configuration with subnets and security groups
C. Reserved Concurrency
D. Provisioned Concurrency

**Answer:** B
**Explanation:** Lambda creates ENIs in specified subnets to access VPC resources. Requires subnet IDs and security group IDs.

---

### 3. Which invocation type should be used when a client needs an immediate response from Lambda?
A. Asynchronous
B. Event Source Mapping
C. Synchronous
D. Scheduled

**Answer:** C
**Explanation:** Synchronous invocation returns results immediately (CLI, SDK, API Gateway, ALB).

---

### 4. A Lambda function is invoked by S3 events. On failure, how many times does Lambda retry by default?
A. 0 (no retry)
B. 2 times
C. 3 times
D. Unlimited until success

**Answer:** B
**Explanation:** Asynchronous invocations retry twice on failure (3 total attempts).

---

### 5. What is the maximum RAM allocation for a Lambda function?
A. 3 GB
B. 5 GB
C. 10 GB
D. 15 GB

**Answer:** C
**Explanation:** Lambda supports RAM from 128 MB to 10,240 MB (10 GB). CPU scales proportionally with RAM.

---

### 6. A Lambda function needs to share common dependencies with other functions. What is the best approach?
A. Include dependencies in each function's deployment package
B. Use Lambda Layers
C. Use environment variables
D. Use EFS mount

**Answer:** B
**Explanation:** Lambda Layers allow sharing code/dependencies across functions (max 5 layers, 250 MB each).

---

### 7. Which service provides temporary storage for Lambda functions that persists across invocations?
A. EBS volumes
B. S3 buckets
C. /tmp directory
D. Lambda Layers

**Answer:** C
**Explanation:** /tmp directory provides 10 GB ephemeral storage that persists across invocations in the same execution context.

---

### 8. A Lambda function experiences cold starts. Which feature pre-initializes execution environments?
A. Reserved Concurrency
B. Provisioned Concurrency
C. Lambda Layers
D. Async invocation

**Answer:** B
**Explanation:** Provisioned Concurrency keeps execution environments warm to eliminate cold starts.

---

### 9. What is the default concurrency limit for Lambda functions per region?
A. 100
B. 500
C. 1,000
D. 10,000

**Answer:** C
**Explanation:** Default account-level concurrency limit is 1,000 per region (can be increased).

---

### 10. A Lambda function needs to read secrets from AWS Secrets Manager. What IAM permission is required?
A. lambda:GetSecret
B. secretsmanager:GetSecretValue
C. kms:Decrypt
D. ssm:GetParameter

**Answer:** B
**Explanation:** secretsmanager:GetSecretValue permission is required in the Lambda execution role.

---

### 11. Which Lambda feature allows routing traffic between two versions for canary deployments?
A. Versions
B. Aliases
C. Layers
D. Environment variables

**Answer:** B
**Explanation:** Aliases can route traffic between versions (e.g., 90% to v1, 10% to v2) for canary deployments.

---

### 12. A Lambda function URL is created with AuthType set to NONE. Who can invoke it?
A. Only IAM users
B. Only users with API keys
C. Anyone with the URL (public)
D. Only resources in the same VPC

**Answer:** C
**Explanation:** AuthType NONE makes the function URL publicly accessible without authentication.

---

### 13. Which AWS service can Lambda NOT directly integrate with as an event source?
A. DynamoDB Streams
B. Kinesis Data Streams
C. RDS database
D. SQS

**Answer:** C
**Explanation:** Lambda cannot directly subscribe to RDS events. Use EventBridge or SNS for RDS notifications.

---

### 14. What happens when a Lambda function in a VPC needs internet access?
A. It automatically has internet access
B. Requires NAT Gateway in a public subnet
C. Requires Internet Gateway attached to the VPC
D. Not possible for VPC Lambda functions

**Answer:** B
**Explanation:** Lambda in private subnet needs NAT Gateway (or VPC endpoints) for internet/AWS service access.

---

### 15. Which environment variable contains the AWS request ID for a Lambda invocation?
A. AWS_LAMBDA_REQUEST_ID
B. AWS_REQUEST_ID
C. LAMBDA_REQUEST_ID
D. Available via context object, not environment variable

**Answer:** D
**Explanation:** Request ID is available via the context object (context.aws_request_id), not as an environment variable.

---

### 16. A Lambda function processes messages from an SQS queue. What happens if the function fails?
A. Message is immediately deleted
B. Message returns to queue after visibility timeout
C. Message is sent to DLQ immediately
D. Lambda retries indefinitely

**Answer:** B
**Explanation:** Failed messages return to the queue after visibility timeout for retry.

---

### 17. Which deployment type gradually shifts traffic from old to new Lambda version over time?
A. AllAtOnce
B. Canary
C. Linear
D. Blue/Green

**Answer:** C
**Explanation:** Linear deployment gradually shifts traffic (e.g., Linear10PercentEvery3Minutes).

---

### 18. What is the maximum size of a Lambda deployment package (zipped)?
A. 10 MB
B. 50 MB
C. 250 MB
D. 500 MB

**Answer:** B
**Explanation:** Direct upload limit is 50 MB zipped. Use S3 for larger packages (up to 250 MB unzipped).

---

### 19. A Lambda function needs to be invoked every hour. Which service should trigger it?
A. CloudWatch Events (EventBridge)
B. SNS
C. SQS
D. Step Functions

**Answer:** A
**Explanation:** EventBridge (CloudWatch Events) supports scheduled/cron expressions for periodic Lambda invocations.

---

### 20. Which Lambda runtime environment variable specifies the handler function?
A. LAMBDA_HANDLER
B. _HANDLER
C. FUNCTION_HANDLER
D. AWS_LAMBDA_FUNCTION_HANDLER

**Answer:** B
**Explanation:** _HANDLER environment variable contains the handler location (e.g., index.handler).

---

### 21. What is Lambda@Edge primarily used for?
A. Running Lambda in private VPCs
B. Running Lambda functions at CloudFront edge locations
C. Connecting Lambda to RDS databases
D. Deploying Lambda across multiple regions

**Answer:** B
**Explanation:** Lambda@Edge runs Lambda functions at CloudFront edge locations to customize content delivery with low latency.

---

### 22. Which Lambda feature reduces cold start times for Java functions?
A. Provisioned Concurrency
B. Lambda SnapStart
C. Lambda Layers
D. Reserved Concurrency

**Answer:** B
**Explanation:** Lambda SnapStart (for Java 11+) takes a snapshot of initialized execution environment and reuses it to reduce cold starts by up to 10x.

---

### 23. What happens to a Lambda function version once published?
A. It can be modified
B. It becomes immutable
C. It expires after 30 days
D. It requires redeployment

**Answer:** B
**Explanation:** Published Lambda versions are immutable. Code and configuration cannot be changed. Use $LATEST for development.

---

### 24. A Lambda function fails asynchronously. Where can failed events be sent for debugging?
A. CloudWatch Logs only
B. Dead Letter Queue (SQS or SNS)
C. S3 bucket
D. DynamoDB table

**Answer:** B
**Explanation:** Configure a Dead Letter Queue (DLQ) using SQS or SNS to capture failed asynchronous invocation events after all retries are exhausted.

---

### 25. What are Lambda Extensions used for?
A. Adding more memory to functions
B. Integrating with monitoring, security, and governance tools
C. Extending execution timeout beyond 15 minutes
D. Running multiple functions simultaneously

**Answer:** B
**Explanation:** Lambda Extensions allow integration with monitoring, observability, security, and governance tools without modifying function code. They run in the execution environment.

---

### 26. What is the maximum payload size for synchronous Lambda invocations?
A. 256 KB
B. 6 MB
C. 10 MB
D. 256 MB

**Answer:** B
**Explanation:** Synchronous invocations support up to 6 MB payload (request and response combined).

---

### 27. Which Lambda feature automatically retries failed asynchronous invocations?
A. DLQ
B. Built-in retry with exponential backoff (2 retries)
C. Destinations
D. Event Source Mappings

**Answer:** B
**Explanation:** Lambda automatically retries failed asynchronous invocations twice with exponential backoff before sending to DLQ or Destination.

---

### 28. What is the maximum number of concurrent executions for Lambda per region by default?
A. 100
B. 500
C. 1,000
D. 10,000

**Answer:** C
**Explanation:** Default concurrent execution limit is 1,000 per region (soft limit, can be increased).

---

### 29. Which Lambda runtime environment variable contains the function name?
A. LAMBDA_FUNCTION_NAME
B. AWS_LAMBDA_FUNCTION_NAME
C. FUNCTION_NAME
D. _FUNCTION_NAME

**Answer:** B
**Explanation:** AWS_LAMBDA_FUNCTION_NAME environment variable contains the function name.

---

### 30. What is the purpose of Lambda Reserved Concurrency?
A. Reserve memory
B. Guarantee available concurrency and limit maximum concurrency
C. Reserve CPU
D. Reserve storage

**Answer:** B
**Explanation:** Reserved Concurrency guarantees a specific number of concurrent executions and sets a maximum limit.

---

### 31. Which Lambda invocation type is used by S3 event notifications?
A. Synchronous
B. Asynchronous
C. Event Source Mapping
D. Scheduled

**Answer:** B
**Explanation:** S3 event notifications invoke Lambda asynchronously.

---

### 32. What is the maximum execution time for Lambda functions in VPC?
A. 5 minutes
B. 15 minutes
C. Same as non-VPC (15 minutes)
D. 30 minutes

**Answer:** C
**Explanation:** Lambda functions in VPC have the same 15-minute maximum execution time as non-VPC functions.

---

### 33. Which Lambda feature routes failed events to a destination after retries?
A. DLQ only
B. Lambda Destinations (SQS, SNS, Lambda, EventBridge)
C. CloudWatch Logs
D. S3

**Answer:** B
**Explanation:** Lambda Destinations can route success/failure events to SQS, SNS, Lambda, or EventBridge (more flexible than DLQ).

---

### 34. What is the purpose of Lambda function versions?
A. Track code changes
B. Create immutable snapshots of function code and configuration
C. Increase performance
D. Reduce costs

**Answer:** B
**Explanation:** Versions are immutable snapshots of function code, configuration, and dependencies.

---

### 35. Which Lambda event source supports batch window for aggregating records?
A. S3
B. Kinesis Data Streams
C. API Gateway
D. CloudWatch Events

**Answer:** B
**Explanation:** Kinesis and DynamoDB Streams support batch window to aggregate records before invoking Lambda.

---

### 36. What is the maximum size of Lambda deployment package (unzipped)?
A. 50 MB
B. 100 MB
C. 250 MB
D. 500 MB

**Answer:** C
**Explanation:** Unzipped deployment package (code + dependencies) can be up to 250 MB.

---

### 37. Which Lambda feature allows running functions from container images?
A. Lambda Layers
B. Lambda Container Image Support
C. Docker Lambda
D. ECS Lambda

**Answer:** B
**Explanation:** Lambda supports deploying functions as container images up to 10 GB from ECR.

---

### 38. What is the purpose of Lambda function aliases?
A. Create function shortcuts
B. Point to specific versions and enable traffic shifting
C. Rename functions
D. Group functions

**Answer:** B
**Explanation:** Aliases point to specific versions and support weighted traffic shifting for canary deployments.

---

### 39. Which Lambda runtime provides the fastest cold start?
A. Python
B. Node.js
C. Java
D. .NET

**Answer:** B
**Explanation:** Node.js and Python generally have faster cold starts than Java and .NET due to smaller runtime overhead.

---

### 40. What is the maximum number of layers per Lambda function?
A. 3
B. 5
C. 10
D. 15

**Answer:** B
**Explanation:** Lambda functions can use up to 5 layers, with total unzipped size limit of 250 MB.

---

### 41. Which Lambda event source mapping feature processes records in order?
A. FIFO SQS queues
B. Standard SQS queues
C. S3 events
D. SNS topics

**Answer:** A
**Explanation:** FIFO SQS queues with Lambda maintain message ordering within message groups.

---

### 42. What is the purpose of Lambda SnapStart?
A. Start functions faster
B. Reduce cold start latency for Java functions using snapshots
C. Take snapshots of data
D. Start multiple functions

**Answer:** B
**Explanation:** SnapStart reduces cold start latency for Java 11+ by taking snapshots of initialized execution environments.

---

### 43. Which Lambda metric indicates throttling?
A. Errors
B. Throttles
C. ConcurrentExecutions
D. Duration

**Answer:** B
**Explanation:** The Throttles metric shows the number of invocation attempts that were throttled due to concurrency limits.

---

### 44. What happens when a Lambda function exceeds its timeout?
A. Function continues running
B. Function is terminated and returns timeout error
C. Function is retried automatically
D. Function enters pending state

**Answer:** B
**Explanation:** Lambda terminates the function and returns a timeout error when execution exceeds the configured timeout.

---

### 45. Which Lambda feature allows sharing code across functions?
A. Aliases
B. Versions
C. Layers
D. Extensions

**Answer:** C
**Explanation:** Lambda Layers allow sharing libraries, custom runtimes, and dependencies across multiple functions.

---

### 46. What is the maximum memory allocation for Lambda functions?
A. 3 GB
B. 5 GB
C. 10 GB
D. 15 GB

**Answer:** C
**Explanation:** Lambda supports memory allocation from 128 MB to 10,240 MB (10 GB). CPU scales proportionally.

---

### 47. Which Lambda invocation mode processes DynamoDB Stream records?
A. Synchronous
B. Asynchronous
C. Event Source Mapping (poll-based)
D. Scheduled

**Answer:** C
**Explanation:** DynamoDB Streams use event source mapping where Lambda polls the stream for records.

---

### 48. What is the purpose of Lambda function concurrency metrics?
A. Monitor errors
B. Track concurrent executions and identify throttling
C. Monitor duration
D. Track invocations

**Answer:** B
**Explanation:** Concurrency metrics (ConcurrentExecutions, UnreservedConcurrentExecutions) help track usage and identify throttling.

---

### 49. Which Lambda feature allows custom runtime implementations?
A. Lambda Layers with custom runtime
B. Container images
C. Both A and B
D. Not supported

**Answer:** C
**Explanation:** Custom runtimes can be implemented using Lambda Layers or container images.

---

### 50. What is the maximum timeout for Lambda@Edge functions?
A. 5 seconds (viewer triggers)
B. 30 seconds (origin triggers)
C. Both A and B depending on trigger
D. 15 minutes

**Answer:** C
**Explanation:** Lambda@Edge has different timeouts: 5 seconds for viewer request/response, 30 seconds for origin request/response.

