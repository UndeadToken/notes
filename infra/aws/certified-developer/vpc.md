# AWS Certified Developer – Associate (DVA-C02) Exam VPC & Networking Cheat Sheet

---

### VPC Basics
- VPC: Virtual Private Cloud, private network in a region.
- Subnets: Partition VPC per Availability Zone (AZ).
  - Public Subnet: Accessible from the internet.
  - Private Subnet: Not accessible from the internet.
- Default VPC: One per region, only public subnets.

### Internet Access
- Internet Gateway (IGW): Provides internet access to public subnets.
- NAT Gateway / NAT Instance: Allow private subnet instances to access the internet.

### Security
- Security Groups (SG): Stateful, instance-level firewall, only ALLOW rules.
- Network ACLs (NACL): Stateless, subnet-level firewall, ALLOW + DENY rules.

| Feature | Security Group | NACL |
|---------|----------------|------|
| Level | Instance | Subnet |
| Rules | Allow only | Allow & Deny |
| State | Stateful | Stateless |

### Monitoring
- VPC Flow Logs: Capture IP traffic (VPC, subnet, ENI); send logs to S3, CloudWatch, Kinesis.

### Connectivity Between VPCs
- VPC Peering: Connects 2 VPCs privately; must not overlap CIDR; not transitive.
- VPC Endpoints: Private access to AWS services within a VPC.
  - Gateway Endpoint: S3, DynamoDB.
  - Interface Endpoint: Other AWS services.

### On-Premises Connectivity
- Site-to-Site VPN: Encrypted connection over public internet.
- Direct Connect: Private, physical connection; fast, secure, long setup.

### Architecture Patterns
- Three-tier Architecture: Public Subnet → Private Subnet → Data Subnet (RDS / ElastiCache).

### LAMP Stack on EC2
- Linux OS, Apache web server, MySQL (RDS), PHP (app logic).
- Optional: Redis / Memcached for caching.
- Local storage: EBS volume.

---
