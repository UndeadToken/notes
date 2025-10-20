AWS Cloud Development Kit

- Define your cloud infrastructure using a familiar language
    - Javascript, TypeScript, Python, Java, .NET
- Contains high level components called constructs
- The code is “compiled” into a CloudFormation template (JSON/YAML)
- You can therefore deploy infrastructure and application runtime code together
    - Great for Lambda functions
    - Great for Docker containers in ECS / EKS

Construct (e.g. Lambdas, S3 …) -> CDK CLI -> CloudFormation Template -> CloudFormation
(cdk synth)

- SAM
    - Serverless focused
    - Write your template declaratively in JSON or YAML
    - Great for quickly getting started with Lambda
    - Leverages CloudFormation
- CDK
    - All AWS services
    - Write infra in a programming language
    - Leverages CloudFormation

- You can use SAM CLI to locally test your CDK apps
- You must first run cdk synth

CDK Application (Lambda) -> cdk synth -> CloudFormation Template (MyCDKStack.template.json) -> SAM CLI

sam local invoke -t MyCDKStack.template.json myFunction

Constructs

- CDK Construct is a component that encapsulates everything CDK needs to create the final CloudFormation stack
- Can represent a single AWS resource (e.g. S3 bucket) or multiple related resources (e.g. worker queue with compute)
- AWS Construct Library
    - A collection of Constructs included in AWS CDK which contains Constructs for every AWS resource
    - Contains 3 different levels of Constructs available (L1, L2, L3)

Layer 1 Constructs

- Can be called CDN Resources which represents all resources directly available in CloudFormation
- Constructs are periodically generated from CloudFormation Resource Specification
- Construct names start with Cfn (e.g. CfnBucket)
- You must explicitly configure all resource properties

Layer 2 Constructs

- Represents AWS resources but with a higher level of(intent-based API)
- Similar functionality as L1 but with convenient defaults and boilerplate
    - You don’t need to know all the details about the resource properties
- Provide methods that make it simpler to work with the resource (e.g. bucket.addLifeCycleRule())

Layer 3 Constructs

- Can be called Patterns, which represents multiple related resources
- Helps you complete common tasks in AWS
- Examples:
    - aws-apigateway.LambdaRestApi represents an API Gateway backed by a Lambda function
    - aws-ecs-patterns.ApplicationLoadBalancerFargateService which represents an architecture that includes a fargate cluster with Application Load Balancer

Commands & Bootstrapping

- npm install -g aws-cdk-lib
- cdk init app
- cdk synth
- cdk bootstrap (deploys CDK Toolkit staging Stack)
- cdk deploy
- cdk diff
- cdk destroy

Bootstrapping

- The process of provisioning resources for CDK before you can deploy CDK apps into an AWS environment
- AWS Environment = account & Region
- CloudFromation Stack called CDKToolkit is created and contains
    - S3Bucket — to store files
    - IAM Roles — to grant permissions to perform deployments
- You must run the following command for each new environment
    - cdk bootstrap aws://<aws_account>/<aws)region>
- Otherwise you will get an error “Policy contains a statement with one or more invalid principal”

Unit Testing

- To test CDK apps, use CDK Assertions Module combined with popular test frameworks such as Jest, or Pytest
- Verify we have a specific resources rules conditions parameters…
- Two types of tests:
    - Fine-grained Assertions (common) — test specific aspects of the CloudFormation template (e.g. if a resource has this property with this value)
    - Snapshot Tests — test the synthesised CloudFormation template against a previously stored baseline template
- To import a template
    - Template.fromStack(MyStack): stack built in CDK
    - Template.fromString(MyString): stack build outside CDK

M
