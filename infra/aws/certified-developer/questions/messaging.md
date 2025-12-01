### 1. Which SQS queue type guarantees message ordering?
A. Standard Queue
B. FIFO Queue
C. Priority Queue
D. Delay Queue

**Answer:** B
**Explanation:** FIFO queues guarantee exactly-once processing and preserve message order.

---

### 2. What is the maximum message retention period for SQS?
A. 1 day
B. 4 days
C. 7 days
D. 14 days

**Answer:** D
**Explanation:** SQS retains messages for 4 days by default, maximum 14 days.

---

### 3. What is the maximum message size for SQS?
A. 64 KB
B. 128 KB
C. 256 KB
D. 512 KB

**Answer:** C
**Explanation:** SQS messages can be up to 256 KB. Use Extended Client Library for larger messages via S3.

---

### 4. What is the default visibility timeout for SQS messages?
A. 10 seconds
B. 30 seconds
C. 60 seconds
D. 120 seconds

**Answer:** B
**Explanation:** Default visibility timeout is 30 seconds (configurable 0 seconds to 12 hours).

---

### 5. Which SQS feature delays message availability after sending?
A. Visibility Timeout
B. Delay Queue
C. Message Timer
D. Retention Period

**Answer:** B
**Explanation:** Delay Queues postpone message delivery for up to 15 minutes.

---

### 6. What is the maximum throughput for SQS FIFO queues with batching?
A. 300 messages/second
B. 1,000 messages/second
C. 3,000 messages/second
D. Unlimited

**Answer:** C
**Explanation:** FIFO queues support 300 msg/s standard, 3,000 msg/s with batching.

---

### 7. Which SNS feature allows filtering messages sent to subscribers?
A. Message Attributes
B. Subscription Filter Policies
C. Topic Policies
D. Message Groups

**Answer:** B
**Explanation:** Subscription Filter Policies filter messages based on attributes before delivery.

---

### 8. What is the maximum number of SNS subscriptions per topic?
A. 1,000
B. 10,000
C. 100,000
D. 12,500,000

**Answer:** D
**Explanation:** SNS supports up to 12.5 million subscriptions per topic.

---

### 9. Which Kinesis service loads streaming data to S3, Redshift, or OpenSearch?
A. Kinesis Data Streams
B. Kinesis Data Firehose
C. Kinesis Data Analytics
D. Kinesis Video Streams

**Answer:** B
**Explanation:** Kinesis Data Firehose delivers streaming data to destinations (near real-time, serverless).

---

### 10. What is the default retention period for Kinesis Data Streams?
A. 1 hour
B. 24 hours
C. 7 days
D. 30 days

**Answer:** B
**Explanation:** Default retention is 24 hours (configurable 1-365 days).

---

### 11. Which Kinesis capacity mode automatically scales shards?
A. Provisioned
B. On-Demand
C. Auto-Scaling
D. Elastic

**Answer:** B
**Explanation:** On-Demand mode automatically manages shards based on throughput.

---

### 12. What is the maximum throughput per shard for Kinesis Data Streams writes?
A. 1 MB/s
B. 2 MB/s
C. 5 MB/s
D. 10 MB/s

**Answer:** A
**Explanation:** Each shard supports 1 MB/s or 1,000 records/s for writes.

---

### 13. Which SQS feature captures messages that fail processing after maximum receives?
A. Visibility Timeout
B. Dead Letter Queue (DLQ)
C. Delay Queue
D. Message Retention

**Answer:** B
**Explanation:** DLQ captures messages that exceed the maximum receive count.

---

### 14. What is the purpose of long polling in SQS?
A. Increase message size
B. Reduce API calls by waiting for messages
C. Improve message ordering
D. Enable encryption

**Answer:** B
**Explanation:** Long polling (1-20s) reduces empty responses and API costs by waiting for messages.

---

### 15. Which messaging pattern does SNS implement?
A. Queue (pull)
B. Pub/Sub (push)
C. Stream
D. Request/Response

**Answer:** B
**Explanation:** SNS implements Pub/Sub pattern, pushing messages to multiple subscribers.

---

### 16. A Kinesis consumer needs dedicated throughput. Which fan-out type?
A. Shared
B. Enhanced
C. Standard
D. Dedicated

**Answer:** B
**Explanation:** Enhanced fan-out provides 2 MB/s per shard per consumer (dedicated throughput).

---

### 17. What is the maximum batch size for SQS BatchGetMessage?
A. 1 message
B. 10 messages
C. 100 messages
D. 1,000 messages

**Answer:** B
**Explanation:** ReceiveMessage can retrieve up to 10 messages per request.

---

### 18. Which service allows real-time SQL queries on streaming data?
A. Kinesis Data Streams
B. Kinesis Data Firehose
C. Kinesis Data Analytics
D. Athena

**Answer:** C
**Explanation:** Kinesis Data Analytics processes streaming data with SQL or Apache Flink.

---

### 19. What ensures message deduplication in SQS FIFO queues?
A. Message Group ID
B. Message Deduplication ID
C. Sequence Number
D. Visibility Timeout

**Answer:** B
**Explanation:** Message Deduplication ID (or content-based deduplication) prevents duplicates in FIFO queues.

---

### 20. Which SNS protocol delivers messages to HTTP/HTTPS endpoints?
A. Email
B. SMS
C. HTTP/HTTPS
D. Lambda

**Answer:** C
**Explanation:** SNS supports HTTP/HTTPS subscriptions for webhook-style delivery.

---

### 21. What is the purpose of SNS FIFO topics?
A. Increase throughput
B. Guarantee message ordering and exactly-once delivery
C. Enable message filtering
D. Support multiple protocols

**Answer:** B
**Explanation:** SNS FIFO topics guarantee strict message ordering and exactly-once delivery to SQS FIFO queues.

---

### 22. Which SQS feature allows adding metadata to messages for filtering?
A. Message Attributes
B. Message Tags
C. Message Headers
D. Message Properties

**Answer:** A
**Explanation:** Message Attributes are custom key-value pairs that can be used for filtering and processing logic.

---

### 23. What determines which shard a Kinesis record is written to?
A. Timestamp
B. Partition Key
C. Sequence Number
D. Record Size

**Answer:** B
**Explanation:** Partition Key is hashed to determine which shard receives the record.

---

### 24. How can SNS filter messages based on attributes before delivery?
A. Message Groups
B. Topic Policies
C. Subscription Filter Policies
D. Message Deduplication

**Answer:** C
**Explanation:** Subscription Filter Policies use JSON to filter messages based on message attributes.

---

### 25. Which service provides a serverless event bus for application integration?
A. SQS
B. SNS
C. Kinesis
D. EventBridge

**Answer:** D
**Explanation:** EventBridge is a serverless event bus that connects applications using events from AWS services, SaaS, and custom applications.

---

### 26. What is the maximum message size for SQS?
A. 64 KB
B. 256 KB
C. 1 MB
D. 10 MB

**Answer:** B
**Explanation:** SQS messages can be up to 256 KB. Use S3 for larger messages with Extended Client Library.

---

### 27. Which SQS feature prevents duplicate processing?
A. Message deduplication
B. Exactly-once processing (FIFO with deduplication)
C. Visibility timeout
D. Dead Letter Queue

**Answer:** B
**Explanation:** FIFO queues with content-based deduplication prevent duplicate messages within 5-minute window.

---

### 28. What is the maximum retention period for SQS messages?
A. 1 day
B. 4 days
C. 7 days
D. 14 days

**Answer:** D
**Explanation:** SQS messages can be retained from 1 minute to 14 days (default 4 days).

---

### 29. Which Kinesis Data Streams feature increases throughput?
A. Shards
B. Enhanced Fan-Out
C. Partition keys
D. All of the above

**Answer:** D
**Explanation:** Adding shards, using Enhanced Fan-Out, and proper partition key distribution all increase throughput.

---

### 30. What is the maximum number of SNS subscriptions per topic?
A. 100
B. 1,000
C. 10,000
D. 12.5 million

**Answer:** D
**Explanation:** SNS topics support up to 12.5 million subscriptions.

---

### 31. Which SQS visibility timeout range is valid?
A. 0 seconds to 1 hour
B. 0 seconds to 12 hours
C. 1 second to 24 hours
D. 0 seconds to 7 days

**Answer:** B
**Explanation:** Visibility timeout ranges from 0 seconds to 12 hours (default 30 seconds).

---

### 32. What is the purpose of Kinesis Data Streams retention?
A. Store data
B. Retain data for replay and reprocessing (1-365 days)
C. Archive data
D. Backup data

**Answer:** B
**Explanation:** Kinesis retains data for 1 to 365 days, allowing replay and reprocessing.

---

### 33. Which SNS message attribute type is supported?
A. String
B. Number
C. Binary
D. All of the above

**Answer:** D
**Explanation:** SNS supports String, Number, String.Array, and Binary message attribute types.

---

### 34. What is the maximum batch size for SQS SendMessageBatch?
A. 5 messages
B. 10 messages
C. 100 messages
D. 1,000 messages

**Answer:** B
**Explanation:** SendMessageBatch supports up to 10 messages per batch.

---

### 35. Which Kinesis feature provides dedicated throughput per consumer?
A. Standard consumers
B. Enhanced Fan-Out consumers
C. Batch consumers
D. Parallel consumers

**Answer:** B
**Explanation:** Enhanced Fan-Out provides dedicated 2 MB/s throughput per consumer per shard.

---

### 36. What is the purpose of SQS Long Polling?
A. Poll longer
B. Reduce empty responses and costs by waiting for messages
C. Increase throughput
D. Improve latency

**Answer:** B
**Explanation:** Long Polling waits up to 20 seconds for messages, reducing empty responses and API calls.

---

### 37. Which EventBridge feature transforms events before delivery?
A. Input Transformer
B. Event Mapper
C. Event Transformer
D. Content Transformer

**Answer:** A
**Explanation:** Input Transformer modifies event data before sending to targets.

---

### 38. What is the maximum number of Kinesis Data Streams shards per stream?
A. 100
B. 500
C. 1,000
D. Unlimited (account limit)

**Answer:** D
**Explanation:** No hard limit on shards per stream, subject to account-level shard limits (default 500, can be increased).

---

### 39. Which SQS queue type guarantees message ordering?
A. Standard Queue
B. FIFO Queue
C. Priority Queue
D. Ordered Queue

**Answer:** B
**Explanation:** FIFO queues guarantee exactly-once processing and preserve message order within message groups.

---

### 40. What is the maximum size of SNS message?
A. 64 KB
B. 256 KB
C. 1 MB
D. 10 MB

**Answer:** B
**Explanation:** SNS messages can be up to 256 KB.

---

### 41. Which Kinesis Data Streams metric indicates throttling?
A. WriteProvisionedThroughputExceeded
B. ReadProvisionedThroughputExceeded
C. Both A and B
D. ThrottledRecords

**Answer:** C
**Explanation:** Both WriteProvisionedThroughputExceeded and ReadProvisionedThroughputExceeded indicate throttling.

---

### 42. What is the purpose of SQS Delay Queues?
A. Delay processing
B. Postpone delivery of messages for up to 15 minutes
C. Slow down consumers
D. Rate limiting

**Answer:** B
**Explanation:** Delay Queues postpone message delivery for 0 to 15 minutes.

---

### 43. Which EventBridge feature replays archived events?
A. Event Replay
B. Archive Replay
C. Event Reprocessing
D. Replay Rules

**Answer:** A
**Explanation:** Event Replay replays archived events to event buses for debugging and testing.

---

### 44. What is the maximum throughput per Kinesis Data Streams shard?
A. 1 MB/s write, 2 MB/s read
B. 2 MB/s write, 4 MB/s read
C. 5 MB/s write, 10 MB/s read
D. Unlimited

**Answer:** A
**Explanation:** Each shard supports 1 MB/s or 1,000 records/s write, and 2 MB/s read.

---

### 45. Which SQS feature moves failed messages to another queue?
A. Message forwarding
B. Dead Letter Queue (DLQ)
C. Error queue
D. Failure queue

**Answer:** B
**Explanation:** DLQ receives messages that fail processing after maximum receive count.

---

### 46. What is the purpose of SNS Message Filtering?
A. Filter spam
B. Deliver messages to subscriptions based on filter policies
C. Remove duplicates
D. Validate messages

**Answer:** B
**Explanation:** Message Filtering delivers messages to subscriptions only if they match the filter policy.

---

### 47. Which Kinesis feature processes streaming data in real-time?
A. Kinesis Data Analytics
B. Kinesis Data Firehose
C. Kinesis Data Streams
D. All of the above

**Answer:** D
**Explanation:** All Kinesis services process streaming data: Streams (custom processing), Analytics (SQL queries), Firehose (delivery).

---

### 48. What is the maximum number of message groups in SQS FIFO queue?
A. 100
B. 1,000
C. 10,000
D. Unlimited

**Answer:** D
**Explanation:** FIFO queues support unlimited message groups (limited by throughput: 300 TPS per group or 3,000 TPS with batching).

---

### 49. Which EventBridge feature connects to SaaS applications?
A. Event Sources
B. Partner Event Sources
C. Custom Event Bus
D. API Destinations

**Answer:** B
**Explanation:** Partner Event Sources receive events from SaaS providers like Zendesk, Datadog, and PagerDuty.

---

### 50. What is the purpose of Kinesis Data Firehose?
A. Store data
B. Load streaming data into data stores (S3, Redshift, Elasticsearch, Splunk)
C. Process data
D. Analyze data

**Answer:** B
**Explanation:** Kinesis Data Firehose loads streaming data into S3, Redshift, Elasticsearch, Splunk, and HTTP endpoints.

