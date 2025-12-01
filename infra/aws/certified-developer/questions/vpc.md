### 1. Which VPC component allows instances in private subnets to access the internet?
A. Internet Gateway
B. NAT Gateway
C. VPC Peering
D. VPN Gateway

**Answer:** B
**Explanation:** NAT Gateway (or NAT Instance) allows private subnet instances to access internet while remaining private.

---

### 2. What is the difference between Security Groups and NACLs?
A. No difference
B. SGs are stateful, NACLs are stateless
C. SGs are stateless, NACLs are stateful
D. Both are stateful

**Answer:** B
**Explanation:** Security Groups are stateful (return traffic allowed automatically). NACLs are stateless (require explicit rules).

---

### 3. Which VPC component provides internet access to public subnets?
A. NAT Gateway
B. Internet Gateway
C. VPN Gateway
D. Transit Gateway

**Answer:** B
**Explanation:** Internet Gateway enables communication between VPC and the internet.

---

### 4. What is the maximum number of VPCs per region by default?
A. 1
B. 5
C. 10
D. Unlimited

**Answer:** B
**Explanation:** Default limit is 5 VPCs per region (can be increased).

---

### 5. Which VPC feature captures IP traffic information?
A. CloudTrail
B. CloudWatch
C. VPC Flow Logs
D. Network Logs

**Answer:** C
**Explanation:** VPC Flow Logs capture IP traffic going to/from network interfaces.

---

### 6. Can VPC Peering be transitive?
A. Yes, always
B. No, not transitive
C. Only within same region
D. Only with VPN

**Answer:** B
**Explanation:** VPC Peering is not transitive. A↔B and B↔C doesn't mean A↔C.

---

### 7. Which VPC endpoint type is used for S3 and DynamoDB?
A. Interface Endpoint
B. Gateway Endpoint
C. Service Endpoint
D. Private Endpoint

**Answer:** B
**Explanation:** Gateway Endpoints are used for S3 and DynamoDB (free, route table entries).

---

### 8. What is the purpose of VPC Endpoints?
A. Connect to internet
B. Private access to AWS services without internet
C. Connect VPCs
D. Monitor traffic

**Answer:** B
**Explanation:** VPC Endpoints enable private connections to AWS services without internet gateway.

---

### 9. Which NACL rule number has the highest priority?
A. 1
B. 100
C. Lowest number
D. Highest number

**Answer:** C
**Explanation:** NACL rules are evaluated in order from lowest to highest number.

---

### 10. What is the default NACL behavior?
A. Deny all traffic
B. Allow all traffic
C. Allow inbound, deny outbound
D. Deny inbound, allow outbound

**Answer:** B
**Explanation:** Default NACL allows all inbound and outbound traffic.

---

### 11. Which VPC component connects on-premises network to AWS via encrypted tunnel?
A. Direct Connect
B. VPN Gateway
C. Internet Gateway
D. NAT Gateway

**Answer:** B
**Explanation:** VPN Gateway creates encrypted Site-to-Site VPN connection over internet.

---

### 12. What is the maximum CIDR block size for a VPC?
A. /16
B. /20
C. /24
D. /28

**Answer:** A
**Explanation:** VPC CIDR blocks range from /16 (65,536 IPs) to /28 (16 IPs).

---

### 13. Which AWS service provides dedicated private connection to AWS?
A. VPN
B. Direct Connect
C. VPC Peering
D. Transit Gateway

**Answer:** B
**Explanation:** Direct Connect provides dedicated physical connection (not over internet).

---

### 14. What is the purpose of a Bastion Host?
A. Database server
B. SSH/RDP access to private instances
C. Load balancer
D. NAT instance

**Answer:** B
**Explanation:** Bastion Host (Jump Box) provides secure SSH/RDP access to private subnet instances.

---

### 15. Which VPC component allows multiple VPCs to connect via hub-and-spoke model?
A. VPC Peering
B. Transit Gateway
C. Internet Gateway
D. VPN Gateway

**Answer:** B
**Explanation:** Transit Gateway acts as a hub connecting multiple VPCs and on-premises networks.

---

### 16. What is the default Security Group behavior?
A. Allow all inbound, deny all outbound
B. Deny all inbound, allow all outbound
C. Allow all traffic
D. Deny all traffic

**Answer:** B
**Explanation:** Default SG denies all inbound, allows all outbound traffic.

---

### 17. Which VPC feature allows DNS resolution for private hosted zones?
A. Route 53 Resolver
B. DNS Server
C. VPC DNS
D. Private DNS

**Answer:** A
**Explanation:** Route 53 Resolver enables DNS resolution between VPC and on-premises networks.

---

### 18. What is the purpose of Elastic Network Interface (ENI)?
A. Load balancing
B. Virtual network card for EC2 instances
C. Internet access
D. VPN connection

**Answer:** B
**Explanation:** ENI is a virtual network interface that can be attached to EC2 instances.

---

### 19. Which VPC component is required for IPv6 support?
A. NAT Gateway
B. Egress-Only Internet Gateway
C. Internet Gateway
D. VPN Gateway

**Answer:** B
**Explanation:** Egress-Only Internet Gateway allows outbound IPv6 traffic while blocking inbound.

---

### 20. What is the maximum number of rules per Security Group?
A. 50
B. 60
C. 100
D. 120

**Answer:** B
**Explanation:** Maximum 60 inbound and 60 outbound rules per security group.

---

### 21. What is VPC Sharing (Resource Access Manager)?
A. Share VPCs across accounts
B. Share subnets with other AWS accounts in same organization
C. Share security groups
D. Share internet gateways

**Answer:** B
**Explanation:** VPC Sharing allows sharing subnets with other AWS accounts within the same AWS Organization.

---

### 22. What is AWS PrivateLink used for?
A. Connect VPCs
B. Private connectivity to services without internet, NAT, or VPC peering
C. Encrypt traffic
D. Monitor connections

**Answer:** B
**Explanation:** PrivateLink provides private connectivity to AWS services and SaaS applications without exposing traffic to the internet.

---

### 23. Which service helps manage IP address allocation across multiple VPCs?
A. IPAM (IP Address Manager)
B. Route 53
C. VPC Manager
D. Network Manager

**Answer:** A
**Explanation:** IPAM helps plan, track, and monitor IP addresses across multiple VPCs and regions.

---

### 24. What is AWS Network Firewall used for?
A. Replace security groups
B. Managed firewall service for VPC-level protection
C. Monitor traffic
D. Encrypt connections

**Answer:** B
**Explanation:** Network Firewall provides managed network firewall protection for VPCs with stateful inspection and intrusion prevention.

---

### 25. Which tool analyzes network reachability between resources?
A. VPC Flow Logs
B. Reachability Analyzer
C. Network Insights
D. CloudWatch

**Answer:** B
**Explanation:** VPC Reachability Analyzer analyzes and debugs network reachability between resources without sending packets.

---

### 26. What is the maximum number of VPCs per region per account?
A. 5
B. 10
C. 20
D. 50

**Answer:** A
**Explanation:** Default limit is 5 VPCs per region per account (soft limit, can be increased).

---

### 27. Which VPC feature allows private connection to AWS services?
A. Internet Gateway
B. NAT Gateway
C. VPC Endpoint (PrivateLink)
D. Egress-Only Internet Gateway

**Answer:** C
**Explanation:** VPC Endpoints (Interface and Gateway) allow private connections to AWS services without internet access.

---

### 28. What is the purpose of VPC Transit Gateway?
A. Connect VPCs and on-premises networks
B. Transitive peering hub
C. Simplify network topology
D. All of the above

**Answer:** D
**Explanation:** Transit Gateway acts as a cloud router to connect VPCs and on-premises networks, enabling transitive peering.

---

### 29. Which VPC component is highly available by default?
A. NAT Instance
B. NAT Gateway
C. Bastion Host
D. VPN Connection

**Answer:** B
**Explanation:** NAT Gateway is a managed service with built-in high availability and scalability.

---

### 30. What is the maximum number of subnets per VPC?
A. 100
B. 200
C. 500
D. Unlimited (within CIDR limits)

**Answer:** B
**Explanation:** VPCs support up to 200 subnets.

---

### 31. Which VPC feature filters traffic at the subnet level?
A. Security Groups
B. Network ACLs (NACLs)
C. Route Tables
D. Internet Gateway

**Answer:** B
**Explanation:** Network ACLs provide stateless traffic filtering at the subnet level.

---

### 32. What is the purpose of VPC Peering?
A. Connect two VPCs
B. Connect VPC to internet
C. Connect VPC to on-premises
D. Connect subnets

**Answer:** A
**Explanation:** VPC Peering connects two VPCs, enabling routing traffic between them using private IP addresses.

---

### 33. Which VPC component allows IPv6 egress only?
A. Internet Gateway
B. NAT Gateway
C. Egress-Only Internet Gateway
D. VPC Endpoint

**Answer:** C
**Explanation:** Egress-Only Internet Gateway allows IPv6 outbound communication while preventing inbound connections.

---

### 34. What is the maximum bandwidth for AWS Direct Connect?
A. 1 Gbps
B. 10 Gbps
C. 100 Gbps
D. 400 Gbps

**Answer:** C
**Explanation:** Direct Connect supports connections up to 100 Gbps.

---

### 35. Which VPC feature captures IP traffic information?
A. CloudTrail
B. VPC Flow Logs
C. CloudWatch Logs
D. Traffic Mirroring

**Answer:** B
**Explanation:** VPC Flow Logs capture information about IP traffic going to and from network interfaces in your VPC.

---

### 36. What is the purpose of VPC DHCP Options Sets?
A. Configure DHCP
B. Define domain name, DNS servers, NTP servers
C. Assign IP addresses
D. Manage subnets

**Answer:** B
**Explanation:** DHCP Options Sets configure domain name, domain name servers, NTP servers, and NetBIOS servers.

---

### 37. Which VPC endpoint type uses a private IP address?
A. Gateway Endpoint
B. Interface Endpoint
C. Service Endpoint
D. Public Endpoint

**Answer:** B
**Explanation:** Interface Endpoints (PrivateLink) use private IP addresses from your subnet.

---

### 38. What is the maximum number of routes per route table?
A. 50
B. 100
C. 200
D. 1,000

**Answer:** A
**Explanation:** Route tables support up to 50 routes (can be increased to 100).

---

### 39. Which VPC feature allows copying network traffic for inspection?
A. VPC Flow Logs
B. Traffic Mirroring
C. Network Firewall
D. VPC Peering

**Answer:** B
**Explanation:** Traffic Mirroring copies network traffic from an ENI to a target for inspection and monitoring.

---

### 40. What is the purpose of VPC Prefix Lists?
A. List prefixes
B. Group CIDR blocks for use in security groups and route tables
C. List subnets
D. List VPCs

**Answer:** B
**Explanation:** Prefix Lists group CIDR blocks (like AWS service IPs) to simplify security group rules and route tables.

---

### 41. Which VPN type connects users to VPC?
A. Site-to-Site VPN
B. Client VPN
C. Direct Connect
D. Transit Gateway VPN

**Answer:** B
**Explanation:** AWS Client VPN connects individual users (devices) to the VPC.

---

### 42. What is the maximum number of security groups per VPC?
A. 500
B. 1,000
C. 2,500
D. 5,000

**Answer:** C
**Explanation:** VPCs support up to 2,500 security groups per region.

---

### 43. Which VPC feature enables transitive routing?
A. VPC Peering
B. Transit Gateway
C. NAT Gateway
D. VPC Endpoint

**Answer:** B
**Explanation:** Transit Gateway is the only native option that supports transitive routing between attached VPCs and VPNs.

---

### 44. What is the purpose of Bring Your Own IP (BYOIP)?
A. Use own IPs
B. Bring publicly routable IPv4/IPv6 addresses to AWS
C. Private IPs
D. Elastic IPs

**Answer:** B
**Explanation:** BYOIP allows you to bring your own publicly routable IP address ranges to AWS.

---

### 45. Which VPC component is required for Site-to-Site VPN?
A. Internet Gateway
B. Virtual Private Gateway (VGW) or Transit Gateway
C. NAT Gateway
D. VPC Endpoint

**Answer:** B
**Explanation:** Site-to-Site VPN requires a Virtual Private Gateway or Transit Gateway on the AWS side.

---

### 46. What is the maximum transmission unit (MTU) for VPC peering?
A. 1500 bytes
B. 9001 bytes (Jumbo Frames)
C. 10000 bytes
D. Unlimited

**Answer:** B
**Explanation:** VPC peering supports Jumbo Frames with MTU up to 9001 bytes.

---

### 47. Which VPC feature provides managed DNS firewall?
A. Route 53 Resolver DNS Firewall
B. Network Firewall
C. WAF
D. Shield

**Answer:** A
**Explanation:** Route 53 Resolver DNS Firewall filters outbound DNS queries from your VPC.

---

### 48. What is the purpose of VPC IP Address Manager (IPAM)?
A. Manage IPs
B. Automate IP address management and planning across accounts
C. Assign Elastic IPs
D. Monitor IPs

**Answer:** B
**Explanation:** IPAM automates IP address management, planning, and tracking across AWS accounts and regions.

---

### 49. Which VPC endpoint type supports S3 and DynamoDB?
A. Interface Endpoint
B. Gateway Endpoint
C. Service Endpoint
D. Private Endpoint

**Answer:** B
**Explanation:** Gateway Endpoints are used specifically for S3 and DynamoDB (no cost).

---

### 50. What is the maximum number of secondary CIDR blocks per VPC?
A. 1
B. 5
C. 10
D. 20

**Answer:** B
**Explanation:** VPCs support 1 primary CIDR block and up to 4 secondary CIDR blocks (total 5).

