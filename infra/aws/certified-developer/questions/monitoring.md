### 1. Which CloudWatch metric is NOT available by default for EC2 instances?
A. CPUUtilization
B. NetworkIn
C. MemoryUtilization
D. DiskReadBytes

**Answer:** C
**Explanation:** Memory metrics must be pushed as custom metrics using the CloudWatch Agent.

---

### 2. What is the default metric resolution for EC2 instances?
A. 1 minute
B. 5 minutes
C. 10 minutes
D. 15 minutes

**Answer:** B
**Explanation:** Default (basic) monitoring provides metrics every 5 minutes. Detailed monitoring provides 1-minute metrics.

---

### 3. How long are CloudWatch Logs retained by default?
A. 7 days
B. 30 days
C. Never expire
D. 1 year

**Answer:** C
**Explanation:** CloudWatch Logs never expire by default (retention is configurable from 1 day to 10 years).

---

### 4. Which CloudWatch feature allows querying log data with a custom query language?
A. Log Streams
B. Log Insights
C. Log Filters
D. Log Analytics

**Answer:** B
**Explanation:** CloudWatch Logs Insights provides a query language for searching and analyzing log data.

---

### 5. A CloudWatch Alarm is in INSUFFICIENT_DATA state. What does this mean?
A. Alarm threshold breached
B. Not enough data points to evaluate
C. Alarm is disabled
D. Metric does not exist

**Answer:** B
**Explanation:** INSUFFICIENT_DATA means there aren't enough data points to determine the alarm state.

---

### 6. Which X-Ray concept represents a single service or component in a trace?
A. Trace
B. Segment
C. Subsegment
D. Annotation

**Answer:** B
**Explanation:** A Segment represents work done by a single service/component in the trace.

---

### 7. What is the purpose of X-Ray annotations?
A. Add non-searchable metadata
B. Add searchable key-value pairs for filtering
C. Configure sampling rules
D. Enable tracing

**Answer:** B
**Explanation:** Annotations are indexed key-value pairs that can be used to filter and search traces.

---

### 8. Which service audits AWS API calls for compliance?
A. CloudWatch
B. X-Ray
C. CloudTrail
D. Config

**Answer:** C
**Explanation:** CloudTrail logs all AWS API calls for auditing and compliance.

---

### 9. What is the default retention period for CloudTrail events?
A. 7 days
B. 30 days
C. 90 days
D. 1 year

**Answer:** C
**Explanation:** CloudTrail retains events for 90 days by default. Export to S3 for longer retention.

---

### 10. Which CloudTrail event type captures S3 object-level operations?
A. Management Events
B. Data Events
C. Insights Events
D. System Events

**Answer:** B
**Explanation:** Data Events capture high-volume operations like S3 GetObject, PutObject, and Lambda invocations.

---

### 11. A Lambda function needs distributed tracing. What must be enabled?
A. CloudWatch Logs
B. X-Ray Active Tracing
C. CloudTrail
D. VPC Flow Logs

**Answer:** B
**Explanation:** Enable Active Tracing in Lambda configuration and attach AWSXRayWriteOnlyAccess policy.

---

### 12. Which CloudWatch feature detects unusual API activity automatically?
A. CloudWatch Alarms
B. CloudWatch Insights
C. CloudTrail Insights
D. X-Ray Analytics

**Answer:** C
**Explanation:** CloudTrail Insights detects unusual activity by analyzing CloudTrail management events.

---

### 13. What is the maximum resolution for custom CloudWatch metrics?
A. 1 second
B. 5 seconds
C. 10 seconds
D. 1 minute

**Answer:** A
**Explanation:** High-resolution custom metrics support 1-second resolution.

---

### 14. Which API publishes custom metrics to CloudWatch?
A. PutMetricData
B. PublishMetric
C. SendMetric
D. CreateMetric

**Answer:** A
**Explanation:** PutMetricData API publishes custom metric data to CloudWatch.

---

### 15. A CloudWatch Alarm should trigger when CPU > 80% for 3 consecutive periods. What is this called?
A. Threshold
B. Evaluation Period
C. Datapoints to Alarm
D. Statistic

**Answer:** C
**Explanation:** Datapoints to Alarm specifies how many evaluation periods must breach the threshold.

---

### 16. Which service aggregates events from multiple AWS accounts?
A. CloudWatch Events
B. EventBridge
C. CloudTrail
D. Config

**Answer:** B
**Explanation:** EventBridge supports cross-account event aggregation with resource-based policies.

---

### 17. What is the purpose of CloudWatch Synthetics Canary?
A. Monitor EC2 instances
B. Test APIs and websites proactively
C. Analyze logs
D. Trace distributed applications

**Answer:** B
**Explanation:** Synthetics Canary runs scripted tests (Node.js/Python) to monitor endpoints and detect issues.

---

### 18. Which X-Ray feature controls the number of requests traced to reduce costs?
A. Filtering
B. Sampling
C. Throttling
D. Batching

**Answer:** B
**Explanation:** Sampling rules control what percentage of requests are traced.

---

### 19. A CloudWatch Log Group needs to trigger a Lambda function on specific log patterns. What is required?
A. Metric Filter
B. Subscription Filter
C. Log Insights Query
D. Log Stream

**Answer:** B
**Explanation:** Subscription Filters send log events to Lambda, Kinesis, or Firehose in real-time.

---

### 20. Which CloudWatch metric measures API Gateway backend latency only?
A. Latency
B. IntegrationLatency
C. Duration
D. ResponseTime

**Answer:** B
**Explanation:** IntegrationLatency measures only backend integration time, excluding API Gateway processing.

---

### 21. What is CloudWatch Contributor Insights used for?
A. Analyzing log data
B. Identifying top contributors to system behavior (top talkers)
C. Creating custom metrics
D. Monitoring API calls

**Answer:** B
**Explanation:** Contributor Insights analyzes log data to find top contributors (e.g., top IPs, URLs, user agents).

---

### 22. Which CloudWatch feature performs mathematical operations on metrics?
A. Metric Filters
B. Metric Math
C. Metric Aggregation
D. Metric Transformation

**Answer:** B
**Explanation:** Metric Math allows performing mathematical operations (SUM, AVG, MAX, etc.) on multiple metrics.

---

### 23. What is a CloudWatch Composite Alarm?
A. An alarm that monitors multiple metrics
B. An alarm based on the state of other alarms using AND/OR logic
C. An alarm with multiple thresholds
D. An alarm that triggers multiple actions

**Answer:** B
**Explanation:** Composite Alarms combine multiple alarms using AND/OR logic to reduce alarm noise.

---

### 24. Which EventBridge feature automatically discovers event schemas?
A. Event Bus
B. Schema Registry
C. Event Archive
D. Event Replay

**Answer:** B
**Explanation:** Schema Registry automatically discovers and stores event schemas from EventBridge events.

---

### 25. What is CloudWatch RUM (Real User Monitoring) used for?
A. Monitoring backend services
B. Collecting client-side performance data from web applications
C. Analyzing log files
D. Tracing distributed applications

**Answer:** B
**Explanation:** CloudWatch RUM collects client-side performance metrics (page load, errors, user sessions) from real users.

---

### 26. What is the maximum retention period for CloudWatch Logs?
A. 1 year
B. 5 years
C. 10 years
D. Indefinite

**Answer:** D
**Explanation:** CloudWatch Logs can be retained indefinitely or set to expire from 1 day to 10 years.

---

### 27. Which CloudWatch feature aggregates metrics across accounts and regions?
A. CloudWatch Dashboards
B. CloudWatch Cross-Account Observability
C. CloudWatch Insights
D. CloudWatch Synthetics

**Answer:** B
**Explanation:** Cross-Account Observability enables monitoring and troubleshooting across multiple accounts and regions.

---

### 28. What is the maximum number of dimensions per CloudWatch metric?
A. 5
B. 10
C. 20
D. 30

**Answer:** D
**Explanation:** CloudWatch metrics support up to 30 dimensions.

---

### 29. Which X-Ray feature shows service dependencies?
A. Traces
B. Service Map
C. Segments
D. Annotations

**Answer:** B
**Explanation:** Service Map visualizes service dependencies and performance characteristics.

---

### 30. What is the purpose of CloudWatch Logs Insights?
A. Analyze logs
B. Query and analyze log data using SQL-like syntax
C. Store logs
D. Export logs

**Answer:** B
**Explanation:** Logs Insights provides interactive log analytics with a purpose-built query language.

---

### 31. Which CloudWatch alarm state indicates insufficient data?
A. OK
B. ALARM
C. INSUFFICIENT_DATA
D. PENDING

**Answer:** C
**Explanation:** INSUFFICIENT_DATA state occurs when the alarm doesn't have enough data to evaluate.

---

### 32. What is the maximum number of metrics per CloudWatch dashboard?
A. 50
B. 100
C. 500
D. 2,500

**Answer:** C
**Explanation:** CloudWatch dashboards support up to 500 metrics per dashboard.

---

### 33. Which X-Ray sampling strategy reduces tracing costs?
A. Sample all requests
B. Reservoir and rate-based sampling
C. Random sampling
D. No sampling

**Answer:** B
**Explanation:** X-Ray uses reservoir (first N requests per second) and rate-based sampling to reduce costs while maintaining visibility.

---

### 34. What is the purpose of CloudWatch Anomaly Detection?
A. Detect anomalies
B. Automatically detect unusual metric patterns using ML
C. Monitor errors
D. Alert on failures

**Answer:** B
**Explanation:** Anomaly Detection uses machine learning to detect unusual metric patterns and create dynamic thresholds.

---

### 35. Which CloudWatch Logs feature encrypts log data?
A. KMS encryption
B. SSL/TLS
C. Log Groups encryption
D. All of the above

**Answer:** A
**Explanation:** CloudWatch Logs uses KMS to encrypt log data at rest.

---

### 36. What is the maximum retention for X-Ray trace data?
A. 7 days
B. 30 days
C. 90 days
D. 1 year

**Answer:** B
**Explanation:** X-Ray stores trace data for 30 days.

---

### 37. Which CloudWatch feature tests API endpoints from multiple locations?
A. CloudWatch Synthetics (Canaries)
B. CloudWatch RUM
C. CloudWatch Insights
D. CloudWatch Alarms

**Answer:** A
**Explanation:** CloudWatch Synthetics Canaries run scripts to test endpoints, APIs, and user flows from multiple locations.

---

### 38. What is the purpose of CloudWatch Embedded Metric Format (EMF)?
A. Format metrics
B. Embed custom metrics in structured log events
C. Export metrics
D. Compress metrics

**Answer:** B
**Explanation:** EMF allows embedding custom metrics in structured JSON log events for automatic extraction.

---

### 39. Which X-Ray annotation type is indexed for filtering?
A. Metadata
B. Annotations
C. Segments
D. Subsegments

**Answer:** B
**Explanation:** Annotations are key-value pairs indexed for filtering traces. Metadata is not indexed.

---

### 40. What is the maximum size of a CloudWatch Logs event?
A. 64 KB
B. 256 KB
C. 1 MB
D. 10 MB

**Answer:** B
**Explanation:** Maximum log event size is 256 KB.

---

### 41. Which CloudWatch metric statistic represents the count of data points?
A. Sum
B. Average
C. SampleCount
D. Maximum

**Answer:** C
**Explanation:** SampleCount represents the number of data points used for the statistic calculation.

---

### 42. What is the purpose of EventBridge Archive?
A. Archive events
B. Store events for replay and debugging
C. Compress events
D. Delete old events

**Answer:** B
**Explanation:** EventBridge Archive stores events for later replay, useful for debugging and testing.

---

### 43. Which CloudWatch feature provides automated responses to alarms?
A. CloudWatch Actions
B. CloudWatch Alarms with SNS/Lambda/Auto Scaling actions
C. CloudWatch Automation
D. CloudWatch Workflows

**Answer:** B
**Explanation:** CloudWatch Alarms can trigger SNS notifications, Lambda functions, Auto Scaling actions, and EC2 actions.

---

### 44. What is the maximum number of CloudWatch Logs subscriptions per log group?
A. 1
B. 2
C. 5
D. 10

**Answer:** B
**Explanation:** Each log group supports up to 2 subscription filters.

---

### 45. Which X-Ray feature groups traces by HTTP status code?
A. Service Map
B. Trace Groups
C. Filter Expressions
D. Segments

**Answer:** C
**Explanation:** Filter Expressions allow grouping and filtering traces by various attributes including HTTP status codes.

---

### 46. What is the purpose of CloudWatch Contributor Insights?
A. Analyze contributors
B. Identify top contributors to metrics (top talkers)
C. Monitor contributions
D. Track changes

**Answer:** B
**Explanation:** Contributor Insights analyzes log data to identify top contributors (e.g., top IP addresses, URLs, users).

---

### 47. Which CloudWatch Logs feature streams logs to other services?
A. Log Export
B. Subscription Filters
C. Log Forwarding
D. Log Streaming

**Answer:** B
**Explanation:** Subscription Filters stream log data to Lambda, Kinesis Data Streams, or Kinesis Data Firehose in real-time.

---

### 48. What is the maximum number of EventBridge rules per event bus?
A. 100
B. 300
C. 500
D. 1,000

**Answer:** B
**Explanation:** Each event bus supports up to 300 rules (soft limit).

---

### 49. Which X-Ray SDK feature automatically captures AWS SDK calls?
A. Auto-instrumentation
B. AWS X-Ray SDK middleware
C. Service plugins
D. Subsegments

**Answer:** B
**Explanation:** X-Ray SDK middleware automatically captures AWS SDK calls, HTTP requests, and SQL queries.

---

### 50. What is the purpose of CloudWatch Metric Streams?
A. Stream metrics
B. Continuously stream CloudWatch metrics to destinations like S3 or third-party services
C. Monitor streams
D. Create metrics

**Answer:** B
**Explanation:** Metric Streams continuously stream CloudWatch metrics to S3, Kinesis Data Firehose, or third-party services for analysis.

