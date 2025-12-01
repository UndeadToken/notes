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
