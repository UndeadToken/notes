EC2 - Elastic Cloud Compute  
  
EC2 Instance: AMI (OS) + Instance Size (CPU + RAM) + Storage + Security Groups + EC2 User Data  
  
- EC2 is one of the most populate of QWS’ offering  
- EC2 = Elastic Compute Cloud = Infrastructure as a Service  
- It mainly consists in the capability of:  
    - Renting virtual machines (EC2)  
    - Storing data on virtual drives (EBS)  
    - Distributing load across machines (ELB)  
    - Scaling the services using an auto-scaling group (ASG)  
- Knowing EC2 is fundamental to understand how the cloud works  
  
EC2: Billing & Cost Management  
  
IAM user and role access to billing information:  
https://us-east-1.console.aws.amazon.com/billing/home#/account  
  
EC2: Sizing & Configuration Options  
  
- Operating System (OS): Linux, Windows or Mac OS  
- How much compute power & cores (CPU)  
- How much random-access memory (RAM)  
- How much storage space:  
    - Network-attached (EBS & EFS)  
    - Hardware (EC2 Instance Store)  
- Network card: speed of the card, Public IP address  
- Firewall rules: security group  
- Bootstrap script (configure at first launch): EC2 User Data  
  
EC2: User Data  
  
- It is possible to bootstrap our instances using an EC2 User Data script  
- Bootstrapping means launching commands when a machine starts  
- That script is only run once at the instance first start  
- EC2 user data is used to automate boot tasks such as:  
    - Installing updates  
    - Installing software  
    - Downloading common files from the internet  
    - Anything you can think of  
- The EC2 User Data Script runs with the root user  
  
EC2: Instance Types  
  
Instance	vCPU (Cores)	Mem (GiB)	Storage	Network Performance	EBS Bandwidth (Mbps)  
t2.micro	1	1	EBS-Only	Low to Moderate	  
t2.xlarge	4	16	EBS-Only	Moderate	  
c5d.4xlarge	16	32	1 x 400 NVMe SSD	Up to 10 Gbps	4,750  
r5.16xlarge	64	512	EBS-Only	20 Gbps	13,600  
m5.8xlarge	32	128	EBS-Only	10 Gbps	6,800  
t2.micro is part of the AWS free tier (up to 750 hours per month)  
Free tier eligible customers can get up to 30 GB of EBS General Purpose (SSD) or Magnetic Storage  
  
https://aws.amazon.com/ec2/instance-types/  
https://www.ec2instances.info/  
  
m5.2xlarge  
m: instance class  
5: generation (AWS improves them over time)  
2xlarge: size within the instance class  
  
EC2: Security Groups  
  
- Security Groups are the fundamental of network security in AWS  
- They control how traffic is allowed into or out of our EC2 instances  
- Security Groups only contain allow rules  
- Security Groups rules can reference by IP or by security group  
- Security Groups are acting as a Firewall on EC2 instances  
- They regulate access to ports, Authorised IP ranges, inbound and outbound traffic  
- Security Groups can be attached to multiple instances  
- Security Groups are locked down to a region / VPC combination  
- All inbound traffic is blocked by default  
- All outbound traffic is authorised by default  
  
Classic Ports:  
  
- 22 = SSH (Secure Shell)  
- 21 = FTP (File Transfer Protocol)  
- 22 = SFTP (Secure File Transfer Protocol)  
- 80 = HTTP  
- 443 = HTTPS  
- 3389 = RDP (Remote Desktop Protocol) - log into Windows instance  
  
EC2: Instances Purchasing Options  
  
- On-Demand Instances — short workload, predictable, pay by second  
- Reserved (1 & 3 years)  
    - Reserved instances — long workloads  
    - Convertible Reserved Instances — long workloads with flexible instances  
- Savings Plans (1 & 3 years) — Commitment to an amount of usage, long workloads  
- Spot Instances — Short workloads, cheap, can lose instances (less reliable)  
- Dedicated Hosts — Book an entire physical server, control instance placement  
- Dedicated Instances — No other customers will share your hardware  
- Capacity Reservations — Reserve capacity in a specific AZ for any duration  
  
EC2 On Demand  
  
- Pay for what you use:  
    - Linux or Windows - billing per second, after the first minute  
    - All other operating systems - billing per hour  
- Has the highest cost but no upfront payment  
- No long-term commitment  
- Recommended for short-term and un-interrupted workloads, where you can’t predict how the application will behave  
  
EC2 Reserved Instances  
  
- Up to 72% discount compared to On-demand  
- You reserve a specific instance attributes (Instance Type, Region, Tenancy, OS)  
- Reservation Period — 1 year (+discount) or 3 years (+++discount)  
- Payment Options — No Upfront (+), Partial Upfront (++), All Upfront (+++)  
- Reserved Instance’s Scope — Regional or Zonal (Reserve capacity in an AZ)  
- Recommended for steady-state usage applications (e.g. database)  
- You can buy and sell in the Reserved Instance Marketplace  
- Convertible Reserved Instance  
    - Can change the EC2 instance type, instance family, OS, scope and tenancy  
    - Up to 66% discount  
  
EC2 Savings Plans  
  
- Get a discount based on long-term usage (up to 72% - same as RIs)  
- Commit to a certain type of usage ($10/hr for 1 or 3 years)  
- Usage beyond EC2 Savings Plans is billed at the On-Demand price  
- Locaked to a specific instance family & AWS region (e.g., M5 in us-east-1)  
- Flexible across:  
    - Instance Size (e.g., m5.xlarge, m5.2xlarge)  
    - OS (e.g., Linux, Windows)  
    - Tenancy (Host, Dedicated, Default)  
  
EC2 Spot Instances  
  
- Can get a discount of up to 90% compared to On-demand  
- Instances that you can “lose” at any point in time if your max price is less than the current spot price  
- The MOST cost-efficient instances in AWS  
- Useful for workloads that are resilient to failure  
    - Batch jobs  
    - Data analysis  
    - Image processing  
    - Any distributed workloads  
    - Workloads with flexible start and end time  
- Not suitable for critical jobs or databases  
  
EC2 Dedicated Hosts  
  
- A physical server with EC2 instance capacity fully dedicated to your use  
- Allows you address compliance requirements and use your existing server-bound software licenses (per-socket, per-core, per—VM software licenses)  
- Purchasing Options:  
    - On-demand — pay per second for active Dedicated Host  
    - Reserved — 1 or 3 years (No Upfront, Partial Upfront, All Upfront)  
- The most expensive option  
- Useful for software that have complicated licensing model (BYOL — Bring Your Own License)  
- Or for companies that have strong regulatory or compliance needs  
  
EC2 Dedicated Instances  
  
- Instances run on hardware that’s dedicated to you  
- May share hardware with other instances in same account  
- No control over instance placement (can move hardware after Stop / Start)  
  
Characteristic	Dedicated Instances	Dedicated Hosts  
Enables the use of dedicated physical servers	X	X  
Per instance billing (subject to a $2 per region fee)	X	  
Per host billing		X  
Visibility of sockets, cores, host ID		X  
Affinity between a host and instance		X  
Targeted instance placement		X  
Automated instance placement	X	X  
Add capacity using an allocation request		X  
	  
EC2: Capacity Reservations  
  
- Reserve On-Demand instances capacity in a specific AZ for any duration  
- You always have access to EC2 capacity when you need it  
- No time commitment (create/cancel anytime), no billing discounts  
- Combine with Regional Reserved Instances and Savings Plans to benefit from billing discounts  
- You’re charged at On-Demand rate whether you run instances or not  
- Suitable for short-term, uninterrupted workloads that needs to be in a specific AZ  
  
Which purchasing option is right for me?  
  
- On demand: coming and staying in a resort whenever we like, we pay the full price  
- Reserved: like planning ahead and if we plan to stay for a long time, we may get a good discount  
- Savings plans: pay a certain amount per hour for certain period and stay in any room (e.g., King, Suite, Sea View, …)  
- Spot Instances: the hotel allows people to bid for the empty rooms and the highest bidder keeps the rooms. You can get kicked out at any time  
- Dedicated Hosts: We book an entire building of the resort  
  
  
Price Type	Price (per hour)  
On-Demand	$0.10  
Spot Instance (Spot Price)	$0.038 - $0.039 (up to 61% off)  
Reserved Instance (1 year)	$0.062 (No Upfront) - $0.058 (All Upfront)  
Reserved Instance (3 years)	$0.043 (No Upfront) - $0.037 (All Upfront)  
EC2 Savings Plan (1 year)	$0.062 (No Upfront) - $0.058 (All Upfront)  
Reserved Convertible Instance (1 year)	$0.071 (No Upfront) - $0.066 (All Upfront)  
Dedicated Host	On-Demand Price  
Dedicated Host Reservation	Up to 70% off  
Capacity Reservations	On-Demand Price  
  
EC2: Shared Responsibility Model  
  
AWS  
  
- Infrastructure (global network security)  
- Isolation on physical hosts]  
- Replacing faulty hardware  
- Compliance validation  
  
User  
  
- Security Groups rules  
- Operating-system patches and updates  
- Software and utilities installed on the EC2 instance  
- IAM Roles assigned to EC2 & IAM user access management  
- Data security on your instance  
