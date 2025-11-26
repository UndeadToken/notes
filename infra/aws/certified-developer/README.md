# AWS Certified Developer Associate (CVA-C02) – Key Notes

---

## **1. AWS Overview**
- **AWS (Amazon Web Services)**: Cloud provider offering on-demand servers and services.
- Enables scalable, flexible, and cost-efficient IT infrastructure.
- Powers major global applications:
  - **Amazon.com**
  - **Netflix**
  - **Airbnb**, **Spotify**, etc.

---

## **2. AWS Cloud Use Cases**
- Build sophisticated, scalable applications across industries:
  - **Enterprise IT, Backup & Storage**
  - **Big Data Analytics**
  - **Web Hosting**
  - **Mobile & Social Apps**
  - **Gaming**

---

## **3. AWS Global Infrastructure**

### **Regions**
- AWS Regions are clusters of data centers.
- Examples: `us-east-1`, `eu-west-3`
- **Most AWS services are region-scoped.**
- **How to choose a region:**
  - **Compliance:** Data governance and legal requirements
  - **Proximity:** Reduce latency for end users
  - **Service Availability:** Not all services/features are available in every region
  - **Pricing:** Cost varies by region (check AWS pricing page)

### **Availability Zones (AZs)**
- Each region has multiple AZs (usually 3–6)
- Example AZs: `ap-southeast-2a`, `ap-southeast-2b`, `ap-southeast-2c`
- Characteristics:
  - Each AZ is 1+ discrete data centers
  - Redundant power, networking, and connectivity
  - Isolated to prevent cross-AZ failures
  - Connected with high-bandwidth, ultra-low latency links

### **Edge Locations / Points of Presence**
- AWS has **400+ Edge Locations** & **10+ Regional Caches**
- Spread across 90+ cities in 40+ countries
- Used by services like **CloudFront** to deliver content with low latency

---

# AWS Documentation Index

This repository contains detailed guides and references for various AWS services and concepts. Click the links below to explore each topic:

- [Advanced Identity](advanced-identity.md)  
- [API Gateway](api-gateway.md)  
- [AWS CDK](cdk.md)  
- [CI/CD](cicd.md)  
- [CLI, SDK, IAM Roles and Policies](cli-sdk-iam-roles-and-policies.md)  
- [CloudFormation](cloud-formation.md)  
- [CloudFront](cloudfront.md)  
- [Cognito](cognito.md)  
- [DynamoDB](dynamodb.md)  
- [EC2 Storage](ec2-storage.md)  
- [EC2](ec2.md)  
- [ECS, ECR, and Fargate](ecs-ecr-fargate.md)  
- [Elastic Beanstalk](elastic-beanstalk.md)  
- [ESG & ALB](esg-alb.md)  
- [Exam Review Tips](exam-review-tips.md)  
- [IAM](iam.md)  
- [Integration and Messaging](integration-and-messaging.md)  
- [Lambda](lambda.md)  
- [Monitoring](monitoring.md)  
- [Other Services](other-services.md)  
- [RDS, Aurora, and ElastiCache](rds-aurora-elasticache.md)  
- [Route 53](route53.md)  
- [S3](s3.md)  
- [SAM](sam.md)  
- [Security and Encryption](security-and-encryption.md)  
- [Step Functions](step-functions.md)  
- [VPC](vpc.md)  

This README itself can be referenced [here](README.md).

---

## **4. References**
- [AWS Global Infrastructure](https://aws.amazon.com/about-aws/global-infrastructure/regional-product-services)
- [AWS Infrastructure Overview](https://infrastructure.aws)
- [Certified Developer Course PDF](https://courses.datacumulus.com/downloads/certified-developer-k92)

---

This format is **study-friendly** and matches the copyable style you wanted for notes on CloudFormation and AWS fundamentals.
