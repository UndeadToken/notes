# AWS Certified Developer – Associate (DVA-C02) Exam Route 53 Cheat Sheet

---

### DNS Basics
- **DNS** = Domain Name System; translates hostnames → IP addresses.
- **FQDN**: Fully Qualified Domain Name (e.g., `api.www.example.com.`).
- **Terminology**:
  - **Domain Registrar**: Registers domain (Route 53, GoDaddy).
  - **Name Server (NS)**: Resolves DNS queries (Authoritative / Non-Authoritative).
  - **Zone File**: Contains DNS records.
  - **TLD / SLD**: Top Level / Second Level Domains.
  - **DNS Records**: A, AAAA, CNAME, NS, MX, etc.

### Amazon Route 53
- Managed, highly available, **Authoritative DNS**.
- Also a **Domain Registrar**.
- Health checks for resources.
- Only AWS service with 100% SLA.

### Route 53 Records
- **Record Elements**:
  - Name (domain/subdomain)
  - Type (A, AAAA, CNAME, NS…)
  - Value (IP / hostname)
  - TTL (cache duration)
  - Routing Policy
- **Record Types to know**:
  - **A** → IPv4
  - **AAAA** → IPv6
  - **CNAME** → hostname → hostname (not for root domain)
  - **NS** → name servers

### Alias Records
- Points hostname → AWS resource (ELB, CloudFront, API Gateway…).
- Can be root domain (Zone Apex) or subdomain.
- Free, auto-updates IPs, TTL not configurable.
- Cannot use for EC2 DNS names.

### Hosted Zones
- **Container** for DNS records.
- **Public** → Internet traffic.
- **Private** → VPC-only traffic.
- Cost: $0.50/month per hosted zone.

### TTL
- High TTL → fewer queries, possibly stale records.
- Low TTL → more queries, quick updates.
- Alias records ignore TTL.

### Routing Policies
- Define **how Route 53 responds to queries** (not actual traffic routing).
1. **Simple**: one resource or multiple random.
2. **Weighted**: % of traffic to resources; supports health checks.
3. **Latency-based**: route to lowest latency region; supports health checks.
4. **Failover (Active-Passive)**: route to backup if primary fails.
5. **Geolocation**: route by user location; specify default record.
6. **Geoproximity**: shift traffic using bias; requires Traffic Flow.
7. **Multi-Value**: return multiple resources; up to 8 healthy; can use health checks.

### Health Checks
- Monitor endpoint availability (HTTP, HTTPS, TCP).
- **Calculated health checks**: combine multiple checks (AND, OR, NOT).
- Private endpoints → use CloudWatch metric + alarm as health check.

### Traffic Flow
- Visual editor for complex routing.
- Supports versioning.
- Can be applied across multiple hosted zones.

### IP-based Routing
- Route by client IP / CIDR.
- Optimizes performance and reduces network costs.

### Domain Registrar vs DNS Service
- **Registrar**: buys domain name.
- **DNS service**: manages DNS records.
- You can register elsewhere (e.g., GoDaddy) and use Route 53 as DNS.

---
