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
