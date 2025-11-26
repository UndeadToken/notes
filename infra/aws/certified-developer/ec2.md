# Amazon EC2 – Elastic Compute Cloud

## Overview
- EC2 = Virtual machines in the cloud (IaaS)
- Core components:
  - EC2 Instances (compute)
  - EBS (block storage)
  - ELB (load balancing)
  - ASG (auto-scaling)
- EC2 Instance = AMI (OS) + Instance Size (CPU & RAM) + Storage + Security Groups + User Data

---

## EC2 Billing & Cost Management
- Access via IAM user/role: [Billing Console](https://us-east-1.console.aws.amazon.com/billing/home#/account)
- Pricing models:
  - On-Demand
  - Reserved (1 & 3 years)
  - Convertible Reserved
  - Savings Plans
  - Spot Instances
  - Dedicated Hosts
  - Dedicated Instances
  - Capacity Reservations

---

## EC2 Configuration Options
- **OS:** Linux, Windows, macOS
- **Compute:** CPU cores
- **Memory:** RAM size
- **Storage:** EBS, EFS, Instance Store
- **Networking:** Public IP, network speed
- **Security:** Security Groups (firewall)
- **Bootstrap scripts:** User Data

### EC2 User Data
- Runs at first instance launch
- Runs as root
- Automates setup:
  - Software installation
  - Updates
  - File downloads
- Example: `#!/bin/bash sudo yum update -y`

---

## EC2 Instance Types
| Instance | vCPU | RAM (GiB) | Storage | Network | EBS Bandwidth |
|----------|------|-----------|---------|--------|---------------|
| t2.micro | 1    | 1         | EBS Only | Low-Moderate | - |
| t2.xlarge | 4   | 16        | EBS Only | Moderate | - |
| c5d.4xlarge | 16 | 32       | 1x400 NVMe | Up to 10 Gbps | 4750 Mbps |
| r5.16xlarge | 64 | 512      | EBS Only | 20 Gbps | 13600 Mbps |
| m5.8xlarge | 32  | 128      | EBS Only | 10 Gbps | 6800 Mbps |

- **Free tier:** t2.micro (750 hours/month + 30GB EBS)

---

## Security Groups
- Act as firewalls (region/VPC specific)
- Only allow rules (default deny inbound, allow outbound)
- Attach to multiple instances
- Common ports:
  - 22 SSH, 3389 RDP, 80 HTTP, 443 HTTPS, 21 FTP, 22 SFTP

---

## EC2 Purchasing Options
| Option | Use Case | Cost/Notes |
|--------|----------|------------|
| On-Demand | Short-term, unpredictable workloads | Pay per second/minute, no commitment |
| Reserved Instances | Steady-state workloads | 1–3 year commitment, up to 72% discount |
| Convertible Reserved | Long-term with flexibility | Change instance family/type, up to 66% discount |
| Savings Plans | Long-term usage commitment | Up to 72% discount, flexible across sizes/OS |
| Spot Instances | Fault-tolerant, batch workloads | Up to 90% discount, can be terminated anytime |
| Dedicated Hosts | Compliance, BYOL | Full physical server, highest cost |
| Dedicated Instances | Isolation required, limited compliance | Hardware dedicated but shared across account |
| Capacity Reservations | Guarantee capacity in AZ | Charged at On-Demand rate |

- **Analogy:**  
  - On-Demand: book a hotel room anytime  
  - Reserved: plan ahead for discount  
  - Spot: bid for empty rooms  
  - Dedicated Host: book entire building

---

## EC2 Shared Responsibility Model
**AWS Responsibilities**
- Physical infrastructure security
- Hardware isolation & replacement
- Network security
- Compliance validation

**Customer Responsibilities**
- Security Groups & network rules
- OS patches and updates
- Software installation
- IAM roles & user access
- Data security on the instance
