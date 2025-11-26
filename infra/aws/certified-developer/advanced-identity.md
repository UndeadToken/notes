Advanced Identity

STS - Security Token Service

- Allows granting limited and temporary access to AWS resources (up to 1 hour)
- AssumeRole: Assume roles within your account or cross-account
- AssumeRoleWithSAML: Return credentials for users logged in with SAML
- AssumeRoleWithWebIdentity:
    - Return creds for users logged in with an IdP (Facebook Login, Google Login, OIDC compatible)
    - AWS recommends using Cognito Identity Pools instead
- GetSessionToken: For MFA, from a user or AWS account root user
- GetFederationToken: Obtain temporary credentials for a federated user
- GetCallerIdentity: Return details about the IAM user or role used in the API call
- DecodeAuthorizationMessage: Decode error messages when an AWS API is denied

Using STS to Assume a Role

- Define an IAM Role within your account or cross-account
- Define which principals can access this IAM Role
- Use AWS STS (Security Token Service) to retrieve credentials and impersonate the IAM Role (AssumeRole API)
- Temporary credentials can be valid between 15 minutes and 1 hour

STS with MFA

- Use GetSessionToken from STS
- Appropriate IAM policy using IAM Conditions: aws:MultiFactorAuthPresent:true
- GetSessionToken returns:
    - Access Key ID
    - Secret Access Key
    - Session Token
    - Expiration Date

Advanced IAM

Authorization Model Evaluation of Policies (Simplified)

1. If there's an explicit DENY, end decision and DENY
2. If there's an ALLOW, end decision with ALLOW
3. Else DENY

Decision starts at DENY -> Evaluate all applicable policies -> Explicit DENY? -> DENY, else -> ALLOW? -> ALLOW

IAM Policies & S3 Bucket Policies

- IAM Policies are attached to users, roles, groups
- S3 Bucket Policies are attached to buckets
- Evaluation of access = IAM Policies + S3 Bucket Policies

Examples:

- IAM Role attached to EC2 allows RW to "my bucket" + no S3 bucket policy → EC2 can read/write
- IAM Role attached to EC2 allows RW + S3 bucket explicit DENY → EC2 cannot read/write
- IAM Role attached to EC2 allows nothing + S3 bucket explicit allow → EC2 can read/write
- IAM Role attached to EC2 explicit DENY + S3 bucket explicit allow → EC2 cannot read/write

Dynamic Policies with IAM

- Assign each user a /home/<user> folder in S3:

Option 1: One policy per user (not scalable)
Option 2: Dynamic policy with ${aws:username}

{
  "Sid": "AllowAllS3ActionsInUserFolder",
  "Action": ["s3:*"],
  "Effect": "Allow",
  "Resource": ["arn:aws:s3:::my-company/home/${aws:username}/*"]
}

Inline vs Managed Policies

- AWS Managed Policy: Maintained by AWS, updated automatically
- Customer Managed Policy: Reusable, version controlled, best practice
- Inline Policy: One-to-one relationship with principal, deleted with principal

Granting a User Permissions to Pass a Role to an AWS Service

- Some AWS services require passing an IAM role
- Example: EC2, Lambda, ECS, CodePipeline
- Requires iam:PassRole permission (often with iam:GetRole)
- Roles can only be passed to services allowed by the role’s trust policy

Directory Services

Microsoft Active Directory (AD)

- Found on Windows Server with AD Domain Services
- Stores User Accounts, Computers, Printers, File Shares, Security Groups
- Centralized security management
- Objects organized in trees; trees form a forest

AWS Directory Options:

- AWS Managed Microsoft AD: Fully managed, supports MFA, trust with on-prem AD
- AD Connector: Proxy to on-prem AD, supports MFA, users managed on-prem
- Simple AD: AD-compatible directory on AWS, cannot join on-prem AD

Auth Flows:

- On-prem AD → trust → AWS Managed AD → Auth
- On-prem AD → Proxy → AD Connector → Auth
- Simple AD → AWS-managed auth
