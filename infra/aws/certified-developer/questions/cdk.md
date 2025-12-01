### 1. Which programming languages does AWS CDK support?
A. Python only
B. TypeScript, Python, Java, C#, Go
C. JavaScript only
D. Ruby and PHP

**Answer:** B
**Explanation:** CDK supports TypeScript, Python, Java, C#, and Go.

---

### 2. What does CDK compile into?
A. Lambda functions
B. CloudFormation templates
C. Docker images
D. Terraform files

**Answer:** B
**Explanation:** CDK code compiles into CloudFormation templates (JSON/YAML).

---

### 3. Which CDK command generates CloudFormation template?
A. cdk deploy
B. cdk synth
C. cdk compile
D. cdk generate

**Answer:** B
**Explanation:** `cdk synth` synthesizes CDK app into CloudFormation template.

---

### 4. What is the purpose of CDK Bootstrapping?
A. Start application
B. Provision resources (S3 bucket, IAM roles) for CDK deployments
C. Install dependencies
D. Run tests

**Answer:** B
**Explanation:** Bootstrapping provisions S3 bucket and IAM roles needed for CDK deployments per account/region.

---

### 5. Which CDK construct level represents raw CloudFormation resources?
A. L1 (CFN Resources)
B. L2 (Intent-based)
C. L3 (Patterns)
D. L4 (Custom)

**Answer:** A
**Explanation:** L1 constructs (CfnXxx) represent raw CloudFormation resources.

---

### 6. Which CDK construct level provides convenient defaults and helper methods?
A. L1
B. L2
C. L3
D. L4

**Answer:** B
**Explanation:** L2 constructs provide intent-based API with convenient defaults and helper methods.

---

### 7. Which CDK construct level represents common architectural patterns?
A. L1
B. L2
C. L3 (Patterns)
D. L4

**Answer:** C
**Explanation:** L3 constructs (Patterns) represent multi-resource patterns (e.g., LambdaRestApi, ApplicationLoadBalancedFargateService).

---

### 8. Which CDK command deploys the stack to AWS?
A. cdk synth
B. cdk deploy
C. cdk push
D. cdk create

**Answer:** B
**Explanation:** `cdk deploy` deploys the CDK stack to AWS.

---

### 9. What is the purpose of `cdk diff`?
A. Delete stack
B. Show differences between deployed stack and local changes
C. Deploy stack
D. Run tests

**Answer:** B
**Explanation:** `cdk diff` shows what changes will be made before deployment.

---

### 10. Which CDK command destroys a stack?
A. cdk delete
B. cdk remove
C. cdk destroy
D. cdk terminate

**Answer:** C
**Explanation:** `cdk destroy` deletes the CloudFormation stack and resources.

---

### 11. What is the CDK Toolkit staging stack called?
A. CDKStack
B. CDKToolkit
C. CDKBootstrap
D. CDKStaging

**Answer:** B
**Explanation:** Bootstrapping creates a stack called CDKToolkit with S3 bucket and IAM roles.

---

### 12. Which CDK feature allows testing infrastructure code?
A. CDK Assertions Module
B. CDK Test Framework
C. CDK Validator
D. CDK Checker

**Answer:** A
**Explanation:** CDK Assertions Module (with Jest, Pytest) tests infrastructure code.

---

### 13. What are the two types of CDK tests?
A. Unit and Integration
B. Fine-grained Assertions and Snapshot Tests
C. Functional and Performance
D. Static and Dynamic

**Answer:** B
**Explanation:** Fine-grained Assertions test specific aspects; Snapshot Tests compare against baseline template.

---

### 14. Which CDK command initializes a new project?
A. cdk new
B. cdk create
C. cdk init
D. cdk start

**Answer:** C
**Explanation:** `cdk init` creates a new CDK project with templates.

---

### 15. What is the purpose of CDK Context?
A. Store application state
B. Provide runtime configuration and feature flags
C. Encrypt data
D. Monitor deployments

**Answer:** B
**Explanation:** CDK Context provides configuration values and feature flags for the app.

---

### 16. Which file stores CDK context values?
A. cdk.json
B. context.json
C. config.json
D. settings.json

**Answer:** A
**Explanation:** cdk.json stores context values and CDK configuration.

---

### 17. Can CDK and SAM be used together?
A. No, incompatible
B. Yes, use `cdk synth` then `sam local invoke`
C. Only for Lambda
D. Only with CloudFormation

**Answer:** B
**Explanation:** Run `cdk synth` to generate template, then use SAM CLI for local testing.

---

### 18. Which CDK feature allows importing existing CloudFormation templates?
A. Template.fromStack
B. Template.fromString
C. Both A and B
D. Not possible

**Answer:** C
**Explanation:** Template.fromStack imports CDK stacks; Template.fromString imports external templates.

---

### 19. What is the purpose of CDK Aspects?
A. Visual design
B. Apply operations to all constructs in scope
C. Monitor stacks
D. Encrypt resources

**Answer:** B
**Explanation:** Aspects apply operations (validation, tagging) to all constructs in a scope.

---

### 20. Which CDK command shows the CloudFormation template without deploying?
A. cdk show
B. cdk synth
C. cdk template
D. cdk preview

**Answer:** B
**Explanation:** `cdk synth` generates and displays the CloudFormation template without deploying.

---

### 21. What is CDK Pipelines used for?
A. Data pipelines
B. CI/CD pipelines for CDK applications
C. Network pipelines
D. Logging pipelines

**Answer:** B
**Explanation:** CDK Pipelines provides a high-level construct for creating self-mutating CI/CD pipelines for CDK applications.

---

### 22. Which CDK feature allows creating custom CloudFormation resources?
A. Custom Constructs
B. Custom Resources (Provider Framework)
C. Custom Stacks
D. Custom Aspects

**Answer:** B
**Explanation:** CDK Provider Framework simplifies creating custom CloudFormation resources backed by Lambda functions.

---

### 23. How does CDK handle file assets (Lambda code, Docker images)?
A. Inline in template
B. Uploads to S3/ECR during deployment
C. Stores locally
D. Not supported

**Answer:** B
**Explanation:** CDK automatically uploads file assets to S3 (code) or ECR (images) during deployment and references them in the template.

---

### 24. What is CDK Migrate used for?
A. Migrate between AWS accounts
B. Convert CloudFormation templates to CDK code
C. Migrate databases
D. Update CDK version

**Answer:** B
**Explanation:** CDK Migrate converts existing CloudFormation templates and deployed stacks into CDK code.

---

### 25. How do you specify different configurations for dev/prod environments in CDK?
A. Multiple apps
B. Environment-specific context values and stack props
C. Separate repositories
D. Not possible

**Answer:** B
**Explanation:** Use context values (`cdk.json`), environment variables, or stack properties to configure stacks for different environments (dev, prod).

---

### 26. What is the purpose of `cdk bootstrap`?
A. Install CDK
B. Provision resources (S3 bucket, roles) required by CDK to deploy stacks
C. Start app
D. Initialize project

**Answer:** B
**Explanation:** Bootstrapping provisions an S3 bucket and IAM roles needed by CDK to store assets and deploy stacks.

---

### 27. Which CDK construct level represents AWS CloudFormation resources directly?
A. L1 (Level 1)
B. L2 (Level 2)
C. L3 (Level 3)
D. L0

**Answer:** A
**Explanation:** L1 constructs (CFN Resources) directly represent CloudFormation resources (e.g., CfnBucket).

---

### 28. What is the purpose of `cdk diff`?
A. Compare versions
B. Compare local CDK code with deployed stack
C. Compare files
D. Check syntax

**Answer:** B
**Explanation:** `cdk diff` compares the synthesized CloudFormation template from your local code with the deployed stack.

---

### 29. Which CDK feature allows sharing values between stacks?
A. Outputs
B. Exports
C. Cross-stack references
D. All of the above

**Answer:** D
**Explanation:** You can share values using CfnOutput (Exports) which creates cross-stack references when consumed by another stack.

---

### 30. What is the purpose of `cdk synth`?
A. Synthesize CloudFormation template
B. Deploy stack
C. Compile code
D. Run tests

**Answer:** A
**Explanation:** `cdk synth` executes your app and synthesizes it into a CloudFormation template (YAML/JSON).

---

### 31. Which CDK construct level provides high-level abstractions with defaults?
A. L1
B. L2
C. L3
D. L4

**Answer:** B
**Explanation:** L2 constructs (AWS Resources) provide high-level abstractions with sensible defaults and convenience methods (e.g., s3.Bucket).

---

### 32. How do you test CDK constructs?
A. Unit tests using assertions module
B. Integration tests
C. Snapshot tests
D. All of the above

**Answer:** D
**Explanation:** CDK supports fine-grained assertions, snapshot testing, and integration testing.

---

### 33. What is a CDK Aspect?
A. Visual aspect
B. Visitor pattern implementation to traverse and modify construct tree
C. Configuration
D. Property

**Answer:** B
**Explanation:** Aspects allow applying operations (validation, tagging, modification) to all constructs in a given scope.

---

### 34. Which command destroys a CDK stack?
A. cdk delete
B. cdk destroy
C. cdk remove
D. cdk terminate

**Answer:** B
**Explanation:** `cdk destroy` deletes the CloudFormation stack and its resources.

---

### 35. What is the purpose of `cdk.json`?
A. Configuration
B. Define app entry point and context values
C. Dependencies
D. Credentials

**Answer:** B
**Explanation:** `cdk.json` configures the CDK app, specifying the command to run the app and context values.

---

### 36. Which CDK construct level represents patterns or solutions?
A. L1
B. L2
C. L3
D. L4

**Answer:** C
**Explanation:** L3 constructs (Patterns) represent architectural patterns involving multiple resources (e.g., ECS Patterns).

---

### 37. How do you reference an existing resource in CDK?
A. Import methods (e.g., Bucket.fromBucketName)
B. New resource
C. Copy resource
D. Reference ID

**Answer:** A
**Explanation:** Use static `from*` methods (like `Bucket.fromBucketName`) to import and reference existing resources.

---

### 38. What is the purpose of `cdk watch`?
A. Watch logs
B. Monitor deployment
C. Watch for file changes and automatically deploy (hotswap)
D. Watch metrics

**Answer:** C
**Explanation:** `cdk watch` monitors file changes and automatically deploys updates, attempting faster hotswap deployments where possible.

---

### 39. Which language is NOT supported by CDK?
A. TypeScript
B. Python
C. Java
D. Ruby (Supported but less common, C# and Go are also supported. Swift is not.)
E. C++

**Answer:** E
**Explanation:** CDK supports TypeScript, JavaScript, Python, Java, C#, and Go. C++ is not supported.

---

### 40. What is the purpose of CDK Context?
A. Store state
B. Cache values (like AZs, AMI IDs) and configuration
C. Store logs
D. Store credentials

**Answer:** B
**Explanation:** Context caches values retrieved from AWS (like availability zones) to ensure deterministic synthesis.

---

### 41. How do you add tags to resources in CDK?
A. Tags.of(scope).add(key, value)
B. resource.addTag()
C. resource.tag()
D. Tag.add()

**Answer:** A
**Explanation:** Use `Tags.of(scope).add('key', 'value')` to apply tags to a construct and its children.

---

### 42. What is the purpose of `cdk doctor`?
A. Fix issues
B. Check CDK environment and configuration
C. Diagnose errors
D. Heal stack

**Answer:** B
**Explanation:** `cdk doctor` gathers information about your environment to help troubleshoot issues.

---

### 43. Which CDK feature prevents accidental deletion of stateful resources?
A. RemovalPolicy
B. DeletionProtection
C. RetainPolicy
D. Lock

**Answer:** A
**Explanation:** `RemovalPolicy.RETAIN` (default for databases/S3) keeps the resource when the stack is destroyed.

---

### 44. What is the purpose of CDK Assets?
A. Store money
B. Bundle and upload local files (code, images) to S3/ECR
C. Asset tracking
D. Static files

**Answer:** B
**Explanation:** Assets allow bundling local files (Lambda code, Docker images) and uploading them to S3 or ECR during deployment.

---

### 45. How do you define dependencies between stacks in CDK?
A. stack.addDependency(otherStack)
B. stack.dependsOn(otherStack)
C. stack.link(otherStack)
D. Automatic

**Answer:** A
**Explanation:** Use `stackA.addDependency(stackB)` to explicitly define deployment order.

---

### 46. What is the purpose of `cdk list` (ls)?
A. List resources
B. List stacks in the app
C. List files
D. List dependencies

**Answer:** B
**Explanation:** `cdk list` lists the IDs of all stacks defined in the CDK app.

---

### 47. Which CDK feature allows accessing values from SSM Parameter Store?
A. ssm.StringParameter.valueForStringParameter
B. ssm.get()
C. ssm.read()
D. ssm.fetch()

**Answer:** A
**Explanation:** `ssm.StringParameter.valueForStringParameter` retrieves the value of an SSM parameter at synthesis time.

---

### 48. What is the purpose of `cdk init`?
A. Initialize git
B. Create a new CDK project from a template
C. Initialize stack
D. Initialize credentials

**Answer:** B
**Explanation:** `cdk init app --language typescript` creates a new CDK project structure.

---

### 49. How do you override CloudFormation properties in an L2 construct?
A. cfnOptions
B. escape hatches (node.defaultChild)
C. override()
D. modify()

**Answer:** B
**Explanation:** Use escape hatches (accessing `node.defaultChild` and casting to L1) to override low-level CloudFormation properties.

---

### 50. What is the default removal policy for S3 buckets in CDK?
A. DESTROY
B. RETAIN
C. SNAPSHOT
D. DELETE

**Answer:** B
**Explanation:** By default, stateful resources like S3 buckets have a removal policy of RETAIN to prevent data loss.

**Explanation:** Use CDK context values, environment variables, and stack props to configure different environments (dev, staging, prod).
