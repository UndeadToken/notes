# AWS CLI, SDK, IAM Roles & Policies

## EC2 Instance Metadata Service (IMDS)
- Allows EC2 instances to access information about themselves.
- URL: `http://169.254.169.254/latest/meta-data`
- Metadata = instance info; Userdata = launch script.
- Can retrieve IAM Role name, **cannot retrieve IAM policy**.

### IMDSv1 vs IMDSv2
- **IMDSv1:** Direct HTTP GET requests to metadata endpoint.
- **IMDSv2:** More secure, requires session token.
  1. Obtain session token:
  ```bash
  TOKEN=`curl -X PUT "http://169.254.169.254/latest/api/token" \
    -H "X-aws-ec2-metadata-token-ttl-seconds: 21600"`
  ```
  2. Use token to query metadata:
  ```bash
  curl http://169.254.169.254/latest/meta-data/profile \
    -H "X-aws-ec2-metadata-token: $TOKEN"
  ```

---

## AWS CLI
- Supports multiple profiles:
```bash
aws configure --profile my-other-aws
aws s3 ls --profile my-other-aws
```
- MFA support via temporary session:
```bash
aws sts get-session-token \
  --serial-number <arn-of-mfa-device> \
  --token-code <code-from-token> \
  --duration-seconds 3600
```

---

## AWS SDK
- Language-specific libraries to programmatically access AWS services.
- Supported SDKs:
  - Server: Python (boto3), Java, C#, Go, Node.js, PHP, C++
  - Mobile: Android, iOS
  - IoT: Embedded C, Arduino
- SDK handles API signing and retries automatically.

---

## API Rate Limits & Service Quotas
- Example limits:
  - `DescribeInstances` (EC2) — 100 calls/sec
  - `GetObject` (S3) — 5500 GET/sec per prefix
- **Exponential backoff** for intermittent throttling.
- Request service quota increase via AWS Console or Service Quotas API.

### Exponential Backoff Rules
- Retry on:
  - 5xx server errors
  - Throttling exceptions
- Do **not** retry on 4xx client errors.

---

## AWS Credentials & Provider Chain
Order AWS CLI/SDK checks for credentials:
1. Command-line options (`--region`, `--output`, `--profile`)
2. Environment variables (`AWS_ACCESS_KEY`, `AWS_SECRET_KEY`, `AWS_SESSION_TOKEN`)
3. CLI credentials file (`~/.aws/credentials`)
4. Container credentials (ECS, Fargate)
5. EC2 instance profile credentials

### Best Practices
- Never hard-code credentials.
- Prefer IAM Roles:
  - EC2 instances → Instance Role
  - ECS tasks → Task Role
  - Lambda → Lambda Role
- Outside AWS, use environment variables or named profiles.

---

## AWS Signature Version 4 (SigV4)
- Signs HTTP requests to AWS APIs using credentials.
- Steps:
  1. Create canonical request.
  2. Create string to sign.
  3. Calculate signature.
  4. Add signature to request.
- SDK and CLI handle signing automatically.
