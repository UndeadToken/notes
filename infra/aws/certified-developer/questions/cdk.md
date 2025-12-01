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
**Explanation:** Use CDK context values, environment variables, and stack props to configure different environments (dev, staging, prod).
