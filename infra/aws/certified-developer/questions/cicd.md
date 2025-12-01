### 1. Which CodeCommit authentication method is recommended for HTTPS access?
A. SSH keys
B. Git credentials
C. AWS CLI Credential Helper
D. Access keys

**Answer:** C
**Explanation:** AWS CLI Credential Helper is the recommended method for HTTPS authentication with CodeCommit.

---

### 2. A CodePipeline fails at the build stage. Where should you look first for error details?
A. CloudTrail logs
B. CodeBuild build logs in CloudWatch
C. S3 artifact bucket
D. EventBridge events

**Answer:** B
**Explanation:** CodeBuild outputs detailed build logs to CloudWatch Logs.

---

### 3. Which file defines build instructions for CodeBuild?
A. buildspec.yml
B. appspec.yml
C. pipeline.json
D. config.yml

**Answer:** A
**Explanation:** buildspec.yml (at code root) defines build phases, commands, and artifacts for CodeBuild.

---

### 4. A CodeDeploy deployment to EC2 instances requires which file?
A. buildspec.yml
B. appspec.yml
C. template.yml
D. Dockerfile

**Answer:** B
**Explanation:** appspec.yml defines deployment instructions for CodeDeploy (files, hooks, permissions).

---

### 5. Which CodeDeploy deployment type creates a new Auto Scaling Group?
A. In-place
B. Rolling
C. Blue/Green
D. Canary

**Answer:** C
**Explanation:** Blue/Green deployment creates a new ASG with new instances, then switches traffic.

---

### 6. What is the default number of retry attempts for failed CodeBuild builds?
A. 0 (no retry)
B. 1
C. 2
D. 3

**Answer:** A
**Explanation:** CodeBuild does not automatically retry failed builds by default.

---

### 7. Which CodeDeploy deployment configuration updates all instances simultaneously?
A. OneAtATime
B. HalfAtATime
C. AllAtOnce
D. Custom

**Answer:** C
**Explanation:** AllAtOnce deploys to all instances simultaneously (fastest, maximum downtime).

---

### 8. Where does CodeBuild store build artifacts by default?
A. CodeCommit
B. S3
C. EBS volumes
D. CloudWatch

**Answer:** B
**Explanation:** CodeBuild uploads artifacts to S3 (can be encrypted with KMS).

---

### 9. Which service orchestrates the entire CI/CD workflow?
A. CodeCommit
B. CodeBuild
C. CodeDeploy
D. CodePipeline

**Answer:** D
**Explanation:** CodePipeline orchestrates the full CI/CD workflow (Source → Build → Test → Deploy).

---

### 10. A Lambda deployment should shift 10% of traffic to the new version, then 100% after 5 minutes. Which deployment type?
A. Linear
B. Canary
C. AllAtOnce
D. Blue/Green

**Answer:** B
**Explanation:** Canary deployment (e.g., LambdaCanary10Percent5Minutes) shifts a percentage, then all traffic.

---

### 11. Which CodePipeline stage action can require manual approval?
A. Source
B. Build
C. Approval
D. Deploy

**Answer:** C
**Explanation:** Manual approval actions pause the pipeline for human review before proceeding.

---

### 12. Where should sensitive build environment variables be stored?
A. buildspec.yml in plaintext
B. AWS Systems Manager Parameter Store
C. Git repository
D. CloudWatch Logs

**Answer:** B
**Explanation:** Use SSM Parameter Store or Secrets Manager for sensitive values, referenced in buildspec.yml.

---

### 13. Which CodeDeploy lifecycle event runs before the application is stopped?
A. ApplicationStop
B. BeforeInstall
C. AfterInstall
D. ApplicationStart

**Answer:** A
**Explanation:** ApplicationStop hook runs before the application is stopped during deployment.

---

### 14. A CodePipeline needs to deploy to multiple regions. What is required?
A. Multiple pipelines
B. Cross-region actions
C. StackSets
D. Multi-region CodeDeploy

**Answer:** B
**Explanation:** CodePipeline supports cross-region actions to deploy to multiple regions.

---

### 15. Which service provides automated code reviews using machine learning?
A. CodeGuru Reviewer
B. CodeBuild
C. CodeDeploy
D. CodePipeline

**Answer:** A
**Explanation:** CodeGuru Reviewer provides ML-powered automated code reviews for quality and security.

---

### 16. What is the purpose of CodeArtifact?
A. Store source code
B. Manage software package dependencies
C. Deploy applications
D. Build Docker images

**Answer:** B
**Explanation:** CodeArtifact manages and stores software packages (Maven, npm, pip, NuGet).

---

### 17. A CodeDeploy deployment fails and should automatically roll back. What triggers this?
A. Manual intervention
B. CloudWatch Alarm threshold breach
C. EventBridge rule
D. Lambda function

**Answer:** B
**Explanation:** CodeDeploy can automatically roll back on CloudWatch Alarm triggers.

---

### 18. Which buildspec.yml phase installs dependencies?
A. pre_build
B. install
C. build
D. post_build

**Answer:** B
**Explanation:** The install phase installs runtime versions and dependencies.

---

### 19. A CodePipeline artifact is encrypted. Which service manages the keys?
A. IAM
B. KMS
C. Secrets Manager
D. Certificate Manager

**Answer:** B
**Explanation:** CodePipeline artifacts in S3 are encrypted using KMS keys.

---

### 20. Which CodeDeploy hook verifies the deployment was successful?
A. BeforeInstall
B. ApplicationStart
C. ValidateService
D. AfterInstall

**Answer:** C
**Explanation:** ValidateService hook runs tests to verify the deployment was successful.

---

### 21. What is AWS CodeStar used for?
A. Storing source code
B. Unified interface for managing CI/CD toolchain
C. Building Docker images
D. Deploying Lambda functions

**Answer:** B
**Explanation:** CodeStar provides a unified interface to manage the entire CI/CD toolchain (CodeCommit, CodeBuild, CodeDeploy, CodePipeline).

---

### 22. Which service provides runtime performance profiling for applications?
A. CodeGuru Reviewer
B. CodeGuru Profiler
C. X-Ray
D. CloudWatch

**Answer:** B
**Explanation:** CodeGuru Profiler analyzes application runtime performance and identifies expensive code paths.

---

### 23. A Lambda function deployment should shift traffic gradually using SAM. Which deployment preference?
A. AllAtOnce
B. Canary10Percent5Minutes
C. Immediate
D. Rolling

**Answer:** B
**Explanation:** SAM supports deployment preferences like Canary10Percent5Minutes, Linear10PercentEvery1Minute, and AllAtOnce.

---

### 24. Which CodePipeline variable contains the commit ID from CodeCommit?
A. #{SourceVariables.CommitId}
B. #{Source.CommitId}
C. #{CodeCommit.CommitId}
D. #{Variables.CommitId}

**Answer:** A
**Explanation:** CodePipeline variables use #{SourceVariables.CommitId} syntax to reference source action outputs.

---

### 25. A CodeBuild project needs to access resources in a VPC. What must be configured?
A. VPC configuration with subnets and security groups
B. NAT Gateway
C. Internet Gateway
D. VPC Peering

**Answer:** A
**Explanation:** CodeBuild requires VPC configuration (VPC ID, subnets, security groups) to access VPC resources.

---

### 26. What is the maximum build timeout for CodeBuild?
A. 1 hour
B. 4 hours
C. 8 hours
D. 24 hours

**Answer:** C
**Explanation:** CodeBuild supports build timeouts from 5 minutes to 8 hours.

---

### 27. Which CodeDeploy deployment configuration deploys to one instance at a time?
A. AllAtOnce
B. HalfAtATime
C. OneAtATime
D. Sequential

**Answer:** C
**Explanation:** OneAtATime deployment configuration deploys to one instance at a time.

---

### 28. What is the purpose of CodeDeploy AppSpec file?
A. Specify application code
B. Define deployment actions and lifecycle event hooks
C. Configure build settings
D. Define pipeline stages

**Answer:** B
**Explanation:** AppSpec file defines deployment actions, file locations, and lifecycle event hooks for CodeDeploy.

---

### 29. Which CodePipeline action type retrieves code from a repository?
A. Build
B. Source
C. Deploy
D. Test

**Answer:** B
**Explanation:** Source action retrieves code from repositories like CodeCommit, GitHub, S3, or ECR.

---

### 30. What is the maximum number of stages in a CodePipeline?
A. 5
B. 10
C. 20
D. 50

**Answer:** D
**Explanation:** CodePipeline supports up to 50 stages per pipeline.

---

### 31. Which CodeCommit feature prevents force pushes?
A. Branch protection
B. Approval rules
C. Repository policies
D. Merge strategies

**Answer:** A
**Explanation:** Branch protection rules can prevent force pushes and deletions on protected branches.

---

### 32. What is the purpose of CodeBuild buildspec.yml?
A. Build specifications
B. Define build commands, phases, and artifacts
C. Configure environment
D. All of the above

**Answer:** D
**Explanation:** buildspec.yml defines build commands, phases, environment variables, and artifacts.

---

### 33. Which CodeDeploy lifecycle event runs after application deployment?
A. ApplicationStop
B. BeforeInstall
C. ApplicationStart
D. ValidateService

**Answer:** D
**Explanation:** ValidateService runs after ApplicationStart to validate the deployment.

---

### 34. What is the maximum artifact size for CodePipeline?
A. 1 GB
B. 5 GB
C. 10 GB
D. Unlimited

**Answer:** B
**Explanation:** CodePipeline artifacts are limited to 5 GB.

---

### 35. Which CodeBuild environment type provides Docker support?
A. Linux
B. Windows
C. Both A and B
D. Custom

**Answer:** C
**Explanation:** Both Linux and Windows CodeBuild environments support Docker.

---

### 36. What is the purpose of CodeDeploy deployment groups?
A. Group deployments
B. Define target instances/services for deployment
C. Group applications
D. Group users

**Answer:** B
**Explanation:** Deployment groups specify which instances, Lambda functions, or ECS services receive the deployment.

---

### 37. Which CodePipeline feature allows manual approval?
A. Manual Action
B. Approval Action
C. Review Action
D. Confirm Action

**Answer:** B
**Explanation:** Approval Action pauses pipeline execution for manual approval before proceeding.

---

### 38. What is the maximum number of actions per stage in CodePipeline?
A. 10
B. 20
C. 50
D. 100

**Answer:** C
**Explanation:** Each CodePipeline stage supports up to 50 actions.

---

### 39. Which CodeCommit trigger can invoke Lambda?
A. Repository triggers
B. CloudWatch Events
C. Both A and B
D. SNS only

**Answer:** C
**Explanation:** Both repository triggers and CloudWatch Events can invoke Lambda functions on CodeCommit events.

---

### 40. What is the purpose of CodeBuild cache?
A. Cache builds
B. Store dependencies to speed up subsequent builds
C. Cache artifacts
D. Cache logs

**Answer:** B
**Explanation:** CodeBuild cache stores dependencies (like npm packages) to speed up subsequent builds.

---

### 41. Which CodeDeploy compute platform supports blue/green deployments?
A. EC2/On-Premises
B. Lambda
C. ECS
D. All of the above

**Answer:** D
**Explanation:** All three compute platforms (EC2, Lambda, ECS) support blue/green deployments.

---

### 42. What is the maximum number of parallel actions in CodePipeline?
A. 5
B. 10
C. 20
D. 50

**Answer:** D
**Explanation:** CodePipeline supports up to 50 parallel actions within a stage.

---

### 43. Which CodeCommit feature requires pull request approval?
A. Branch protection
B. Approval rules
C. Merge checks
D. Review policies

**Answer:** B
**Explanation:** Approval rules require specified number of approvals before merging pull requests.

---

### 44. What is the purpose of CodeBuild environment variables?
A. Store secrets
B. Pass configuration to build commands
C. Define build parameters
D. All of the above

**Answer:** D
**Explanation:** Environment variables pass configuration, secrets (from Parameter Store/Secrets Manager), and parameters to builds.

---

### 45. Which CodeDeploy rollback strategy is automatic?
A. Manual rollback
B. Automatic rollback on deployment failure or CloudWatch alarm
C. Scheduled rollback
D. No automatic rollback

**Answer:** B
**Explanation:** CodeDeploy can automatically roll back on deployment failure or CloudWatch alarm triggers.

---

### 46. What is the maximum retention period for CodePipeline execution history?
A. 30 days
B. 90 days
C. 12 months
D. 13 months

**Answer:** D
**Explanation:** CodePipeline retains execution history for 12 months (13 months for detailed history).

---

### 47. Which CodeBuild phase installs dependencies?
A. pre_build
B. install
C. build
D. post_build

**Answer:** B
**Explanation:** The install phase installs packages and dependencies defined in buildspec.yml.

---

### 48. What is the purpose of CodeDeploy traffic shifting?
A. Shift network traffic
B. Gradually route traffic to new deployment version
C. Load balancing
D. Failover

**Answer:** B
**Explanation:** Traffic shifting gradually routes traffic from old to new deployment version (canary, linear, all-at-once).

---

### 49. Which CodePipeline source provider supports webhooks?
A. GitHub
B. Bitbucket
C. GitLab
D. All of the above

**Answer:** D
**Explanation:** GitHub, Bitbucket, and GitLab all support webhooks to trigger CodePipeline automatically.

---

### 50. What is the maximum number of concurrent builds per project in CodeBuild?
A. 1
B. 10
C. 60
D. Unlimited

**Answer:** C
**Explanation:** Default limit is 60 concurrent builds per project (can be increased).

