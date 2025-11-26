# Other AWS Services

## SES (Simple Email Service)
- Send emails via:
  - SMTP interface
  - AWS SDK
- Can receive emails; integrate with:
  - S3, SNS, Lambda
- IAM integration for sending permissions

---

## OpenSearch
- Successor to Amazon Elasticsearch
- Provides full-text search capabilities beyond DynamoDB primary key/index queries
- Deployment modes:
  - Managed cluster
  - Serverless cluster
- SQL not natively supported (plugin available)
- Ingest data from Kinesis Firehose, AWS IoT, CloudWatch logs
- Security: IAM, Cognito, KMS encryption, TLS
- Visualization with OpenSearch Dashboards

### Example pipelines
- `DynamoDB Table -> DynamoDB Stream -> Lambda -> OpenSearch`
- `CloudWatch Logs -> Subscription Filter -> Lambda -> OpenSearch`
- `CloudWatch Logs -> Subscription Filter -> Kinesis Firehose -> OpenSearch`
- `Kinesis Data Streams -> Firehose -> OpenSearch`
- `Kinesis Data Streams -> Lambda -> OpenSearch`

---

## Athena
- Serverless SQL query service on S3 data
- Supports CSV, JSON, ORC, Avro, Parquet
- Pricing: $5/TB scanned
- Works with QuickSight for dashboards

### Use cases
- Business intelligence, analytics, reporting
- Analyze VPC Flow Logs, ELB Logs, CloudTrail logs

### Performance improvement
- Columnar formats: Parquet or ORC
- Compression: bzip2, gzip, lz4, snappy, zstd
- Partition datasets for efficient queries
- Use larger files (>128MB) to reduce overhead

### Federated Query
- Query across relational, non-relational, object, and custom sources
- Uses Lambda-based data source connectors
- Supports AWS or on-premises sources

---

## MSK (Managed Streaming for Apache Kafka)
- Alternative to Kinesis
- Fully managed Kafka with brokers & Zookeeper nodes
- Multi-AZ deployment for HA
- Data stored on EBS
- Serverless option available (auto scale compute/storage)

### Differences vs Kinesis Data Streams
| Feature | Kinesis DS | MSK |
|---------|------------|-----|
| Message size | 1 MB | 1 MB default, configurable |
| Partitioning | Shards | Topics with partitions |
| Encryption | TLS + KMS | PLAINTEXT/TLS + KMS |

### Integrations
- MSK -> Kinesis Data Analytics
- MSK -> Glue
- MSK -> Lambda
- MSK -> EC2 / ECS / EKS

---

## Certificate Manager (ACM)
- Provision, manage, deploy SSL/TLS certificates
- Supports public/private certificates
- Free for public TLS certs
- Auto-renewal
- Integrations: ELB, CloudFront, API Gateway

### ACM Private CA
- Create private root and subordinate CAs
- Issue X.509 certificates trusted only within your organization
- Use cases: TLS, code signing, authentication for users, devices, APIs

---

## Macie
- Fully managed data security & privacy service
- Uses ML and pattern matching to detect sensitive data (PII)
- Example pipeline: `S3 -> Macie -> EventBridge -> ...`

---

## AppConfig
- Manage dynamic configuration independently of code deployments
- Use cases: feature flags, tuning, allow/block lists
- Supports EC2, Lambda, ECS, EKS
- Can gradually deploy and rollback
- Validation:
  - JSON schema (syntactic)
  - Lambda function (semantic)

---

## CloudWatch Evidently
- Feature experimentation & safe rollout
- Concepts:
  - Launches: enable/disable features for subset of users
  - Experiments: A/B testing for multiple feature variations
  - Overrides: assign specific variation to a user
- Collects experiment data, analyzes stats, monitors performance
