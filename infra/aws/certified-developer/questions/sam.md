### 1. Which SAM template header indicates it's a SAM template?
A. AWSTemplateFormatVersion
B. Transform: AWS::Serverless-2016-10-31
C. Type: AWS::SAM
D. SAMVersion: 1.0

**Answer:** B
**Explanation:** Transform: AWS::Serverless-2016-10-31 indicates a SAM template.

---

### 2. Which SAM resource type represents a Lambda function?
A. AWS::Lambda::Function
B. AWS::Serverless::Function
C. AWS::SAM::Function
D. AWS::Serverless::Lambda

**Answer:** B
**Explanation:** AWS::Serverless::Function is the SAM resource type for Lambda functions.

---

### 3. Which SAM CLI command deploys a SAM application?
A. sam deploy
B. sam publish
C. sam upload
D. sam create

**Answer:** A
**Explanation:** `sam deploy` packages and deploys SAM applications to AWS.

---

### 4. What does `sam local invoke` do?
A. Deploy to AWS
B. Invoke Lambda function locally
C. Start API Gateway locally
D. Generate events

**Answer:** B
**Explanation:** `sam local invoke` runs a Lambda function locally with a test payload.

---

### 5. Which SAM policy template grants read-only access to S3?
A. S3FullAccessPolicy
B. S3ReadPolicy
C. S3GetObjectPolicy
D. S3AccessPolicy

**Answer:** B
**Explanation:** S3ReadPolicy grants read-only permissions to S3 objects.

---

### 6. Which SAM command starts a local API Gateway endpoint?
A. sam local invoke
B. sam local start-api
C. sam local start-lambda
D. sam local api

**Answer:** B
**Explanation:** `sam local start-api` starts a local HTTP server hosting all functions.

---

### 7. What is the purpose of SAM Accelerate (`sam sync`)?
A. Deploy infrastructure only
B. Synchronize code changes quickly without CloudFormation
C. Delete old versions
D. Run tests

**Answer:** B
**Explanation:** `sam sync --code` synchronizes code changes in seconds, bypassing CloudFormation.

---

### 8. Which SAM feature enables gradual Lambda deployments?
A. AutoPublishAlias + DeploymentPreference
B. Versioning
C. Aliases
D. Layers

**Answer:** A
**Explanation:** AutoPublishAlias with DeploymentPreference enables Canary/Linear deployments via CodeDeploy.

---

### 9. What does `sam local generate-event` do?
A. Deploy events to AWS
B. Generate sample event payloads for testing
C. Create EventBridge rules
D. Monitor events

**Answer:** B
**Explanation:** `sam local generate-event` creates sample payloads (S3, API Gateway, SNS, etc.) for testing.

---

### 10. Which SAM deployment preference shifts 10% traffic, then 100% after 10 minutes?
A. Linear10PercentEvery10Minutes
B. Canary10Percent10Minutes
C. AllAtOnce
D. Gradual10Percent

**Answer:** B
**Explanation:** Canary10Percent10Minutes shifts 10% traffic, waits 10 minutes, then shifts remaining 90%.

---

### 11. Where should SAM policy templates be defined in a SAM template?
A. Policies section under function
B. IAM section
C. Resources section
D. Permissions section

**Answer:** A
**Explanation:** Policies are defined under the function's Policies property.

---

### 12. Which SAM command initializes a new SAM project?
A. sam create
B. sam new
C. sam init
D. sam start

**Answer:** C
**Explanation:** `sam init` creates a new SAM project with templates.

---

### 13. What file contains SAM configuration for multiple environments?
A. config.toml
B. samconfig.toml
C. sam.config
D. environments.yml

**Answer:** B
**Explanation:** samconfig.toml stores configuration for different environments (dev, prod).

---

### 14. Which SAM resource type represents an API Gateway?
A. AWS::ApiGateway::RestApi
B. AWS::Serverless::Api
C. AWS::SAM::Api
D. AWS::Serverless::HttpApi

**Answer:** B
**Explanation:** AWS::Serverless::Api represents an API Gateway REST API in SAM.

---

### 15. What is the purpose of SAM PreTraffic and PostTraffic hooks?
A. Encrypt traffic
B. Validate deployment before and after traffic shift
C. Monitor traffic
D. Route traffic

**Answer:** B
**Explanation:** Hooks run Lambda functions to validate deployment before and after traffic shifting.

---

### 16. Which SAM command packages the application for deployment?
A. sam build
B. sam package
C. sam bundle
D. sam compile

**Answer:** B
**Explanation:** `sam package` (or `sam deploy` which includes packaging) uploads code to S3.

---

### 17. What does `sam sync --watch` do?
A. Monitor CloudWatch logs
B. Automatically sync changes when files are modified
C. Watch for errors
D. Monitor deployments

**Answer:** B
**Explanation:** `sam sync --watch` monitors file changes and automatically synchronizes them.

---

### 18. Which SAM policy template allows polling an SQS queue?
A. SQSReadPolicy
B. SQSPollerPolicy
C. SQSAccessPolicy
D. SQSQueuePolicy

**Answer:** B
**Explanation:** SQSPollerPolicy grants permissions to poll an SQS queue.

---

### 19. What is the purpose of `sam build`?
A. Deploy to AWS
B. Build application and dependencies locally
C. Generate CloudFormation template
D. Start local server

**Answer:** B
**Explanation:** `sam build` builds the application and prepares dependencies for deployment or local testing.

---

### 20. Which SAM resource type represents a DynamoDB table?
A. AWS::DynamoDB::Table
B. AWS::Serverless::SimpleTable
C. AWS::SAM::Table
D. AWS::Serverless::Table

**Answer:** B
**Explanation:** AWS::Serverless::SimpleTable creates a DynamoDB table with a simple schema.

---

### 21. What is the purpose of SAM Connectors?
A. Connect to databases
B. Automatically generate IAM permissions between resources
C. Connect Lambda functions
D. Connect to VPCs

**Answer:** B
**Explanation:** SAM Connectors automatically create IAM permissions for resource-to-resource communication (e.g., Function to Table).

---

### 22. Which SAM feature allows embedding nested applications?
A. AWS::Serverless::Application
B. AWS::Serverless::Nested
C. AWS::SAM::Stack
D. AWS::Serverless::Module

**Answer:** A
**Explanation:** AWS::Serverless::Application embeds nested SAM/CloudFormation applications from SAR or S3.

---

### 23. What does `sam pipeline init` create?
A. New SAM project
B. CI/CD pipeline configuration
C. API Gateway pipeline
D. Lambda pipeline

**Answer:** B
**Explanation:** `sam pipeline init` generates CI/CD pipeline configuration for popular CI/CD tools (GitHub Actions, GitLab, Jenkins).

---

### 24. Which SAM resource type creates an HTTP API (not REST API)?
A. AWS::Serverless::Api
B. AWS::Serverless::HttpApi
C. AWS::Serverless::RestApi
D. AWS::ApiGatewayV2::Api

**Answer:** B
**Explanation:** AWS::Serverless::HttpApi creates an API Gateway HTTP API (lower latency, lower cost than REST API).

---

### 25. How can you pass environment variables to SAM local functions?
A. --env-vars flag with JSON file
B. --environment flag
C. .env file
D. samconfig.toml

**Answer:** A
**Explanation:** Use `sam local invoke --env-vars env.json` to pass environment variables from a JSON file.
