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
