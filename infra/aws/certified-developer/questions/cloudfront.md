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

---

### 21. What is CloudFront Origin Shield?
A. Security feature
B. Additional caching layer to reduce origin load
C. DDoS protection
D. Origin encryption

**Answer:** B
**Explanation:** Origin Shield is an additional caching layer between edge locations and origin to reduce origin load and improve cache hit ratio.

---

### 22. Which CloudFront feature adds security headers to responses?
A. Security Policies
B. Response Headers Policies
C. Origin Policies
D. Cache Policies

**Answer:** B
**Explanation:** Response Headers Policies automatically add security headers (HSTS, CSP, X-Frame-Options) to CloudFront responses.

---

### 23. What is CloudFront Continuous Deployment used for?
A. Deploy to production
B. Test configuration changes with a subset of traffic before full deployment
C. Monitor deployments
D. Rollback deployments

**Answer:** B
**Explanation:** Continuous Deployment allows testing CloudFront configuration changes with a small percentage of traffic before full rollout.

---

### 24. Which CloudFront feature provides low-latency key-value storage at edge locations?
A. CloudFront Cache
B. CloudFront KeyValueStore
C. Lambda@Edge
D. Edge Storage

**Answer:** B
**Explanation:** CloudFront KeyValueStore provides low-latency key-value data access at edge locations for CloudFront Functions.

---

### 25. What is the purpose of CloudFront origin connection settings?
A. Monitor connections
B. Configure connection timeout, attempts, and protocol
C. Encrypt connections
D. Load balance origins

**Answer:** B
**Explanation:** Origin connection settings control connection timeout, number of attempts, and protocol (HTTP/HTTPS) for origin requests.

---

### 26. What is the maximum execution time for CloudFront Functions?
A. 1 millisecond
B. 5 seconds
C. 30 seconds
D. 1 minute

**Answer:** A
**Explanation:** CloudFront Functions have a strict execution time limit of 1 millisecond or less.

---

### 27. Which CloudFront feature allows executing code at edge locations?
A. Lambda@Edge
B. CloudFront Functions
C. Both A and B
D. Edge Functions

**Answer:** C
**Explanation:** Both Lambda@Edge (Node.js/Python, longer duration) and CloudFront Functions (JS, sub-ms) run code at edge.

---

### 28. What is the purpose of CloudFront Origin Shield?
A. Shield origin
B. Centralized caching layer to reduce load on origin
C. Security shield
D. DDoS protection

**Answer:** B
**Explanation:** Origin Shield acts as a centralized caching layer to improve cache hit ratio and reduce load on the origin.

---

### 29. Which CloudFront event triggers Lambda@Edge?
A. Viewer Request
B. Origin Request
C. Origin Response
D. All of the above

**Answer:** D
**Explanation:** Lambda@Edge can be triggered on Viewer Request, Origin Request, Origin Response, and Viewer Response.

---

### 30. What is the maximum size of a file CloudFront can serve?
A. 1 GB
B. 10 GB
C. 20 GB
D. 30 GB

**Answer:** D
**Explanation:** CloudFront supports files up to 30 GB in size.

---

### 31. Which CloudFront feature restricts access to content?
A. Signed URLs
B. Signed Cookies
C. Origin Access Control (OAC)
D. All of the above

**Answer:** D
**Explanation:** Signed URLs/Cookies restrict viewer access; OAC restricts access to S3 origins.

---

### 32. What is the purpose of CloudFront KeyValueStore?
A. Store keys
B. Low-latency key-value store for CloudFront Functions
C. Store values
D. Cache data

**Answer:** B
**Explanation:** CloudFront KeyValueStore provides low-latency read access to key-value data from within CloudFront Functions.

---

### 33. Which CloudFront distribution type supports RTMP?
A. Web
B. RTMP
C. Streaming
D. None (Deprecated)

**Answer:** D
**Explanation:** RTMP distributions are deprecated and discontinued. Use Web distributions for HTTP streaming (HLS/DASH).

---

### 34. What is the maximum number of behaviors per distribution?
A. 10
B. 25
C. 50
D. 100

**Answer:** B
**Explanation:** Default limit is 25 cache behaviors per distribution (can be increased).

---

### 35. Which CloudFront feature allows testing configuration changes?
A. Staging Distribution
B. Continuous Deployment (Staging Distribution)
C. Test Distribution
D. Blue/Green

**Answer:** B
**Explanation:** CloudFront Continuous Deployment allows creating a staging distribution to test configuration changes with a portion of traffic.

---

### 36. What is the purpose of CloudFront Origin Access Control (OAC)?
A. Control origin access
B. Securely access S3 origins (replaces OAI)
C. Access control list
D. Firewall

**Answer:** B
**Explanation:** OAC is the modern way to securely restrict access to S3 origins to only CloudFront (supports SSE-KMS, unlike OAI).

---

### 37. Which CloudFront metric indicates cache performance?
A. CacheHitRate
B. Requests
C. BytesDownloaded
D. TotalErrorRate

**Answer:** A
**Explanation:** CacheHitRate indicates the percentage of requests served from the cache.

---

### 38. What is the maximum number of alternate domain names (CNAMEs) per distribution?
A. 10
B. 50
C. 100
D. Unlimited

**Answer:** C
**Explanation:** You can add up to 100 alternate domain names (CNAMEs) to a distribution.

---

### 39. Which CloudFront feature compresses objects?
A. Gzip
B. Brotli
C. Both A and B
D. Zip

**Answer:** C
**Explanation:** CloudFront can automatically compress objects using Gzip and Brotli.

---

### 40. What is the purpose of CloudFront Response Headers Policies?
A. Modify headers
B. Control HTTP headers sent to viewers (CORS, security headers)
C. Log headers
D. Cache headers

**Answer:** B
**Explanation:** Response Headers Policies allow you to add, remove, or modify HTTP headers sent to viewers (e.g., for CORS or security).

---

### 41. Which CloudFront function runtime is supported?
A. Node.js
B. Python
C. JavaScript (ES5.1 compliant)
D. Go

**Answer:** C
**Explanation:** CloudFront Functions use a lightweight JavaScript runtime (ES5.1 compliant).

---

### 42. What is the maximum execution time for Lambda@Edge (Origin Request/Response)?
A. 5 seconds
B. 30 seconds
C. 60 seconds
D. 15 minutes

**Answer:** B
**Explanation:** Lambda@Edge Origin Request/Response triggers have a 30-second timeout (Viewer triggers have 5 seconds).

---

### 43. Which CloudFront feature allows serving private content?
A. Signed URLs
B. Signed Cookies
C. Both A and B
D. Private Distribution

**Answer:** C
**Explanation:** Signed URLs and Signed Cookies are used to serve private content to authenticated users.

---

### 44. What is the purpose of CloudFront Field-Level Encryption?
A. Encrypt fields
B. Encrypt specific data fields (like credit cards) at the edge
C. Encrypt entire request
D. Encrypt response

**Answer:** B
**Explanation:** Field-Level Encryption encrypts specific fields in POST requests at the edge before forwarding to origin.

---

### 45. Which CloudFront cache policy setting includes query strings?
A. Query String Forwarding
B. Cache Key Settings
C. Origin Request Policy
D. Whitelist

**Answer:** B
**Explanation:** Cache Key Settings in a Cache Policy determine which query strings are included in the cache key.

---

### 46. What is the maximum number of origins per distribution?
A. 10
B. 25
C. 50
D. 100

**Answer:** B
**Explanation:** You can configure up to 25 origins per distribution.

---

### 47. Which CloudFront feature allows custom error pages?
A. Error Pages
B. Custom Error Responses
C. Error Handling
D. Failover

**Answer:** B
**Explanation:** Custom Error Responses allow you to return a custom file and HTTP status code when the origin returns an error.

---

### 48. What is the purpose of CloudFront Origin Groups?
A. Group origins
B. Origin failover (primary and secondary origin)
C. Load balancing
D. Replication

**Answer:** B
**Explanation:** Origin Groups allow configuring a primary and secondary origin for high availability (failover).

---

### 49. Which CloudFront log type provides detailed request information?
A. Standard Logs (Access Logs)
B. Real-time Logs
C. Both A and B
D. CloudTrail

**Answer:** C
**Explanation:** Both Standard Logs (delivered to S3) and Real-time Logs (delivered to Kinesis) provide detailed request info.

---

### 50. What is the maximum body size for CloudFront Functions?
A. 40 KB
B. 1 MB
C. No body access
D. Unlimited

**Answer:** C
**Explanation:** CloudFront Functions do not have access to the request body (Lambda@Edge does).

