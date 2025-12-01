### 1. Which Route 53 record type maps a domain to an IPv4 address?
A. A Record
B. AAAA Record
C. CNAME Record
D. MX Record

**Answer:** A
**Explanation:** A Record maps a hostname to an IPv4 address.

---

### 2. Which Route 53 record type maps a domain to an IPv6 address?
A. A Record
B. AAAA Record
C. CNAME Record
D. NS Record

**Answer:** B
**Explanation:** AAAA Record maps a hostname to an IPv6 address.

---

### 3. Can CNAME records be used for the root domain (zone apex)?
A. Yes, always
B. No, use Alias records instead
C. Yes, with special configuration
D. Only for subdomains

**Answer:** B
**Explanation:** CNAME cannot be used for zone apex. Use Alias records for root domains.

---

### 4. Which Route 53 routing policy routes traffic to the lowest latency endpoint?
A. Simple
B. Weighted
C. Latency-based
D. Geolocation

**Answer:** C
**Explanation:** Latency-based routing directs traffic to the region with lowest latency.

---

### 5. Which Route 53 routing policy distributes traffic based on assigned weights?
A. Simple
B. Weighted
C. Failover
D. Multivalue

**Answer:** B
**Explanation:** Weighted routing distributes traffic based on assigned percentages (e.g., 70% to A, 30% to B).

---

### 6. What is the purpose of Route 53 Health Checks?
A. Check DNS resolution
B. Monitor endpoint availability and trigger failover
C. Encrypt traffic
D. Cache responses

**Answer:** B
**Explanation:** Health Checks monitor endpoint availability and can trigger failover routing.

---

### 7. Which Route 53 routing policy routes to a backup resource if primary fails?
A. Weighted
B. Latency
C. Failover
D. Geoproximity

**Answer:** C
**Explanation:** Failover routing provides active-passive failover to backup resource.

---

### 8. What is the purpose of Route 53 Alias records?
A. Create aliases for users
B. Map to AWS resources (ELB, CloudFront, S3) for free
C. Encrypt DNS queries
D. Cache DNS responses

**Answer:** B
**Explanation:** Alias records map to AWS resources, auto-update IPs, and are free (no query charges).

---

### 9. Which Route 53 routing policy routes based on user's geographic location?
A. Geolocation
B. Geoproximity
C. Latency
D. Weighted

**Answer:** A
**Explanation:** Geolocation routing routes based on user's geographic location (country, continent).

---

### 10. What is the difference between Geolocation and Geoproximity routing?
A. No difference
B. Geoproximity uses bias to shift traffic, Geolocation doesn't
C. Geolocation is faster
D. Geoproximity is cheaper

**Answer:** B
**Explanation:** Geoproximity allows shifting traffic using bias values. Geolocation routes strictly by location.

---

### 11. Which Route 53 routing policy returns multiple healthy records?
A. Simple
B. Multivalue Answer
C. Weighted
D. Failover

**Answer:** B
**Explanation:** Multivalue Answer returns up to 8 healthy records (client-side load balancing).

---

### 12. What is the maximum TTL for Route 53 records?
A. 1 hour
B. 24 hours
C. 7 days
D. No maximum

**Answer:** D
**Explanation:** TTL can be set to any value (typically 60-86400 seconds).

---

### 13. Which Route 53 feature provides DNSSEC?
A. Route 53 Resolver
B. DNSSEC signing
C. Health Checks
D. Traffic Flow

**Answer:** B
**Explanation:** Route 53 supports DNSSEC for domain signing and validation.

---

### 14. What is the purpose of Route 53 Traffic Flow?
A. Monitor traffic
B. Visual editor for complex routing configurations
C. Encrypt traffic
D. Cache DNS

**Answer:** B
**Explanation:** Traffic Flow provides a visual editor to create complex routing policies.

---

### 15. Which Route 53 routing policy is best for A/B testing?
A. Simple
B. Weighted
C. Failover
D. Latency

**Answer:** B
**Explanation:** Weighted routing allows splitting traffic percentages for A/B testing.

---

### 16. Can Route 53 Alias records point to on-premises servers?
A. Yes, always
B. No, only AWS resources
C. Yes, with VPN
D. Only with Direct Connect

**Answer:** B
**Explanation:** Alias records can only point to AWS resources (ELB, CloudFront, S3, API Gateway, etc.).

---

### 17. What is the purpose of Route 53 Resolver?
A. Resolve DNS queries
B. Enable DNS resolution between VPC and on-premises
C. Cache DNS responses
D. Monitor DNS queries

**Answer:** B
**Explanation:** Route 53 Resolver enables DNS resolution between VPC and on-premises networks.

---

### 18. Which Route 53 health check type combines multiple health checks?
A. Simple
B. Calculated
C. Composite
D. Aggregated

**Answer:** B
**Explanation:** Calculated health checks combine multiple checks using AND, OR, NOT logic.

---

### 19. What is the cost for Route 53 Alias record queries?
A. $0.40 per million queries
B. $0.50 per million queries
C. $1.00 per million queries
D. Free

**Answer:** D
**Explanation:** Alias record queries to AWS resources are free (no query charges).

---

### 20. Which Route 53 routing policy requires Traffic Flow?
A. Simple
B. Weighted
C. Geoproximity
D. Failover

**Answer:** C
**Explanation:** Geoproximity routing requires Route 53 Traffic Flow (visual policy builder).

---

### 21. What is the purpose of Route 53 Private Hosted Zones?
A. Public DNS resolution
B. DNS resolution within VPCs
C. Cache DNS queries
D. Monitor DNS traffic

**Answer:** B
**Explanation:** Private Hosted Zones provide DNS resolution for resources within one or more VPCs.

---

### 22. Which Route 53 health check type monitors CloudWatch alarms?
A. Endpoint health check
B. Calculated health check
C. CloudWatch Alarm health check
D. Composite health check

**Answer:** C
**Explanation:** CloudWatch Alarm health checks monitor the state of CloudWatch alarms.

---

### 23. Can you combine multiple routing policies in a single hosted zone?
A. No, only one policy per zone
B. Yes, different policies for different records
C. Only with Traffic Flow
D. Only for Alias records

**Answer:** B
**Explanation:** Different records in the same hosted zone can use different routing policies.

---

### 24. What is the purpose of DNSSEC validation in Route 53?
A. Encrypt DNS queries
B. Verify DNS responses haven't been tampered with
C. Speed up DNS resolution
D. Cache DNS responses

**Answer:** B
**Explanation:** DNSSEC validates that DNS responses are authentic and haven't been modified in transit.

---

### 25. Which Route 53 feature helps with disaster recovery and application availability?
A. Traffic Flow
B. Application Recovery Controller (ARC)
C. Health Checks
D. Resolver

**Answer:** B
**Explanation:** Application Recovery Controller provides readiness checks and routing controls for multi-region disaster recovery.

---

### 26. What is the maximum number of hosted zones per account?
A. 100
B. 500
C. 1,000
D. 2,000

**Answer:** B
**Explanation:** Default limit is 500 hosted zones per account (can be increased).

---

### 27. Which Route 53 routing policy routes traffic based on user location?
A. Latency Routing
B. Geolocation Routing
C. Geoproximity Routing
D. Weighted Routing

**Answer:** B
**Explanation:** Geolocation Routing routes traffic based on the geographic location of the user (continent, country, state).

---

### 28. What is the purpose of Route 53 Resolver?
A. Resolve DNS queries
B. Hybrid DNS resolution between on-premises and AWS
C. Resolve conflicts
D. Resolve errors

**Answer:** B
**Explanation:** Route 53 Resolver (Inbound/Outbound endpoints) enables hybrid DNS resolution between on-premises and VPCs.

---

### 29. Which Route 53 record type maps a hostname to an IPv6 address?
A. A
B. AAAA
C. CNAME
D. MX

**Answer:** B
**Explanation:** AAAA record maps a hostname to an IPv6 address.

---

### 30. What is the maximum number of health checks per account?
A. 50
B. 100
C. 200
D. 500

**Answer:** C
**Explanation:** Default limit is 200 health checks per account (can be increased).

---

### 31. Which Route 53 feature visualizes and manages complex routing?
A. Traffic Flow
B. Routing Policy
C. Hosted Zone
D. Resolver

**Answer:** A
**Explanation:** Traffic Flow provides a visual editor to create and manage complex routing configurations (Traffic Policies).

---

### 32. What is the purpose of Route 53 Alias records?
A. Map domain to IP
B. Map domain to AWS resources (ELB, CloudFront, S3) at zone apex
C. Map domain to domain
D. Redirect traffic

**Answer:** B
**Explanation:** Alias records map domains to AWS resources (ELB, CloudFront, S3, API Gateway) and support zone apex (root domain).

---

### 33. Which Route 53 routing policy routes traffic based on network latency?
A. Latency Routing
B. Geolocation Routing
C. Geoproximity Routing
D. Failover Routing

**Answer:** A
**Explanation:** Latency Routing routes traffic to the region with the lowest network latency for the user.

---

### 34. What is the maximum TTL for a DNS record?
A. 1 hour
B. 24 hours
C. 48 hours
D. 172800 seconds (2 days) or more

**Answer:** D
**Explanation:** TTL can be set to any value (typically up to 172800 seconds or more, though long TTLs delay propagation).

---

### 35. Which Route 53 feature logs DNS queries?
A. CloudTrail
B. Route 53 Query Logging
C. VPC Flow Logs
D. CloudWatch Logs

**Answer:** B
**Explanation:** Route 53 Query Logging logs DNS queries to CloudWatch Logs for public hosted zones.

---

### 36. What is the purpose of Route 53 Split-View DNS?
A. Split traffic
B. Serve different DNS responses based on source (internal vs external)
C. Split zones
D. Split records

**Answer:** B
**Explanation:** Split-View DNS (using private and public hosted zones with same name) serves different responses to internal (VPC) and external users.

---

### 37. Which Route 53 routing policy allows testing new versions?
A. Weighted Routing
B. Failover Routing
C. Multivalue Answer Routing
D. Simple Routing

**Answer:** A
**Explanation:** Weighted Routing allows splitting traffic (e.g., 90% to v1, 10% to v2) for testing and blue/green deployments.

---

### 38. What is the maximum number of records per hosted zone?
A. 1,000
B. 10,000
C. 100,000
D. Unlimited (10,000 default)

**Answer:** D
**Explanation:** Default limit is 10,000 records per hosted zone (can be increased).

---

### 39. Which Route 53 health check type monitors CloudWatch alarms?
A. Endpoint check
B. Calculated check
C. CloudWatch Alarm check
D. Metric check

**Answer:** C
**Explanation:** Health checks can monitor the state of CloudWatch alarms to determine health.

---

### 40. What is the purpose of Route 53 DNSSEC?
A. Encrypt DNS
B. Sign DNS responses to prevent spoofing and tampering
C. Secure transfer
D. Private DNS

**Answer:** B
**Explanation:** DNSSEC signs DNS responses with cryptographic signatures to ensure authenticity and integrity.

---

### 41. Which Route 53 routing policy routes traffic based on resource location?
A. Geolocation Routing
B. Geoproximity Routing
C. Latency Routing
D. Weighted Routing

**Answer:** B
**Explanation:** Geoproximity Routing routes traffic based on the geographic location of the resource and optionally the user (using Traffic Flow).

---

### 42. What is the maximum number of reusable delegation sets?
A. 50
B. 100
C. 500
D. 1,000

**Answer:** B
**Explanation:** You can create up to 100 reusable delegation sets per account.

---

### 43. Which Route 53 feature allows registering domains?
A. Route 53 Resolver
B. Route 53 Domain Registration
C. Route 53 Registrar
D. Route 53 Domains

**Answer:** B
**Explanation:** Route 53 functions as a domain registrar, allowing you to register and manage domain names.

---

### 44. What is the purpose of Route 53 VPC Association Authorization?
A. Authorize VPC peering
B. Authorize associating a private hosted zone with a VPC in another account
C. Authorize users
D. Authorize DNS queries

**Answer:** B
**Explanation:** VPC Association Authorization allows associating a private hosted zone with a VPC in a different AWS account.

---

### 45. Which Route 53 routing policy returns multiple healthy IPs?
A. Simple Routing
B. Multivalue Answer Routing
C. Weighted Routing
D. Failover Routing

**Answer:** B
**Explanation:** Multivalue Answer Routing returns up to 8 healthy records in response to DNS queries (client-side load balancing).

---

### 46. What is the maximum number of traffic policies per account?
A. 50
B. 100
C. 500
D. 1,000

**Answer:** A
**Explanation:** Default limit is 50 traffic policies per account.

---

### 47. Which Route 53 feature filters outbound DNS traffic?
A. Route 53 Resolver DNS Firewall
B. Network Firewall
C. WAF
D. Shield

**Answer:** A
**Explanation:** Route 53 Resolver DNS Firewall filters outbound DNS queries from your VPC against domain lists.

---

### 48. What is the purpose of Route 53 Calculated Health Checks?
A. Calculate latency
B. Combine results of multiple health checks (AND/OR/NOT logic)
C. Calculate costs
D. Monitor performance

**Answer:** B
**Explanation:** Calculated Health Checks monitor the status of other health checks to determine overall health (e.g., 2 out of 3 healthy).

---

### 49. Which Route 53 record type is used for email servers?
A. A
B. CNAME
C. MX
D. TXT

**Answer:** C
**Explanation:** MX (Mail Exchange) record specifies the mail servers responsible for accepting email for the domain.

---

### 50. What is the purpose of Route 53 Service Naming?
A. Name services
B. Integration with ECS Service Discovery
C. Name domains
D. Name zones

**Answer:** B
**Explanation:** Route 53 Auto Naming (Service Discovery) automatically manages DNS records for microservices (ECS/Fargate).

