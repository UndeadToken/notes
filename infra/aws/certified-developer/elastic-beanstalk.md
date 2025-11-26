# Elastic Beanstalk (EB)

## Overview
- Developer-centric service to deploy applications on AWS.
- Uses underlying services: EC2, ASG, ELB, RDS, etc.
- **Managed Service:** handles provisioning, scaling, load balancing, health monitoring, instance configuration.
- Developer responsibility: application code.
- Beanstalk is free; you pay for underlying resources.

## Core Components
- **Application:** Collection of EB components (environments, versions, configurations).
- **Application Version:** Specific iteration of application code.
- **Environment:** Collection of AWS resources running a single application version.
  - Tiers: Web Server & Worker.
  - Multiple environments possible (dev, test, prod).

### Deployment Workflow
1. Create Application  
2. Upload Version  
3. Launch Environment  
4. Manage Environment  
5. Upload Version  

---

## Supported Platforms
- Go, Java SE, Java w/ Tomcat
- .NET Core Linux, .NET on Windows
- Node.js, PHP, Python, Ruby
- Package Builder, Single / Multi-container Docker, Preconfigured Docker

---

## Deployment Modes

| Mode | Description |
|------|-------------|
| Single Instance | One AZ, Elastic IP, EC2, RDS Master. Good for dev. |
| High Availability | Multi-AZ, ALB, ASG, EC2, RDS Master + Standby. Good for prod. |

---

## Deployment Options for Updates
- **All at once:** Fastest, downtime occurs.
- **Rolling:** Update small batches sequentially.
- **Rolling with additional batches:** Old app still available while batch updates.
- **Immutable:** New ASG, deploy new version, swap when healthy.
- **Blue-Green:** Create new environment, switch CNAME when ready.
- **Traffic Splitting:** Canary testing (small % traffic to new version).

---

## EB CLI Commands
- `eb create`, `eb status`, `eb health`, `eb events`, `eb logs`, `eb open`, `eb deploy`, `eb config`, `eb terminate`

---

## Deployment Process
1. Describe dependencies (`requirements.txt`, `package.json`).
2. Package code as zip.
3. Upload zip to console (creates app version).
4. EB deploys to each EC2 instance, resolves dependencies, starts app.

---

## Lifecycle Policy
- EB stores max 1000 application versions.
- Use lifecycle policies to remove old versions:
  - Based on time
  - Based on space
- Currently used versions are not deleted.
- Option to retain source bundle in S3.

---

## EB Extensions (.ebextensions)
- Customize environment via code.
- Location: `.ebextensions/` in source root.
- Format: YAML/JSON, `.config` extension.
- Features:
  - Modify default settings (`option_settings`).
  - Add resources: RDS, ElastiCache, DynamoDB, etc.
- Resources managed by `.ebextensions` are deleted if environment is terminated.

---

## Cloning
- Clone an environment with same configuration.
- Useful for test deployments.
- Preserves:
  - Load balancer type
  - RDS type (data not preserved)
  - Environment variables
- Post-clone, settings can be modified.

---

## Migration Considerations
- **Load Balancer:** Cannot change LB type post-creation. Solution: create new environment, deploy, swap CNAME.
- **RDS:** Best practice for prod: create RDS separately; provide connection string to EB app.
- EB-provisioned RDS is tied to environment lifecycle (good for dev/test, not prod).
