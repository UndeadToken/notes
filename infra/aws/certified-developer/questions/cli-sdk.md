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
**Explanation:** AWS SDKs automatically sign requests with HMAC-SHA256 using your access keys (SigV4).

---

### 26. Which AWS CLI parameter filters output on the client side?
A. --filter
B. --query
C. --select
D. --output

**Answer:** B
**Explanation:** The `--query` parameter uses JMESPath to filter and format the output on the client side.

---

### 27. How do you specify a named profile in AWS CLI?
A. --profile profile-name
B. --user profile-name
C. --account profile-name
D. --config profile-name

**Answer:** A
**Explanation:** Use the `--profile` option to specify a named profile from the credentials/config file.

---

### 28. Which AWS SDK feature automatically handles exponential backoff?
A. Retries
B. Waiters
C. Pagination
D. Throttling

**Answer:** A
**Explanation:** AWS SDKs automatically implement exponential backoff and jitter for retries on throttle errors.

---

### 29. What is the default output format for AWS CLI?
A. text
B. table
C. json
D. yaml

**Answer:** C
**Explanation:** The default output format is `json` (unless configured otherwise in config file).

---

### 30. Which AWS CLI command generates a skeleton JSON for input?
A. --generate-cli-skeleton
B. --skeleton
C. --json-input
D. --dry-run

**Answer:** A
**Explanation:** `--generate-cli-skeleton` generates a JSON skeleton for the command's input parameters.

---

### 31. What is the purpose of AWS SDK Waiters?
A. Wait for response
B. Poll a resource until it reaches a desired state
C. Wait for user input
D. Wait for error

**Answer:** B
**Explanation:** Waiters automatically poll a resource (e.g., EC2 instance) until it reaches a specific state (e.g., running).

---

### 32. Which environment variable sets the default region for AWS CLI?
A. AWS_DEFAULT_REGION
B. AWS_REGION
C. REGION
D. AWS_Config_Region

**Answer:** A
**Explanation:** `AWS_DEFAULT_REGION` sets the default region for the AWS CLI.

---

### 33. How do you decode encoded authorization messages in CLI?
A. aws sts decode-authorization-message
B. aws iam decode-message
C. aws decode-message
D. aws sts decode

**Answer:** A
**Explanation:** Use `aws sts decode-authorization-message` to decode encoded error messages (requires DecodeAuthorizationMessage permission).

---

### 34. Which AWS CLI output format is best for scripting?
A. json
B. text
C. table
D. yaml

**Answer:** B
**Explanation:** `text` output is tab-delimited and works well with Unix tools like grep, awk, and sed.

---

### 35. What is the maximum number of items returned by default in CLI pagination?
A. 10
B. 50
C. 100
D. 1000 (service dependent)

**Answer:** D
**Explanation:** Services have default page sizes (often 50 or 1000), but CLI v2 handles pagination automatically to retrieve all items.

---

### 36. Which file stores AWS CLI credentials?
A. ~/.aws/config
B. ~/.aws/credentials
C. ~/.aws/secrets
D. ~/.aws/keys

**Answer:** B
**Explanation:** `~/.aws/credentials` stores access keys and secret keys. `~/.aws/config` stores configuration like region and output format.

---

### 37. How do you run an AWS CLI command in dry-run mode?
A. --dry-run
B. --test
C. --validate
D. --check

**Answer:** A
**Explanation:** Many EC2 commands support `--dry-run` to verify permissions and parameters without executing the action.

---

### 38. Which AWS SDK class allows customizing HTTP client settings?
A. ClientConfiguration (or similar per language)
B. HttpClient
C. ConnectionManager
D. RequestHandler

**Answer:** A
**Explanation:** ClientConfiguration (Java) or Config (JS/Python) allows customizing timeouts, proxies, and retry behavior.

---

### 39. What is the precedence of credentials in AWS CLI?
A. Environment vars > Command line > Config file
B. Command line > Environment vars > Credentials file > Config file > Instance profile
C. Config file > Environment vars > Command line
D. Instance profile > Command line

**Answer:** B
**Explanation:** Precedence: Command line options > Environment variables > Credentials file > Config file > Instance profile.

---

### 40. Which AWS CLI parameter enables debug logging?
A. --debug
B. --verbose
C. --log-level debug
D. --trace

**Answer:** A
**Explanation:** `--debug` prints detailed debug logs, including HTTP requests and responses.

---

### 41. How do you assume a role using AWS CLI?
A. aws sts assume-role
B. aws iam assume-role
C. aws role assume
D. aws switch-role

**Answer:** A
**Explanation:** `aws sts assume-role` returns temporary credentials for the assumed role.

---

### 42. Which JMESPath expression selects the first item in a list?
A. [0]
B. [1]
C. first()
D. head()

**Answer:** A
**Explanation:** `[0]` selects the first element of an array in JMESPath.

---

### 43. What is the purpose of `aws configure`?
A. Install CLI
B. Set up credentials, region, and output format
C. Update CLI
D. Configure service

**Answer:** B
**Explanation:** `aws configure` interactively sets up access key, secret key, region, and output format.

---

### 44. Which AWS SDK feature allows mocking services for testing?
A. Mocking Framework
B. Stubbing / Mocking support
C. TestClient
D. Simulation

**Answer:** B
**Explanation:** Most AWS SDKs provide ways to stub or mock service responses for unit testing (e.g., botocore stubs in Python).

---

### 45. How do you pass a binary file to a CLI parameter?
A. file://path/to/file
B. fileb://path/to/file
C. binary://path/to/file
D. @path/to/file

**Answer:** B
**Explanation:** Use `fileb://` prefix to pass binary data (like a zip file for Lambda) to a parameter.

---

### 46. Which AWS CLI command updates a CloudFormation stack?
A. aws cloudformation update-stack
B. aws cloudformation deploy
C. Both A and B
D. aws cloudformation apply

**Answer:** C
**Explanation:** `update-stack` updates directly; `deploy` is a higher-level command that handles change sets and updates.

---

### 47. What is the purpose of the `--no-sign-request` parameter?
A. Disable signing
B. Send anonymous request (for public buckets/objects)
C. Skip validation
D. Speed up request

**Answer:** B
**Explanation:** `--no-sign-request` sends the request without signing it, useful for accessing public S3 data anonymously.

---

### 48. Which AWS SDK feature handles large S3 uploads?
A. Multipart Upload
B. Transfer Manager / S3 Transfer Utility
C. Batch Upload
D. Bulk Upload

**Answer:** B
**Explanation:** Transfer Manager (Java) or S3 Transfer Utility (Python/JS) automatically handles multipart uploads for large files.

---

### 49. How do you specify a custom endpoint URL in AWS CLI?
A. --url
B. --endpoint-url
C. --host
D. --target

**Answer:** B
**Explanation:** `--endpoint-url` overrides the default service endpoint (useful for local testing like LocalStack).

---

### 50. What is the maximum size of a JSON parameter in CLI?
A. 4 KB
B. 32 KB
C. 128 KB
D. Shell limit

**Answer:** D
**Explanation:** The limit is determined by the operating system's maximum command line length (shell limit), not the CLI itself.

---

### 20. What is the best practice for AWS credentials in applications?
A. Hard-code in source code
B. Use IAM roles (EC2 instance profile, Lambda execution role)
C. Store in environment variables
D. Use root credentials

**Answer:** B
**Explanation:** Use IAM roles for AWS services. Never hard-code credentials.

---

### 21. What is the purpose of AWS CLI `--query` parameter?
A. Search AWS resources
B. Filter and format CLI output using JMESPath
C. Query databases
D. Search documentation

**Answer:** B
**Explanation:** `--query` uses JMESPath expressions to filter and transform CLI output.

---

### 22. Which AWS SDK feature waits for a resource to reach a desired state?
A. Polling
B. Waiters
C. Observers
D. Monitors

**Answer:** B
**Explanation:** Waiters poll resources until they reach a desired state (e.g., instance running, stack complete).

---

### 23. What is the recommended frequency for rotating AWS access keys?
A. Never
B. Every 30 days
C. Every 90 days
D. Every year

**Answer:** C
**Explanation:** AWS recommends rotating access keys every 90 days for security best practices.

---

### 24. Which AWS CLI v2 feature provides automatic pagination?
A. --max-items
B. --page-size
C. --no-paginate (to disable)
D. Enabled by default

**Answer:** D
**Explanation:** AWS CLI v2 automatically paginates results by default (use --no-paginate to disable).

---

### 25. What is the purpose of AWS SDK request signing?
A. Encrypt data
B. Authenticate requests using access keys
C. Compress data
D. Cache requests

**Answer:** B
**Explanation:** Request signing (SigV4) authenticates API requests using AWS access keys to verify identity and prevent tampering.
