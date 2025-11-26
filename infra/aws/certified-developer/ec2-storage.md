# AWS Certified Developer – Associate (DVA-C02) EC2 & Storage Cheat Sheet

---

### EC2 Storage Overview

#### EBS (Elastic Block Store)
- Network-attached storage, persists beyond instance termination.
- AZ-bound; one EBS → one instance (except io1/io2 multi-attach).
- Free Tier: 30 GB/month (gp2 SSD or magnetic).
- Provisioned capacity: size & IOPS billed.
- Delete on Termination: root EBS deleted by default; can preserve manually.
- Snapshots: point-in-time backups; can copy across AZs/Regions.
- Snapshot Archive: 75% cheaper, restores in 24–72h.
- Fast Snapshot Restore (FSR): pre-warm snapshot for low latency.

#### AMI (Amazon Machine Image)
- Pre-configured EC2 image with OS, software, configs.
- Region-specific, can be copied across regions.
- Launch instances from public or custom AMIs.
- EC2 Image Builder: automates AMI creation, testing, and maintenance.

#### EC2 Instance Store
- Ephemeral, physically attached to host.
- High I/O performance, data lost on stop/terminate.
- Good for cache, buffer, scratch space.

#### EFS (Elastic File System)
- Managed NFS file system; mountable on multiple EC2 instances.
- Multi-AZ, scalable, pay-per-use.
- POSIX-compliant (Linux only), uses security groups for access.
- Performance Modes: General Purpose (default), Max I/O.
- Throughput Modes: Bursting, Provisioned, Elastic.
- Storage Classes: Standard, Infrequent Access (EFS-IA), Archive.
- Use cases: shared website files, CMS, content management.

#### FSx Overview
- Managed high-performance file systems:
  - FSx for Lustre: HPC, low-latency, scalable.
  - FSx for Windows File Server: SMB/NTFS, AD-integrated.
  - FSx for NetApp ONTAP.

### Multi-Attach EBS
- Only io1/io2 volumes.
- Attach up to 16 EC2 instances in the same AZ.
- Each instance has read/write access.
- Must use cluster-aware file system.

### Comparison: EBS vs EFS vs Instance Store

| Feature                | EBS                 | EFS                        | Instance Store       |
|------------------------|-------------------|----------------------------|-------------------|
| Mount                  | 1 instance (multi-attach io1/io2) | Multiple instances      | Single instance    |
| AZ-bound               | Yes               | Multi-AZ                  | Yes (ephemeral)    |
| Persistence            | Yes               | Yes                        | No                 |
| Use Case               | Root / app storage | Shared file storage       | Temp / cache       |
| OS                     | Linux / Windows   | Linux only                | Linux / Windows    |
| Scalability            | Manual            | Automatic                 | Fixed              |
| Cost                   | Moderate          | Higher                     | Included w/ instance|
| Backup                 | Snapshots         | Lifecycle policies         | N/A                |

### Shared Responsibility Model – Storage
AWS:
- Hardware reliability, replication, infrastructure security.

User:
- Backups, snapshots, encryption, instance store data management.
