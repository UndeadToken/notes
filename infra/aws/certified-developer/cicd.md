CICD

CICD: CodeCommit, CodePipeline, CodeBuild, CodeDeploy

- CodeCommit — storing our code
- CodePipeline — automating our pipeline from code to Elastic Beanstalk
- CodeBuild — building and testing our code
- CodeDeploy — deploying the code to EC2 instances (not Elastic Beanstalk)
- CodeStar — manage software development activities in one place
- CodeArtifact — store, publish, and share software packages
- CodeGuru — automated code reviews using Machine Learning 

Continuous Integration (CI)

- Developers push the code to a code repository often (e.g. GitHub, CodeCommit, BitBucket…)
- A testing/build server checks the code as soon as it’s pushed (CodeBuild, Jenkins CI, …)
- The developer gets feedback about the tests and checks that have passed/failed
- Find bugs early, then fix bugs
- Deliver faster as the code is tested
- Deploy often
- Happier developers, as they’re unblocked

Continuous Delivery (CD)

- Ensures that the software can be released reliably whenever needed
- Ensures deployments happen often and are quick
- Shift away from “one release every 3 months” to “5 releases a day”
- Usually means automated deployment (e.g. CodeDeploy, Jenkins CD, Spinnaker, …)
 
Developer -> Code Repository -> Build Server -> Deployment Server -> Application Server v1, .. v2	

CodeCommit -> CodeBuild -> CodeDeploy
<—————— CodePipeline———————>

Elastic Beanstalk as alternative to CodeDeploy

CodeCommit

- Version control tracks code changes and enables rollback
- Enabled using Git
- Git repository can be local and central online repository
- Benefits:
    - Collaborative
    - Code backup
    - Auditable
    - Private Git repositories
    - No limit on repositories
    - Fully managed, highly available
    - AWS Cloud account only for security and compliance
    - Encryption
    - Integrations

Security

- Interactions via Git
- Authentication:
    - SSH Keys — IAM users configure ssh keys
    - HTTPS — AWS CLI Credential helper or Git Credentials
- Authorization:
    - IAM policies manage repository access
- Encryption:
    - Repositories encrypted at rest (KMS)
    - Encrypted in transit (HTTPS or SSH)
- Cross-account Access:
    - Do NOT share SSH keys or AWS credentials
    - Use IAM Role and AWS STS (AssumeRole API)

CodePipeline

- Visual workflow to orchestrate CI/CD
- Source — CodeCommit, ECR, S3, Bitbucket, GitHub
- Build — CodeBuild, Jenkins, CloudBees, TeamCity
- Test — CodeBuild, AWS Device Farm, 3rd party tools
- Deploy — CodeDeploy, Elastic Beanstalk, CloudFormation, ECS, S3
- Invoke — Lambda, Step Functions
- Stages:
    - Sequential or parallel actions (e.g. Build -> Test -> Deploy -> Load Testing)
    - Manual approvals possible
- Artifacts stored in S3

Troubleshooting

- CloudWatch Events (EventBridge) for pipeline/action/stage changes
- Can create events for failed/cancelled pipelines
- Console shows failure info
- Ensure IAM Service Role has sufficient permissions

CodeBuild

- Source — CodeCommit, S3, Bitbucket, GitHub
- Build instructions: buildspec.yml or manual console entry
- Output logs stored in S3 & CloudWatch Logs
- Monitor build stats using CloudWatch Metrics
- EventBridge triggers notifications for failed builds
- Build projects defined in CodePipeline or CodeBuild

Supported Environments: Java, Ruby, Python, Go, Node.js, Android, .NET Core, PHP, Docker

- buildspec.yml at code root
- Env — environment variables:
    - Variables — plaintext
    - Parameter-store — SSM parameter store
    - SecretsManager — AWS Secrets Manager
- Phases:
    - install — dependencies
    - pre_build — pre-build commands
    - build — build commands
    - post_build — finishing touches
- artifacts — upload to S3 (KMS encrypted)
- cache — cache dependencies to S3

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
    pre_build:
        commands:
            - docker login -u ….
    build:
        commands:
            - mvn install…

artifacts:
    files:
        - target/messageUtil-1.0.jar

cache:
    paths:
        - "/root/.m2/**/*"

CodeDeploy

- Automates application deployment
- Deploys new versions to EC2, on-premises, Lambda, ECS
- Automated rollback capability
- Gradual deployment control
- appspec.yml defines deployment

EC2/On-premises

- Deploy to EC2 or on-prem servers
- In-place or blue/green deployments
- CodeDeploy Agent required on targets
- Deployment speed options:
    - AllAtOnce: max downtime
    - HalfAtATime: reduced capacity 50%
    - OneAtATime: slowest, minimal impact
    - Custom: define %

Lambda

- Automates traffic shift for Lambda aliases
- Linear: grow traffic gradually
    - LambdaLinear10PercentEvery3Minutes
- Canary: try X percent then 100%
    - LambdaCanary10Percent5Minutes
- AllAtOnce: immediate

ECS

- Automates deployment of new ECS Task Definition
- Blue/Green only
- Linear or Canary options
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

- Use appspec.yml + deployment strategy
- In-place update to EC2 fleet
- Hooks verify deployment phases

In-place deployment

- Updates existing EC2 instances
- New ASG instances get automated deployment

Blue/Green deployment

- New ASG created (settings copied)
- Option to retain old ASG
- Must use ELB

Redeploy & Rollbacks

- Rollback = redeploy last known good revision
- Automatic: deployment failure or CloudWatch Alarm triggered
- Manual rollback possible
- Disable rollback option
- Rollback creates new deployment, not restore previous

CodeArtifact

- Manages software package dependencies
- Secure, scalable, cost-effective artifact management
- Works with Maven, Gradle, npm, yarn, twine, pip, NuGet
- Developers and CodeBuild retrieve dependencies from CodeArtifact

EventBridge Integration

- Events triggered on package version create, modify, delete

Resource Policy

- Authorizes other accounts to access CodeArtifact
- Principle can read all or none of repository packages

CodeGuru

- ML-powered automated code reviews and application performance recommendations
- CodeGuru Reviewer — static code analysis
- CodeGuru Profiler — runtime performance insights
- Identifies critical issues, vulnerabilities, hard-to-find bugs
- Supports Java and Python
- Integrates with GitHub, Bitbucket, CodeCommit

CodeGuru Profiler

- Understand runtime behavior
- Identify CPU/memory inefficiencies
- Improve performance and reduce costs
- Heap summary for memory usage
- Anomaly detection
- Minimal runtime overhead

Agent Configuration

- MaxStackDepth — max call stack depth profiled
- MemoryUsageLimitPercent — memory usage limit for profiler
- MinimumTimeForReportingInMilliseconds — minimum interval for sending reports
- ReportingIntervalInMilliseconds — interval for reporting profiles
- SamplingIntervalMilliseconds — interval for sampling profiles (higher sampling = more data)
