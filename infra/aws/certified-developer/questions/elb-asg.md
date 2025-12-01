### 1. Which load balancer operates at Layer 7 (Application Layer)?
A. Classic Load Balancer
B. Network Load Balancer
C. Application Load Balancer
D. Gateway Load Balancer

**Answer:** C
**Explanation:** ALB operates at Layer 7, supporting HTTP/HTTPS routing based on path, host, headers.

---

### 2. Which load balancer provides ultra-low latency and static IP addresses?
A. Application Load Balancer
B. Network Load Balancer
C. Classic Load Balancer
D. Gateway Load Balancer

**Answer:** B
**Explanation:** NLB operates at Layer 4 (TCP/UDP), provides ultra-low latency (~100ms) and static IPs.

---

### 3. What is the purpose of Target Groups in ALB/NLB?
A. Group load balancers
B. Route requests to registered targets (EC2, IP, Lambda)
C. Configure security groups
D. Monitor health

**Answer:** B
**Explanation:** Target Groups contain registered targets that receive traffic from the load balancer.

---

### 4. Which ALB feature allows routing based on URL path?
A. Host-based routing
B. Path-based routing
C. Query string routing
D. Header routing

**Answer:** B
**Explanation:** ALB supports path-based routing (e.g., /api/* → backend, /images/* → S3).

---

### 5. What is Cross-Zone Load Balancing?
A. Load balancing across regions
B. Load balancing across Availability Zones
C. Load balancing across VPCs
D. Load balancing across accounts

**Answer:** B
**Explanation:** Cross-Zone LB distributes traffic evenly across all targets in all enabled AZs.

---

### 6. Which load balancer type is enabled for Cross-Zone Load Balancing by default?
A. ALB
B. NLB
C. CLB
D. GWLB

**Answer:** A
**Explanation:** ALB has Cross-Zone LB enabled by default (free). NLB/GWLB disabled by default (paid).

---

### 7. What is the purpose of Connection Draining (Deregistration Delay)?
A. Drain excess traffic
B. Complete in-flight requests before deregistering target
C. Reduce latency
D. Encrypt connections

**Answer:** B
**Explanation:** Connection Draining allows in-flight requests to complete before removing target (1-3600s, default 300s).

---

### 8. Which Auto Scaling policy maintains a target metric value?
A. Step Scaling
B. Target Tracking Scaling
C. Simple Scaling
D. Scheduled Scaling

**Answer:** B
**Explanation:** Target Tracking maintains a specific metric target (e.g., CPU at 40%).

---

### 9. What is the minimum size for an Auto Scaling Group?
A. 0
B. 1
C. 2
D. 3

**Answer:** A
**Explanation:** ASG minimum size can be 0 (no instances running).

---

### 10. Which ASG scaling policy uses CloudWatch alarms?
A. Target Tracking
B. Step Scaling
C. Scheduled Scaling
D. Predictive Scaling

**Answer:** B
**Explanation:** Step Scaling uses CloudWatch alarms to trigger scaling actions based on thresholds.

---

### 11. What is the default health check type for Auto Scaling Groups?
A. ELB health check
B. EC2 status check
C. Custom health check
D. No health check

**Answer:** B
**Explanation:** Default is EC2 status check (can be changed to ELB health check).

---

### 12. Which ALB feature maintains session affinity?
A. Connection Draining
B. Sticky Sessions (Session Affinity)
C. Cross-Zone Load Balancing
D. Health Checks

**Answer:** B
**Explanation:** Sticky Sessions ensure requests from same client go to same target.

---

### 13. What is the maximum duration for ALB sticky session cookies?
A. 1 hour
B. 1 day
C. 7 days
D. 1 year

**Answer:** C
**Explanation:** ALB sticky session cookies can last from 1 second to 7 days.

---

### 14. Which ASG feature gradually updates instances with new configuration?
A. Rolling Update
B. Instance Refresh
C. Blue/Green Deployment
D. Canary Deployment

**Answer:** B
**Explanation:** Instance Refresh gradually replaces instances with new launch template configuration.

---

### 15. What is the purpose of ASG Scaling Cooldown?
A. Cool down servers
B. Prevent rapid scaling actions
C. Reduce costs
D. Improve performance

**Answer:** B
**Explanation:** Cooldown period (default 300s) prevents additional scaling actions until previous action completes.

---

### 16. Which load balancer supports WebSocket protocol?
A. Classic Load Balancer
B. Application Load Balancer
C. Network Load Balancer
D. All of the above

**Answer:** B
**Explanation:** ALB supports WebSocket and HTTP/2 protocols.

---

### 17. What is the purpose of Gateway Load Balancer?
A. HTTP routing
B. Deploy and manage third-party virtual appliances (firewalls, IDS/IPS)
C. TCP load balancing
D. WebSocket support

**Answer:** B
**Explanation:** GWLB routes traffic to virtual appliances for inspection/filtering (Layer 3, GENEVE protocol).

---

### 18. Which ALB feature allows Lambda functions as targets?
A. Lambda integration
B. Lambda targets
C. Serverless targets
D. Function targets

**Answer:** A
**Explanation:** ALB can invoke Lambda functions directly as targets for HTTP requests.

---

### 19. What is the default health check interval for load balancers?
A. 5 seconds
B. 10 seconds
C. 30 seconds
D. 60 seconds

**Answer:** C
**Explanation:** Default health check interval is 30 seconds (configurable 5-300 seconds).

---

### 20. Which ASG metric is commonly used for scaling web applications?
A. NetworkIn
B. DiskReadOps
C. CPUUtilization
D. MemoryUtilization

**Answer:** C
**Explanation:** CPUUtilization is the most common metric for scaling web applications.

---

### 21. Which ALB feature adds a unique identifier to track requests?
A. Request ID
B. X-Amzn-Trace-Id header
C. Session ID
D. Correlation ID

**Answer:** B
**Explanation:** ALB adds X-Amzn-Trace-Id header to track requests through distributed systems.

---

### 22. Can Network Load Balancer terminate TLS connections?
A. No, NLB is Layer 4 only
B. Yes, NLB supports TLS termination
C. Only with ALB
D. Only in specific regions

**Answer:** B
**Explanation:** NLB supports TLS termination while maintaining ultra-low latency and static IPs.

---

### 23. What is the purpose of ASG Lifecycle Hooks?
A. Monitor instance health
B. Perform custom actions during instance launch/termination
C. Scale instances
D. Configure load balancers

**Answer:** B
**Explanation:** Lifecycle Hooks pause instance launch/termination to perform custom actions (install software, drain connections).

---

### 24. Which ASG scaling policy uses machine learning to forecast traffic?
A. Target Tracking
B. Step Scaling
C. Predictive Scaling
D. Scheduled Scaling

**Answer:** C
**Explanation:** Predictive Scaling uses machine learning to forecast traffic patterns and schedule scaling ahead of time.

---

### 25. What is the purpose of ASG Warm Pools?
A. Cool down instances
B. Maintain pre-initialized instances for faster scaling
C. Store instance configurations
D. Monitor instance health

**Answer:** B
**Explanation:** Warm Pools keep pre-initialized instances in a stopped or running state for faster scaling response.

---

### 26. What is the maximum number of targets per target group?
A. 100
B. 1,000
C. 10,000
D. Unlimited

**Answer:** B
**Explanation:** Target groups support up to 1,000 targets.

---

### 27. Which load balancer type supports WebSockets?
A. Classic Load Balancer
B. Application Load Balancer
C. Network Load Balancer
D. All of the above

**Answer:** D
**Explanation:** All three load balancer types support WebSockets.

---

### 28. What is the maximum number of rules per ALB listener?
A. 25
B. 50
C. 100
D. 1,000

**Answer:** C
**Explanation:** ALB listeners support up to 100 rules.

---

### 29. Which ASG scaling policy adjusts capacity based on metric?
A. Target Tracking Scaling
B. Step Scaling
C. Simple Scaling
D. All of the above

**Answer:** D
**Explanation:** All three policies adjust capacity based on metrics with different behaviors.

---

### 30. What is the purpose of ALB sticky sessions?
A. Stick to instances
B. Route requests from same client to same target
C. Session management
D. Load balancing

**Answer:** B
**Explanation:** Sticky sessions (session affinity) route requests from the same client to the same target.

---

### 31. Which load balancer operates at Layer 4?
A. Application Load Balancer
B. Network Load Balancer
C. Classic Load Balancer
D. Gateway Load Balancer

**Answer:** B
**Explanation:** Network Load Balancer operates at Layer 4 (Transport layer) for TCP/UDP traffic.

---

### 32. What is the maximum number of ASG launch configurations?
A. 100
B. 200
C. 1,000
D. Unlimited

**Answer:** B
**Explanation:** Maximum of 200 launch configurations per region.

---

### 33. Which ALB feature routes based on HTTP headers?
A. Path-based routing
B. Host-based routing
C. Header-based routing (routing rules)
D. Query string routing

**Answer:** C
**Explanation:** ALB supports routing based on HTTP headers, methods, query strings, and source IP.

---

### 34. What is the purpose of ASG cooldown period?
A. Cool down instances
B. Prevent rapid scaling actions
C. Delay scaling
D. Monitor scaling

**Answer:** B
**Explanation:** Cooldown period prevents ASG from launching/terminating instances too quickly after scaling activity.

---

### 35. Which load balancer provides static IP addresses?
A. Application Load Balancer
B. Network Load Balancer
C. Classic Load Balancer
D. All of the above

**Answer:** B
**Explanation:** Network Load Balancer provides static IP addresses (one per AZ).

---

### 36. What is the maximum number of listeners per load balancer?
A. 10
B. 50
C. 100
D. Unlimited

**Answer:** B
**Explanation:** Load balancers support up to 50 listeners.

---

### 37. Which ASG feature ensures minimum number of instances?
A. Desired capacity
B. Minimum capacity
C. Reserved capacity
D. Base capacity

**Answer:** B
**Explanation:** Minimum capacity ensures ASG maintains at least that many instances.

---

### 38. What is the purpose of NLB cross-zone load balancing?
A. Balance across zones
B. Distribute traffic evenly across all targets in all enabled AZs
C. Zone redundancy
D. Multi-region balancing

**Answer:** B
**Explanation:** Cross-zone load balancing distributes traffic evenly across targets in all enabled AZs.

---

### 39. Which ALB target type is supported?
A. Instance
B. IP
C. Lambda
D. All of the above

**Answer:** D
**Explanation:** ALB supports instance, IP, and Lambda function targets.

---

### 40. What is the maximum number of target groups per ALB?
A. 10
B. 50
C. 100
D. 1,000

**Answer:** C
**Explanation:** ALBs support up to 100 target groups.

---

### 41. Which ASG termination policy terminates oldest instance?
A. OldestInstance
B. OldestLaunchConfiguration
C. OldestLaunchTemplate
D. Both B and C

**Answer:** D
**Explanation:** Both OldestLaunchConfiguration and OldestLaunchTemplate terminate oldest instances.

---

### 42. What is the purpose of ALB slow start mode?
A. Start slowly
B. Gradually increase traffic to new targets for warm-up
C. Reduce latency
D. Monitor startup

**Answer:** B
**Explanation:** Slow start mode gradually increases traffic to new targets to allow warm-up time.

---

### 43. Which load balancer supports PrivateLink?
A. Application Load Balancer
B. Network Load Balancer
C. Classic Load Balancer
D. Gateway Load Balancer

**Answer:** B
**Explanation:** Network Load Balancer supports AWS PrivateLink for private connectivity.

---

### 44. What is the maximum number of instances per ASG?
A. 100
B. 1,000
C. 10,000
D. Depends on account limits

**Answer:** D
**Explanation:** Limited by EC2 instance limits and account quotas (can scale to thousands).

---

### 45. Which ALB feature provides authentication?
A. Cognito User Pools
B. OIDC identity providers
C. Both A and B
D. Not supported

**Answer:** C
**Explanation:** ALB supports authentication via Cognito User Pools and OIDC identity providers.

---

### 46. What is the purpose of ASG instance protection?
A. Protect instances
B. Prevent scale-in from terminating specific instances
C. Security protection
D. Backup instances

**Answer:** B
**Explanation:** Instance protection prevents ASG scale-in from terminating protected instances.

---

### 47. Which load balancer metric indicates unhealthy targets?
A. UnHealthyHostCount
B. TargetResponseTime
C. RequestCount
D. HTTPCode_Target_5XX_Count

**Answer:** A
**Explanation:** UnHealthyHostCount shows number of unhealthy targets.

---

### 48. What is the maximum number of certificates per ALB?
A. 1
B. 25
C. 50
D. Unlimited

**Answer:** B
**Explanation:** ALBs support up to 25 certificates per load balancer.

---

### 49. Which ASG feature allows scheduled scaling?
A. Scheduled Actions
B. Cron scaling
C. Time-based scaling
D. Calendar scaling

**Answer:** A
**Explanation:** Scheduled Actions scale ASG based on predictable load changes at specific times.

---

### 50. What is the purpose of NLB connection draining?
A. Drain connections
B. Complete in-flight requests before deregistering targets
C. Close connections
D. Monitor connections

**Answer:** B
**Explanation:** Connection draining (deregistration delay) allows completing in-flight requests before removing targets.

