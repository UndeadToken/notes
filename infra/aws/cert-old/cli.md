AWS CLI, SDK, IAM Roles & Policies

- AWS EC2 Instance Metadata (IMDS) is powerful but one of the least
known features to developers

- It allows AWS EC2 instance to “learn about themselves” without using
an IAM Role for that purpose

- The URL is http//169.254.169.254/latest/meta-data

- You an retrieve the IAM Role name from the metadata, but you
CANNOT retrieve the IAM Policy

- Metadata = Info about the EC2 instance

- Userdata = launch script of the EC2 instance

IMDSv2 vs IMDSv1
Instance Metadata Service
–
IMDSV1 is accessing http://168.254.169.254/latest/meta-data
–
IMDSv2 is more secure and is done in two steps:
–
1.) Get Session Token (limited validity) — using headers & PUT
TOKEN=`curl -X PUT “http://169.254.169.254/latest/api/token” -H “X-aws-ec2-
metadata-token-ttl-seconds: 21600”`
- 2.) Use Session Token in IMDSv2 calls — using headers
curl http://169.254.169.254/latest/meta-data/profile -H “X-aws-ec2-metadata-
token: $TOKEN”
Working with multiple users:
aws configure —profile my-other-aws
aws s3 ls —profile my-other-aws
MFA with CLI
–
–
To use MFA with the CLI, you must create a temporary session
To do so, you must run the STS GetSessionToken API call
aws sts get-session-token —serial-number <arn-of-the-mfa-device> —token-
code <code-from-token> —duration-seconds 3600
aws sts get-session-token help
AWS SDK
If you don’t specify or configure a default region, then us-east-1 will be chosen
by default
–
–
–
–
–
–
–
AWS Software Development Kit (AWS SDK)
Language-specific API’s (Set of libraries)
Enables you to access and manage AWS services programmatically
Embedded within your application
Supports
–
SDKs (Javascript; Python, PHP, .NET, Java, Go, Node.js, C++)
–
Mobile Device SDKs (Android, iOS, …)
–
IoT Device SDKs (Embedded C, Arduino, …)
We have to use the AWS SDK when coding against AWS services such
as DynamoDB
The AWS CLI uses the Python SDK (boto3)
AWS Limits (Quotas)
API Rate Limits
–
–
–
–
–
–
–
DescribeInstances API for EC2 has a limit of 100 calls per second
GetObject on S3 has a limit of 5500 GET per second per prefix
For intermittent Errors: Implement Exponential Backoff
For Consistent Errors: request an API throttling limit increase
Service Quotas (Service Limits)
Running On-Demand Standard Instances 1 152 vCPU
You can request a service limit increase by opening a ticket
You can request a service quota increase by using the Service Quotas
API
Exponential Back (any AWS service)
If you get ThrottlingException intermittently, use exponential backoff
Retry mechanism already included in AWS SDK API calls
Must implement yourself if using the AWS API as-is or in specific
cases
–
–
Must only implement the retries on 5xx server errors and throttling
Do not implement on the 400 client errors
AWS Credentials Provider & Chain
–
–
–
The CLI will look for credentials in this order:
–
Command line options — —region, —output, and —profile
–
–
–
–
Environment variables — AWS
ACCESS
_
_KEY, AWS_
SECRET
_KEY,
and AWS
SESSION
TOKEN
_
_
CLI credentials file — aws configure ~/.aws/credentials
Container Credentials — for EC2 tasks
Instance profile credentials — for EC2 Instance Profiles
AWS Credentials Best Practices
–
–
–
–
Never store aws credentials in your code
Best practice is for credentials to be inherited from the credentials
chain
If using working within AWS, use IAM Roles
–
=> EC2 Instance Roles for EC2 instances
–
=> EC2 Roles for ECS tasks
–
=> Lambda Roles for Lambda Functions
If working outside of AWS, use environment variables / named
profiles
AWS Signature v4 Signing (Sigv4)
–
–
–
–
When you call the AWS HTTP API, you sign the request s that AWS
can identify you, using your AWS credentials (access key & secret
key)
Note: some requests to Amazon S3 don’t need to be signed
If you use the SDK or CLI, the HTTP requests are signed for you
You should sign an AWS HTTP request using Signature v4 (SigV4)
1.) Create canonical request
2.) Create string to sign
3.) Calculate signature
4.) Add signature to request
