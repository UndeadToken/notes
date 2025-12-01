### 1. What is the maximum item size in DynamoDB?
A. 100 KB
B. 256 KB
C. 400 KB
D. 1 MB

**Answer:** C
**Explanation:** DynamoDB items have a maximum size of 400 KB including attribute names and values.

---

### 2. A table has a partition key "UserID" and sort key "Timestamp". How many items can have the same UserID?
A. 1
B. 10
C. 100
D. Unlimited

**Answer:** D
**Explanation:** Multiple items can share the same partition key if they have different sort keys.

---

### 3. What is the difference between a strongly consistent read and an eventually consistent read?
A. Strong reads cost more RCUs
B. Strong reads guarantee latest data, eventual reads may return stale data
C. Strong reads are faster
D. No difference

**Answer:** B
**Explanation:** Strongly consistent reads return the most up-to-date data. Eventually consistent reads may not reflect recent writes (but use half the RCUs).

---

### 4. How many RCUs are required to read 10 items of 8 KB each per second with strong consistency?
A. 10
B. 20
C. 40
D. 80

**Answer:** B
**Explanation:** Each item is 8 KB = 2 RCUs (4 KB per RCU). 10 items × 2 = 20 RCUs for strong consistency.

---

### 5. How many WCUs are required to write 5 items of 3 KB each per second?
A. 5
B. 10
C. 15
D. 20

**Answer:** C
**Explanation:** Each item is 3 KB = 3 WCUs (1 KB per WCU). 5 items × 3 = 15 WCUs.

---

### 6. What is the maximum number of Local Secondary Indexes (LSI) per table?
A. 5
B. 10
C. 20
D. Unlimited

**Answer:** A
**Explanation:** DynamoDB supports a maximum of 5 LSIs per table (must be created at table creation).

---

### 7. Which index type can be created after table creation?
A. Local Secondary Index (LSI)
B. Global Secondary Index (GSI)
C. Both LSI and GSI
D. Neither

**Answer:** B
**Explanation:** GSIs can be added/removed after table creation. LSIs must be defined at table creation.

---

### 8. A DynamoDB transaction involves 3 writes of 2 KB each. How many WCUs are consumed?
A. 6
B. 12
C. 18
D. 24

**Answer:** B
**Explanation:** Transactions consume 2× capacity. 3 items × 2 KB = 6 WCUs × 2 = 12 WCUs.

---

### 9. What is DynamoDB Accelerator (DAX) primarily used for?
A. Backup and restore
B. In-memory caching for microsecond latency
C. Cross-region replication
D. Data encryption

**Answer:** B
**Explanation:** DAX provides in-memory caching with microsecond read latency and solves hot key problems.

---

### 10. Which DynamoDB feature automatically deletes expired items based on a timestamp attribute?
A. Streams
B. TTL (Time-to-Live)
C. Conditional Writes
D. Batch Operations

**Answer:** B
**Explanation:** TTL automatically deletes items after expiration timestamp (free, no WCU cost).

---

### 11. A DynamoDB Stream is configured with NEW_AND_OLD_IMAGES. What information is captured?
A. Only new item state
B. Only old item state
C. Both new and old item states
D. Only the primary key

**Answer:** C
**Explanation:** NEW_AND_OLD_IMAGES captures both the before and after states of modified items.

---

### 12. What is the retention period for DynamoDB Streams?
A. 1 hour
B. 24 hours
C. 7 days
D. 30 days

**Answer:** B
**Explanation:** DynamoDB Streams retain records for 24 hours.

---

### 13. Which operation retrieves items by partition key and optional sort key condition?
A. Scan
B. Query
C. GetItem
D. BatchGetItem

**Answer:** B
**Explanation:** Query retrieves items by partition key (required) and optional sort key conditions.

---

### 14. A Scan operation returns 1 MB of data but the application only needs 100 KB. What happens?
A. Only 100 KB is scanned
B. 1 MB is scanned, 100 KB returned (consumes RCUs for 1 MB)
C. Error is returned
D. Automatic pagination occurs

**Answer:** B
**Explanation:** Scan reads all data before filtering, consuming RCUs for all scanned data.

---

### 15. Which capacity mode automatically scales based on traffic without manual provisioning?
A. Provisioned mode
B. On-Demand mode
C. Reserved mode
D. Burst mode

**Answer:** B
**Explanation:** On-Demand mode automatically scales reads/writes based on traffic (2.5× more expensive).

---

### 16. What is the purpose of optimistic locking in DynamoDB?
A. Encrypt data at rest
B. Prevent concurrent overwrites using version numbers
C. Improve read performance
D. Enable cross-region replication

**Answer:** B
**Explanation:** Optimistic locking uses conditional writes with version numbers to prevent concurrent overwrites.

---

### 17. Which DynamoDB feature allows querying across multiple partitions efficiently?
A. Local Secondary Index
B. Global Secondary Index
C. Partition Key
D. Sort Key

**Answer:** B
**Explanation:** GSI allows querying with a different partition key, enabling efficient queries across partitions.

---

### 18. A table experiences throttling due to hot partitions. Which solution helps distribute load?
A. Increase RCU/WCU
B. Add write sharding to partition keys
C. Enable DAX
D. Use Scan instead of Query

**Answer:** B
**Explanation:** Write sharding adds random suffixes to partition keys to distribute writes across partitions.

---

### 19. Which API operation allows atomic updates to multiple items across multiple tables?
A. BatchWriteItem
B. UpdateItem
C. TransactWriteItems
D. PutItem

**Answer:** C
**Explanation:** TransactWriteItems provides ACID transactions across multiple items/tables.

---

### 20. What is the maximum number of items returned by a single Query operation?
A. 100 items
B. 1,000 items
C. Up to 1 MB of data
D. Unlimited

**Answer:** C
**Explanation:** Query returns up to 1 MB of data per request. Use pagination for more results.

---

### 21. What is DynamoDB Global Tables used for?
A. Backup and restore
B. Multi-region, multi-active replication
C. Caching data
D. Data encryption

**Answer:** B
**Explanation:** Global Tables provide multi-region, multi-active (active-active) replication with automatic conflict resolution for globally distributed applications.

---

### 22. Which query language can be used with DynamoDB for SQL-like queries?
A. SQL
B. PartiQL
C. GraphQL
D. LINQ

**Answer:** B
**Explanation:** PartiQL is a SQL-compatible query language that works with DynamoDB, allowing SELECT, INSERT, UPDATE, and DELETE operations.

---

### 23. What is the purpose of DynamoDB Point-in-Time Recovery (PITR)?
A. Monitor table performance
B. Restore table to any point in the last 35 days
C. Replicate data across regions
D. Encrypt data at rest

**Answer:** B
**Explanation:** PITR enables continuous backups and allows restoring a table to any second within the last 35 days.

---

### 24. How does DynamoDB Adaptive Capacity help with hot partitions?
A. Automatically increases table size
B. Redistributes unused capacity to hot partitions
C. Deletes cold data
D. Creates new indexes

**Answer:** B
**Explanation:** Adaptive Capacity automatically redistributes unused read/write capacity from underutilized partitions to hot partitions experiencing throttling.

---

### 25. What is a ProjectionExpression used for in DynamoDB?
A. Creating secondary indexes
B. Specifying which attributes to retrieve in a query
C. Defining partition keys
D. Setting TTL values

**Answer:** B
**Explanation:** ProjectionExpression specifies which attributes to retrieve from items, reducing data transfer and costs by fetching only needed attributes.
