# AWS Serverless – Lambda Notes

---

## **1. Serverless Overview**
- Serverless: Developers deploy **code/functions** without managing infrastructure.
- Initially meant **FaaS (Function as a Service)**.
- Pioneered by **AWS Lambda**; now includes managed databases, messaging, storage.
- **Not “no servers”**: Servers exist but are fully managed.

---

## **2. AWS Serverless Services**
- **Compute**: AWS Lambda, Fargate
- **Database**: DynamoDB, Aurora Serverless
- **Identity & Auth**: AWS Cognito
- **API**: API Gateway
- **Storage**: Amazon S3
- **Messaging**: SNS, SQS, Kinesis Data Firehose
- **Workflow**: Step Functions

- **Key characteristics**:
  - Functions run on-demand
  - Limited execution time
  - Automated scaling
  - Easy pricing: pay per request & compute time
    - Free tier: 1M requests, 400,000 GB-s compute
  - Integrated with AWS services and programming languages
  - Monitoring via CloudWatch
  - RAM up to 10GB → increases CPU/network

---

## **3. Lambda Invocation Types**

### **Synchronous**
- Triggered via CLI, SDK, API Gateway, ALB
- Results returned immediately
- Error handling must be managed client-side
- **Flow examples**:
  - CLI/SDK → Lambda → Response
  - Client → API Gateway → Lambda → Response

### **Asynchronous**
- Triggered by S3, SNS, CloudWatch Events, EventBridge
- Lambda queues events, retries on errors (3 attempts by default)
- DLQ (SQS/SNS) for failed events
- Processing must be **idempotent**

---

## **4. Event Sources**
- **S3 Event Notifications**: ObjectCreated, ObjectRemoved, ObjectRestore
- **Streams & Polling**: Kinesis, DynamoDB Streams, SQS FIFO/Standard
- Event Source Mapping: Polls data, invokes Lambda in batches
- Error handling:
  - Retry, discard, split batch
  - Use destinations or DLQs for failures

---

## **5. Lambda Execution**
- **Event Object**: Input data from the triggering service
- **Context Object**: Provides metadata (aws_request_id, function_name, memory)
- **Execution role**: IAM role granting permissions to AWS services
- **Resource-based policies**: Grant cross-account/service access
- **Environment variables**: Key/value pairs, KMS encrypted secrets
- **Logging & monitoring**: CloudWatch Logs & Metrics
- **Tracing**: AWS X-Ray for performance monitoring

---

## **6. Lambda Runtime & Environment**
- `/tmp` directory: 10GB temp storage persists across invocations
- Execution context can be reused for multiple invocations
- **Layers**: Share dependencies across functions (5 layers, 250MB each)
- **File systems**: Mount EFS in VPC if needed

---

## **7. Lambda Performance & Scaling**
- RAM: 128MB–10GB → CPU scales with RAM
- Timeout: 3s default, max 900s (15 mins)
- Concurrency: 1000 default, can be reserved or increased
- Cold Starts: First invocation of a new instance
- Provisioned Concurrency: Pre-allocated for low-latency

---

## **8. Networking**
- Default: AWS-managed VPC (cannot access your VPC resources)
- Custom VPC: Specify subnets, security groups → creates ENI
- Public subnet ≠ Internet access; use NAT gateway or VPC endpoints

---

## **9. Deployment Options**
- **Inline**: Simple code snippets in CloudFormation
- **S3**: Reference Lambda zip in CloudFormation
- **Container Images**: Up to 10GB, from ECR, must implement Lambda Runtime API
- **Versions & Aliases**:
  - Versions are immutable; Aliases point to versions
  - Canary, Linear, AllAtOnce deployments via CodeDeploy
- **Function URLs**: Dedicated HTTPS endpoints
  - AuthType: NONE (public) or AWS_IAM (authenticated)

---

## **10. Edge Computing**
- **CloudFront Functions**: Lightweight JS for CDN customisation (ms-scale latency)
- **Lambda@Edge**: NodeJS/Python functions at CloudFront locations
  - Viewer Request, Origin Request/Response, Viewer Response
  - Longer execution, network & filesystem access

---

## **11. Best Practices**
- Initialise SDKs, DB connections, dependencies outside handler
- Minimise deployment size; use Layers for dependencies
- Avoid recursive Lambda calls
- Encrypt secrets with KMS
- Use environment variables for config

---

## **12. References**
- [AWS Lambda Pricing](https://aws.amazon.com/lambda/pricing)
- [AWS Lambda Developer Guide](https://docs.aws.amazon.com/lambda)
- [Lambda Container Images](https://docs.aws.amazon.com/lambda/latest/dg/images-create.html)
- [CloudFront Functions](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/Introduction.html)
- [Lambda@Edge](https://docs.aws.amazon.com/AmazonCloudFront/latest/DeveloperGuide/lambda-at-the-edge.html)
