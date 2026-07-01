AWS Integration & Messaging  
  
    - When we start deploying multiple applications, they will inevitably need to communicate with one another  
    - There are two patterns of application communication  
  
1. Synchronous communications (application to application) e.g. Service A -> Service B  
2. Asynchronous / Event based (application to queue to application)  
	Service A -> Queue -> Service B  
  
SQS: Queue Model  
SNS: Pub/Sub Model  
Kinesis: Real-time Streaming Model  
  
  
SQS  
  
SQS to decouple between application tiers.  
  
Producer (Send Messages) -> SQS Queue -> Consumer (Poll messages)  
  
Amazon SQS - Standard Queue  
  
- Oldest offering (over 10 years old)  
- Fully managed service, used to decouple applications  
  
Attributes:  
- Unlimited throughput, unlimited number of messages in queue  
- Default retention of messages: 4 days, maximum of 14 days  
- Low latency (<10ms on publish and receive)  
- Limitation of 256kb per message sent  
  
- Can have duplicate messages (at least once delivery, occasionally)  
- Can have out of order messages (best effort ordering)  
  
Produced Messages:  
- Produced to SQS using the SDK (SendMessage API)  
- The message is persisted in SQS until a consumer deletes it  
- Default retention of messages: 4 days, maximum of 14 days  
- Example: send an order to be processed  
- Unlimited throughput  
  
Consuming Messages:  
- Consumers (running on EC2 instances, servers, or AWS Lambda…)  
- Poll SQS for messages (receive up to 10 messages at a time)  
- Process the messages (e.g. insert the message into RDS database)  
- Delete the messages using the DeleteMessage API  
  
Multiple EC2 Instances Consumers:  
- Consumers receive and process messages in parallel  
- At least once delivery  
- Best effort message ordering  
- Consumers delete messages after processing them  
- We can scale consumers horizontally to improve throughput of processing  
  
SQS with Auto Scaling Group (ASG) e.g. CloudWatch Metric — Queue Length with ApproximateNumberOfMessages alarm for breach CloudWatch Alarm.  
  
SQS Security:  
- Encryption:  
    - In-flight encryption using HTTPS API  
    - At-rest encryption using KMS keys  
    - Client-side encryption if the client wants to perform encryption/decryption itself  
- Access Controls: IAM policies to regulate access to the SQS API  
- SQS Access Policies (similar to S3 bucket policies)  
    - Useful for cross-account access to SQS queues  
    - Useful for allowing other services (SNS, S3, ..) to write to an SQS queue  
  
SQS Queue Access Policy  
  
Cross Account Access:  
{  
  “Version”: “2012-10-17”,  
  “Statement”: [{  
    “Effect”: “Allow”,  
    “Principle”: {“AWS”:[“111222333”]},  
    “Action”: [“sqs:ReceiveMessage”],  
    ”Resource”:”arn:aws:sqs:is-east-q:4444555566666:queue1”,  
    “Condition”: {        “ArnLike”: {“aws:SourceArn”: “arn:aws:s3:*:*:bucket1”},  
       “StringEquals”: {“aws:SourceAccount”: “<bucket1_owner_account_id>”}     }  
 }  
}  
  
SQS — Message Visibility Timeout:  
  
- After a message is polled by a consumer, it becomes invisible to other consumers  
- By default, the ”message visibility timeout” is 30 seconds  
- That means the message has 30 seconds to be processed  
- After the message visibility timeout is over, the message is ‘visible’ in SQS  
- If a message is not processed within the visibility timeout, it will be processed twice  
- A consumer could call the ChangeMessageVisibility API to get more time  
- If visibility timeout is high (hours), and consumer crashes, re-processing will take time  
- If visibility timeout is too low (seconds), we may get duplicates  
  
SQS — Dead Letter Queue (DLQ):  
  
Prevent a failure loop.  
  
- If a consumer fails to process a message within the Visibility Timeout… the message goes back to the queue!  
- We can set a threshold of how many times a message can go back to the queue  
- After the MaximumReceives threshold is exceeded, the message goes into a dead letter queue (DLQ)  
- Useful for debugging  
- DLQ of a FIFO queue must also be a FIFO queue  
- DLQ of a Standard queue must also be a Standard queue  
- Make sure the process the messages in the DLQ before they expire:  
    - Good to set a retention of 14 days in the DLQ  
  
SQS DLQ — Redrive to Source:  
  
- Feature to help consume messages in the DLQ to understand what is wrong with them  
- When our code is fixed, we can retrieve the messages from the DLQ back into the source queue (or any other queue) in batches without writing custom code  
  
SQS — Delay Queue:  
  
- Delay a message (consumers don’t see it immediately up to 15 minutes)  
- Default is 0 seconds (message is available right away)  
- Can set a default at queue level  
- Can override the default on send using the DelaySeconds  
  
SQS — Long Polling:  
  
- When a consumer requests a message from the queue, it can optionally wait for messages to arrive id there are none in the queue  
- This is called Long Polling  
- LongPolling decreases the number of API calls made to SQS while increasing the efficiency and decreasing there latency of your application  
- The wait time can be between 1 to 20sec   
- Long Polling is preferable to Short Polling  
- Long polling can be enabled at the queue level or at the API level using ReceiveMessageWaitTimeSeconds  
  
SQS — Extended Client:  
  
- Message size limit is 256kb, how to send large messages e.g. 1gb  
- Using the SQS Extended Client (Java Library)  
  
Producer -> Small metadata message -> SQS -> small metadata -> consumer  
  
Producer -> Send large message to s3 -> s3 -> retrieve large message -> consumer  
  
SQS — API:  
  
- CreateQueue (MessageRetentionPeriod), DeleteQueue  
- PurgeQueue: delete all messages in queue  
- SendMessage(DelaySeconds), ReceiveMessage, DeleteMessage  
- MaxNumberOfMessages: default 1, max 10 (for ReceiveMessage API)  
- ReceiveMessageWaitTimeSeconds: Long Polling  
- ChangeMessageVisibility: change the message timeout  
- Batch APIs for SendMessage, DeleteMessage, ChangeMessageVisibility helps decrease your costs   
  
SQS — FIFO Queue  
  
- FIFO = First In First Out (Ordering of messages in the queue)  
- Limited throughput: 300 msg/s without batching, 3000 msg/s with  
- Exactly-once send capability (by removing duplicates)  
- Messages are processed in order by the consumer  
  
FIFO Deduplication:  
  
- De-duplication interval is 5 minutes  
- Two de-duplication methods:  
    - Content-based deduplication: will do a sha256 hash of the message body  
    - Explicitly provide a Message Deduplication ID  
  
FIFO Message Grouping:  
  
- If you specify the same value of MessageGroupID in an SQS FIFO queue, you can only have one consumer, and all the messages are in order  
- To get ordering at the level of a subnet of messages, specify different values for MessageGroupID  
    - Messages that share a common Message Group ID will be in order within the group  
    - Each Group ID can have a different consumer (parallel processing)  
    - Ordering across groups is not guaranteed  
   
SNS  
  
- The “event producer” only sends message to one SNS topic  
- As many “event receivers” (subscriptions) as we want to listen to the SNS topic notifications  
- Each subscriber to the topic will get all the messages (note: new feature to filter messages)  
- Up to 12,500,000 subscriptions per topic  
- 100,000 topics limit  
- Many AWS services can send data directly to SNS for notifications  
  
SNS — How to publish:  
  
- Topic Publish (using the SDK)  
    - Create a topic  
    - Create a subscription (or many)  
    - Publish to the topic  
  
- Direct Publish (for mobile apps SDK)  
    - Create a platform application  
    - Create a platform endpoint  
    - Publish to the platform endpoint  
    - Works with Google GCM, Apple, APNS, Amazon ADM  
  
SNS — Security:  
  
- Encryption:  
    - In-flight encryption using HTTPS API  
    - At-rest encryption using KMS keys  
    - Client-side encryption if the client wants to perform encryption/decryption itself  
  
- Access Controls: IAM policies to regulate access to the SNS API  
  
- SNS Access Policies (similar to S3 bucket policies)  
    - Useful for cross-account access to SNS topics  
    - Useful for allowing other services (S3…) to write to an SNS topic  
  
SNS — Fan Out:  
  
- Push once in SNS, receive in all SQS queues that are subscribers  
- Fully decoupled, no data loss  
- SQS allows for: data persistence, delayed processing and retries of work  
- Ability to add more SQS subscribers over time  
- Make sure your SQS queue access policy allows for SNS to write  
- Cross-Region delivery: works with SQS queues in other regions  
  
Application: S3 Events to multiple queues:  
  
- For the same combination of: event type (e.g. object create) and prefix (e.g. images/) you can only have one S3 Event Rule  
- If you want to send the same S3 event to many SQS queues, use fan-out  
  
Application: SNS to Amazon S3 through Kinesis Data Firehose:  
  
- SNS can send Kinesis and therefore we can have the following solutions architecture  
  
Service -> SNS Topic -> Kinesis Data Firehose -> S3  
(Or any supported KDF Destination)  
  
SNS — FIFO Topic:  
  
- FIFO = First In First Out (Ordering of messages in the topic)  
- Similar features as SQS FIFO  
    - Ordering by Message Group ID (all messages in the same group are ordered)  
    - Deduplication using a Deduplication ID or Content Based Deduplication  
- Can have SQS Standard and FIFO queues as subscribers  
- Limited throughput (same throughput as SQS FIFO)  
  
SNS — Message Filtering:  
  
- JSON policy used to filter messages sent to SNS topic’s subscriptions  
- If a subscription doesn’t have a filter policy, it receives every message  
  
Kinesis  
  
- Makes it easy to collect, process, and analyse streaming data in real-time  
- Ingest real-time data such as: Application logs, Metrics, Website clickstreams, IoT telemetry data…  
- Kinesis Data Streams: capture, process and store data streams  
- Kinesis Data Firehose: load data streams into AWS data stores  
- Kinesis Data Analytics: analyse data streams with SQL or Apache Flink  
- Kinesis Video Streams: capture, process, and store video streams  
  
Kinesis Data Streams  
  
Kinesis Data Streams consist of shards. Shard 1, Shard 2, … Shard N. Can scale # of shards.  
  
Producers send data into data streams. Applications, clients, sdk, KPL, kinesis agent etc…  
  
- Retention between 1 day to 365 days  
- Ability to reprocess (replay) data  
- Once data is inserted in Kinesis, it can’t be deleted (immutability)  
- Data that shares the same partition goes to the same shard (ordering)  
- Producers: AWS SDK, Kinesis Producer Library (KPL), Kinesis Agent  
- Consumers:  
    - Write your own: Kinesis Client Library (KCL), AWS SDK  
    - Managed: AWS Lambda, Kinesis Data Firehose, Kinesis Data Analytics  
  
Record:  
(Between Producer and Shard)  
Partition Key  
Data Blob (up to 1 MB)  
1MB/sec  
Or 1000 msg/sec per shared  
  
Record:  
(Between Shard and Consumer)  
Partition Key  
Sequence No.  
Data blob  
2 MB/sec (shared) Per shard all consumers OR 2MB/sec (enhanced) Per shard per consumer  
  
Consumers: Apps (KCL, SDK); Lambda, Kinesis Data Firehose, Kinesis Data Analytics  
  
Kinesis Data Streams — Capacity Modes:  
  
- Provisioned mode:  
    - You choose the number of shards provisioned, scale manually or using API  
    - Each shard gets 1MB/s in (or 1000 records per second)  
    - Each shard gets 2MB/s out (classic or enhanced fan-out consumer)  
    - You pay per shard provisioned per hour  
  
- On-demand mode:  
    - No need to provision or manage the capacity  
    - Default capacity provisioned (4 MB/s in or 4000 records per second)  
    - Scales automatically based on observed throughput peak during the last 30 days  
    - Pay per stream per hour & data in/out per GB  
  
Kinesis Data Streams — Security:  
  
- Control access / authorization using IAM policies  
- Encryption in flight using HTTPS endpoints  
- Encryption at rest using KMS  
- You can implement encryption/decryption of data on client side (harder)  
- VPC Endpoints available for Kinesis to access within VPC  
- Monitor API calls using CloudTrail  
  
Kinesis Producers  
  
Record -> Hash Function -> Same Shard  
Partition Key = Device Id, Same partition key = Same shard  
Use highly distributed partition key to avoid “hot partition”  
Retries with exponential backoff  
Increase shards (scaling)  
  
Over producing to a shard yields a ProvisionedThroughputException.  
  
- Puts data records into data streams  
- Data record consists of:  
    - Sequence number (unique per partition-key within shard)  
    - Partition key (must specify while put records into stream)  
    - Data blob (up to 1MB)  
- Producers:  
    - AWS SDK: simple producer  
    - Kinesis Producer Library (KPL): C++, Java, Batch, compression, retries  
    - Kinesis Agent: monitor log files  
- Write throughput: 1MB/sec or 1000 records/sec per shard  
- PutRecord API  
- Use batching with PutRecords API to reduce costs & increase throughput  
  
Kinesis Consumers  
  
- Get data records from data streams and process them  
- AWS Lambda  
- Kinesis Data Analytics  
- Kinesis Data Firehose  
- Custom Consumer (AWS SDK) — Classic or Enhanced Fan-Out  
- Kinesis Client Library (KCL): Library to simplify reading from data stream  
  
Shared (Class) Fan-out consumer:  
(Sharing) 2MB/sec per shard across all consumers (2MB split over n consumers)  
  
Enhanced Fan-out Consumer:  
2 MB/sec per consumer per shard (not shared, 2MB each).  
  
Kinesis Consumer Types:  
- Shared (Classic) Fan-out Consumer — pull  
    - Low number of consuming applications  
    - Read throughput: 2MB/s per shard across all consumers  
    - Max 5 GetRecords API calls/sec  
    - Latency ~200ms  
    - Minimise cost ($)  
    - Consumers poll data from Kinesis using GetRecords API call  
    - Returns up to 10 MB (then throttle for 5 seconds) or up to 10,000 records  
- Enhanced Fan-out Consumer - Push  
    - Multiple consuming applications for the same stream  
    - 2MB/sec per consumer per shard  
    - Latency ~70ms  
    - Higher costs ($$$)  
    - Kinesis pushes data to consumers over HTTP/2 (SubscribeToShard API)  
    - Soft limit of 5 consumer applications (KCL) per data stream (default)  
  
Kinesis Consumers — AWS Lambda:  
Lambda functions (process records & save to DynamoDB)  
  
- Supports Classic & Enhanced fan-out consumers  
- Read records in batches  
- Can configure batch size and batch window  
- If error occurs, Lambda retries utilities succeeds or data expired  
- Can process up to 10 batches per shard simultaneously  
  
#cliv2  
aws kinesis put-record —stream-name test  
—partition-key user1 —data “user signup”  
—cli-binary-format raw-in-base64-out  
  
#cliv1  
aws kinesis put-record —stream-name test  
—partition-key user1 —data “user signup”  
  
aws kinesis describe-stream —stream-name test  
  
aws kinesis get-shard-iterator —stream-name test  
—shard-id shardId-0000000  
—shard-iterator-type TRIM_HORIZON  
  
Aws kinesis get-records —shard-iterator <>  
  
Kinesis Client Library (KCL)  
  
- A Java library that helps read record from kinesis Data Stream with distributed applications sharing the read workload  
- Each shard is to be read by only one KCL instance  
    - 4 shard = max 4 KCL instances  
    - 6 shards = max 6 KCL instances  
- Progress is checkpoint into DynamoDB (needs IAM access)  
- Track other workers and share the work amongst shards using DynamoDB  
- KCL can run on EC2, Elastic Beanstalk, and on-premises  
- Records are read in order at the shard level  
- Versions:  
    - KCL 1.x (supports shared consumer)  
    - KCL 2.x (supports shared & enhanced fan-out consumer)  
  
Kinesis Operations  
  
Shard Splitting:  
(Increase capacity and cost)  
- Used to increase the Stream capacity (1MB/s data in per shard)  
- Used to divide a “hot shard”  
- The old shard is closed and will be deleted once the data is expired  
- No automatic scaling (manually increase/decrease capacity)  
- Can’t split into more than two shards in a single operation  
  
Merging Shards:  
- Decrease the Stream Capacity and save costs  
- Can be used to group two shards with low traffic (cold shards)  
- Old shards are closed and will be deleted once the data is expired  
- Can’t merge more than two shares in a single operation  
  
Kinesis Data Firehose  
  
Takes data from sources and puts into destination.  
  
Sources:  
Kinesis Data Streams, Amazon Cloud Watch, AWS IoT, Applications, Clients, SDK, Kinesis Agent.  
  
Destinations:  
Amazon S3, Amazon Redshift, Amazon OpenSearch  
3rd party Datadog, mongoldb etc… http endpoint…  
  
All or failed data to s3 backup bucket.  
  
- Fully Managed Service, no administration, automatic scaling, server less  
    - AWS Redshift, Amazon S3, OpenSearch  
    - 3rd Party partner: Splunk / MongoDB / DataDog / NewRelic  
    - Custom send to any HTTP Endpoint  
- Pay for data going through Firehose  
- Near Real Time  
    - Buffer interval: 0 seconds (no buffering) to 900 seconds  
    - Buffer size: minimum 1MB  
- Supports many data formats, conversions, transformations, compression  
- Supports custom data transformations using AWS Lambda  
- Can send failed or all data to a backup S3 bucket  
  
Kinesis Data Streams vs Firehose  
  
Kinesis Data Streams  
  
- Streaming Service for ingest at scale  
- Write for custom code (producer / consumer)  
- Real-time (~200ms)  
- Managing scaling (Shard splitting / merging)  
- Data storage for 1 to 365 days  
- Supports replay capability  
  
Kinesis Data Firehose  
  
- Load streaming data into S3 / Redshift / OpenSearch / 3rd Party / custom HTTP  
- Fully managed  
- Near real-time  
- Automatic scaling  
- No data storage  
- Doesn’t support replay capability  
  
Kinesis Data Analytics  
  
Kinesis Data Analytics (SQL Application)  
  
Kinesis Data Analytics for SQL applications can reference data in S3 and perform SQL statements for real-time analytics when consuming data from Kinesis Data Streams and Kinesis Data Firehose.   
  
Destinations or “sinks” such as Kinesis Data Streams and respective destinations (aws lambda, applications, …); Kinesis Data Firehose and respective Firehose destinations (s3, redshift, …).  
  
- Real-time analytics on Kinesis Data Streams & Firehose using SQL  
- Add reference data from Amazon S3 to enrich streaming data  
- Fully managed, no servers to provision  
- Automatic scaling  
- Pay for actual consumption rate  
- Output:  
    - Kinesis Data Streams: create streams out of real-time analytics queries  
    - Kinesis Data Firehose: send analytics query results to destinations  
- Use cases:  
    - Time-series analytics  
    - Real-time dashboards  
    - Real-time metrics  
  
Kinesis Data Analytics for Apache Flink  
  
Kinesis Data Streams, Amazon MSK -> Kinesis Data Analytics for Apache Flink  
  
- Use Flink (Java, Scala or SQL) to process and analyse streaming data  
- Run any Apache Flink application on a managed cluster on AWS  
    - Provisioning compute resources, parallel computation, automatic scaling  
    - Application backups (implemented as checkpoints and snapshots)  
    - Use any Apache Flink programming features  
    - Flink does not read from Firehose (use Kinesis Analytics for SQL instead)  
  
SQS vs SNS vs Kinesis  
  
SQS  
  
- Consumer “pull data”  
- Data is deleted after being consumed  
- Can have as many workers (consumers) as we want  
- No need to provision throughput  
- Ordering guarantees only on FIFO queues  
- Individual message delay capability  
  
SNS  
  
- Push data to many subscribers  
- Up to 12,500,000 subscribers  
- Data is not persisted (lost if not delivered)  
- Pub/Sub  
- Up to 100,000 topics  
- No need to provision throughput  
- Integrates with SQS for fan-out architecture pattern  
- FIFO capability for SQS FIFO  
  
Kinesis  
  
- Standard: Pull data  
    - 2 MB per shard  
- Enhanced-fan out: push data  
    - 2 MB per shard per consumer  
- Possibility to replay data  
- Meant for real-time big data, analytics and ETL  
- Ordering at the shard level  
- Data expires after X days  
- Provisioned mode or on-demand capacity mode  
