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
