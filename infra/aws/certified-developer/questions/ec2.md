### 1. Which EC2 instance type is included in the AWS Free Tier?
A. t2.small
B. t2.micro
C. t3.micro
D. m5.large

**Answer:** B
**Explanation:** t2.micro provides 750 hours/month in the AWS Free Tier.

---

### 2. What is the purpose of EC2 User Data?
A. Store user credentials
B. Run scripts at instance first launch
C. Configure security groups
D. Create AMIs

**Answer:** B
**Explanation:** User Data runs bootstrap scripts as root at first instance launch.

---

### 3. Which EC2 purchasing option provides up to 90% discount but can be terminated anytime?
A. On-Demand
B. Reserved Instances
C. Spot Instances
D. Dedicated Hosts

**Answer:** C
**Explanation:** Spot Instances offer up to 90% discount but can be terminated by AWS when capacity is needed.

---

### 4. What is the default termination behavior for root EBS volumes?
A. Retained
B. Deleted
C. Snapshotted
D. Encrypted

**Answer:** B
**Explanation:** Root EBS volumes are deleted by default when instance terminates (can be changed).

---

### 5. Which EC2 metadata URL provides instance information?
A. http://169.254.169.254/latest/meta-data
B. http://localhost/metadata
C. http://ec2-metadata.aws
D. http://metadata.ec2.internal

**Answer:** A
**Explanation:** Instance metadata is available at http://169.254.169.254/latest/meta-data.

---

### 6. What is the difference between IMDSv1 and IMDSv2?
A. No difference
B. IMDSv2 requires session token for security
C. IMDSv1 is faster
D. IMDSv2 only works in VPC

**Answer:** B
**Explanation:** IMDSv2 requires obtaining a session token first, improving security against SSRF attacks.

---

### 7. Which EC2 instance type is optimized for memory-intensive applications?
A. t2 (burstable)
B. c5 (compute optimized)
C. r5 (memory optimized)
D. i3 (storage optimized)

**Answer:** C
**Explanation:** r5 instances are memory-optimized for in-memory databases and big data processing.

---

### 8. What is the purpose of EC2 Security Groups?
A. Encrypt data
B. Act as virtual firewalls controlling inbound/outbound traffic
C. Monitor instances
D. Create backups

**Answer:** B
**Explanation:** Security Groups are stateful firewalls controlling traffic at the instance level.

---

### 9. Which EC2 purchasing option requires a 1 or 3-year commitment?
A. On-Demand
B. Spot Instances
C. Reserved Instances
D. Capacity Reservations

**Answer:** C
**Explanation:** Reserved Instances require 1 or 3-year commitment for up to 72% discount.

---

### 10. What happens when an EC2 instance is stopped?
A. Instance is terminated
B. Data on instance store is lost
C. EBS data is lost
D. Instance cannot be restarted

**Answer:** B
**Explanation:** Instance store (ephemeral) data is lost when instance stops. EBS data persists.

---

### 11. Which EC2 feature allows changing instance type?
A. Instance resizing
B. Instance modification
C. Stop instance, change type, restart
D. Not possible

**Answer:** C
**Explanation:** Stop the instance, change instance type, then restart (EBS-backed instances only).

---

### 12. What is the purpose of EC2 Placement Groups?
A. Group instances for billing
B. Control instance placement for performance/availability
C. Create auto-scaling groups
D. Manage security groups

**Answer:** B
**Explanation:** Placement Groups control how instances are placed (cluster, spread, partition) for performance or availability.

---

### 13. Which EC2 instance type provides dedicated physical servers?
A. On-Demand
B. Reserved
C. Dedicated Hosts
D. Spot

**Answer:** C
**Explanation:** Dedicated Hosts provide physical servers dedicated to your use (for licensing/compliance).

---

### 14. What is the maximum number of Elastic IPs per region by default?
A. 1
B. 5
C. 10
D. 20

**Answer:** B
**Explanation:** Default limit is 5 Elastic IPs per region (can be increased).

---

### 15. Which EC2 feature provides detailed monitoring at 1-minute intervals?
A. Basic Monitoring
B. Detailed Monitoring
C. CloudWatch Logs
D. CloudTrail

**Answer:** B
**Explanation:** Detailed Monitoring provides metrics every 1 minute (vs 5 minutes for basic).

---

### 16. What is the purpose of EC2 Instance Connect?
A. Connect instances to VPC
B. SSH access via browser without key pairs
C. Connect to RDS
D. VPN connection

**Answer:** B
**Explanation:** EC2 Instance Connect provides browser-based SSH access without managing key pairs.

---

### 17. Which EC2 instance state incurs charges?
A. Stopped
B. Running
C. Terminated
D. Pending

**Answer:** B
**Explanation:** Charges apply only when instance is in running state (EBS storage charged separately).

---

### 18. What is the purpose of EC2 Launch Templates?
A. Create AMIs
B. Define instance configuration for reuse
C. Monitor instances
D. Create security groups

**Answer:** B
**Explanation:** Launch Templates define instance configuration (AMI, type, storage, network) for reuse.

---

### 19. Which EC2 instance type is best for burstable CPU performance?
A. t2/t3 instances
B. c5 instances
C. m5 instances
D. r5 instances

**Answer:** A
**Explanation:** t2/t3 instances provide burstable CPU performance with CPU credits.

---

### 20. What is the maximum number of network interfaces per EC2 instance?
A. 1
B. Depends on instance type
C. 5
D. Unlimited

**Answer:** B
**Explanation:** Maximum ENIs depends on instance type (e.g., t2.micro: 2, m5.large: 3).

---

### 21. What is EC2 Hibernation used for?
A. Stop instance permanently
B. Save RAM state to EBS and resume later
C. Create AMI
D. Terminate instance

**Answer:** B
**Explanation:** Hibernation saves RAM contents to EBS root volume, allowing fast resume with preserved state.

---

### 22. Which EC2 feature provides enhanced networking with higher bandwidth and lower latency?
A. Enhanced Networking (SR-IOV)
B. Elastic Network Adapter (ENA)
C. Nitro System
D. All of the above

**Answer:** D
**Explanation:** Enhanced Networking (SR-IOV), ENA, and Nitro System all provide improved network performance.

---

### 23. What is the purpose of EC2 Instance Metadata categories?
A. Monitor instances
B. Provide instance information (AMI ID, instance type, security groups, etc.)
C. Store user data
D. Configure networking

**Answer:** B
**Explanation:** Instance metadata provides information about the instance including AMI ID, instance type, public/private IPs, security groups, and IAM role credentials.

---

### 24. Which service automates AMI creation and maintenance?
A. EC2 Image Builder
B. AMI Builder
C. CloudFormation
D. Systems Manager

**Answer:** A
**Explanation:** EC2 Image Builder automates creation, management, and deployment of customized, secure AMIs.

---

### 25. What is a Spot Fleet?
A. Group of On-Demand instances
B. Collection of Spot and optionally On-Demand instances
C. Reserved Instance pool
D. Dedicated Host group

**Answer:** B
**Explanation:** Spot Fleet is a collection of Spot Instances and optionally On-Demand instances that meet specified capacity requirements.

---

### 26. What is the maximum number of EC2 instances per region by default?
A. 20
B. 100
C. 1,000
D. Varies by instance type (typically 20 On-Demand)

**Answer:** D
**Explanation:** Default limits vary by instance type (typically 20 On-Demand vCPUs per region, can be increased).

---

### 27. Which EC2 placement group provides lowest latency?
A. Cluster
B. Spread
C. Partition
D. All same latency

**Answer:** A
**Explanation:** Cluster placement group provides lowest latency by placing instances close together in single AZ.

---

### 28. What is the maximum number of security groups per instance?
A. 1
B. 5
C. 10
D. 16

**Answer:** B
**Explanation:** EC2 instances support up to 5 security groups.

---

### 29. Which EC2 instance type is optimized for memory-intensive workloads?
A. C-series (Compute Optimized)
B. R-series (Memory Optimized)
C. T-series (Burstable)
D. M-series (General Purpose)

**Answer:** B
**Explanation:** R-series instances are memory-optimized for memory-intensive applications.

---

### 30. What is the maximum number of ENIs per instance?
A. 1
B. 5
C. Depends on instance type
D. Unlimited

**Answer:** C
**Explanation:** Maximum ENIs depends on instance type (ranges from 2 to 15).

---

### 31. Which EC2 pricing model provides highest discount?
A. On-Demand
B. Reserved Instances
C. Spot Instances
D. Savings Plans

**Answer:** C
**Explanation:** Spot Instances provide up to 90% discount but can be interrupted.

---

### 32. What is the purpose of EC2 User Data?
A. Store user information
B. Run scripts at instance launch
C. Configure users
D. Backup data

**Answer:** B
**Explanation:** User Data runs scripts/commands automatically when instance launches.

---

### 33. Which EC2 feature allows changing instance type?
A. Instance modification
B. Instance resizing
C. Stop instance, change type, restart
D. Not possible

**Answer:** C
**Explanation:** Stop instance, change instance type, then restart (for EBS-backed instances).

---

### 34. What is the maximum number of tags per EC2 instance?
A. 10
B. 25
C. 50
D. 100

**Answer:** C
**Explanation:** EC2 instances support up to 50 tags.

---

### 35. Which EC2 instance purchasing option provides capacity reservation?
A. On-Demand
B. Reserved Instances
C. On-Demand Capacity Reservations
D. Both B and C

**Answer:** D
**Explanation:** Both Reserved Instances and On-Demand Capacity Reservations provide capacity reservation.

---

### 36. What is the purpose of EC2 placement groups?
A. Group instances
B. Control instance placement for performance or availability
C. Organize resources
D. Manage capacity

**Answer:** B
**Explanation:** Placement groups control how instances are placed on underlying hardware for performance or availability.

---

### 37. Which EC2 instance state incurs charges?
A. Running
B. Stopped
C. Terminated
D. Pending

**Answer:** A
**Explanation:** Only running instances incur compute charges (stopped instances only charge for EBS storage).

---

### 38. What is the maximum number of EBS volumes per instance?
A. 10
B. 20
C. 40
D. Unlimited

**Answer:** C
**Explanation:** EC2 instances support up to 40 EBS volumes (including root volume).

---

### 39. Which EC2 feature provides detailed monitoring?
A. Basic Monitoring (5-minute intervals)
B. Detailed Monitoring (1-minute intervals)
C. CloudWatch
D. CloudTrail

**Answer:** B
**Explanation:** Detailed Monitoring provides metrics at 1-minute intervals (vs 5-minute for basic).

---

### 40. What is the purpose of EC2 Dedicated Hosts?
A. Dedicated support
B. Physical servers dedicated to your use for compliance/licensing
C. High performance
D. Isolated networking

**Answer:** B
**Explanation:** Dedicated Hosts provide physical servers for compliance requirements and bring-your-own-license scenarios.

---

### 41. Which EC2 instance type uses credits for CPU bursting?
A. M-series
B. C-series
C. T-series (Burstable)
D. R-series

**Answer:** C
**Explanation:** T-series instances use CPU credits for bursting above baseline performance.

---

### 42. What is the maximum number of Elastic IPs per region?
A. 5
B. 10
C. 20
D. Unlimited

**Answer:** A
**Explanation:** Default limit is 5 Elastic IPs per region (soft limit, can be increased).

---

### 43. Which EC2 feature allows running commands on multiple instances?
A. Systems Manager Run Command
B. User Data
C. SSH
D. EC2 Connect

**Answer:** A
**Explanation:** Systems Manager Run Command executes commands on multiple instances remotely.

---

### 44. What is the purpose of EC2 Instance Connect?
A. Connect instances
B. Browser-based SSH connection
C. Network connectivity
D. VPN connection

**Answer:** B
**Explanation:** EC2 Instance Connect provides browser-based SSH access without managing SSH keys.

---

### 45. Which EC2 placement group distributes instances across hardware?
A. Cluster
B. Spread
C. Partition
D. Distributed

**Answer:** B
**Explanation:** Spread placement group distributes instances across distinct hardware to reduce correlated failures.

---

### 46. What is the maximum number of instances in a spread placement group per AZ?
A. 3
B. 7
C. 10
D. Unlimited

**Answer:** B
**Explanation:** Spread placement groups support up to 7 instances per AZ.

---

### 47. Which EC2 feature provides instance recovery?
A. Auto Recovery
B. CloudWatch Alarms with EC2 recover action
C. Backup
D. Snapshots

**Answer:** B
**Explanation:** CloudWatch Alarms can trigger EC2 instance recovery on system status check failures.

---

### 48. What is the purpose of EC2 Fleet?
A. Manage fleets
B. Launch and manage mix of On-Demand, Reserved, and Spot instances
C. Container fleet
D. Auto Scaling

**Answer:** B
**Explanation:** EC2 Fleet launches and manages a mix of instance types and purchasing options to meet capacity.

---

### 49. Which EC2 instance metadata category provides IAM role credentials?
A. /latest/meta-data/iam
B. /latest/meta-data/iam/security-credentials/role-name
C. /latest/meta-data/credentials
D. /latest/meta-data/role

**Answer:** B
**Explanation:** IAM role credentials are available at /latest/meta-data/iam/security-credentials/[role-name].

---

### 50. What is the maximum number of rules per security group?
A. 50 inbound, 50 outbound
B. 60 inbound, 60 outbound
C. 100 inbound, 100 outbound
D. Unlimited

**Answer:** B
**Explanation:** Security groups support up to 60 inbound and 60 outbound rules.

