Elastic Beanstalk  
  
Under the hood, Elastic Beanstalk relies on CloudFormation. CloudFormation is used to provision other AWS services. You can define CloudFormation resource sin your .ebextensions.  
  
- Elastic Beanstalk is a developer centric view of deploying an application on AWS  
- It uses all the components we’ve seen before: EC2, ASG, ELB, RDS, …  
- Managed service  
    - Automatically handles capacity provisioning, load balancing, scaling, application health monitoring, instance configuration,…  
    - Just the application code is the responsibility of the developer  
    - We still have full control over the configuration  
    - Beanstalk is free but you pay for the underlying instances  
  
Elastic Beanstalk — Components  
  
- Application: Collection of Elastic Beanstalk components (environments, versions, configurations,…)  
- Application Version: an iteration of your application code  
- Environment  
    - Collection of AWS resources running an application version (only one application version at a time)  
    - Tiers: Web Server Environment Tier & Worker Environment Tier  
    - You can create multiple environments (dev, test, prod, …)  
  
Create Application -> Upload Version -> Launch Environment -> Manage Environment -> Upload Version  
  
Elastic Beanstalk — Supported Platforms  
  
- Go  
- Java SE  
- Java with Tomcat  
- .NET Core Linux  
- .NET on Windows Server  
- Node.js  
- PHP  
- Python  
- Ruby  
- Package Builder  
- Signle Container Docker  
- Multi-container Docker  
- Preconfigured Docker  
  
Elastic Beanstalk — Deployment Modes  
  
Single Instance Great for dev:  
- Availability Zone 1  
- Elastic IP  
- EC2 Instance  
- RDS Master  
  
High Availability with Load Balancer Great for Prod  
- Availability Zone 1  
- Elastic IP  
- EC2 Instance  
- RDS Master  
- ALB  
- ASG  
- Availability Zone 2  
- Elastic IP  
- EC2 Instance  
- RDS Standby  
  
Elastic Beanstalk — Deployment options for Updates  
  
- All at once (Deploy in one go) — fastest, but instances aren’t available to serve traffic for a bit (downtime)  
- Rolling: Update a few instances at a time (bucket), and then move onto the next bucket once the first bucket is healthy  
- Rolling with additional batches: Like rolling, but spins up new instances to move the batch (so that the old application is still available)  
- Immutable: spins up new instances in a new ASG, deploys version to these instances, and then swaps all the instances when everything is healthy.  
- Blue Green: Create a new environment and switch over when ready.  
- Traffic Splitting: canary testing - send a small % of traffic to new deployment.  
  
Elastic Beanstalk — CLI  
  
- We can install an additional CLI called EB cli which makes working wit Beanstalk from the CLI easier.  
- Basic commands are:  
    - eb create  
    - eb status  
    - eb health  
    - eb events  
    - eb logs  
    - eb open  
    - eb deploy  
    - eb config  
    - eb terminate  
  
Elastic Beanstalk Deployment Process  
  
- Describe dependencies (requirements.txt for Python, package.json for Node.js)  
- Package code as zip, and describe dependencies  
- Console: upload zip (creates new app version), and then deploy  
- Elastic Beanstalk will deploy the zip on each EC2 instance, resolve dependencies and start the application  
  
Beanstalk Lifecycle Policy  
  
- Elastic Beanstalk can store at most 1000 application versions  
- If you don’t remove old versions, you won’t be able to deploy anymore  
- To phase out old application versions, use a lifecycle policy  
    - Base on time (old versions are removed)  
    - Based on space (when you have too many versions)  
- Versions that are currently used won’t be deleted  
- Option not to delete the source bundle in S3 to prevent data loss  
  
Elastic Beanstalk Extensions  
  
- A zip file containing our code must be deployed to Elastic Beanstalk  
- All the parameters set in the UI can be configured with code using files  
- Requirements:  
    - In the .ebextensions/ directory in the root of the source code  
    - YAML / JSON format  
    - .config extensions (example: logging.config)  
    - Able to modify some default settings using: option_settings  
    - Ability to add resources such as RDS, ElastiCache, DynamoDB etc…  
  
- Resources managed by .ebextesions get deleted if the environment goes away  
  
Elastic Beanstalk — Cloning  
  
- Clone an environment with the exact same configuration  
- Useful for deploying a ”test” version of your application  
- All resources and configuration are preserved:  
    - Load balancer type configuration  
    - RDS database type (but the data is not preserved)  
    - Environment variables  
- After cloning an environment, you can change settings  
  
Elastic beanstalk — Migration  
  
Load Balancer:  
- After creating an Elastic Beanstalk environment, you cannot change the ELB type only the configuration  
- To migrate:  
    - Create a new environment with the same configuration except LB (can’t clone)  
    - Deploy your application onto the new environment  
    - Perform a CNAME swap or Route 53 update  
  
RDS with Elastic Beanstalk:  
- RDS can be provisioned with Beanstalk, which is great for dev / test  
- This is not great for prod as the database lifecycle is tied to the Beanstalk environment lifecycle  
- The best for prod is to separately create an RDS database and provide our EB application with the connection string  
  
  
https://docs.aws.amazon.com/elasticbeanstalk/latest/db/using-features.deploy-existing-version.html  
  
  
  
