# ELB & ASG — Elastic Load Balancing & Auto Scaling

## Scalability & High Availability
- **Scalability:** Application can handle increased load.
  - Vertical (scale up) — increase instance size.
  - Horizontal (scale out) — increase number of instances.
- **High Availability:** Run instances across at least 2 Availability Zones to survive failures.

### Vertical Scalability
- Example: t2.micro → t2.large
- Common for non-distributed systems like databases.
- Limited by hardware.

### Horizontal Scalability
- Add more instances to distribute load.
- Common for web apps / cloud-native systems.

### Elasticity
- Automatic scaling based on load.
- Cloud-friendly: pay-per-use, cost optimization.

### Agility
- Fast provisioning of IT resources (minutes vs weeks).

---

## Load Balancing

### Purpose
- Forward traffic to multiple instances.
- Provide single access point (DNS).
- Health checks for failure detection.
- SSL termination (HTTPS).
- Cross-AZ high availability.

### AWS Elastic Load Balancers
- **Managed by AWS:** automatic upgrades, maintenance, HA.
- Types:
  1. **Application Load Balancer (ALB)** — HTTP/HTTPS, Layer 7
  2. **Network Load Balancer (NLB)** — TCP/UDP, ultra-low latency, Layer 4
  3. **Gateway Load Balancer (GWLB)** — Layer 3, deploy/manage 3rd party appliances
  4. **Classic Load Balancer (CLB)** — legacy, Layer 4 & 7, retired 2023

### Health Checks
- Port and route (/health) based.
- Non-200 response = instance unhealthy.

### ALB Features
- Path, hostname, query string, header-based routing.
- Supports HTTP/2, WebSocket, gRPC.
- Multiple target groups (EC2, IP, ECS, Lambda).
- Port mapping for containerized apps.
- Fixed DNS name; client IP via `X-Forwarded-For`.
- Microservices & container-friendly.

### NLB Features
- TCP/UDP traffic, millions of requests/sec.
- Static IP per AZ, supports Elastic IP.
- Ultra-low latency (~100ms vs 400ms for ALB).

### GWLB Features
- Route traffic to virtual appliances (firewalls, IDS/IPS).
- GENEVE protocol, Layer 3.
- Supports EC2 & private IP targets.

### Cross-Zone Load Balancing
- ALB: enabled by default, free inter-AZ.
- NLB & GWLB: disabled by default, paid inter-AZ.
- CLB: disabled by default, free inter-AZ if enabled.

---

## Auto Scaling Groups (ASG)

### Purpose
- Automatically scale EC2 instances based on load.
- Maintain min/max/desired capacity.
- Replace unhealthy instances.
- Auto-register instances with load balancer.
- Cost-efficient: only run optimal number of instances.

### ASG Components
- **Launch Template:** AMI, instance type, userdata, EBS, security, IAM role, network, load balancer.
- **Min / Max / Desired Capacity**
- **Scaling Policies**: manual, dynamic (target tracking, step), scheduled, predictive.

### Scaling Strategies
- **Manual Scaling:** adjust ASG size manually.
- **Dynamic Scaling:** based on CloudWatch alarms.
  - **Target Tracking:** maintain metric target (e.g., CPU 40%).
  - **Step Scaling:** add/remove units based on threshold.
- **Scheduled Scaling:** pre-plan for predictable traffic.
- **Predictive Scaling:** ML predicts future traffic, pre-provisions instances.

### Instance Refresh
- Updates launch template across ASG instances.
- Configure min healthy %, warm-up time.

### Scaling Cooldowns
- Prevents immediate additional scaling actions.
- Default 300s.
- Use ready-to-use AMIs to reduce cooldown.

### Metrics to Scale On
- CPUUtilization
- RequestCountPerTarget
- Network In/Out
- Custom metrics via CloudWatch

### Connection Draining / Deregistration Delay
- Graceful shutdown for in-flight requests.
- 1–3600s (default 300s), can disable.

---

## SSL / TLS Certificates
- Managed via ACM (AWS Certificate Manager) or uploaded manually.
- HTTPS listener requires default certificate; optional multiple certificates via SNI.
- **ALB & NLB:** support SNI, multiple certs.
- **CLB:** supports only one cert, multiple CLBs needed for multiple hostnames.

### Sticky Sessions
- Ensures client consistently reaches same backend instance.
- Supports CLB, ALB, NLB.
- Cookie-based; configurable expiration.
- Types:
  - **Application Cookies:** custom or load balancer-generated (AWSALBAPP)
  - **Duration-based Cookies:** ALB (AWSALB), CLB (AWSELB)
- May create backend load imbalance.
