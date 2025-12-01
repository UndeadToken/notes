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

---

### 26. What is the maximum number of functions in a SAM template?
A. 10
B. 50
C. 100
D. No limit (CloudFormation 500 resource limit applies)

**Answer:** D
**Explanation:** SAM templates are CloudFormation templates, so the 500 resource limit applies.

---

### 27. Which SAM policy template grants DynamoDB read access?
A. DynamoDBReadPolicy
B. DynamoDBCrudPolicy
C. DynamoDBStreamReadPolicy
D. Both A and C

**Answer:** A
**Explanation:** DynamoDBReadPolicy grants read-only access to DynamoDB tables.

---

### 28. What is the purpose of SAM Accelerate?
A. Accelerate builds
B. Sync local changes to AWS in seconds for faster development
C. Accelerate deployments
D. Accelerate tests

**Answer:** B
**Explanation:** SAM Accelerate (`sam sync`) syncs local code changes to AWS in seconds without full deployments.

---

### 29. Which SAM command validates the template?
A. sam check
B. sam validate
C. sam test
D. sam verify

**Answer:** B
**Explanation:** `sam validate` validates SAM template syntax and structure.

---

### 30. What is the maximum timeout for SAM local API?
A. 30 seconds
B. 5 minutes
C. 15 minutes
D. No timeout (runs locally)

**Answer:** D
**Explanation:** SAM local runs on your machine without AWS Lambda's timeout constraints.

---

### 31. Which SAM resource creates an EventBridge rule?
A. AWS::Serverless::EventRule
B. AWS::Serverless::Rule
C. AWS::Events::Rule
D. AWS::Serverless::EventBridgeRule

**Answer:** C
**Explanation:** Use standard CloudFormation AWS::Events::Rule resource in SAM templates.

---

### 32. What is the purpose of SAM build --use-container?
A. Build in Docker container
B. Build Lambda functions in Docker matching Lambda runtime environment
C. Deploy to containers
D. Test containers

**Answer:** B
**Explanation:** --use-container builds functions in Docker containers matching Lambda runtime for consistent dependencies.

---

### 33. Which SAM policy template grants S3 read/write access?
A. S3ReadPolicy
B. S3WritePolicy
C. S3CrudPolicy
D. S3FullAccessPolicy

**Answer:** C
**Explanation:** S3CrudPolicy grants read and write access to S3 buckets.

---

### 34. What is the maximum number of layers per SAM function?
A. 3
B. 5
C. 10
D. 15

**Answer:** B
**Explanation:** Lambda functions (including SAM) support up to 5 layers.

---

### 35. Which SAM command deploys guided mode?
A. sam deploy
B. sam deploy --guided
C. sam deploy --interactive
D. sam deploy --wizard

**Answer:** B
**Explanation:** `sam deploy --guided` walks through deployment configuration interactively.

---

### 36. What is the purpose of SAM template Globals section?
A. Define global variables
B. Define properties shared across all functions/APIs
C. Global configuration
D. Environment variables

**Answer:** B
**Explanation:** Globals section defines properties (timeout, memory, environment) shared across all serverless resources.

---

### 37. Which SAM local command starts API Gateway locally?
A. sam local api
B. sam local start-api
C. sam api start
D. sam start api

**Answer:** B
**Explanation:** `sam local start-api` starts API Gateway locally for testing.

---

### 38. What is the maximum deployment package size for SAM?
A. 50 MB (zipped)
B. 250 MB (unzipped)
C. Same as Lambda limits
D. 1 GB

**Answer:** C
**Explanation:** SAM uses Lambda, so same limits apply: 50 MB zipped, 250 MB unzipped.

---

### 39. Which SAM feature generates CI/CD pipelines?
A. SAM Pipelines
B. SAM Deploy
C. SAM Build
D. SAM Accelerate

**Answer:** A
**Explanation:** `sam pipeline init` generates CI/CD pipeline configurations for various providers.

---

### 40. What is the purpose of SAM template Parameters?
A. Pass values at deployment time
B. Configure functions
C. Define resources
D. Set environment variables

**Answer:** A
**Explanation:** Parameters allow passing values (like environment names) at deployment time.

---

### 41. Which SAM command deletes a stack?
A. sam remove
B. sam delete
C. sam destroy
D. Both A and B

**Answer:** D
**Explanation:** Both `sam delete` and `sam remove` delete CloudFormation stacks.

---

### 42. What is the maximum number of event sources per SAM function?
A. 1
B. 5
C. 10
D. Unlimited

**Answer:** D
**Explanation:** SAM functions can have multiple event sources (API, S3, DynamoDB, etc.).

---

### 43. Which SAM policy template grants Lambda invoke permissions?
A. LambdaInvokePolicy
B. LambdaExecutionPolicy
C. InvokeFunctionPolicy
D. FunctionInvokePolicy

**Answer:** A
**Explanation:** LambdaInvokePolicy grants permission to invoke Lambda functions.

---

### 44. What is the purpose of SAM local start-lambda?
A. Start Lambda locally
B. Start Lambda endpoint for AWS SDK/CLI testing
C. Start Lambda functions
D. Debug Lambda

**Answer:** B
**Explanation:** `sam local start-lambda` starts a local endpoint that emulates Lambda for SDK/CLI testing.

---

### 45. Which SAM template section defines outputs?
A. Exports
B. Outputs
C. Returns
D. Results

**Answer:** B
**Explanation:** Outputs section defines values to export from the stack.

---

### 46. What is the maximum number of SAM Connectors per resource?
A. 1
B. 5
C. 10
D. Unlimited

**Answer:** D
**Explanation:** Resources can have multiple SAM Connectors to different resources.

---

### 47. Which SAM command shows deployment logs?
A. sam logs
B. sam tail
C. sam logs --tail
D. Both A and C

**Answer:** D
**Explanation:** `sam logs` shows logs, `--tail` follows them in real-time.

---

### 48. What is the purpose of SAM template Metadata?
A. Store metadata
B. Configure SAM CLI behavior and documentation
C. Tag resources
D. Version control

**Answer:** B
**Explanation:** Metadata section configures SAM CLI behavior (like build settings) and adds documentation.

---

### 49. Which SAM event source type triggers on S3 events?
A. S3Event
B. S3
C. Both A and B
D. S3Trigger

**Answer:** B
**Explanation:** Use `S3` event source type for S3 event notifications.

---

### 50. What is the purpose of SAM template Conditions?
A. Conditional logic
B. Control resource creation based on parameters
C. Error handling
D. Validation

**Answer:** B
**Explanation:** Conditions control whether resources are created based on parameter values or other conditions.

