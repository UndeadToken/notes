### 1. Which RDS database engine is AWS proprietary?
A. PostgreSQL
B. MySQL
C. Aurora
D. MariaDB

**Answer:** C
**Explanation:** Aurora is AWS's proprietary cloud-optimized database (MySQL/PostgreSQL compatible).

---

### 2. What is the maximum storage for Aurora?
A. 16 TB
B. 64 TB
C. 128 TB
D. Unlimited

**Answer:** C
**Explanation:** Aurora storage auto-scales up to 128 TB.

---

### 3. How many read replicas can Aurora have?
A. 5
B. 10
C. 15
D. 20

**Answer:** C
**Explanation:** Aurora supports up to 15 read replicas with sub-10ms replication lag.

---

### 4. Which RDS feature provides automatic failover?
A. Read Replicas
B. Multi-AZ deployment
C. Snapshots
D. Backups

**Answer:** B
**Explanation:** Multi-AZ provides automatic failover to standby instance in different AZ.

---

### 5. What is the purpose of RDS Read Replicas?
A. Automatic failover
B. Scale read workloads
C. Backup database
D. Encrypt data

**Answer:** B
**Explanation:** Read Replicas scale read-heavy workloads with asynchronous replication.

---

### 6. Which RDS encryption method encrypts data at rest?
A. SSL/TLS
B. KMS
C. IPSec
D. SSH

**Answer:** B
**Explanation:** RDS uses AWS KMS to encrypt data at rest (databases, backups, snapshots, replicas).

---

### 7. What is the maximum retention period for automated RDS backups?
A. 7 days
B. 14 days
C. 30 days
D. 35 days

**Answer:** D
**Explanation:** Automated backups can be retained for 0-35 days (default 7 days).

---

### 8. Which Aurora feature provides microsecond read latency?
A. Read Replicas
B. Aurora Serverless
C. Aurora Global Database
D. Aurora with DAX

**Answer:** D
**Explanation:** Aurora can integrate with DAX (DynamoDB Accelerator) for caching, but Aurora itself provides millisecond latency. This question is slightly misleading - Aurora doesn't have microsecond latency natively.

**Corrected Answer:** None of the above
**Explanation:** Aurora provides millisecond latency, not microsecond. DAX is for DynamoDB, not Aurora.

---

### 9. What is the purpose of RDS Proxy?
A. Backup database
B. Connection pooling and improved scalability
C. Encrypt connections
D. Monitor queries

**Answer:** B
**Explanation:** RDS Proxy pools and shares database connections, improving scalability and reducing failover time.

---

### 10. Which ElastiCache engine supports complex data structures (sorted sets, lists)?
A. Memcached
B. Redis
C. Both
D. Neither

**Answer:** B
**Explanation:** Redis supports complex data structures, persistence, replication, and high availability.

---

### 11. Which ElastiCache engine supports Multi-AZ with automatic failover?
A. Memcached
B. Redis
C. Both
D. Neither

**Answer:** B
**Explanation:** Redis supports Multi-AZ with automatic failover. Memcached does not support HA.

---

### 12. What is the purpose of ElastiCache?
A. Store files
B. In-memory caching for databases
C. Backup data
D. Encrypt data

**Answer:** B
**Explanation:** ElastiCache provides in-memory caching to reduce database load and improve performance.

---

### 13. Which Aurora feature allows read/write in multiple regions?
A. Aurora Replicas
B. Aurora Global Database
C. Aurora Serverless
D. Aurora Multi-Master

**Answer:** B
**Explanation:** Aurora Global Database spans multiple regions with <1s replication lag.

---

### 14. What is Aurora Serverless?
A. Aurora without servers
B. Auto-scaling Aurora that adjusts capacity based on demand
C. Aurora in Lambda
D. Aurora without storage

**Answer:** B
**Explanation:** Aurora Serverless automatically scales capacity up/down based on application needs.

---

### 15. Which RDS feature allows point-in-time recovery?
A. Snapshots only
B. Automated backups with transaction logs
C. Read Replicas
D. Multi-AZ

**Answer:** B
**Explanation:** Automated backups with transaction logs enable point-in-time recovery within retention period.

---

### 16. What is the replication type for RDS Read Replicas?
A. Synchronous
B. Asynchronous
C. Semi-synchronous
D. No replication

**Answer:** B
**Explanation:** Read Replicas use asynchronous replication (eventual consistency).

---

### 17. Which RDS feature encrypts data in transit?
A. KMS
B. SSL/TLS
C. IPSec
D. VPN

**Answer:** B
**Explanation:** SSL/TLS encrypts data in transit between application and RDS.

---

### 18. What is the maximum number of RDS Read Replicas?
A. 5
B. 10
C. 15
D. 20

**Answer:** C
**Explanation:** RDS supports up to 15 read replicas (5 for SQL Server).

---

### 19. Which caching strategy writes data to cache when written to database?
A. Lazy Loading
B. Write-Through
C. Write-Behind
D. Cache-Aside

**Answer:** B
**Explanation:** Write-Through writes data to cache simultaneously with database writes.

---

### 20. What is the purpose of Aurora Backtrack?
A. Backup database
B. Restore data to any point in time without backups
C. Replicate data
D. Encrypt data

**Answer:** B
**Explanation:** Aurora Backtrack allows "rewinding" database to a previous point in time (up to 72 hours).

---

### 21. What is Aurora Cloning used for?
A. Backup database
B. Create a copy-on-write clone for testing without impacting production
C. Replicate across regions
D. Scale reads

**Answer:** B
**Explanation:** Aurora Cloning creates a fast, cost-effective copy-on-write clone of the database for testing or development.

---

### 22. Which RDS feature allows access to the underlying OS?
A. RDS Standard
B. RDS Custom
C. RDS Advanced
D. Not possible

**Answer:** B
**Explanation:** RDS Custom (for Oracle and SQL Server) provides access to the underlying OS and database for custom configurations.

---

### 23. Which ElastiCache for Redis feature provides password authentication?
A. Redis AUTH
B. IAM Authentication
C. Security Groups
D. VPC Isolation

**Answer:** A
**Explanation:** Redis AUTH provides password-based authentication for ElastiCache for Redis clusters.

---

### 24. What is RDS Performance Insights used for?
A. Backup database
B. Monitor and analyze database performance with visual dashboard
C. Scale database
D. Encrypt data

**Answer:** B
**Explanation:** Performance Insights provides a visual dashboard to monitor database load and identify performance bottlenecks.

---

### 25. What is the purpose of ElastiCache for Redis Cluster Mode?
A. Single node deployment
B. Partition data across multiple shards for horizontal scaling
C. Backup data
D. Encrypt data

**Answer:** B
**Explanation:** Cluster Mode partitions data across multiple shards (up to 500 nodes) for horizontal scaling and higher throughput.
