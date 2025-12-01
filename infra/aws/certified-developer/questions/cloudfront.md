### 1. What is the primary purpose of CloudFront?
A. Store files
B. Content Delivery Network (CDN) for low-latency content delivery
C. Compute service
D. Database caching

**Answer:** B
**Explanation:** CloudFront is a CDN that caches content at edge locations globally for low latency.

---

### 2. How many edge locations does CloudFront have?
A. 50+
B. 100+
C. 216+
D. 400+

**Answer:** C
**Explanation:** CloudFront has 216+ edge locations globally (and growing).

---

### 3. Which CloudFront origin type is NOT supported?
A. S3 Bucket
B. Application Load Balancer
C. EC2 Instance
D. RDS Database

**Answer:** D
**Explanation:** CloudFront supports S3, ALB, EC2, custom HTTP endpoints, but not RDS directly.

---

### 4. What is the purpose of CloudFront Origin Access Control (OAC)?
A. Control cache behavior
B. Restrict S3 bucket access to CloudFront only
C. Monitor origins
D. Encrypt content

**Answer:** B
**Explanation:** OAC restricts S3 bucket access so only CloudFront can access objects.

---

### 5. What is the default TTL for CloudFront cache?
A. 1 hour
B. 24 hours
C. 7 days
D. 30 days

**Answer:** B
**Explanation:** Default TTL is 24 hours (configurable 0 seconds to 1 year).

---

### 6. Which CloudFront feature invalidates cached objects?
A. Cache Refresh
B. Cache Invalidation
C. Cache Clear
D. Cache Reset

**Answer:** B
**Explanation:** Cache Invalidation (CreateInvalidation API) removes objects from edge caches.

---

### 7. What is the purpose of CloudFront Signed URLs?
A. Encrypt URLs
B. Control access to private content with expiration
C. Shorten URLs
D. Monitor access

**Answer:** B
**Explanation:** Signed URLs provide time-limited access to private content with policies (expiration, IP ranges).

---

### 8. What is the difference between Signed URLs and Signed Cookies?
A. No difference
B. Signed URLs for single files, Signed Cookies for multiple files
C. Signed Cookies are more secure
D. Signed URLs are faster

**Answer:** B
**Explanation:** Signed URLs restrict access to individual files. Signed Cookies allow access to multiple files.

---

### 9. Which CloudFront feature provides automatic failover to secondary origin?
A. Origin Groups
B. Origin Failover
C. Multi-Origin
D. Backup Origin

**Answer:** A
**Explanation:** Origin Groups define primary and secondary origins for automatic failover.

---

### 10. What is the purpose of CloudFront Cache Behaviors?
A. Monitor cache
B. Define caching rules for URL path patterns
C. Clear cache
D. Encrypt cache

**Answer:** B
**Explanation:** Cache Behaviors define different caching settings for different URL patterns (e.g., /api/*, /images/*).

---

### 11. Which CloudFront feature encrypts sensitive fields in POST requests?
A. SSL/TLS
B. Field-Level Encryption
C. KMS Encryption
D. Origin Encryption

**Answer:** B
**Explanation:** Field-Level Encryption encrypts specific form fields using public keys.

---

### 12. What is the purpose of CloudFront Geo Restriction?
A. Improve performance
B. Allow/block access based on user's country
C. Route to nearest edge
D. Encrypt traffic

**Answer:** B
**Explanation:** Geo Restriction creates allowlist or blocklist based on user's geographic location.

---

### 13. Which CloudFront price class includes all edge locations?
A. Price Class 100
B. Price Class 200
C. Price Class All
D. Price Class Global

**Answer:** C
**Explanation:** Price Class All uses all edge locations (most expensive, best performance).

---

### 14. What is the purpose of CloudFront Real-Time Logs?
A. Debug cache issues
B. Stream request data to Kinesis for analysis
C. Monitor origins
D. Encrypt logs

**Answer:** B
**Explanation:** Real-Time Logs send request data to Kinesis Data Streams for real-time monitoring and analysis.

---

### 15. Which CloudFront feature allows custom logic at edge locations?
A. Lambda@Edge
B. CloudFront Functions
C. Both A and B
D. Neither

**Answer:** C
**Explanation:** Both Lambda@Edge and CloudFront Functions run custom code at edge locations.

---

### 16. What is the difference between CloudFront Functions and Lambda@Edge?
A. No difference
B. CloudFront Functions are lighter/faster (ms latency), Lambda@Edge more powerful
C. Lambda@Edge is cheaper
D. CloudFront Functions support more languages

**Answer:** B
**Explanation:** CloudFront Functions are lightweight JavaScript (sub-ms latency). Lambda@Edge supports Node.js/Python with more capabilities.

---

### 17. Which CloudFront event can trigger Lambda@Edge?
A. Viewer Request only
B. Origin Request only
C. Viewer Request, Origin Request, Origin Response, Viewer Response
D. Cache Hit/Miss

**Answer:** C
**Explanation:** Lambda@Edge can run on Viewer Request, Origin Request, Origin Response, and Viewer Response.

---

### 18. What is the maximum cache key size for CloudFront?
A. 1 KB
B. 4 KB
C. 8 KB
D. No limit

**Answer:** C
**Explanation:** Cache key (hostname + path + headers + cookies + query strings) is limited to 8 KB.

---

### 19. Which CloudFront feature improves cache hit ratio?
A. Cache Policies
B. Origin Request Policies
C. Cache Behaviors
D. All of the above

**Answer:** D
**Explanation:** Cache Policies, Origin Request Policies, and Cache Behaviors all help optimize caching.

---

### 20. Can CloudFront cache dynamic content?
A. No, only static content
B. Yes, with appropriate TTL and cache policies
C. Only with Lambda@Edge
D. Not recommended

**Answer:** B
**Explanation:** CloudFront can cache dynamic content with low TTL and proper cache policies (query strings, headers).
