### 1. Which EBS volume type is best for boot volumes and general workloads?
A. gp2/gp3 (General Purpose SSD)
B. io1/io2 (Provisioned IOPS SSD)
C. st1 (Throughput Optimized HDD)
D. sc1 (Cold HDD)

**Answer:** A
**Explanation:** gp2/gp3 General Purpose SSD is recommended for boot volumes and general workloads.

---

### 2. What is the maximum IOPS for io2 Block Express volumes?
A. 16,000
B. 64,000
C. 256,000
D. 1,000,000

**Answer:** C
**Explanation:** io2 Block Express provides up to 256,000 IOPS and 4,000 MB/s throughput.

---

### 3. Which EBS volume type can be attached to multiple EC2 instances simultaneously?
A. gp3
B. io1/io2 with Multi-Attach
C. st1
D. All EBS volumes

**Answer:** B
**Explanation:** Only io1/io2 volumes support Multi-Attach (up to 16 instances in same AZ).

---

### 4. What happens to EBS volumes when an EC2 instance is terminated?
A. All volumes are deleted
B. Root volume deleted by default, others retained
C. All volumes retained
D. All volumes snapshotted

**Answer:** B
**Explanation:** Root EBS volume deleted by default; additional volumes retained (configurable).

---

### 5. Which storage type provides the highest I/O performance?
A. EBS
B. Instance Store
C. EFS
D. S3

**Answer:** B
**Explanation:** Instance Store provides highest I/O (physically attached) but is ephemeral.

---

### 6. What is the purpose of EBS Snapshots?
A. Increase performance
B. Point-in-time backups stored in S3
C. Encrypt volumes
D. Attach to multiple instances

**Answer:** B
**Explanation:** EBS Snapshots are incremental backups stored in S3 for disaster recovery.

---

### 7. Which EBS feature reduces snapshot restore time?
A. Snapshot Archive
B. Fast Snapshot Restore (FSR)
C. Snapshot Copy
D. Snapshot Encryption

**Answer:** B
**Explanation:** Fast Snapshot Restore (FSR) pre-warms snapshots for instant volume creation.

---

### 8. What is the retention period for Snapshot Archive?
A. 24 hours
B. 90 days minimum
C. 1 year
D. Indefinite

**Answer:** B
**Explanation:** Snapshot Archive requires minimum 90-day retention (75% cheaper, 24-72h restore).

---

### 9. Which file system can be mounted on multiple EC2 instances across AZs?
A. EBS
B. Instance Store
C. EFS (Elastic File System)
D. S3

**Answer:** C
**Explanation:** EFS is a managed NFS file system mountable on multiple instances across AZs.

---

### 10. What is the purpose of AMIs (Amazon Machine Images)?
A. Monitor instances
B. Pre-configured templates for launching instances
C. Backup data
D. Encrypt volumes

**Answer:** B
**Explanation:** AMIs are pre-configured templates containing OS, software, and configurations.

---

### 11. Which EFS performance mode provides highest throughput?
A. General Purpose
B. Max I/O
C. Bursting
D. Provisioned

**Answer:** B
**Explanation:** Max I/O mode provides higher aggregate throughput (higher latency per operation).

---

### 12. What is the default EFS throughput mode?
A. Provisioned
B. Bursting
C. Elastic
D. Fixed

**Answer:** B
**Explanation:** Bursting mode scales throughput with file system size (default mode).

---

### 13. Which EFS storage class is most cost-effective for infrequently accessed files?
A. Standard
B. Infrequent Access (IA)
C. Archive
D. One Zone

**Answer:** B
**Explanation:** EFS Infrequent Access (IA) reduces costs for files not accessed frequently.

---

### 14. Can EBS volumes be attached to instances in different AZs?
A. Yes, always
B. No, EBS is AZ-bound
C. Yes, with Multi-Attach
D. Only for io2 volumes

**Answer:** B
**Explanation:** EBS volumes are AZ-specific and can only attach to instances in the same AZ.

---

### 15. Which tool automates AMI creation, testing, and distribution?
A. EC2 Image Builder
B. AMI Creator
C. CloudFormation
D. Systems Manager

**Answer:** A
**Explanation:** EC2 Image Builder automates AMI creation, testing, and distribution pipelines.

---

### 16. What is the minimum size for an EBS gp3 volume?
A. 1 GB
B. 1 GiB
C. 10 GiB
D. 100 GiB

**Answer:** B
**Explanation:** gp3 volumes range from 1 GiB to 16 TiB.

---

### 17. Which EBS volume type is optimized for big data and data warehouses?
A. gp3
B. io2
C. st1 (Throughput Optimized HDD)
D. sc1

**Answer:** C
**Explanation:** st1 is optimized for frequently accessed, throughput-intensive workloads (big data, data warehouses).

---

### 18. What happens to Instance Store data when an instance is stopped?
A. Data persists
B. Data is lost
C. Data is backed up to S3
D. Data is moved to EBS

**Answer:** B
**Explanation:** Instance Store is ephemeral; data is lost on stop/terminate (persists on reboot).

---

### 19. Which EBS encryption method encrypts data at rest?
A. TLS
B. SSL
C. KMS
D. IPSec

**Answer:** C
**Explanation:** EBS uses AWS KMS to encrypt data at rest.

---

### 20. Can you change an EBS volume type while it's attached?
A. No, must detach first
B. Yes, using Elastic Volumes feature
C. Only for gp2 to gp3
D. Not possible

**Answer:** B
**Explanation:** Elastic Volumes allows modifying volume type, size, and IOPS without detaching.
