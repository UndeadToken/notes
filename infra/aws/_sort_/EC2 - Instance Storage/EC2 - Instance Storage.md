EC2 - Instance Storage  
  
EBS (Elastic Block Store) Volume is a network drive you can attach to your instances while they run.  
  
- It allows your instances to persist data, even after their termination  
- They can only be mounted to one instance at a time (at the CCP level)  
- They are bound to a specific availability zone  
  
Note: CCP - Certified Cloud Practitioner - one EBS can be only mounted to one EC2 instance. Associate Level (Solutions Architect, Developer, SysOps): “multi-attach” feature for some EBS  
  
Free tier: 30GB of free EBS storage of type General Purpose (SSD) or magnetic per month.  
  
EBS: Volume  
  
- It’s a network drive (i.e not a physical drive)  
    - It uses the network to communicate with the instance, which means there might be a bit of latency  
    - It can be detached from an EC2 instance and attached to another one quickly  
- It’s locked to an Availability Zone (AZ)  
    - An EBS Volume in us-east-1a cannot be attached to us-east-1b  
    - To move a volume across, you first need to snapshot it  
- Have a provisioned capacity (size in GB’s, and IOPS)  
    - You get billed for all the provisioned capacity  
    - You can increase the capacity of the drive over time  
- EBS volumes cannot be attached to multiple instances, except for io1 and io2 volume types: this is called the EBS Multi-Attach feature  
  
Delete on Termination attribute  
  
- Controls the EBS behaviour when an EC2 instance terminates  
    - By default, the root EBS volume is deleted (attribute enabled)  
- This can be controlled by the AWS console / AWS CLI  
- Use case: preserve root volume when instance is terminated  
  
EBS: Snapshots  
  
- Make a backup (snapshot) of your EBS volume at a point in time  
- Not necessary to detach volume to do snapshot, but recommended  
- Can copy snapshots across AZ or Region  
  
EBS Snapshot Archive  
  
- Move a snapshot to an “”archive tier that is 75% cheaper  
- Takes within 24 to 72 hours for restoring the archive  
  
Recycle Bin for BES Snapshots  
  
- Setup rules to retain snapshots so you can recover them after an accidental deletion  
- Specify retention (from 1 day to 1 year)  
  
Fast Snapshot Restore (FSR)  
  
- Force full initialisation of snapshot to have to latency on the first use ($$$)  
  
EBS: AMI Overview  
  
- AMI = Amazon Machine Image  
- AMI are a customisation of an EC2 instance  
    - You add your own software, configuration, operating system, monitoring…  
    - Faster boot/  configuration time because all your software is pre-packaged  
- AMI are built for a specific region (and can be copied across regions)  
- You can launch EC2 instances from:  
    - A public AMI: AWS provided  
    - Your own AMI: you make and maintain them yourself  
  
AMI Process (from an EC2 Instance)  
  
- Start an EC2 instance and customise it  
- Stop the instance (for data integrity)  
- Build an AMI — this will also create EBS snapshots  
- Launch instances from other AMI’s  
  
EC2: Image Builder  
  
- Used to automate the creation of Virtual Machines or container images  
- => Automate the creation, maintain, validate and test EC2 AMI’s  
- Can be run on a schedule (weekly, whenever packages are updated, etc…)  
- Free service (only pay for the underlying resources)  
  
EC2: Instance Store  
  
- EBS volumes are network drives with good but “limited” performance  
- If you need a high-performance hardware disk, use EC2 Instance Store  
    - Better I/O performance  
    - EC2 Instance Store lose their storage if they’re stopped (ephemeral)  
    - Good for buffer / cache/ scratch data / temporary content  
    - Risk of data loss if hardware fails  
  
Local EC2 Instance Store Options  
  
EFS Elastic File System  
  
- Managed NFS (network file system) that can be mounted on 100s of EC2 instances  
- EFS works with Linux EC2 instances in multi-AZ  
- High available, scalable, expensive (3x gp2), pay per useful no capacity planning  
  
- Use cases: content management, web serving, data sharing, Wordpress  
- Uses NFSv4.1 protocol  
- Uses security group to control access to EFS  
- Compatible with Linux based AMI (not Windows)  
- Encryption at rest using KMS  
  
- POSIX file system (~Linux) that has a standard file API  
- File system scales automatically, pay-per-use, no capacity planning!  
  
EFS Scale  
  
- 1000s of concurrent NFS clients, 10GB+ /s throughput  
- Grow to Petabyte-scale network file system, automatically  
  
Performance Mode (set at EFS creation time)  
  
- General Purpose (default) - latency-sensitive use cases (web server, CMS, etc…)  
- MAX I/O — higher latency, throughput, highly parallel (big data, media processing)  
  
 Throughput Mode  
  
- Bursting - 1TB = 50MiB/s + burst of up to 100MiB/s  
- Provisioned — set your throughput regardless of storage size, ex: 1 GiB/s for 1 TB storage  
- Elastic - automatically scales throughput up or down based on your workload  
    - Up to 3GiB/s for reads and 1GiB/s for writes  
    - Used for unpredictable workloads  
  
EFS Infrequent Access (EFS-IA)  
  
- Storage class that is cost-optimised for files not accessed every day  
- Up to 92% lower cost compared to EFS Standard  
- EFS will automatically move your files to EFS-IA based on the last time they were accessed  
- Enable EFS-IA with a Lifecycle Policy  
- Example: move files that are not accessed for 60 days to EFS-IA  
- Transparent to the applications accessing EFS  
  
Shared Responsibility Model for EC2 Storage  
  
AWS:  
- Infrastructure  
- Replication for data for EBS volumes & EFS drives  
- Replacing faulty hardware  
- Ensuring their employees cannot access your data  
  
User:  
- Setting up backup / snapshot procedures  
- Setting up data encryption  
- Responsibility of any data on the drives  
- Understanding the risk of using EC2 Instance Store  
  
EFS Storage Classes  
  
Storage Tiers  
  
Lifecycle Management Feature — move file after N days  
  
Over 90% in cost savings.  
  
- Standard: for frequently accessed files  
- Infrequent access: EFS-IA cost to retrieve files, lower price to store  
- Archive: rarely accessed data (few times each year), 50% cheaper  
- Implement lifecycle policies to move files between storage tiers  
  
Availability and durability  
  
- Standard: Multi-AZ, great for prod  
- One Zone: One AZ, great for dev, backup enabled by default, compatible with IA (EFS One Zone-IA)  
  
Amazon FSx - Overview  
  
Launch 3rd party high-performance file systems on AWS. Fully managed service:  
  
- FSx for Lustre  
    - A fully managed, high-performance, scalable file storage for High Performance Computing (HPC)  
    - The name Lustre is derived from “Linux” and “cluster”  
    - Machine learning, Analytics, Video Processing, Financial Modeling,…  
    - Scales up to 100s GB/s, millions of IOPS, sub-ms latencies  
- FSx for Windows File Server  
    - A fully managed, highly reliable, and scalable Windows native shared file system  
    - Built on Windows File Server  
    - Supports SMB protocol & Windows NTFS  
    - Integrated with Microsoft Active Directory  
- FSx for NetApp ONTAP  
  
EBS Multi-Attach — io/io2 family  
  
- Attach the same EBS volume to multiple EC2 instances in the same AZ  
- Each instance has full read & write permissions to the high-performance volume  
- Use case:  
    - Achieve higher application availability in clustered Linux applications (ex: Teradata)  
    - Applications must manage concurrent write operations  
- Up To 16 EC2 Instances at a time  
- Must use a file system that’s cluster-aware (not XFS, EXT4, etc…)  
  
Amazon EFS - Elastic File System  
  
- Managed NFS (network file system) that can be mounted on many EC2  
- EFS works with EC2 instances in multi-AZ  
- Highly available, scalable, expensive (3x gp2), pay per use  
- Use cases: content management, web serving, data sharing, Wordpress  
- Uses NFS4.1 protocol  
- Uses security group to control access to EFS  
- Compatible with Linux based AMI (not Windows)  
- Encryption at rest using KMS  
- POSIX file system (~Linux) that has a standard file API  
- File system scales automatically, pay-per-use, no capacity planning!  
  
EBS vs EFS — Elastic Block Storage  
  
EBS Volumes  
  
- One instance (except multi-attach io1/io2)  
- Are locked at the Availability Zone (AZ) level  
- gp2: IO increases if the disk size increases  
- gp3 & io 1: can increase IO independently  
  
To migrate an EBS volume across AZ:  
- Take a snapshot  
- Restore the snapshot to another AZ  
- EBS backups use IO and you shouldn’t run them while your application is handling a lot of traffic  
  
Root EBS volumes of instances get terminated by default if the EC2 instance gets terminated. (You can disable that)  
  
EFS Volume  
  
- Mounting 100s of instances across AZ  
- EFS share website files (Wordpress)  
- Only for Linux instances (POSIX)  
- EFS has a higher price point than EBS  
- Can leverage Storage Tiers for cost savings  
- Remember: EFS vs EBS vs Instance Store  
  
