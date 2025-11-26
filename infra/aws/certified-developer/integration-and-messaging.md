# AWS Integration & Messaging Overview

## Application Communication Patterns
1. **Synchronous (Application → Application)**
   - Example: Service A calls Service B directly
2. **Asynchronous / Event-driven (Application → Queue → Application)**
   - Example: Service A → Queue → Service B

### AWS Messaging Services
| Service | Model | Use Case |
|---------|-------|----------|
| SQS | Queue | Decouple application tiers, reliable message delivery |
| SNS | Pub/Sub | Broadcast messages to multiple subscribers |
| Kinesis | Real-time streaming | Capture, process, and analyse streaming data |

---

## Amazon SQS (Simple Queue Service)

### Standard Queue
- Fully managed, decouples applications
- Unlimited throughput, messages, and retention (default 4 days, max 14 days)
- Low latency (<10ms)
- At-least-once delivery, best-effort ordering
- Max message size: 256 KB

### Workflow
**Producer → SQS Queue → Consumer**
- Producers send messages using `SendMessage` API
- Consumers poll messages using `ReceiveMessage`
- Consumers delete messages after processing (`DeleteMessage` API)
- Supports multiple consumers, auto-scaling with CloudWatch metrics

### Features
- **Visibility Timeout**: Message invisible to others while being processed (default 30s)
- **Dead Letter Queue (DLQ)**: Capture failed messages after maximum receives
- **Delay Queue**: Delay message availability (0–900 seconds)
- **Long Polling**: Reduce API calls by waiting for messages (1–20s)
- **Extended Client**: Handle large messages via S3

### FIFO Queues
- Exactly-once delivery, ordered processing
- Deduplication: content-based or explicit
- Message Groups: order maintained within group, parallel processing across groups
- Limited throughput (300 msg/s standard, 3000 msg/s with batching)

### Security
- Encryption in transit (HTTPS) and at rest (KMS)
- IAM policies & queue access policies for fine-grained permissions

---

## Amazon SNS (Simple Notification Service)

### Pub/Sub Workflow
- **Producer → SNS Topic → Multiple Subscribers**
- Supports fan-out to multiple SQS queues or endpoints
- Supports message filtering with subscription policies
- Supports FIFO topics (ordering & deduplication)
- Direct publishing to mobile platforms (GCM, APNS, ADM)

### Security
- HTTPS in-flight encryption, KMS at rest
- IAM and topic access policies for cross-account access

---

## AWS Kinesis

### Overview
- Real-time streaming platform
- Services:
  - **Data Streams**: Capture & process data in shards
  - **Data Firehose**: Load streaming data to AWS or 3rd-party destinations
  - **Data Analytics**: SQL or Apache Flink processing
  - **Video Streams**: Capture video in real-time

### Kinesis Data Streams
- Composed of shards (scalable unit)
- Partition Key ensures ordering within shard
- Retention: 1–365 days
- Producers: SDK, KPL, Kinesis Agent
- Consumers: KCL, Lambda, Firehose, Analytics
- Fan-out options:
  - Shared: 2MB/s per shard across all consumers
  - Enhanced: 2MB/s per shard per consumer

### Capacity Modes
- **Provisioned**: Manual shard management, predictable throughput
- **On-demand**: Auto-scaling, pay per usage

### Operations
- Shard splitting: scale up
- Shard merging: scale down

### Security
- IAM, HTTPS, KMS encryption, VPC endpoints
- CloudTrail for monitoring API calls

---

## Kinesis Data Firehose
- Fully managed, serverless delivery to S3, Redshift, OpenSearch, or custom endpoints
- Near real-time (buffer 0–900s, 1 MB minimum)
- Supports transformation via Lambda
- Automatic scaling, no data storage or replay

---

## Kinesis Data Analytics
- SQL-based or Apache Flink
- Real-time analytics on streams
- Can enrich with S3 reference data
- Outputs to Data Streams, Firehose, or custom destinations
- Use cases: dashboards, time-series metrics, analytics

---

## SQS vs SNS vs Kinesis Comparison

| Feature | SQS | SNS | Kinesis |
|---------|-----|-----|--------|
| Data Model | Queue (pull) | Pub/Sub (push) | Stream (pull/push) |
| Data Persistence | Yes (until consumed) | No | Yes (1–365 days) |
| Consumers | Unlimited | Subscribers (up to 12.5M) | Classic/Enhanced fan-out |
| Ordering | FIFO only | FIFO topic | Shard-level |
| Replay | No | No | Yes |
| Use Case | Decoupled apps | Broadcast / notifications | Real-time analytics & ETL |
