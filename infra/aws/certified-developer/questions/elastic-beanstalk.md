### 1. Which Elastic Beanstalk deployment option has the fastest deployment time but causes downtime?
A. Rolling
B. All at once
C. Immutable
D. Blue/Green

**Answer:** B
**Explanation:** All at once deploys to all instances simultaneously (fastest, but causes downtime).

---

### 2. What file extension is required for Elastic Beanstalk configuration files?
A. .yaml
B. .json
C. .config
D. .ebextensions

**Answer:** C
**Explanation:** Configuration files in .ebextensions/ must have .config extension (YAML or JSON).

---

### 3. Which Elastic Beanstalk deployment creates a new Auto Scaling Group?
A. Rolling
B. Rolling with additional batches
C. Immutable
D. All at once

**Answer:** C
**Explanation:** Immutable deployment creates a new ASG with new instances, then swaps when healthy.

---

### 4. What is the maximum number of application versions Elastic Beanstalk stores?
A. 100
B. 500
C. 1,000
D. Unlimited

**Answer:** C
**Explanation:** Elastic Beanstalk stores max 1,000 versions. Use lifecycle policies to auto-delete old versions.

---

### 5. Where should .ebextensions configuration files be located?
A. Root of source bundle
B. /config directory
C. .ebextensions/ directory in source root
D. S3 bucket

**Answer:** C
**Explanation:** Configuration files must be in .ebextensions/ directory at the source bundle root.

---

### 6. Which Elastic Beanstalk deployment allows testing with a small percentage of traffic?
A. Rolling
B. Canary
C. Traffic Splitting
D. Blue/Green

**Answer:** C
**Explanation:** Traffic Splitting sends a percentage of traffic to new version for canary testing.

---

### 7. What happens to RDS databases provisioned by Elastic Beanstalk when the environment is terminated?
A. Database is retained
B. Database is deleted
C. Database is snapshotted
D. Database is migrated

**Answer:** B
**Explanation:** EB-provisioned RDS is tied to environment lifecycle and deleted with the environment.

---

### 8. Which Elastic Beanstalk CLI command deploys a new application version?
A. eb create
B. eb deploy
C. eb update
D. eb push

**Answer:** B
**Explanation:** `eb deploy` deploys a new application version to the environment.

---

### 9. An Elastic Beanstalk environment needs to change load balancer type. What is required?
A. Update environment configuration
B. Create new environment with desired LB type
C. Use .ebextensions to modify LB
D. Contact AWS Support

**Answer:** B
**Explanation:** Load balancer type cannot be changed after creation. Must create new environment.

---

### 10. Which Elastic Beanstalk deployment maintains full capacity during updates?
A. All at once
B. Rolling
C. Rolling with additional batches
D. Immutable

**Answer:** C
**Explanation:** Rolling with additional batches launches new instances first, maintaining full capacity.

---

### 11. What is the recommended approach for RDS in production Elastic Beanstalk environments?
A. Provision RDS via Elastic Beanstalk
B. Create RDS separately and provide connection string
C. Use SQLite
D. Use DynamoDB instead

**Answer:** B
**Explanation:** Create RDS separately for production to avoid deletion when environment is terminated.

---

### 12. Which Elastic Beanstalk feature allows cloning an environment?
A. Environment duplication
B. Environment cloning
C. Environment snapshot
D. Environment backup

**Answer:** B
**Explanation:** Cloning creates a new environment with the same configuration (data not preserved).

---

### 13. What is the purpose of Elastic Beanstalk lifecycle policies?
A. Manage environment updates
B. Auto-delete old application versions
C. Configure auto-scaling
D. Set retention for logs

**Answer:** B
**Explanation:** Lifecycle policies automatically delete old versions based on age or count.

---

### 14. Which Elastic Beanstalk platform supports Docker containers?
A. Single Container Docker
B. Multi-container Docker
C. Preconfigured Docker
D. All of the above

**Answer:** D
**Explanation:** Elastic Beanstalk supports Single Container, Multi-container, and Preconfigured Docker platforms.

---

### 15. What file defines dependencies for a Python Elastic Beanstalk application?
A. package.json
B. requirements.txt
C. Gemfile
D. pom.xml

**Answer:** B
**Explanation:** Python applications use requirements.txt to define dependencies.

---

### 16. Which Elastic Beanstalk deployment option has zero downtime and is safest?
A. All at once
B. Rolling
C. Immutable
D. Rolling with additional batches

**Answer:** C
**Explanation:** Immutable deployment is safest (zero downtime, easy rollback, new instances).

---

### 17. How does Elastic Beanstalk Blue/Green deployment work?
A. Updates instances in batches
B. Creates new environment, swaps CNAME
C. Updates all instances simultaneously
D. Uses traffic splitting

**Answer:** B
**Explanation:** Blue/Green creates a new environment, then swaps CNAME when ready.

---

### 18. Which Elastic Beanstalk environment tier is used for background processing?
A. Web Server tier
B. Worker tier
C. Batch tier
D. Processing tier

**Answer:** B
**Explanation:** Worker tier processes background tasks from SQS queues.

---

### 19. What is the default health check path for Elastic Beanstalk?
A. /
B. /health
C. /status
D. /ping

**Answer:** A
**Explanation:** Default health check path is / (root). Can be customized.

---

### 20. Which Elastic Beanstalk feature allows saving environment configuration for reuse?
A. Configuration templates
B. Saved configurations
C. Environment snapshots
D. Configuration profiles

**Answer:** B
**Explanation:** Saved configurations preserve environment settings for reuse across environments.

---

### 21. What is the purpose of Elastic Beanstalk Platform Updates?
A. Update application code
B. Update platform version (OS, runtime, web server)
C. Update environment configuration
D. Update database schema

**Answer:** B
**Explanation:** Platform Updates upgrade the underlying platform (OS patches, runtime versions, web server updates).

---

### 22. Which file defines services for Multi-container Docker platform?
A. Dockerfile
B. Dockerrun.aws.json
C. docker-compose.yml
D. container.config

**Answer:** B
**Explanation:** Dockerrun.aws.json (v2) defines container definitions for Multi-container Docker environments.

---

### 23. How can you schedule periodic tasks in Worker tier environments?
A. CloudWatch Events
B. cron.yaml file
C. Lambda scheduled events
D. .ebextensions

**Answer:** B
**Explanation:** cron.yaml in Worker tier schedules periodic tasks by posting messages to the worker queue.

---

### 24. Which Elastic Beanstalk feature allows setting environment-specific values?
A. Parameters
B. Environment properties
C. Configuration files
D. Stage variables

**Answer:** B
**Explanation:** Environment properties define key-value pairs accessible as environment variables in the application.

---

### 25. What is Elastic Beanstalk Managed Platform Updates?
A. Manual platform updates
B. Automatic platform updates during maintenance window
C. Application code updates
D. Database updates

**Answer:** B
**Explanation:** Managed Platform Updates automatically apply platform patches during a configured maintenance window.

---

### 26. What is the maximum number of application versions per application?
A. 100
B. 500
C. 1,000
D. Unlimited

**Answer:** C
**Explanation:** Elastic Beanstalk supports up to 1,000 application versions per application.

---

### 27. Which Elastic Beanstalk deployment policy has zero downtime?
A. All at once
B. Rolling
C. Rolling with additional batch
D. Immutable

**Answer:** D
**Explanation:** Immutable deployment launches new instances with new version, maintaining full capacity (zero downtime).

---

### 28. What is the purpose of .ebextensions folder?
A. Store extensions
B. Customize environment with configuration files
C. Store logs
D. Store backups

**Answer:** B
**Explanation:** .ebextensions contains YAML/JSON configuration files to customize the environment.

---

### 29. Which Elastic Beanstalk platform supports Docker Compose?
A. Docker platform
B. Multi-container Docker platform
C. Both A and B
D. Not supported

**Answer:** B
**Explanation:** Multi-container Docker platform uses Docker Compose (Dockerrun.aws.json v2).

---

### 30. What is the maximum number of environments per application?
A. 10
B. 50
C. 100
D. 200

**Answer:** D
**Explanation:** Each application supports up to 200 environments.

---

### 31. Which Elastic Beanstalk deployment policy is fastest?
A. All at once
B. Rolling
C. Rolling with additional batch
D. Immutable

**Answer:** A
**Explanation:** All at once deploys to all instances simultaneously (fastest, but has downtime).

---

### 32. What is the purpose of Elastic Beanstalk saved configurations?
A. Save environment
B. Save and reuse environment configuration
C. Backup configurations
D. Export configurations

**Answer:** B
**Explanation:** Saved configurations store environment settings for reuse across environments.

---

### 33. Which Elastic Beanstalk feature provides HTTPS?
A. Load Balancer with SSL certificate
B. CloudFront
C. API Gateway
D. Route 53

**Answer:** A
**Explanation:** Configure Load Balancer with SSL certificate for HTTPS support.

---

### 34. What is the maximum deployment timeout?
A. 30 minutes
B. 1 hour
C. 4 hours
D. No limit

**Answer:** C
**Explanation:** Maximum deployment timeout is 4 hours (240 minutes).

---

### 35. Which Elastic Beanstalk platform tier runs background tasks?
A. Web Server tier
B. Worker tier
C. Batch tier
D. Background tier

**Answer:** B
**Explanation:** Worker tier processes background tasks from SQS queues.

---

### 36. What is the purpose of Elastic Beanstalk environment cloning?
A. Clone application
B. Create exact copy of environment
C. Backup environment
D. Duplicate instances

**Answer:** B
**Explanation:** Cloning creates an exact copy of an environment with same configuration.

---

### 37. Which Elastic Beanstalk metric indicates application health?
A. EnvironmentHealth
B. InstanceHealth
C. ApplicationHealth
D. All of the above

**Answer:** A
**Explanation:** EnvironmentHealth metric indicates overall environment health status.

---

### 38. What is the maximum number of instances per environment?
A. 100
B. 500
C. 1,000
D. Depends on instance type and account limits

**Answer:** D
**Explanation:** Limited by EC2 instance limits and account quotas (typically hundreds).

---

### 39. Which Elastic Beanstalk deployment policy minimizes cost during deployment?
A. All at once
B. Rolling
C. Rolling with additional batch
D. Immutable

**Answer:** B
**Explanation:** Rolling deployment uses existing instances without launching additional capacity.

---

### 40. What is the purpose of Elastic Beanstalk lifecycle policies?
A. Manage instance lifecycle
B. Automatically delete old application versions
C. Manage environment lifecycle
D. Schedule updates

**Answer:** B
**Explanation:** Lifecycle policies automatically delete old application versions based on age or count.

---

### 41. Which Elastic Beanstalk configuration file format is supported?
A. YAML
B. JSON
C. Both A and B
D. XML

**Answer:** C
**Explanation:** .ebextensions supports both YAML (.config) and JSON configuration files.

---

### 42. What is the maximum size of application source bundle?
A. 100 MB
B. 512 MB
C. 1 GB
D. 5 GB

**Answer:** B
**Explanation:** Maximum application source bundle size is 512 MB.

---

### 43. Which Elastic Beanstalk feature provides blue/green deployments?
A. Swap environment URLs
B. Clone and swap
C. Traffic splitting
D. All of the above

**Answer:** D
**Explanation:** Blue/green deployments use environment cloning, URL swapping, or traffic splitting.

---

### 44. What is the purpose of Elastic Beanstalk enhanced health reporting?
A. Basic health checks
B. Detailed health metrics and monitoring
C. Cost reporting
D. Performance reporting

**Answer:** B
**Explanation:** Enhanced health reporting provides detailed metrics, causes of health issues, and instance-level health.

---

### 45. Which Elastic Beanstalk platform supports custom AMIs?
A. All platforms
B. Docker only
C. Custom platform
D. Not supported

**Answer:** C
**Explanation:** Custom platforms allow using custom AMIs with Packer.

---

### 46. What is the maximum number of tags per environment?
A. 10
B. 25
C. 47
D. 50

**Answer:** C
**Explanation:** Environments support up to 47 tags.

---

### 47. Which Elastic Beanstalk deployment policy is safest?
A. All at once
B. Rolling
C. Rolling with additional batch
D. Immutable

**Answer:** D
**Explanation:** Immutable deployment is safest - launches new instances, easy rollback, no impact on existing instances.

---

### 48. What is the purpose of Elastic Beanstalk environment links?
A. Link environments
B. Share resources between environments (RDS, ElastiCache)
C. Network linking
D. Load balancing

**Answer:** B
**Explanation:** Environment links allow sharing resources like RDS databases between environments.

---

### 49. Which Elastic Beanstalk feature allows gradual traffic shifting?
A. Canary deployment
B. Traffic splitting deployment
C. Blue/green deployment
D. Rolling deployment

**Answer:** B
**Explanation:** Traffic splitting deployment gradually shifts traffic to new version for testing.

---

### 50. What is the maximum number of environment properties?
A. 50
B. 100
C. 200
D. Unlimited

**Answer:** C
**Explanation:** Environments support up to 200 environment properties (key-value pairs).

