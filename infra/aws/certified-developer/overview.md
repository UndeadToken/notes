# AWS Certified Developer Associate (C02) - Exam Overview

## Exam Structure
- **Passing Score:** 720/1000
- **Domain 1:** Development with AWS Services (32%)
- **Domain 2:** Security (26%)
- **Domain 3:** Deployment (24%)
- **Domain 4:** Troubleshooting & Optimization (18%)

---

## AWS Global Infrastructure
- **Regions:** Clusters of data centers (choose based on compliance, proximity, service availability, pricing)
- **Availability Zones (AZs):** 3-6 per region, isolated, high-bandwidth interconnected
- **Edge Locations:** 400+ for CloudFront CDN

---

## IAM (Identity & Access Management)
- **Global service:** Users, Groups, Roles, Policies (JSON)
- **Least privilege principle**
- **MFA:** Virtual (Google Auth), U2F (YubiKey), Hardware
- **Access:** Console (password+MFA), CLI/SDK (access keys)
- **Roles:** For AWS services (EC2, Lambda, etc.)
- **Policy evaluation:** Explicit DENY → ALLOW → default DENY

---

## EC2 (Elastic Compute Cloud)
- **Instance types:** t2.micro (free tier), compute/memory/storage optimized
- **Purchasing:** On-Demand, Reserved (1-3yr), Spot (90% discount), Dedicated
- **User Data:** Bootstrap scripts (runs as root at first launch)
- **Security Groups:** Stateful firewall, ALLOW rules only
- **Instance Metadata:** `http://169.254.169.254/latest/meta-data` (IMDSv2 requires token)

---

## EC2 Storage
- **EBS:** Network storage, AZ-bound, snapshots, io1/io2 multi-attach (16 instances)
- **Instance Store:** Ephemeral, high I/O, data lost on stop/terminate
- **EFS:** Multi-AZ NFS, Linux only, auto-scaling, storage classes (Standard, IA, Archive)
- **AMI:** Region-specific, can copy across regions

---

## ELB & ASG
- **ALB:** Layer 7 (HTTP/HTTPS), path/host routing, WebSocket, gRPC
- **NLB:** Layer 4 (TCP/UDP), ultra-low latency, static IP
- **GWLB:** Layer 3, route to virtual appliances
- **Cross-Zone LB:** ALB (default on), NLB/GWLB (default off)
- **ASG:** Min/max/desired capacity, scaling policies (target tracking, step, scheduled, predictive)
- **Connection Draining:** 1-3600s (default 300s)

---

## S3 (Simple Storage Service)
- **Buckets:** Globally unique names, region-specific
- **Objects:** Max 5TB, multi-part upload for >5GB
- **Storage Classes:** Standard, Standard-IA, One Zone-IA, Glacier (Instant/Flexible/Deep Archive), Intelligent-Tiering
- **Versioning:** Bucket-level, protects deletes
- **Replication:** CRR/SRR (requires versioning)
- **Encryption:** SSE-S3 (AWS-managed), SSE-KMS, SSE-C (customer-provided), client-side
- **Performance:** 3500 PUT/5500 GET per prefix/sec, multi-part uploads, Transfer Acceleration
- **Pre-Signed URLs:** Temporary access (GET/PUT)
- **Event Notifications:** S3 → Lambda/SQS/SNS

---

## RDS & Aurora
- **RDS Engines:** PostgreSQL, MySQL, MariaDB, Oracle, SQL Server, Aurora
- **Multi-AZ:** Sync replication, automatic failover
- **Read Replicas:** Async replication, scale reads, cross-region
- **Aurora:** 5x MySQL/3x PostgreSQL performance, 6 copies across 3 AZs, 15 read replicas, auto-scaling storage (128TB)
- **RDS Proxy:** Connection pooling, IAM auth, multi-AZ
- **Security:** KMS at-rest, TLS in-flight, IAM auth

---

## DynamoDB
- **NoSQL:** Key-value, serverless, multi-AZ
- **Primary Keys:** Partition key (HASH) or Partition+Sort key (HASH+RANGE)
- **Capacity Modes:** Provisioned (RCU/WCU) or On-Demand
- **RCU:** 1 strong read/sec per 4KB or 2 eventual reads/sec per 4KB
- **WCU:** 1 write/sec per 1KB
- **Indexes:** LSI (same partition key, alt sort key), GSI (alt primary key)
- **Transactions:** ACID, consumes 2x capacity
- **DAX:** In-memory cache, microsecond latency
- **Streams:** Item-level changes, feed Lambda/Kinesis
- **TTL:** Auto-delete expired items (free)

---

## ElastiCache
- **Redis:** Replication, HA, persistence, sorted sets
- **Memcached:** Sharding, no HA, non-persistent
- **Use cases:** Session state, database caching
- **Strategies:** Lazy loading, write-through, TTL

---

## Route 53
- **DNS:** Authoritative, 100% SLA
- **Record Types:** A (IPv4), AAAA (IPv6), CNAME (hostname→hostname, not root), Alias (AWS resources, free, auto-updates)
- **Routing Policies:** Simple, Weighted, Latency, Failover, Geolocation, Geoproximity, Multi-Value
- **Health Checks:** Monitor endpoints, calculated checks, private endpoints via CloudWatch

---

## VPC
- **Subnets:** Public (IGW), Private (NAT Gateway/Instance)
- **Security Groups:** Stateful, instance-level, ALLOW only
- **NACLs:** Stateless, subnet-level, ALLOW+DENY
- **VPC Peering:** Private connection, non-transitive
- **VPC Endpoints:** Gateway (S3, DynamoDB), Interface (other services)
- **VPC Flow Logs:** IP traffic capture

---

## Lambda
- **Serverless:** Pay per request + compute time (400K GB-s free)
- **Limits:** 15min timeout, 10GB RAM, 10GB /tmp storage
- **Invocation:** Sync (CLI, API Gateway, ALB), Async (S3, SNS, EventBridge), Event Source Mapping (Kinesis, DynamoDB Streams, SQS)
- **Execution Role:** IAM permissions for AWS services
- **Layers:** Share dependencies (5 layers, 250MB each)
- **Concurrency:** 1000 default, reserved/provisioned options
- **VPC:** Specify subnets/SGs, creates ENI
- **Versions & Aliases:** Immutable versions, aliases for routing
- **Function URLs:** HTTPS endpoints (AuthType: NONE or AWS_IAM)

---

## API Gateway
- **Integration Types:** Lambda, HTTP, AWS Service, Mock
- **Endpoint Types:** Edge-Optimized (CloudFront), Regional, Private (VPC)
- **Security:** IAM, Cognito User Pools, Lambda Authorizer
- **Stages:** dev/test/prod, stage variables
- **Canary Deployments:** Gradual traffic shift
- **Caching:** 0.5GB-237GB, TTL 0-3600s
- **Throttling:** 10K rps account limit, 429 on throttle
- **Errors:** 4XX (client), 5XX (server), 504 (29s timeout)
- **CORS:** Enable for cross-domain calls

---

## CloudFormation
- **IaC:** Declarative YAML/JSON templates
- **Template Sections:** Resources (required), Parameters, Mappings, Outputs, Conditions, Transform
- **Intrinsic Functions:** !Ref, !GetAtt, !FindInMap, !Sub, !Join, Fn::Base64
- **DeletionPolicy:** Delete, Retain, Snapshot
- **Stack Policies:** Protect resources from updates
- **StackSets:** Multi-account/region deployments
- **Custom Resources:** Lambda-backed for unsupported resources

---

## Elastic Beanstalk
- **PaaS:** Deploy apps without managing infrastructure
- **Platforms:** Go, Java, .NET, Node.js, PHP, Python, Ruby, Docker
- **Deployment Modes:** Single Instance (dev), HA with ALB+ASG (prod)
- **Deployment Options:** All at once, Rolling, Rolling with additional batches, Immutable, Blue-Green, Traffic Splitting
- **Extensions:** `.ebextensions/*.config` (YAML/JSON) for customization
- **Lifecycle Policy:** Max 1000 versions, auto-delete old versions

---

## ECS, ECR & Fargate
- **ECS Launch Types:** EC2 (manage instances), Fargate (serverless)
- **Task Definitions:** JSON metadata (image, CPU, memory, IAM role)
- **IAM Roles:** EC2 Instance Role (ECS agent), Task Role (per-task permissions)
- **Load Balancing:** ALB (most cases), NLB (high throughput)
- **Auto Scaling:** Task-level (Target Tracking, Step, Scheduled)
- **ECR:** Docker registry, IAM-controlled, image scanning
- **EKS:** Managed Kubernetes, node types (Managed, Self-Managed, Fargate)

---

## CloudFront
- **CDN:** 216 edge locations globally
- **Origins:** S3, ALB, EC2, custom HTTP
- **Cache Key:** Hostname + URL path (+ headers/cookies/query strings)
- **Cache Policies:** Control TTL (0s-1yr), headers, cookies, query strings
- **Signed URLs/Cookies:** Restrict access to paid content
- **Origin Groups:** Primary + secondary for failover
- **Price Classes:** All, 200 (exclude expensive), 100 (cheapest)

---

## Cognito
- **User Pools:** Authentication (sign-in/sign-up), JWT tokens, MFA, federated identities (SAML, Google, Facebook)
- **Identity Pools:** Authorization, temporary AWS credentials, supports guest access
- **Lambda Triggers:** Pre/post auth, pre sign-up, custom messages, token generation
- **ALB Integration:** Offload auth to Cognito
- **Adaptive Authentication:** Risk-based MFA

---

## Step Functions
- **State Machines:** Workflow orchestration (JSON)
- **Task States:** Invoke Lambda, Batch, ECS, DynamoDB, SNS/SQS, Step Functions
- **States:** Task, Choice, Fail/Succeed, Pass, Wait, Map, Parallel
- **Error Handling:** Retry (IntervalSeconds, BackoffRate, MaxAttempts), Catch (ErrorEquals, Next, ResultPath)
- **Standard:** Max 1yr, exactly-once, 2K exec/sec, pricing per state transition
- **Express:** Max 5min, at-least-once, 100K exec/sec, pricing per execution

---

## SQS (Simple Queue Service)
- **Standard Queue:** Unlimited throughput, at-least-once delivery, best-effort ordering
- **FIFO Queue:** Exactly-once, ordered, 300 msg/s (3K with batching)
- **Retention:** 4 days default, max 14 days
- **Message Size:** Max 256KB (Extended Client for S3)
- **Visibility Timeout:** Default 30s, max 12h
- **Dead Letter Queue:** Capture failed messages
- **Long Polling:** 1-20s, reduce API calls

---

## SNS (Simple Notification Service)
- **Pub/Sub:** Fan-out to multiple subscribers
- **Subscribers:** SQS, Lambda, HTTP/S, Email, SMS, mobile push
- **FIFO Topics:** Ordering + deduplication
- **Message Filtering:** Subscription filter policies

---

## Kinesis
- **Data Streams:** Real-time streaming, shards, retention 1-365 days
- **Capacity Modes:** Provisioned (manual shards) or On-Demand (auto-scaling)
- **Producers:** SDK, KPL, Kinesis Agent
- **Consumers:** KCL, Lambda, Firehose, Analytics
- **Fan-out:** Shared (2MB/s per shard) or Enhanced (2MB/s per shard per consumer)
- **Data Firehose:** Near real-time delivery to S3/Redshift/OpenSearch, serverless, no replay
- **Data Analytics:** SQL or Flink for real-time processing

---

## CloudWatch
- **Metrics:** Default 5min (EC2), detailed 1min, custom metrics (PutMetricData)
- **Logs:** Log Groups/Streams, retention (never-10yrs), export to S3/Kinesis/Lambda
- **Log Insights:** Query logs with custom language
- **Alarms:** States (OK, INSUFFICIENT_DATA, ALARM), actions (EC2, ASG, SNS)
- **Synthetics Canary:** Scripted API/URL checks (Node.js/Python)

---

## X-Ray
- **Distributed Tracing:** End-to-end request tracking
- **Concepts:** Trace, Segment, Subsegment, Annotations (searchable), Metadata
- **Sampling:** Control trace volume
- **Integration:** Lambda (auto), EC2/ECS (daemon), SDKs (Java, Python, Node.js, Go, .NET)

---

## CloudTrail
- **Audit:** AWS API calls for compliance
- **Event Types:** Management (config changes), Data (S3/Lambda), Insights (unusual activity)
- **Retention:** 90 days default, S3 for long-term

---

## EventBridge
- **Event-driven:** Schedule (cron) or event patterns
- **Sources:** EC2, S3, CodeBuild, CloudTrail, custom apps
- **Targets:** Lambda, SQS, SNS, ECS, Step Functions
- **Schema Registry:** Infer event structure, generate code

---

## SAM (Serverless Application Model)
- **Framework:** Simplify serverless deployments
- **Transform:** `AWS::Serverless-2016-10-31`
- **Resources:** `AWS::Serverless::Function`, `AWS::Serverless::Api`, `AWS::Serverless::SimpleTable`
- **Commands:** `sam init`, `sam build`, `sam deploy`, `sam local invoke/start-api`
- **Policy Templates:** S3ReadPolicy, SQSPollerPolicy, DynamoDBCrudPolicy
- **Deployment:** Uses CodeDeploy (Canary, Linear, AllAtOnce)
- **SAM Accelerate:** `sam sync --watch` for rapid iteration

---

## CDK (Cloud Development Kit)
- **IaC in Code:** TypeScript, Python, Java, .NET, Go
- **Constructs:** L1 (CFN resources), L2 (intent-based), L3 (patterns)
- **Commands:** `cdk init`, `cdk synth`, `cdk bootstrap`, `cdk deploy`, `cdk diff`, `cdk destroy`
- **Bootstrapping:** Provisions S3 bucket + IAM roles per account/region
- **Testing:** CDK Assertions Module (fine-grained, snapshot tests)

---

## CI/CD
- **CodeCommit:** Git repos, SSH/HTTPS auth, IAM policies, KMS encryption
- **CodeBuild:** Build/test, buildspec.yml, supports Docker, outputs to S3/CloudWatch
- **CodeDeploy:** Deploy to EC2/Lambda/ECS, in-place/blue-green, appspec.yml
  - **EC2:** AllAtOnce, HalfAtATime, OneAtATime, Custom
  - **Lambda:** Linear, Canary, AllAtOnce
- **CodePipeline:** Orchestrate CI/CD (Source, Build, Test, Deploy, Invoke)
- **CodeArtifact:** Package dependency management (Maven, npm, pip, NuGet)
- **CodeGuru:** ML-powered code reviews (Reviewer) and performance profiling (Profiler)

---

## Monitoring & Troubleshooting
- **CloudWatch Logs:** Application logs, metric filters, subscription filters (Kinesis, Lambda)
- **CloudWatch Metrics:** EC2 (CPU, disk, network), custom metrics, high-resolution (1s)
- **CloudWatch Alarms:** Trigger on metrics, composite alarms (AND/OR)
- **X-Ray:** Trace microservices, identify bottlenecks
- **CloudTrail:** Audit API calls, detect unauthorized access

---

## Security & Encryption
- **KMS:** Managed encryption keys, audit via CloudTrail
- **Key Types:** Symmetric (AES-256), Asymmetric (RSA/ECC)
- **Key Categories:** AWS Owned (free), AWS Managed (free), Customer Managed ($1/mo), Imported ($1/mo)
- **Rotation:** AWS-managed (auto yearly), Customer-managed (enable auto/on-demand)
- **Encryption:** At-rest (KMS), in-flight (TLS/SSL), client-side

---

## Advanced Identity
- **STS:** Temporary credentials (AssumeRole, GetSessionToken, GetFederationToken)
- **AssumeRole:** Cross-account or within account, 15min-1hr
- **MFA with STS:** GetSessionToken + IAM condition `aws:MultiFactorAuthPresent:true`
- **IAM Policy Evaluation:** Explicit DENY → ALLOW → default DENY
- **Dynamic Policies:** Use `${aws:username}` for user-specific access
- **iam:PassRole:** Required to pass IAM role to AWS service
- **Directory Services:** AWS Managed AD, AD Connector, Simple AD

---

## Other Services
- **SES:** Send/receive emails (SMTP, SDK), integrate with S3/SNS/Lambda
- **OpenSearch:** Full-text search, managed/serverless, ingest from Kinesis/IoT/CloudWatch
- **Athena:** Serverless SQL on S3 ($5/TB scanned), use Parquet/ORC + compression
- **MSK:** Managed Kafka, multi-AZ, serverless option
- **ACM:** Provision/manage SSL/TLS certs, auto-renewal, integrates with ELB/CloudFront/API Gateway
- **Macie:** Detect PII in S3 using ML
- **AppConfig:** Dynamic configuration, feature flags, gradual deploy/rollback
- **CloudWatch Evidently:** A/B testing, feature experimentation

---

## Best Practices
- **Security:** Never hard-code credentials, use IAM roles, enable MFA, rotate keys
- **Cost:** Use Reserved Instances/Savings Plans, right-size resources, leverage auto-scaling
- **Performance:** Use caching (ElastiCache, DAX, CloudFront), multi-AZ deployments
- **Reliability:** Multi-AZ, auto-scaling, health checks, backups
- **Monitoring:** Enable CloudWatch, X-Ray, CloudTrail, set alarms

---

## Exam Tips
- **Read AWS Whitepapers:** Security Best Practices, Well-Architected Framework, Serverless Architectures
- **Practice:** Hands-on with AWS Console, CLI, SDKs
- **Focus Areas:** Lambda, API Gateway, DynamoDB, S3, IAM, CloudFormation, CI/CD
- **Time Management:** 130 minutes for 65 questions (~2 min/question)
