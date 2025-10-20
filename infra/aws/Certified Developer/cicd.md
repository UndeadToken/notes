CICD: CodeCommit, CodePipeline, CodeBuild, CodeDeloy

- CodeCommit — storing our code
- CodePipeline — automating our pipeline from code to Elastic Beanstalk
- CodeBuild — building and testing our code
- CodeDeploy — deploying the code to EC2 instances (not Elastic Beanstalk)
- CodeStar — manage software development activities in one place
- CodeArtifact — store, publish, and share software packages
- CodeGuru — automated code reviews using Machine Learning 

Continuous Integrations (CI)

- Developers push the code to  a code repository often (e.g. GitHub, CodeCommit, BitBucket…)
- A testing / build server checks the code as soon as it’s pushed (CodeBuild, Jenkins CI, …)
- The developer gets feedback about the tests and checks that have passed / failed
- Find bugs early, then fix bugs
- Deliver faster as the code is tested
- Deploy often
- Happier developers, as they’re unblocked

Continuous Deliver (CD)

- Ensures that the software can be released reliably whenever needed
- Ensures deployments happen often and are quick
- Shift away from “one release every 3 months” to “5 releases a day”
- That usually means automated deployment (e.g. CodeDeploy, Jenkins CD, Spinnaker, …)
 
Developer -> Code Repository -> Build Server -> Deployment Server -> Application Server v1, .. v2	

CodeCommit -> CodeBuild -> CodeDeploy
<—————— CodePipeline———————>

Elastic Beanstalk as alternative to CodeDeploy

CodeCommit

- Version control is the ability to understand the various changes that happened to the code over time (and possibly roll back)
- All these are enabled by using a version control system such as Git
- A Git repository can be synchronised on your computer, but it usually is uploaded on a central online repository
- Benefits are:
    - Collaborative with other developers
    - Make sure the code is backed-up somewhere
    - Make sure it’s fully viewable and auditable 
    - Private Git repositories
    - No limit on repositories
    - Fully managed, highly available
    - Code only in AWS Cloud Account => increased security and compliance
    - Security (encrypted)
    - Integrations

Security

- Interactions are done using Git
- Authentication
    - SSH Keys — AWS users can configure ssh keys in their IAM console
    - HTTPS — with AWS CLI Credential helper or Git Credentials for IAM user
- Authorisation
    - IAM policies to manage users/roles permissions to repositories
- Encryption
    - Repositories are automatically encrypted at rest using AWS KMS
    - Encrypted in transit (can only use HTTPS or SSH — both are secure)
- Cross-account Access
    - Do NOT share your SSH keys or your AWS credentials
    - Use an IAM Role in your AWS account and use AWS STS (AssumeRole api)

On July 25th 2024 AWS abruptly discontinued CodeCommit

CodePipeline

- Visual workflow to orchestrate your CICI
- Source — CodeCommit, ECR, S3, Bitbucket, GitHub
- Build — CodeBuild, Jenkins, CloudBees, TeamCity
- Test — CodeBuild, AWS Device Farm, 3rd party tools…
- Deploy — CodeDeploy, Elastic beanstalk, CloudFormation, ECS, S3…
- Invoke — Lambda, Step Functions
- Consists of stages
    - Each stage can have sequential actions and/or parallel actions
    - Example Build -> Test -> Deploy -> Load Testing
    - Manual approval can be defined at any stage
- Artifacts Stored in s3 buckets

Troubleshooting

- For CodePipeline Pipeline/Action/Stage Execution State Changes
- Use CloudWatch Events (Amazon EventBridge) Example:
    - You can create events for failed pipelines
    - You can create events for cancelled
- If CodePipeline fails a stage, your pipeline stops, and you can get information in the console
- If pipeline can’t perform an action, make sure the “IAM Service Role” attached does have enough IAM Permissions (IAM Policy)

CodeBuild

- Source — CodeCommit, S3, Bitbucket, GitHub
- Build Instructions: Code file buildspec.yml or insert manually in Console
- Output logs can be stored in Amazon S3 & CloudWatch Logs
- Use CloudWatch Metrics to monitor build statistics
- Use EventBridge to detect failed builds and trigger notifications
- Use CloudWatch Alarms to notify if you need thresholds for failures
- Build Projects can be defined within CodePipeline or CodeBuild

Support Environments

Java, Ruby, Python, Go, Node.js, Android, .NET Core, PHP, Docker

- buildspec.yml must be at the root of your code
- Env — define environment variables
    - Variables — plaintext variables
    - Parameter-store — variables stored in SSM parameter store
    - Secrets0manager — variables stored in AWS Secrets manager
- Phases — specify commands to run:
    - Install — install dependencies you may need for your build
    - pre_build — final commands to execute before build
    - Build — actual build commands
    - Post_build — finishing touches (e.g. zip output)
- artifacts — what to upload to s3 (encrypted with KMS)
- cache —files to cache (usually dependencies) to s3 for future build speedup

version: 0.2

env:
	variables:
		JAVA_HOME: …
	parameter-store:
		LOGIN_PASSWORD: /CodeBuild/dockerLoginPassword

phases:
	install:
		commands:
			- apt-get …
	pe_build:
		commands:
			docker login -u ….
	build:
		commands:
			mvn install…

artifacts:
	files:
		 target/messageUtil-1.0.jar

Cache:
	paths:
		- “/root/.m2/**/*”

CodeDeploy

- Deployment service that automates application deployment
- Deploy new applications versions to EC2 instances, On-premise servers, Lambda functions, ECS Services
- Automated Rollback capability in case of failed deployments, or trigger CloudWatch alarm
- Gradual deployment control
- A file named appspec.yml defines how the deployment happens

EC2/On-premises Platform

- Can deploy to EC2 instances & On-premises servers
- Perform in-place deployments or blue/green deployments
- Must run the CodeDeploy Agent on the target instances
- Define deployment speed
    - AllAtOnce: most downtime
    - HalftAtATime: reduced capacity by 50%
    - OneAtATime: slowest, lowest availability impact
    - Custom: define %

CodeDeploy Agent

- The CodeDeploy Agent must be running on the EC2 instances as pre-requisites
- It can be installed and updated automatically if you’re using Systems Manager
- The EC2 Instances must have sufficient permissions to access Amazon S3 to get deployment bundles

Lambda Platform

- CodeDeploy can help you automate traffic shift for Lambda aliases
- Feature is integrated within the SAM framework
- Linear: grow traffic every N minutes until 100%
    - LambdaLinear10PercentEvery3Minutes
    - LambdaLinear10PercentEvery10Minutes
- Canary: try x percent then 100%
    - LambdaCanary10Percent5Minutes
    - LambdaCanary10Percent30Minutes
- AllAtOnce: immediate

ECS Platform

- CodeDeploy can help you automate the deployment of a new ECS Task Definition
- Only Blue/Green Deployments
    - ECSLinear10PercentEvery3Minutes
    - ECSLinear10PercentEvery10Minutes
- Canary: try x percent then 100%
    - ECSCanary10Percent5Minutes
    - ECSCanary10Percent30Minutes
- AllAtOnce: immediate

version: 0.0
os: linux
files:
	- source: /index.html
	   destination: /var/www/html/
hooks:
	BeforeInstall:
	- location: scripts/install_dependencies
           timeout: 300
	   runas: root
        - location: scripts/start_server
	   timeout: 300
	   runas: root
	ApplicationStop:
	- location: /scripts/stop_server
	   timeout: 300
	   runas: root


CodeDeploy for EC2 & ASG

- Define how to deploy the application using appspec.yml + Deployment Strategy
- Will do in-place update to your fleet of EC2 instances
- Can use hooks to verify the deployment after each deployment phase

In-place deployment

- Updates existing EC2 instances
- Newly created EC2 instances by an ASG will also get automated deployments

Blue/Green deployment

- A new Auto-Scaling Group is created (settings are copied)
- Choose how long to keep the old EC2 instances (old ASG)
- Must be using an ELB

Redeploy & Rollbacks

Rollback = redeploy a previously deployed revision of your application

Deployments can be rolled backed:
- Automatically — rollback when a deployment fails or rollout when a CloudWatch Alarm thresholds are met
- Manually
Disable Rollbacks — do not perform rollbacks for this deployment

If a roll back happens, CodeDeploy redeploys the last known good revision as a new deployment not a restored version.

CodeArtifact

- Software packages depend on each other to be built (also called code dependencies) and new ones are created
- Storing and retrieving these dependencies is called artefact management
- Traditionally you need to setup your own artefact management system
- CodeArtifact is a secure, scalable and cost-effective artefact management for software development
- Works with common dependency management tools such as Maven, Gradle, nom, yarn, twine, pip and NuGet
- Developers and CodeBuild can then retrieve dependencies straight from CodeArtifact

Eventbridge Integration

Event is created when a package version is created, modified or deleted.

Resource Policy

- Can be used to authorise another account to access CodeArtifact
- A given principle can either read all the packages in a repository or none of them

CodeGuru

- An ML-powered service for automated code reviews and application performance recommendations
- Provides two functionalities
    - CodeGuru Reviewer: automated code reviews for static code analysis (development)
    - CodeGuru Profiler: visibility/recommendations about applications performance during runtime (production)

- Identify critical issues, security vulnerabilities and hard to find bugs
- Example: common coding best practices, resource leaks, security detection, input validation
- Uses Machine Learning and automated reasoning
- Hard-learned lessons across millions of code reviews on 1000s of open-source and Amazon repositories
- Supports Java and Python
- Integrates with GitHub, Bitbucket, and AWS CodeCommit

CodeGuru Profiler

- Helps understand the runtime behaviour of your application
- Example: identify if your application is consuming excessive CPU capacity on a logging routine
- Features:
    - Identify and remove code inefficiencies
    - Improve application performance (e.g. reduce CPI utilization)
    - Decrease compute costs
    - Provides heap summary (identify which objects using up memory)
    - Anomaly Detection
- Support applications running on AWS or on-premise
- Minimal overhead on application

Agent Configuration

- MaxStackDepth — the maximum depth of the stacks in the code that is represented in the profile
    - example: if CodeGuru profiler fins a method A, which calls method B which calls method C which calls method D then the depth is 4
    - If the MaxStackDepth is set to 2 then the profiler evaluates A and B
- MemoryUsageLimitPercent — the memory percentage used by the profiler
- MinimumTimeForReportingInMilliseconds — the minimum time between sending reports (milliseconds)
- ReportingIntervalInMilliseconds — the reporting interval used to report profiles (milliseconds)
- SamplingIntervalMilliseconds — the sampling interval that is used to profile samples (milliseconds)
    - Reduce to have a higher sampling rate

