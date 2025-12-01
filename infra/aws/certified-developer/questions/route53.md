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
