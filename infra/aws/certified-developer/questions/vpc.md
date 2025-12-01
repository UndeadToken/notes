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
