Other Services

SES Simple Email Service

- Send emails to people using:
    - SMTP interface
    - Or AWS SDK
- Ability to receive email. Integrates with:
    - S3
    - SNS
    - Lambda
- Integrated with IAM for allowing to send emails

OpenSearch

- Amazon OpenSearch is successor to Amazon ElasticSearch
- DynamoDB, queries only exist by primary key or indexes...
- With OpenSearch you can search any field, even partially matches
- It's common to use OpenSearch as a complement to another database
- Tow modes: managed cluster or server less cluster
- Does not natively support SQL (can be enabled via a plugin)
- Ingestion from Kinesis Data Firehose, AWS IoT, and CloudWatch logs
- Security through Cognito & IAM, KMS encryption, TLS
- Comes with OpenSearch Dashboards (visualization)

DynamoDB Table -> DynamoDB Stream -> Lambda Function -> OpenSearch

CloudWatch Logs -> Subscription Filter -> Lambda Function -> OpenSearch

CloudWatch Logs -> Subscription Filter -> Kinesis Data Firehose -> OpenSearch

Kinesis Data Streams -> Firehose -> OpenSearch

Kinesis Data Streams -> Lambda -> OpenSearch

Athena

- Serverless query service to analyse data stored in Amazon S3
- Uses standard SQL language to query the files (built on Presto)
- Supports CSV, JSON, ORC, Avro, and Parquet
- Pricing: $5.00 per TB of data scanned
- Commonly used with Amazon Quicksight for reporting/dashboards

Load data -> s3 -> (query & analyse) Athene  -> QuickSight

Use cases: Business intelligence / analytics / reporting, analyse & query VPC Flow Logs, ELB Logs, CloudTrail trails, etc...

Exam tip: analyse data in S3 using server less SQL, use Athena

Performance Improvement

- Use columnar data for cost-savings (less scann)
    - Apache Parquet or ORC is recommended
    - Huge performance improvement
    - Use Glue to convert your data to Parquet or ORC
- Compress data for smaller retrievals (bzip2, gzip, lz4, slip, zstd)
- Partition datasets in s3 for easy querying on virtual columns
    - s3://yourBucket/pathToTable
        - /<PARTITION_COLUMN_NAME>=<VALUE>
            - ...
        - e.g. s3://athena-examples/flight/parquet/year=1991/month=1/daty=1/
    - Use larger files (> 128MB) to minimise overhead

Federated Query

- Allows you to run SQL queries across data stored in relational, non-relational object, and custom data sources (AWS or on-premises)
- Uses Data Source Connectors that run on AWS Lambda to run Federated Queries (e.g. CloudWatch Logs, DynamoDB, RDS, ...)

MSK Managed Streaming for Apache Kafka 

- Alternative to Amazon Kinesis
- Fully managed Apache Kafka on AWS
    - Allow you to create, update, delete clusters
    - MSK creates & manages Kafka brokers nodes & Zookeeper nodes for you
    - Deploy the MSK cluster in your VPC, multi-AZ (up to 3 for HA)
    - Automatic recovery from common Apache Kafka failures
    - Data is stored on DBS volumes for as long as you want
- MSK Serverless
    - Run Apache Kafka on MSK without managing the capacity
    - MSK automatically provisions resources and scales compute & storage

Kinesis Data Streams

- 1MB message size limiit
- Data Streams with Shards
- Shard splitting & merging
- TLS in-flight encryption
- KMS at-rest encryption

MSK

- 1MB default, configure for higher
- Kafka Topics with Partitions
- Can only add partitions to a topic
- PLAINTEXT or TLS in-flight Encryption
- KMS at-rest encryption

MSK -> Kinesis Data Analytics
MSK -> Glue
MSK -> Lambda
MSK -> EC2, ECS, EKS

Certificate Manager (ACM)

- Let's you easily provision, manage, and deploy SSL/TLS certificates
- Used to provide in-flight encryption for websites (HTTPS)
- Supports both public and private TLS certificates
- Free of charge for public TLS certificates
- Automatic TLS certificate renewal
- Integrations with (load TLS certificates on)
    - Elastic Load Balancers
    - CloudFront Distributions
    - APIs on API Gateway

ACM Private CA

- Managed service allows you to create private certificate authorities (CA) including root and subordinates CAs
- Can issue and deploy end-entity X.509 certificates
- Certificates are trusted only by your Organisation (not the public internet)
- Works for AWS services that are integrated with ACM
- Use cases:
    - Encrypted TLS communication, Cryptographically signing code
    - Authenticate users, computers, API endpoints, and IoT devices
    - Enterprise customers building a Public Key Infrastructure (PKI)

Macie

- Amazon Mace is a fully managed data security data privacy service that uses machine learning and pattern matching to discover and protect your sensitive data in AWS
- Macie helps identify and alert you to sensitive data, such as personally identifiable information (PII)

S3 -> Macie -> EventBridge -> ...

AppConfig

- Configure, validate, and deploy dynamic configurations
- Deploy dynamic configuration changes to your applications independently of any code deployments
    - You dont need to restart the application
- Feature flags, application tuning, allow/block listing...
- Use with apps on EC2 instances, Lambda ECS, EKS
- Gradually deploy the configuration changes and rollback if issues occur
- Validate configuration changes before deployment using:
    -  JSON schema (syntactic check) or
    - Lambda function -- run code to perform validation (semantic check)

CloudWatch Evidently

- Safely validate new features by serving them to a specified % of your users
    - Reduce risk and identify unintended consequences
    - Collect experiment data, analyse using stats, monitor performance
- Launches (=feature flags): enable and disable features for a subset of users
- Experiments (= A/B testing): compare multiple versions of the same feature
- Overrides: pre-define a variation for a specific user

M
