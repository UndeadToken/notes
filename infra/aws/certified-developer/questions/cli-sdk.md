### 1. Which AWS CLI command configures credentials?
A. aws setup
B. aws configure
C. aws init
D. aws login

**Answer:** B
**Explanation:** `aws configure` sets up AWS CLI credentials (Access Key ID, Secret Access Key, region, output format).

---

### 2. Where are AWS CLI credentials stored by default?
A. ~/.aws/config
B. ~/.aws/credentials
C. /etc/aws/credentials
D. ~/.ssh/credentials

**Answer:** B
**Explanation:** Credentials are stored in ~/.aws/credentials file.

---

### 3. What is the AWS credentials provider chain order for EC2 instances?
A. Environment variables → Instance profile
B. Instance profile → Environment variables
C. Command-line options → Environment variables → Credentials file → Instance profile
D. Instance profile only

**Answer:** C
**Explanation:** Order: Command-line → Environment variables → Credentials file → Container credentials → Instance profile.

---

### 4. Which environment variable sets the AWS region?
A. AWS_REGION
B. AWS_DEFAULT_REGION
C. Both A and B
D. AWS_ZONE

**Answer:** C
**Explanation:** Both AWS_REGION and AWS_DEFAULT_REGION set the region.

---

### 5. What is the purpose of AWS CLI profiles?
A. User profiles
B. Manage multiple sets of credentials
C. Monitor usage
D. Encrypt credentials

**Answer:** B
**Explanation:** Profiles allow managing multiple credential sets for different accounts/roles.

---

### 6. Which AWS CLI option specifies a profile?
A. --profile
B. --account
C. --user
D. --credentials

**Answer:** A
**Explanation:** `--profile <name>` specifies which credential profile to use.

---

### 7. What is the purpose of AWS STS GetSessionToken?
A. Get permanent credentials
B. Get temporary credentials with MFA
C. Create new user
D. Rotate access keys

**Answer:** B
**Explanation:** GetSessionToken returns temporary credentials, often used with MFA.

---

### 8. Which AWS SDK retry strategy should be used for throttling errors?
A. No retry
B. Exponential backoff
C. Linear retry
D. Immediate retry

**Answer:** B
**Explanation:** Exponential backoff doubles wait time between retries for throttling (5xx) errors.

---

### 9. Which HTTP status code indicates throttling?
A. 400
B. 403
C. 429
D. 500

**Answer:** C
**Explanation:** HTTP 429 "Too Many Requests" indicates throttling.

---

### 10. Should you retry on 4xx client errors?
A. Yes, always
B. No, fix the request instead
C. Only for 429
D. Only for 403

**Answer:** B
**Explanation:** 4xx errors indicate client problems (except 429). Fix the request instead of retrying.

---

### 11. What is the EC2 Instance Metadata Service URL?
A. http://localhost/metadata
B. http://169.254.169.254/latest/meta-data
C. http://metadata.aws
D. http://ec2-metadata.internal

**Answer:** B
**Explanation:** Instance metadata is available at http://169.254.169.254/latest/meta-data.

---

### 12. Which IMDSv2 header is required to obtain a session token?
A. X-aws-ec2-metadata-token
B. X-aws-ec2-metadata-token-ttl-seconds
C. Authorization
D. X-Metadata-Token

**Answer:** B
**Explanation:** PUT request with X-aws-ec2-metadata-token-ttl-seconds header obtains session token.

---

### 13. Can you retrieve IAM policies from EC2 metadata?
A. Yes, always
B. No, only IAM role name
C. Yes, with IMDSv2
D. Only for root user

**Answer:** B
**Explanation:** Metadata provides IAM role name, not the actual policy.

---

### 14. What is AWS Signature Version 4 (SigV4)?
A. API version
B. Process to sign HTTP requests to AWS
C. Encryption algorithm
D. SDK version

**Answer:** B
**Explanation:** SigV4 signs HTTP requests using AWS credentials for authentication.

---

### 15. Which AWS service quota can be increased?
A. All quotas
B. Some quotas via AWS Console or API
C. No quotas can be increased
D. Only EC2 limits

**Answer:** B
**Explanation:** Many service quotas can be increased via Service Quotas console or API.

---

### 16. What is the default EC2 DescribeInstances API rate limit?
A. 10 calls/sec
B. 50 calls/sec
C. 100 calls/sec
D. 1000 calls/sec

**Answer:** C
**Explanation:** DescribeInstances allows 100 calls per second by default.

---

### 17. Which AWS CLI output format is easiest to parse programmatically?
A. json
B. text
C. table
D. yaml

**Answer:** A
**Explanation:** JSON output is easiest to parse programmatically with jq or scripts.

---

### 18. What is the purpose of AWS CLI pagination?
A. Format output
B. Handle large result sets by retrieving data in chunks
C. Encrypt data
D. Cache results

**Answer:** B
**Explanation:** Pagination retrieves large result sets in multiple API calls (--max-items, --starting-token).

---

### 19. Which AWS SDK feature automatically retries failed requests?
A. Auto-retry
B. Exponential backoff (built-in)
C. Manual retry
D. No retry

**Answer:** B
**Explanation:** AWS SDKs automatically retry failed requests with exponential backoff.

---

### 20. What is the best practice for AWS credentials in applications?
A. Hard-code in source code
B. Use IAM roles (EC2 instance profile, Lambda execution role)
C. Store in environment variables
D. Use root credentials

**Answer:** B
**Explanation:** Use IAM roles for AWS services. Never hard-code credentials.
