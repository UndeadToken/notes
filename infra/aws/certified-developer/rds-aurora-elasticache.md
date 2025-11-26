# AWS Databases & Analytics Overview

## Why Use Databases
- Disk storage (EBS, EFS, EC2, S3) has limits
- Databases allow structured storage, indexing, relationships
- Optimized for specific workloads and performance
- Types:
  - **Relational:** SQL, structured, like spreadsheets
  - **NoSQL:** Flexible schema, distributed, high-performance, purpose-built

---

## NoSQL Data Example
- JSON (JavaScript Object Notation)
  - Nested data, flexible fields, supports arrays
  - Works well with NoSQL databases

---

## AWS Managed Database Benefits
- Quick provisioning, high availability
- Vertical & horizontal scaling
- Automated backup & restore
- OS patching handled by AWS
- Monitoring & alerts

---

## Amazon RDS (Relational Database Service)
- Managed SQL databases
- Supported engines: PostgreSQL, MySQL, MariaDB, Oracle, SQL Server, IBM DB2, Aurora
- Advantages over EC2-hosted DB:
  - Automated provisioning, patching, backups
  - Multi-AZ setup for disaster recovery
  - Read replicas for read scaling
  - Monitoring dashboards
  - Vertical and horizontal scaling
  - Storage backed by EBS
  - No SSH access

### Architecture
```
ELB -> EC2 (ASG optional) -> RDS
```

---

## Amazon Aurora
- AWS proprietary, cloud-optimized RDBMS
- MySQL & PostgreSQL compatible
- 5x MySQL, 3x PostgreSQL performance vs standard RDS
- Storage auto-grows, up to 128 TB
- Up to 15 replicas, sub-10ms replication
- Automatic failover (<30s)
- Serverless option for auto-scaling and pay-per-use

### Features
- Automatic failover
- Backup & recovery
- Push-button scaling
- Automated patching
- Advanced monitoring
- Backtrack (restore data to any point in time)

### High Availability & Scaling
- 6 copies across 3 AZs
- Writes need 4 copies, reads need 3 copies
- Master + 15 read replicas
- Cross-region replication support

---

## RDS Deployment Options
- **Read Replicas:** scale read-heavy workloads, async replication
- **Multi-AZ:** high availability, sync replication, automatic failover
- **Multi-Region Read Replicas:** disaster recovery, global reads

### RDS Storage Auto Scaling
- Dynamically increases storage when free storage <10%
- Max storage threshold must be set
- Supports all RDS engines

---

## RDS & Aurora Security
- No SSH (except RDS Custom)
- Audit logs via CloudWatch
- **At-rest encryption:** AWS KMS
- **In-flight encryption:** TLS default
- IAM authentication & Security Groups control network access
- **RDS Proxy:** connection pooling, auto-scaling, multi-AZ, IAM support

---

## Amazon ElastiCache
- Managed in-memory caching: Redis or Memcached
- Reduces load on databases
- Stateless application support
- Redis: replication, high availability, persistence
- Memcached: sharding, no HA, non-persistent
- Cache strategies: Lazy loading, write-through, TTL, evictions
- MemoryDB: Redis-compatible, durable, in-memory database

### Architecture
```
ELB -> EC2 -> ElastiCache / RDS
```

---

## DynamoDB
- Fully managed NoSQL key-value database
- Highly scalable & low-latency
- DAX: in-memory caching for DynamoDB (10x performance)
- Global Tables: multi-region active-active replication

---

## Data Warehousing & Analytics
- **Redshift:** OLAP, SQL, PB-scale, MPP queries
- **Redshift Serverless:** auto-provisioning, pay-per-use
- **EMR:** Hadoop, Spark, Presto, Flink for Big Data
- **Athena:** serverless SQL queries on S3
- **QuickSight:** serverless BI dashboards

---

## Other AWS Database Services
- **DocumentDB:** MongoDB-compatible, JSON NoSQL
- **Neptune:** graph database, social networks, recommendations, fraud detection
- **Timestream:** time-series DB, scalable, real-time analytics
- **QLDB:** immutable ledger, cryptographically verifiable
- **Managed Blockchain:** Hyperledger Fabric & Ethereum
- **Glue:** ETL and data catalog
- **DMS:** database migration, homogeneous & heterogeneous

---

## Summary Table
| Purpose | Service |
|---------|---------|
| Relational DB / OLTP | RDS, Aurora |
| In-memory cache | ElastiCache, MemoryDB |
| Key-value / NoSQL | DynamoDB, DAX |
| Data warehouse / OLAP | Redshift |
| Hadoop / Big Data | EMR |
| Query S3 data | Athena |
| Dashboards / BI | QuickSight |
| Document DB | DocumentDB |
| Ledger / Immutable | QLDB |
| Blockchain | Managed Blockchain |
| ETL | Glue |
| Migration | DMS |
| Graph DB | Neptune |
| Time series | Timestream |
