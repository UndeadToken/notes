# Amazon DynamoDB Summary

## Overview
- **Type:** NoSQL, serverless, fully managed database  
- **Key Features:**
  - Highly available and replicated across multiple AZs  
  - Scales horizontally for massive workloads  
  - Low latency (microseconds to milliseconds)  
  - Integrated with IAM for security & authorization  
  - Supports event-driven architectures via **DynamoDB Streams**  
  - Offers on-demand and provisioned capacity modes  

## Data Model

### Tables, Items, Attributes
- **Table:** collection of items  
- **Item:** similar to a row  
- **Attribute:** data element (scalar, set, document)  
- **Item size limit:** 400 KB  

### Primary Keys
1. **Partition Key (HASH)**  
   - Unique per item, evenly distributed  
   - Example: `User_ID`  

2. **Partition + Sort Key (HASH + RANGE)**  
   - Combined unique per item  
   - Groups data by partition key  
   - Example: `User_ID + Game_ID`  

## Read/Write Capacity Modes

### Provisioned Mode
- Specify RCU & WCU in advance  
- Supports auto-scaling and burst capacity  
- **WCU:** 1 write/sec per 1 KB item  
- **RCU:** 1 strong read/sec per 4 KB item, or 2 eventual reads/sec per 4 KB item  

### On-Demand Mode
- Automatically scales reads/writes  
- Ideal for unpredictable workloads  
- 2.5x more expensive than provisioned  

## Read/Write Operations
- **PutItem:** create or replace item  
- **UpdateItem:** modify attributes or atomic counters  
- **GetItem:** retrieve by primary key  
- **Query:** retrieve items by partition key and optional sort key  
- **Scan:** inefficient full table scan; use pagination  
- **DeleteItem/DeleteTable:** remove item(s) or table  

### Batch Operations
- **BatchWriteItem:** 25 put/delete operations max, 16 MB total  
- **BatchGetItem:** 100 items max, 16 MB total  

## Indexes
- **Local Secondary Index (LSI):** alternative sort key, same partition key, max 5 per table  
- **Global Secondary Index (GSI):** alternative primary key, separate provisioned capacity, can be added after table creation  

## Advanced Features

### Transactions
- ACID-compliant multi-item, multi-table operations  
- Consumes 2x WCUs & RCUs  
- Operations: `TransactGetItems`, `TransactWriteItems`  

### Optimistic Locking
- Conditional writes using a version number to prevent overwrites  

### DynamoDB Accelerator (DAX)
- In-memory cache, microsecond latency  
- Solves hot key issues  
- Compatible with existing DynamoDB APIs  

### Streams & Event-Driven Programming
- Stream item-level changes  
- Can feed Lambda, Kinesis, etc.  
- Stream options: `KEYS_ONLY`, `NEW_IMAGE`, `OLD_IMAGE`, `NEW_AND_OLD_IMAGES`  

### Time-to-Live (TTL)
- Automatic deletion of expired items  
- Free of extra WCU/RCU cost  
- TTL deletes appear in streams  

## Security & Access Control
- IAM policies for API access  
- Encryption: KMS (at rest), SSL/TLS (in transit)  
- VPC endpoints for private access  
- Fine-grained access via Cognito or Web Identity Federation  
  - Row-level (`LeadingKeys`) or attribute-level restrictions  

## Partitioning & Performance
- **Partitions:** determined by capacity or table size  
- **Throttling causes:** hot keys, hot partitions, large items  
- **Mitigation:** exponential backoff, better key distribution, DAX caching  

## Patterns & Best Practices
- **Large Object Pattern:** store metadata in DynamoDB, object in S3  
- **Session State Cache:** DynamoDB vs ElastiCache  
- **Write Sharding:** distribute hot partitions  
- **Atomic/Conditional Writes:** ensure consistency under concurrency  
