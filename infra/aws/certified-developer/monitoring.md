# AWS Monitoring & Audit: CloudWatch, X-Ray, CloudTrail

## Overview

AWS provides multiple monitoring, troubleshooting, and auditing tools:

| Tool | Purpose |
|------|---------|
| CloudWatch | Metrics, logs, events, alarms, dashboards |
| X-Ray | Distributed tracing for microservices, performance analysis |
| CloudTrail | Auditing AWS API calls and resource changes |

---

## AWS CloudWatch

### Metrics
- Collect and track key metrics (CPU, disk, network)
- EC2 default: every 5 minutes; detailed: every 1 minute (paid)
- Custom metrics: push any metric using `PutMetricData` API
  - Dimensions: `InstanceID`, `EnvironmentName`
  - High-resolution: 1, 5, 10, or 30 seconds
- Example:
```bash
aws cloudwatch put-metric-data --namespace "UsageMetrics" --metric-data file://metric.json
```

### Logs
- Log Groups: application-level
- Log Streams: instances, containers, files
- Expiration: configurable (never–10 years)
- Sources: SDK, CloudWatch Agent, ECS, Lambda, VPC Flow Logs, API Gateway, Route53
- Destinations: S3, Kinesis, Lambda, OpenSearch

### Log Insights
- Query log data with custom query language
- Aggregates, filters, sorts, counts events
- Save queries to dashboards
- Can query across accounts and regions

### Log Exports & Subscriptions
- Export to S3 (CreateExportTask; up to 12 hours delay)
- Real-time: subscription filters to Kinesis Data Streams, Firehose, or Lambda
- Supports cross-account subscriptions

### Alarms
- Trigger actions based on metrics or metric filters
- States: `OK`, `INSUFFICIENT_DATA`, `ALARM`
- Actions:
  - Stop, terminate, reboot EC2
  - Trigger Auto Scaling
  - Notify SNS
- Composite alarms: combine multiple alarms with AND/OR logic

### EC2 Detailed Monitoring
- Improves scaling speed for Auto Scaling Groups
- Free Tier: 10 detailed metrics
- Memory metrics must be pushed as custom metrics via Unified CloudWatch Agent

### CloudWatch Synthetics Canary
- Scripted checks for APIs, URLs, websites
- Detect issues before customers
- Node.js or Python scripts
- Visual monitoring with screenshots
- Integration with CloudWatch Alarms

---

## AWS X-Ray

### Purpose
- Distributed tracing for microservices
- Performance analysis: latency, errors, bottlenecks
- Trace requests end-to-end across services

### Key Concepts
- **Trace:** end-to-end request
- **Segment:** per service/component
- **Subsegment:** detailed info within a segment
- **Annotations:** searchable key-value pairs
- **Metadata:** not searchable
- **Sampling:** controls number of traces to reduce costs

### Integration
- SDKs available for Java, Python, Node.js, Go, .NET
- Capture calls to AWS services, HTTP requests, databases, queues
- X-Ray Daemon: runs as sidecar or per instance
- Lambda: integrated automatically

### Troubleshooting
- Ensure proper IAM permissions
- EC2: run daemon
- Lambda: enable Active Tracing, attach `AWSX-RayWriteOnlyAccess`

### Advanced
- AWS Distro for OpenTelemetry: standardizes telemetry, can send traces to X-Ray, CloudWatch, Prometheus
- Auto-instrumentation with minimal code changes

---

## AWS CloudTrail

### Purpose
- Audit AWS API calls for compliance
- Detect unauthorized access or changes

### Event Types
- **Management Events:** configuration, resource creation/modification
- **Data Events:** high-volume object access (S3, Lambda invocations)
- **Insights Events:** detect unusual activity based on baseline patterns

### Features
- Default retention: 90 days
- Logs to S3 for long-term storage
- Integration with CloudWatch Logs and EventBridge
- Multi-region and multi-account support

---

## Amazon EventBridge

- Formerly CloudWatch Events
- Event-driven automation
- Sources: EC2 state changes, S3 uploads, CodeBuild failures, CloudTrail API calls
- Destinations: Lambda, SQS, SNS, ECS, Step Functions
- Supports cron/schedule and event patterns
- Multi-account aggregation with resource-based policies
- Schema registry: infer event structure and generate code

---

## Monitoring Comparison

| Feature | CloudWatch | X-Ray | CloudTrail |
|---------|-----------|-------|------------|
| Focus | Metrics, logs, alarms | Traces, performance, dependencies | API call auditing |
| Data | EC2, custom metrics, logs | Distributed requests | AWS API calls/events |
| Use | Monitoring, alerting | Troubleshooting, latency analysis | Security, compliance |

---

## Best Practices

- Enable **detailed monitoring** for EC2 with high-resolution metrics if scaling is critical
- Push **memory/disk metrics** using Unified CloudWatch Agent
- Use **Metric Filters + Alarms** to detect log events
- Enable **X-Ray tracing** for microservices and critical applications
- Use **CloudTrail + EventBridge** for security monitoring and automation
- Consider **AWS Distro for OpenTelemetry** to unify tracing and metrics across services
