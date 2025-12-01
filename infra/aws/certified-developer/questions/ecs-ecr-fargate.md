### 1. Which ECS launch type requires managing EC2 instances?
A. Fargate
B. EC2
C. Lambda
D. Serverless

**Answer:** B
**Explanation:** EC2 launch type requires provisioning and managing EC2 instances. Fargate is serverless.

---

### 2. What is the maximum number of containers per ECS task definition?
A. 1
B. 5
C. 10
D. No limit

**Answer:** C
**Explanation:** A task definition can include up to 10 container definitions.

---

### 3. Which IAM role allows ECS tasks to access AWS services?
A. EC2 Instance Role
B. Task Role
C. Execution Role
D. Service Role

**Answer:** B
**Explanation:** Task Role provides IAM permissions for containers to access AWS services (S3, DynamoDB, etc.).

---

### 4. What is the purpose of the ECS Task Execution Role?
A. Allow tasks to access application resources
B. Allow ECS agent to pull images and write logs
C. Allow EC2 instances to join cluster
D. Allow load balancer to route traffic

**Answer:** B
**Explanation:** Execution Role allows ECS to pull container images from ECR and write logs to CloudWatch.

---

### 5. Which load balancer type is recommended for most ECS use cases?
A. Classic Load Balancer
B. Network Load Balancer
C. Application Load Balancer
D. Gateway Load Balancer

**Answer:** C
**Explanation:** ALB is recommended for most ECS workloads (Layer 7, path routing, WebSocket support).

---

### 6. What file system can be mounted to ECS tasks for persistent multi-AZ storage?
A. EBS
B. Instance Store
C. EFS
D. S3

**Answer:** C
**Explanation:** EFS provides persistent, multi-AZ storage that can be mounted to ECS tasks.

---

### 7. Which ECS feature automatically scales tasks based on CloudWatch metrics?
A. Service Auto Scaling
B. Cluster Auto Scaling
C. Task Auto Scaling
D. Container Auto Scaling

**Answer:** A
**Explanation:** ECS Service Auto Scaling adjusts task count based on metrics (CPU, memory, request count).

---

### 8. What is the maximum ephemeral storage for Fargate tasks?
A. 20 GB
B. 50 GB
C. 100 GB
D. 200 GB

**Answer:** D
**Explanation:** Fargate tasks support 20-200 GB ephemeral storage (task-lifecycle bound).

---

### 9. Which ECR feature scans container images for vulnerabilities?
A. Image Scanning
B. Image Validation
C. Security Scan
D. Vulnerability Check

**Answer:** A
**Explanation:** ECR Image Scanning detects software vulnerabilities in container images.

---

### 10. How does ECR authenticate Docker clients?
A. Username and password
B. API keys
C. IAM credentials via get-login-password
D. SSH keys

**Answer:** C
**Explanation:** Use `aws ecr get-login-password` to authenticate Docker with ECR using IAM credentials.

---

### 11. Which ECS task placement strategy minimizes the number of instances used?
A. Random
B. Spread
C. Binpack
D. Balanced

**Answer:** C
**Explanation:** Binpack places tasks to minimize instance usage (cost optimization).

---

### 12. What is the purpose of ECS Service Discovery?
A. Find available EC2 instances
B. Enable service-to-service communication via DNS
C. Discover container images
D. Monitor service health

**Answer:** B
**Explanation:** Service Discovery creates DNS records for ECS services, enabling service-to-service communication.

---

### 13. Which ECS feature ensures tasks run on separate instances?
A. Spread placement strategy
B. distinctInstance placement constraint
C. Binpack placement strategy
D. memberOf placement constraint

**Answer:** B
**Explanation:** distinctInstance constraint ensures each task runs on a different instance.

---

### 14. What is the maximum task definition size (JSON)?
A. 32 KB
B. 64 KB
C. 128 KB
D. 256 KB

**Answer:** B
**Explanation:** Task definition JSON is limited to 64 KB.

---

### 15. Which EKS node type is serverless?
A. Managed Node Groups
B. Self-Managed Nodes
C. Fargate
D. EC2 Nodes

**Answer:** C
**Explanation:** EKS on Fargate is serverless (no nodes to manage).

---

### 16. What is required to use EFS with EKS?
A. EBS CSI driver
B. EFS CSI driver
C. FSx driver
D. S3 driver

**Answer:** B
**Explanation:** EKS requires EFS CSI driver (Container Storage Interface) to mount EFS volumes.

---

### 17. Which ECS data volume type shares data between containers in the same task?
A. EFS volumes
B. Bind mounts
C. EBS volumes
D. S3 volumes

**Answer:** B
**Explanation:** Bind mounts share data between containers within the same task.

---

### 18. What happens to Fargate task storage when the task stops?
A. Data persists
B. Data is lost (ephemeral)
C. Data is backed up to S3
D. Data is snapshotted

**Answer:** B
**Explanation:** Fargate ephemeral storage is task-lifecycle bound and deleted when task stops.

---

### 19. Which AWS service simplifies building and deploying containerized apps on ECS/Fargate?
A. CloudFormation
B. AWS Copilot
C. SAM
D. CDK

**Answer:** B
**Explanation:** AWS Copilot CLI simplifies building, releasing, and operating containerized applications.

---

### 20. What is the default networking mode for Fargate tasks?
A. bridge
B. host
C. awsvpc
D. none

**Answer:** C
**Explanation:** Fargate tasks use awsvpc network mode (each task gets its own ENI and private IP).

---

### 21. What is ECS Anywhere used for?
A. Running ECS tasks in any AWS region
B. Running ECS tasks on on-premises servers
C. Running ECS tasks on multiple clouds
D. Running ECS tasks without containers

**Answer:** B
**Explanation:** ECS Anywhere allows running ECS tasks on customer-managed infrastructure (on-premises or other clouds).

---

### 22. Which ECR feature replicates images across regions?
A. Cross-Region Replication
B. Image Sync
C. Multi-Region Registry
D. Global Registry

**Answer:** A
**Explanation:** ECR Cross-Region Replication automatically replicates images to other regions for disaster recovery and low-latency access.

---

### 23. What is Fargate Spot?
A. Reserved capacity for Fargate
B. Discounted Fargate capacity using spare AWS capacity
C. Dedicated Fargate instances
D. Fargate with guaranteed availability

**Answer:** B
**Explanation:** Fargate Spot runs tasks on spare AWS capacity at up to 70% discount (can be interrupted with 2-minute notice).

---

### 24. Which feature allows executing commands in running ECS containers?
A. ECS Connect
B. ECS Shell
C. ECS Exec
D. Container SSH

**Answer:** C
**Explanation:** ECS Exec enables interactive shell access to running containers using AWS Systems Manager Session Manager.

---

### 25. What is the purpose of ECS Capacity Providers?
A. Manage container images
B. Manage cluster capacity with Auto Scaling Groups or Fargate
C. Provide network capacity
D. Manage storage capacity

**Answer:** B
**Explanation:** Capacity Providers manage cluster capacity, automatically scaling EC2 instances (ASG) or using Fargate/Fargate Spot.

---

### 26. What is the maximum number of tasks per service?
A. 100
B. 1,000
C. 10,000
D. Unlimited (account limits apply)

**Answer:** D
**Explanation:** No hard limit on tasks per service, subject to account-level limits.

---

### 27. Which ECS launch type requires managing EC2 instances?
A. Fargate
B. EC2
C. External
D. Serverless

**Answer:** B
**Explanation:** EC2 launch type requires managing and scaling EC2 instances in the cluster.

---

### 28. What is the maximum task definition size?
A. 32 KB
B. 64 KB
C. 128 KB
D. 256 KB

**Answer:** B
**Explanation:** Task definition maximum size is 64 KB.

---

### 29. Which ECS networking mode provides each task its own ENI?
A. Bridge
B. Host
C. awsvpc
D. None

**Answer:** C
**Explanation:** awsvpc mode gives each task its own elastic network interface (ENI) and private IP.

---

### 30. What is the maximum number of containers per task definition?
A. 5
B. 10
C. 20
D. Unlimited

**Answer:** B
**Explanation:** Task definitions support up to 10 containers.

---

### 31. Which ECS feature provides service auto scaling?
A. Application Auto Scaling
B. EC2 Auto Scaling
C. ECS Auto Scaling
D. Cluster Auto Scaling

**Answer:** A
**Explanation:** ECS uses Application Auto Scaling to scale services based on metrics.

---

### 32. What is the maximum number of task definition revisions?
A. 100
B. 1,000
C. 1 million
D. Unlimited

**Answer:** C
**Explanation:** Each task definition family supports up to 1 million revisions.

---

### 33. Which ECR feature scans images for vulnerabilities?
A. Image Scanning
B. Security Scan
C. Vulnerability Scan
D. Container Scan

**Answer:** A
**Explanation:** ECR Image Scanning detects software vulnerabilities in container images.

---

### 34. What is the maximum number of ECS clusters per region?
A. 100
B. 1,000
C. 10,000
D. Unlimited (soft limit of 10,000)

**Answer:** D
**Explanation:** Default limit is 10,000 clusters per region (soft limit).

---

### 35. Which ECS deployment type updates tasks gradually?
A. Rolling update
B. Blue/green deployment
C. Both A and B
D. Canary deployment

**Answer:** C
**Explanation:** ECS supports both rolling updates and blue/green deployments (with CodeDeploy).

---

### 36. What is the purpose of ECS Service Discovery?
A. Discover services
B. Automatic DNS-based service discovery using Route 53
C. Find containers
D. Network discovery

**Answer:** B
**Explanation:** Service Discovery automatically registers and discovers services using Route 53 Auto Naming.

---

### 37. Which Fargate platform version should be used for production?
A. LATEST
B. Specific version (e.g., 1.4.0)
C. DEFAULT
D. STABLE

**Answer:** B
**Explanation:** Use specific platform versions for production to control updates and ensure stability.

---

### 38. What is the maximum number of load balancers per ECS service?
A. 1
B. 5
C. 10
D. Unlimited

**Answer:** B
**Explanation:** ECS services support up to 5 load balancers (ALB/NLB target groups).

---

### 39. Which ECS feature allows running tasks on external infrastructure?
A. ECS External
B. ECS Anywhere
C. ECS Hybrid
D. ECS On-Premises

**Answer:** B
**Explanation:** ECS Anywhere allows running ECS tasks on on-premises or external infrastructure.

---

### 40. What is the maximum task CPU for Fargate?
A. 4 vCPU
B. 8 vCPU
C. 16 vCPU
D. 32 vCPU

**Answer:** C
**Explanation:** Fargate supports up to 16 vCPU per task.

---

### 41. Which ECS feature provides persistent storage?
A. EBS volumes
B. EFS volumes
C. Instance store
D. S3

**Answer:** B
**Explanation:** ECS tasks can mount EFS file systems for persistent, shared storage.

---

### 42. What is the maximum task memory for Fargate?
A. 30 GB
B. 60 GB
C. 120 GB
D. 240 GB

**Answer:** C
**Explanation:** Fargate supports up to 120 GB memory per task.

---

### 43. Which ECR feature replicates images across regions?
A. Cross-Region Replication
B. Image Replication
C. Multi-Region Replication
D. ECR Replication

**Answer:** B
**Explanation:** ECR Replication automatically replicates images to other regions or accounts.

---

### 44. What is the purpose of ECS task placement strategies?
A. Place tasks
B. Control how tasks are distributed across instances (binpack, spread, random)
C. Schedule tasks
D. Optimize placement

**Answer:** B
**Explanation:** Task placement strategies control task distribution: binpack (maximize utilization), spread (distribute), random.

---

### 45. Which ECS networking mode is required for Fargate?
A. Bridge
B. Host
C. awsvpc
D. None

**Answer:** C
**Explanation:** Fargate requires awsvpc networking mode.

---

### 46. What is the maximum number of ECR repositories per account?
A. 100
B. 1,000
C. 10,000
D. Unlimited (soft limit of 10,000)

**Answer:** D
**Explanation:** Default limit is 10,000 repositories per account (soft limit).

---

### 47. Which ECS feature allows running one-time tasks?
A. RunTask
B. StartTask
C. CreateTask
D. LaunchTask

**Answer:** A
**Explanation:** RunTask API runs one-time tasks (not part of a service).

---

### 48. What is the maximum image size for ECR?
A. 1 GB
B. 10 GB
C. 100 GB
D. Unlimited (10 GB per layer)

**Answer:** D
**Explanation:** No hard limit on image size, but each layer limited to 10 GB.

---

### 49. Which ECS deployment configuration controls task replacement?
A. Minimum healthy percent and maximum percent
B. Deployment strategy
C. Rolling update configuration
D. Task replacement policy

**Answer:** A
**Explanation:** Minimum healthy percent (lower bound) and maximum percent (upper bound) control task replacement during deployments.

---

### 50. What is the purpose of ECS task IAM roles?
A. Authenticate tasks
B. Grant AWS permissions to containers
C. Secure tasks
D. Manage access

**Answer:** B
**Explanation:** Task IAM roles grant AWS API permissions to containers running in the task.

