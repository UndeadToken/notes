# Amazon CloudFront Overview

## What is CloudFront
- Content Delivery Network (CDN) for distributing content globally
- Caches content at edge locations (216 globally)
- Improves read performance and user experience
- Provides DDoS protection via AWS Shield integration
- Works with AWS WAF for application security

---

## CloudFront Origins
- **S3 Bucket**
  - Cache and distribute files
  - Use CloudFront Origin Access Control (OAC) for security
  - Can act as ingress for uploads
- **Custom Origins**
  - Application Load Balancer, EC2 instance, S3 website, or any HTTP backend

### CloudFront vs S3 Cross-Region Replication
| Feature | CloudFront | S3 CRR |
|---------|------------|--------|
| Network | Global edge | Per region |
| Update speed | Cached TTL | Near real-time |
| Use case | Static content | Dynamic content, low-latency regional access |

---

## Caching
- Each edge location caches content
- **Cache Key:** unique identifier for each object (default: hostname + URL path)
- Can include HTTP headers, cookies, query strings
- Maximize cache hit ratio to reduce origin requests
- Use **CreateInvalidation API** to refresh cache manually

### Cache Policies
- Control caching by HTTP headers, cookies, query strings
- Set TTL (0s – 1 year)
- Options: None, Whitelist, Include All-Except, All
- Predefined or custom policies

### Origin Request Policies
- Values sent to origin but not included in cache key
- Includes headers, cookies, query strings
- Add custom headers for origin requests

---

## Cache Behaviours
- Define settings for URL path patterns:
  - `/images/*`, `/api/*`, `/*` (default)
- Direct traffic to different origins or origin groups
- Default behavior processed last

---

## Access Control
- **Geo Restriction**
  - Allowlist or Blocklist based on country
- **Signed URLs / Signed Cookies**
  - Control access to paid or private content
  - Policies include expiration, IP ranges, trusted signers
  - Signed URL: single file
  - Signed Cookies: multiple files

### Signed URL vs S3 Pre-Signed URL
| Feature | CloudFront Signed URL | S3 Pre-Signed URL |
|---------|--------------------|-----------------|
| Scope | Path / distribution | Single S3 object |
| Key Management | Account-level key group | IAM principle key |
| Cache | Leverages CDN caching | Direct S3 access |

---

## High Availability & Failover
- **Origin Groups:** primary + secondary origin for failover
- **Field Level Encryption:** encrypt sensitive fields in POST requests using public key

---

## Real-Time Logs
- Sends request data to Kinesis Data Streams
- Allows monitoring, analysis, and operational actions
- Configurable sampling rate and fields per cache behaviour

---

## Pricing
- Varies by edge location
- Reduce costs by limiting price class:
  - Price Class All — all regions
  - Price Class 200 — excludes expensive regions
  - Price Class 100 — cheapest regions

---

## Summary
- Global CDN with caching and security features
- Supports S3 and custom origins
- Cache policies and origin request policies for fine-grained control
- Signed URLs / Cookies for secure content distribution
- Real-time logging for analytics and monitoring
- Price classes and origin groups help optimize cost and availability
