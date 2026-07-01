Databases & Analytics: RDS, Aurora, ElastiCache  
  
- Storing data on disk (EFS, EBS, EC2 Instance Store, S3) can have its limits  
- Sometimes, you want to store data in a database  
- You can structure the data  
- You build indexes to efficiently query / search through the data  
- You define relationships between your datasets  
- Databases are optimised for purpose and come with different features, shapes and constraints  
  
Relational databases  
  
- Looks just like Excel spreadsheets, with links between them  
- Can use the SQL language to perform queries / lookups  
  
NoSQL Databases  
  
- NoSQL = non-SQL relational databases  
- NoSQL databases are purpose built for specific data models and have flexible schemas for building modern applications  
- Flexibility: easy to evolve data model  
- Scalability: designed to scale-out by using distributed clusters  
- High-performance: optimised for a specific data model  
- Highly functional: types optimised for the data model  
- Examples: Key-value, document, graph, in-memory, search databases  
  
NoSQL data examples:  
  
JSON  
  
- JSON = JavaScript Object Notation  
- JSON is a common form of data that fits into a NoSQL model  
- Data can be nested  
- Fields can change over time  
- Support for new types: arrays, etc…  
  
Databases & Shared Responsibility  on AWS  
  
- AWS offers use to manage different databases  
- Benefits include:  
    - Quick Provisioning, High Availability, vertical and Horizontal Scaling  
    - Automated Backup & Restore, Operations, Upgrades  
    - Operating System Patching is handled by AWS  
    - Monitoring, alerting  
  
Many database technologies could be run on EC2, but you must handled yourself the resiliency, backup, patching, high availability, fault tolerance, scaling…  
  
Amazon RDS  
  
- RDS stands for Relational Database Service  
- It’s a managed DB service for DB use SQL as a query language  
- It allows you to create databases in the cloud that are managed by AWS  
- Postgres’s  
- MySQL  
- MariaDB  
- Oracle  
- Microsoft SQL Server  
- IBM DB2  
- Aurora (AWS Proprietary database)  
  
Advantage over using RDS versus deploying DB on EC2  
  
- RDS is a managed service  
- Automated provisioning, OS patching  
- Continuous backups and restore to specific timestamp (Point in Time Restore)  
- Monitoring dashboards  
- Read replicas for improved read performance  
- Multi AZ setup for DR (Disaster Recovery)  
- Maintenance windows for upgrades  
- Scaling capability (vertical and horizontal)  
- Storage backed by EBS (gp2 or io1)  
- You can’t SSH into your instances  
  
RDS Solution Architecture  
  
-> ELB -> EC2 Instances (Possibly in an ASG) -> RDS  
  
  
Amazon Aurora  
  
- Aurora is proprietary technology from AWS (not open sourced)  
- PostgreSQL and MySQL are both supported as Aurora DB  
- Aurora is ”AWS cloud optimised” and claims 5x performance improvement over MySQL on RDS, over 3x the performance of Posters on RDS  
- Aurora storage automatically grows in increments of 10GB, up to 128 TB  
- Aurora costs more than RDS (20% more) — but is more efficient  
- Aurora can have up to 15 replicas and the replication process is faster than MySQL (sub 10ms replica lag)  
- Failover in Aurora is instantaneous. It’s HA native.  
- Not in the free tier  
  
Features of Aurora  
  
- Automatic fail-over  
- Backup and Recovery  
- Isolation and security  
- Industry compliance  
- Push-button scaling  
- Automated Patching with Zero Downtime  
- Advanced Monitoring  
- Routine Maintenance  
- Backtrack: restore data at any point of time without using backups  
  
Aurora High Availability and Read Scaling  
  
- 6 copies of your data across 3 AZ:  
    - 4 copies out of 6 needed for writes  
    - 3 copies out of 6 needed for reads  
    - Self healing with peer-to-peer replication  
    - Storage is striped across 100s of volumes  
- One Aurora Instance takes writes (master)  
- Automated failover for master in less than 30 seconds  
- Master + up to 15 Aurora Read Replicas serve reads  
- Supports for Cross Region Replication  
  
Amazon Aurora Serverless  
  
- Automated database instantiation and auto-scaling based on actual usage  
- PosgreSQL and MySQL are both supported as Aurora Serverless DB  
- No capacity planning needed  
- Least management overhead  
- Pay per second, can be more cost-effective   
- Use cases: good for infrequent, intermittent or unpredictable workloads…  
  
Client -> Proxy Fleet (managed by Aurora) -> amazon Aurora instances  
  
RDS Deployment Options  
  
RDS Deployments: Read Replicas, Multi-AZ:  
  
- Read Replicas:  
    - Scale the read workload of your DB  
    - Can create up to 15 Read Replicas  
    - Data is only written to the main DB  
- Multi-AZ:  
    - Failover in case of AZ outage (high availability)  
    - Data is only read/written to the main database  
    - Can only have 1 other AZ as failover  
- Multi-Region (Read Replicas):  
    - Disaster recovery in case of region issue  
    - Local performance for global reads  
    - Replication cost  
  
RDS Storage Auto Scaling  
  
- Helps you increase storage on your RDS DB instance dynamically  
- When RDS detects you are running out of free database storage, it scales automatically  
- Avoid manually scaling your database storage  
- You have to set Maximum Storage Threshold (maximum limit for DB storage)  
- Automatically modify storage if:  
    - Free storage is less than 10% of allocated storage  
    - Low-storage lasts at least 5 minutes  
    - 6 hours have passed since last modification  
- Useful for applications with unpredictable workloads  
- Supports all RDS database engines  
  
RDS Read Replicas for read scalability  
  
- Up to 15 Read Replicas  
- Within AZ, Cross AZ or Cross Region  
- Replication is ASYNC, so reads are eventually consistent  
- Replicas can be promoted to their own DB  
- Applications must update the connection string to leverage read replicas  
  
Read Replicas — use cases:  
- You have a production database that is taking on normal load  
- You want to run a reporting application to run some analytics  
- You create a Read Replica to run the new workload there  
- The production application is unaffected  
- Read replicas are used for SELECT (=read) only kind of statements (not INSERT, UPDATE, DELETE)  
  
Read Replicas — Network Cost:  
- In AWS there’s a network cost when data goes from one AZ to another  
- For RDS Read Replicas within the same region, you don’t pay that fee  
  
RDS Multi AZ (Disaster Recovery):  
- SYNC replication  
- One DNS name - automatic app failover to standby  
- Increase availability  
- Failover in case of loss of AZ, loss of network, instance or storage failure  
- No manual intervention in apps  
- Not used for scaling  
- Note: The Read Replicas can be setup as Multi AZ for Disaster Recovery (DR)  
  
RDS — From Single-AZ to Multi-AZ:  
- Zero downtime operation (no need to stop the DB)  
- Just click on “Modify” for the database  
- The following happens internally:  
    - A snapshot is taken  
    - A new DB s restored from the snapshot in a new AZ  
    - Synchronisation is established between the two databases  
  
RDS & Aurora Security  
  
No SSH available except on RDS Custom. Audit logs can be enabled and sent to CloudWatch Logs for longer retention.  
  
At-rest encryption  
  
- Database master & replicas encryption using AWS KMS — must be defined at launch time  
- If the master is not encrypted, the read replicas cannot be encrypted  
- To encrypt an un-encrypted database, go through a DB snapshot & restore as encrypted  
  
In-flight encryption  
  
- TLS-ready by default, use the AWS TLS root certificates client-side  
  
IAM Authentication  
  
- IAM roles to connect to your database (instead of username/pw)  
  
Security Groups  
  
- Control Network access to your RDS / Aurora DB  
  
Amazon RDS Proxy  
  
- Fully managed database proxy for RDS  
- Allows apps to pool and share DB connections established with the database  
- Improving database efficiency by reducing the stress on database resources (e.g. CPU, RAM) and minimize open connections (and timeouts)  
- Serverless, autoscalling, highly available (multi-AZ)  
- Reduced RDS & Aurora fail-pver time buy up to 66%  
- Supports RDS (MySQL, PostgreSQL, MariaDB, MS SQL Server) and Aurora (MySQL, PostgrSQL)  
- No code changes required for most apps  
- Enforce IAM Authentication for DB, and securely store credentials in AWS Secret Manager  
- RDS Proxy is never publicly accessible (must be accessed from VPC)  
  
Amazon ElastiCache Overview  
  
Applications queries ElastiCache, if not available, get from RDS and store in ElastiCache. Helps relieve load in RDS. Cache must have an invalidation strategy to make sure only the most current data is used in there.  
  
- The same way RDS is to get managed relational databases…  
- Elasticache is to get managed Redis or Memcached  
- Caches are in-memory databases with high-performance, low latency  
- Helps reduce load off databases for read intensive workloads  
- Helps make your application stateless  
- AWS takes care of OS maintenance / patching, optimizations, setup, configuration, monitoring, failure recovery and backups  
- Using ElastiCache involves heavy application code changes  
  
ElastiCache Solution Architecture - Cache  
  
->ELB->EC2 Instances -> ElasticCache, RDS  
  
 User Session Store  
  
- User logs into any of the application  
- The application writes the session data into ElastiCache  
- The user hits another instance of our application  
- The instance retrieves the data and the user is already logged in  
  
ElastiCache — Redis vs Memcached  
  
Redis (Replication HA):  
- Multi AZ with Auto-Failover  
- Read Replicas to scale reads and have high availability  
- Data Durability using AOF persistence  
- Backup and restore features  
- Supports Sets and Sorted Sets  
  
Memcached (Sharding No HA - can afford to lose data):   
- Multi-node for partitioning of data (sharding)  
- No high availability (replication)  
- Non persistent  
- No backup and restore  
- Multi-threaded architecture  
  
Caching Implementation Considerations  
  
https://aws.amazon.com/caching/implementation-considerations  
  
- Is it safe to cache data? Data may be out of data, eventually consistent  
- Is caching effective for that data?  
    - Pattern: data chasing slowly, few keys are frequently needed  
    - Anti patterns: data changing rapidly, all large key space frequently needed  
- Is data structured well for caching?  
    - Example: key value caching, or caching of aggregations results  
  
Lazy Loading / Cache-Aside / Lazy Population  
  
Write Through - Add or Update cache when database is updated  
  
Cache Evictions and Time-to-live (TTL)  
  
- Cache eviction can occur in three ways:  
    - You delete the item explicitly in the cache  
    - Item is evicted because the memory is full and it’s not recently used (LRU)  
    - You set an item time-to-live (or TTL)  
    - TTL are helpful for any kind of data  
        - Leaders  
        - Comments  
        - Activity streams  
    - TTL can range from few seconds to hours or days  
    - If too many evictions happen due to memory, you should scale up or out  
  
- Lazy Loading / Cache aside is easy to implement and words for many situations as a foundation, especially on the read side  
- Write-through is usually combined with Lazy Loading as targeted for the queries or workloads that benefit from the optimisation  
- Setting a TTL is usually not a bad idea, except when you’re Write-through. Set it to a sensible value for your application  
- Only cache the data that makes sense (user, profiles, blogs, etc…)  
- Quote: There are only two hard things in Computer Science: cache invalidation and naming things  
  
Amazon MemoryDB for Redis  
  
- Redis-compatible, durable, in-memory database service  
- Ultra-fast performance with over 160 million requests/second  
- Durable in-memory data storage with Multi-AZ transactional log  
- Scale seamlessly from 10s GBs to 100s TBs of storage  
- Use cases: web and mobile apps, online gaming, media streaming…  
  
DynamoDB  
  
- Fully Managed Highly available with replication across 3 AZ  
- NoSQL databases - not a relational database  
- Scales to massive workloads, distributed “serverless” database  
- Millions of requests per seconds, trillions of row, 100s of TB storage  
- Fast and consistent in performance  
- Single-digit millisecond latency — low latency retrieval  
- Integrated with IAM for security, authorization and administration  
- Low cost and auto scaling capabilities  
- Standard & Infrequent Access (IA) Table Class  
- DynamoDB is a key/value database  
  
https://aws.amazon.com/nosql/key-value/  
  
DynamoDB Accelerator - DAX  
  
- Fully managed  in-memory cache for DynamoDB  
- 10x performance improvement — single-digit millisecond latency — when accessing your DynamoDB tables  
- Secure, highly scalable & highly available  
- Difference with ElastiCache at the CCP level: DAX is only used for and is integrated with DynamoDB, while ElastiCache can be used for other databases  
  
Application -> DAX -> DynamoDB -> tables  
  
DynamoDB — Global Tables  
  
- Make a DynamoDB table accessible with low latency in multiple-regions  
- 2-way replication between global tables in multiple regions read/write  
- Active-Active replication (read/write to any AWS region)  
  
Redshift  
  
- Redshift is based on PostgreSQL, but its not used for OLTP  
- It’s OLAP — online analytical processing (analytics and data warehouse)  
- Load data once every hour, not every second  
- 10x better performance than other data warehouses, scale to PBs of data  
- Massively Parallel Query Execution (MPP), highly available  
- Pay as you go based on the instances provisioned  
- Has a SQL interface for performing the queries  
- BI tools such as AWS Quicksight or Tableau integrate with it  
  
Redshift Serverless  
  
- Automatically provisions and sales data warehouse underlying capacity  
- Run analytics workloads without managing data warehouse infrastructure  
- Pay only for what you use (save costs)  
- Use cases: Reporting, washboarding applications, real-time analytics…  
  
Steps:  
  
- Enable Amazon Redshift Serverless for your AWS Account  
- Connect using Amazon Redshift query Editor or any other tool  
- Amazon Redshift Serverless: run queries by automatically provision and scale capacity based on workloads  
- Pay only for compute and storage used during analysis  
  
Amazon EMR  
  
- EMR stands for “Elastic MapReduce”  
- EMR helps creating Hadoop Clusters (BigData) to analyse and process vast amounts of data  
- The clusters can be made of hundreds of EC2 instances  
- Also supports Apache Spark, Base, Presto, Flink  
- EMR takes care of all the provisioning and configuration  
- Auto-scaling and integrated with Spot instances  
- Use cases: data processing, machine learning, web indexing, big data…  
  
Amazon Athena  
  
- Serverless query service to performance analytics against s3 objects  
- Uses standard SQL language to query the files  
- Supports CSV,JSON,ORC,Avro and Paraquet (built on Presto)  
- Pricing: $5.00 per TB of data scanned  
- Use compressed or columnar data for cost-savings (less-scan)  
- Use cases: Business intelligence / analytics / reporting, analyse & query VPC Flow Logs, ELB Logs, CloudTrail trails etc…  
- Exam Tip: analyse data in S3 using server less SQL, use Athena  
  
Client -> load data -> S3 bucket -> Query & Analyse (Amazon Athena) -> Reporting Dashboards -> Amazon QuickSight  
  
Amazon QuickSight  
  
- Serverless machine learning-powered business intelligence service to create interactive dashboards  
- Fast, automatically scalable, embeddable, with per-session pricing  
- Use cases:  
    - Business analytics  
    - Building visualisations  
    - Perform ad-hoc analysis  
    - Get business insights using data  
- Integrated with RDS, Aurora, Athena, Redshift, S3  
  
Document DB  
  
- Aurora is an “AWS-implementation” of PostgreSQL / MySQL  
- DocumentDB is the same for MongoDB (Which is a NoSQL database)  
- MongoDB is used to store, query and index JSON data  
- Similar “deployment concepts” as Aurora  
- Fully Managed, highly available with replication across 3 AZ  
- DocumentDB storage automatically grows in increments of 10GB  
- Automatically scales to workloads with millions of requests  
  
Amazon Neptune  
  
- Fully managed graph database  
- A popular graph dataset would be a social network  
    - Users have friends  
    - Posts have comments  
    - Comments have likes from users  
    - Users share and like posts…  
- Highly available across 3 AZ with up to 15 read replicas  
- Build and run applications working with highly connected datasets — optimised for the complex and hard queries  
- Can store up to billions of relations and query the graph with milliseconds latency  
- Highly available with replication across multiple AZs  
- Great for knowledge graphs (Wikipedia), fraud detection, recommendation engines, social networking  
  
Amazon Timestream  
  
- Fully managed, fast, scalable, serves time series database  
- Automatically scales up/down to adjust capacity  
- Store and analyse trillions of events per day  
- 1000s times faster & 1/10th the cost of relational databases  
- Built-in time series analytics functions (helps you identify patterns in your data in near real-time)  
  
Amazon QLDB  
  
- QLDB stands for Quantum Ledger Database  
- A ledger is a book recording financial transactions  
- Fully managed, m server less, high available, replication across 3 AZ  
- Used to review history of all the changes made to your application data over time  
- Immutable system: no entry can be removed or modified, cryptographically verifiable  
- 2-3x better performance than common ledger blockchain frameworks, manipulate data using SQL  
- 2-3x better performance than common ledger blockchain frameworks, manipulate data using SQL  
- Difference with Amazon Managed blockchain: no decentralisation component, in accordance with financial regulation rules  
  
Managed Blockchain Overview  
  
- Blockchain makes it possible to build applications where multiple parties can execute transactions without the need for a trusted, central authority  
- Amazon Managed Blockchain is a managed service to:  
    - Join public blockchain networks  
    - Or create your own scalable private network  
- Compatible with the frameworks Hyperledger Fabric and Ethereum  
  
AWS Glue  
  
- Managed extract, transform and loads (ETL) service  
- Useful to prepare and transform data for analytics  
- Fully serverless service  
  
Glue data Catalog: catalog of datasets:  
Can be used with Athena, redshift, EMR  
  
S3 Bucket, RDS -> Extract -> transform (Glue ETL) -> Load -> Redshift  
  
Amazon DMS (Database Migration Service)  
  
- Quickly and securely migrate databases to AWS, resilient, self healing  
- The source database remains available during the migration  
- Supports Homogeneous migrations: ex Oracle to Oracle  
- Heterogeneous migrations: ex Microsoft SQL Server to Aurora  
  
Source DB -> EC2 Running DMS -> Target DB  
  
Amazon ElastiCache  
  
Summary  
  
- Relational Databases - OLTP: RDS & Aurora (SQL)  
- Differences between Multi-AZ, Read Replicas, Multi-Region  
- In-memory Database: ElastiCache  
- Key/Value Database: Dynamo DB (serverless) & DAX (cache for DynamoDB)  
- Warehouse - OLAP: Redshift (SQL)  
- Hadoop Cluster: EMR  
- Athena: query data on Amazon S3 (Serverless & SQL)  
- QuickSight: dashboards on your data (server less)  
- DocumentDB: Aurora for MongoDB (JSON — NoSQL database)  
- Amazon QLDB: Financial Transactions Ledger (immutable journal, cryptographically verifiable)  
- Amazon Managed Blockchain: managed Hyperledger Fabric & Ethereal blockchains  
- Glue: managed ETL (Extract Transform Load) and Data Catalog service  
- Database Migration: DMS  
- Neptune: graph database  
- Timestream: time-series database  
