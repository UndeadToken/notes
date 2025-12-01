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

---

### 21. What is EFS Lifecycle Management used for?
A. Delete old files
B. Automatically move files to Infrequent Access storage class
C. Backup files
D. Encrypt files

**Answer:** B
**Explanation:** EFS Lifecycle Management automatically transitions files to IA storage class based on access patterns to reduce costs.

---

### 22. Which RAID configuration provides fault tolerance for EBS volumes?
A. RAID 0 (striping)
B. RAID 1 (mirroring)
C. RAID 5
D. RAID 10

**Answer:** B
**Explanation:** RAID 1 mirrors data across volumes for fault tolerance. RAID 0 improves performance but no redundancy.

---

### 23. What is the purpose of EBS Snapshot Recycle Bin?
A. Delete snapshots
B. Recover accidentally deleted snapshots
C. Archive snapshots
D. Encrypt snapshots

**Answer:** B
**Explanation:** Recycle Bin retains deleted snapshots for a retention period (1 day to 1 year) for recovery.

---

### 24. Which AWS file system is optimized for Windows workloads?
A. EFS
B. FSx for Windows File Server
C. FSx for Lustre
D. EBS

**Answer:** B
**Explanation:** FSx for Windows File Server provides fully managed Windows-native file system with SMB protocol support.

---

### 25. What is the purpose of EBS Direct APIs?
A. Attach volumes faster
B. Read and write EBS snapshot data directly for backup/restore
C. Encrypt volumes
D. Monitor volumes

**Answer:** B
**Explanation:** EBS Direct APIs (ListSnapshotBlocks, GetSnapshotBlock, PutSnapshotBlock) enable direct access to snapshot data for custom backup solutions.

---

### 26. Which EBS volume type is best for high-performance databases?
A. gp3
B. io2 Block Express
C. st1
D. sc1

**Answer:** B
**Explanation:** io2 Block Express provides the highest performance (up to 256,000 IOPS) and durability for mission-critical databases.

---

### 27. What is the maximum size of an EBS volume?
A. 16 TB
B. 32 TB
C. 64 TB
D. 128 TB

**Answer:** C
**Explanation:** EBS volumes (gp2, gp3, io1, io2, st1, sc1) support up to 64 TB size.

---

### 28. Which EFS performance mode is best for big data analytics?
A. General Purpose
B. Max I/O
C. Bursting
D. Provisioned

**Answer:** B
**Explanation:** Max I/O performance mode is optimized for higher aggregate throughput and IOPS (e.g., big data, parallel processing).

---

### 29. What happens to Instance Store data when an instance is stopped?
A. Persisted
B. Lost
C. Backed up to S3
D. Moved to EBS

**Answer:** B
**Explanation:** Instance Store is ephemeral storage; data is lost when the instance is stopped or terminated.

---

### 30. Which EBS feature allows resizing volumes without downtime?
A. Elastic Volumes
B. Dynamic Volumes
C. Auto Scaling
D. Volume Gateway

**Answer:** A
**Explanation:** Elastic Volumes allow you to increase volume size, change volume type, and adjust performance without downtime.

---

### 31. What is the maximum IOPS for gp3 volumes?
A. 3,000
B. 16,000
C. 32,000
D. 64,000

**Answer:** B
**Explanation:** gp3 volumes support up to 16,000 IOPS.

---

### 32. Which EFS throughput mode scales automatically?
A. Bursting
B. Provisioned
C. Elastic
D. Standard

**Answer:** C
**Explanation:** Elastic throughput mode automatically scales throughput up or down based on workload needs.

---

### 33. What is the purpose of EBS Multi-Attach?
A. Attach volume to multiple instances in different AZs
B. Attach volume to multiple instances in the same AZ
C. Attach multiple volumes to one instance
D. Attach volume to multiple regions

**Answer:** B
**Explanation:** EBS Multi-Attach allows attaching a single io1/io2 volume to multiple instances in the same Availability Zone.

---

### 34. Which storage service is best for shared Linux file systems?
A. EBS
B. EFS
C. S3
D. Instance Store

**Answer:** B
**Explanation:** EFS provides a scalable, fully managed shared file system for Linux instances (NFS protocol).

---

### 35. What is the maximum retention period for EBS Snapshots in Recycle Bin?
A. 30 days
B. 90 days
C. 1 year
D. 365 days

**Answer:** D
**Explanation:** Recycle Bin retention rules can specify a retention period from 1 day to 365 days (1 year).

---

### 36. Which EBS volume type is lowest cost for infrequent access?
A. gp3
B. st1
C. sc1 (Cold HDD)
D. standard

**Answer:** C
**Explanation:** sc1 (Cold HDD) provides the lowest cost per GB for infrequently accessed workloads.

---

### 37. What is the purpose of EFS Lifecycle Management?
A. Delete old files
B. Automatically move infrequently accessed files to Infrequent Access (IA) storage class
C. Backup files
D. Versioning

**Answer:** B
**Explanation:** Lifecycle Management automatically moves files that haven't been accessed for a set period to the cost-effective IA storage class.

---

### 38. Which EBS feature creates a point-in-time copy?
A. Backup
B. Snapshot
C. Clone
D. Replica

**Answer:** B
**Explanation:** EBS Snapshots create a point-in-time copy of the volume stored in S3.

---

### 39. What is the maximum throughput for st1 volumes?
A. 250 MB/s
B. 500 MB/s
C. 1,000 MB/s
D. 4,000 MB/s

**Answer:** B
**Explanation:** st1 (Throughput Optimized HDD) volumes support up to 500 MB/s throughput.

---

### 40. Which EFS feature encrypts data in transit?
A. TLS
B. SSL
C. VPN
D. Direct Connect

**Answer:** A
**Explanation:** EFS supports encryption in transit using TLS when mounting the file system.

---

### 41. What is the purpose of EBS Fast Snapshot Restore (FSR)?
A. Restore faster
B. Instantly restore fully initialized volumes from snapshots (no lazy loading)
C. Fast backup
D. Fast clone

**Answer:** B
**Explanation:** FSR enables creating fully initialized volumes from snapshots instantly, eliminating the latency of lazy loading.

---

### 42. Which storage type provides lowest latency?
A. EBS gp3
B. EBS io2
C. EFS
D. Instance Store (NVMe)

**Answer:** D
**Explanation:** Instance Store (physically attached NVMe SSDs) provides the lowest latency and highest IOPS.

---

### 43. What is the maximum number of file systems per account?
A. 100
B. 1,000
C. 10,000
D. Unlimited

**Answer:** B
**Explanation:** Default limit is 1,000 EFS file systems per region per account.

---

### 44. Which EBS volume type supports boot volumes?
A. gp2, gp3, io1, io2
B. st1, sc1
C. All types
D. Only gp3

**Answer:** A
**Explanation:** Only SSD-backed volumes (gp2, gp3, io1, io2) can be used as boot volumes. HDD (st1, sc1) cannot.

---

### 45. What is the purpose of FSx for Lustre?
A. Windows file server
B. High-performance file system for compute-intensive workloads (HPC, ML)
C. General purpose
D. Archive

**Answer:** B
**Explanation:** FSx for Lustre is optimized for high-performance computing, machine learning, and media processing workloads.

---

### 46. Which EBS encryption feature is enabled by default?
A. Encryption by default
B. Snapshot encryption
C. Volume encryption
D. None (must be enabled)

**Answer:** A
**Explanation:** You can enable EBS encryption by default for your account in a region, ensuring all new volumes are encrypted.

---

### 47. What is the maximum IOPS for io2 Block Express?
A. 64,000
B. 100,000
C. 256,000
D. 500,000

**Answer:** C
**Explanation:** io2 Block Express supports up to 256,000 IOPS.

---

### 48. Which EFS access point feature enforces user identity?
A. POSIX User
B. Root directory
C. IAM policy
D. Owner

**Answer:** A
**Explanation:** Access Points can enforce a specific POSIX user ID and group ID for all connections through that point.

---

### 49. What is the purpose of EBS Data Lifecycle Manager (DLM)?
A. Manage data
B. Automate creation, retention, and deletion of EBS snapshots
C. Move data
D. Delete volumes

**Answer:** B
**Explanation:** DLM automates the creation, retention, and deletion of EBS snapshots based on schedules.

---

### 50. Which FSx type supports NetApp ONTAP?
A. FSx for Windows
B. FSx for Lustre
C. FSx for NetApp ONTAP
D. FSx for OpenZFS

**Answer:** C
**Explanation:** FSx for NetApp ONTAP provides fully managed shared storage built on NetApp's ONTAP file system.

