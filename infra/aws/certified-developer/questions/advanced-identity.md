### 1. Which AWS STS API should you use to grant temporary credentials to a user authenticated through an external OpenID Connect (OIDC) identity provider?
A. AssumeRoleWithSAML
B. GetSessionToken
C. AssumeRoleWithWebIdentity
D. GetFederationToken

**Answer:** C
**Explanation:** `AssumeRoleWithWebIdentity` returns temporary security credentials for users who have been authenticated in a mobile or web application with a web identity provider.

---

### 2. You have an IAM Role that allows read/write to an S3 bucket. The S3 bucket has an explicit deny for write actions for the same role. What is the outcome when the role tries to write to the bucket?
A. Write succeeds
B. Write fails due to explicit deny
C. Write succeeds if the IAM policy allows it
D. Write fails unless the bucket policy is removed

**Answer:** B
**Explanation:** In AWS IAM policy evaluation logic, an explicit DENY always overrides an ALLOW.

---

### 3. Which STS API returns the current IAM user or role identity making the API call?
A. GetCallerIdentity
B. GetSessionToken
C. AssumeRole
D. DecodeAuthorizationMessage

**Answer:** A
**Explanation:** `GetCallerIdentity` returns details about the IAM user or role whose credentials are used to call the operation.

---

### 4. You want to enforce MFA for temporary credentials using AWS STS. Which API and IAM condition combination is required?
A. GetSessionToken + aws:MultiFactorAuthPresent:true
B. AssumeRole + aws:MultiFactorAuthPresent:true
C. GetFederationToken + aws:MultiFactorAuthRequired:true
D. AssumeRoleWithWebIdentity + aws:MultiFactorAuthPresent:true

**Answer:** A
**Explanation:** `GetSessionToken` is the only STS API that supports MFA directly for IAM users to obtain temporary credentials with MFA status.

---

### 5. Which of the following statements about IAM policy evaluation is correct?
A. ALLOW always overrides DENY
B. DENY always overrides ALLOW
C. IAM ignores explicit denies if the user has ALLOW in any policy
D. Policies are evaluated in alphabetical order

**Answer:** B
**Explanation:** An explicit DENY in any policy (Identity-based, Resource-based, SCP, etc.) always overrides any ALLOW.

---

### 6. You want to create a dynamic S3 bucket policy allowing each user access only to their personal folder. Which variable can be used in the policy to refer to the current IAM username?
A. ${aws:userid}
B. ${aws:username}
C. ${s3:userid}
D. ${s3:username}

**Answer:** B
**Explanation:** `${aws:username}` resolves to the friendly name of the current IAM user, allowing dynamic policy construction.

---

### 7. Which type of IAM policy is deleted automatically when the principal it is attached to is deleted?
A. Customer Managed Policy
B. AWS Managed Policy
C. Inline Policy
D. Service Control Policy

**Answer:** C
**Explanation:** Inline policies are embedded directly in a single principal (user, group, or role) and are deleted when the principal is deleted.

---

### 8. Which permission is required by the user creating a Lambda function to assign an execution role to it?
A. s3:PutObject
B. iam:PassRole
C. lambda:InvokeFunction
D. sts:AssumeRole

**Answer:** B
**Explanation:** The `iam:PassRole` permission allows a user to pass an IAM role to an AWS service (like Lambda or EC2) so the service can assume it.

---

### 9. Which AWS Directory Service option allows users to authenticate using an on-premises Active Directory without storing passwords in AWS?
A. Simple AD
B. AD Connector
C. AWS Managed Microsoft AD
D. AWS Cloud Directory

**Answer:** B
**Explanation:** AD Connector is a proxy that redirects directory requests to your on-premises Microsoft Active Directory without caching information in the cloud.

---

### 10. What is the default maximum duration for temporary credentials issued via AssumeRole?
A. 15 minutes
B. 1 hour
C. 12 hours
D. 36 hours

**Answer:** B
**Explanation:** The default duration for `AssumeRole` is 1 hour. It can be configured up to 12 hours, but 1 hour is the default.

---

### 11. You decode an AWS API authorization error using STS. Which API provides the ability to convert encoded error messages into readable form?
A. DecodeAuthorizationMessage
B. GetCallerIdentity
C. GetSessionToken
D. GetFederationToken

**Answer:** A
**Explanation:** `DecodeAuthorizationMessage` decodes additional information about the authorization status of a request from an encoded message.

---

### 12. Which STS API would you use to obtain temporary credentials for a federated user authenticated via a custom identity broker?
A. AssumeRole
B. GetFederationToken
C. GetSessionToken
D. AssumeRoleWithWebIdentity

**Answer:** B
**Explanation:** `GetFederationToken` is typically used by a custom identity broker application to issue temporary credentials to federated users.

---

### 13. Which of the following is TRUE regarding AWS Managed Policies?
A. They are deleted automatically when the attached user is deleted
B. They are maintained and updated automatically by AWS
C. They can only be attached to a single user
D. They cannot be reused across accounts

**Answer:** B
**Explanation:** AWS Managed Policies are standalone policies created and administered by AWS, designed for common use cases.

---

### 14. If an IAM Role attached to an EC2 instance has no permissions, but the S3 bucket has an explicit allow for that role, what happens when the EC2 instance tries to read from the bucket (same account)?
A. Access is allowed
B. Access is denied
C. Access depends on AWS region
D. Access requires temporary credentials

**Answer:** A
**Explanation:** In the same account, an explicit ALLOW in either the identity-based policy OR the resource-based policy (Bucket Policy) is sufficient for access (unless there is an explicit DENY).

---

### 15. Which authentication flow correctly represents a user on an on-prem AD accessing AWS resources via AWS Managed AD?
A. On-prem AD → AD Connector → Auth
B. On-prem AD → trust → AWS Managed AD → Auth
C. Simple AD → Proxy → AWS Managed AD → Auth
D. On-prem AD → Simple AD → Auth

**Answer:** B
**Explanation:** AWS Managed Microsoft AD supports trust relationships with on-premises Active Directory, allowing on-prem users to access AWS resources.

---

### 16. What is the purpose of STS session tags?
A. Tag resources
B. Pass attributes during role assumption for ABAC (Attribute-Based Access Control)
C. Monitor sessions
D. Encrypt session data

**Answer:** B
**Explanation:** Session tags allow you to pass attributes (key-value pairs) when assuming a role, which can be used in policies for Attribute-Based Access Control (ABAC).

---

### 17. Which STS API is used for SAML 2.0 federation?
A. AssumeRoleWithWebIdentity
B. AssumeRoleWithSAML
C. GetFederationToken
D. AssumeRole

**Answer:** B
**Explanation:** `AssumeRoleWithSAML` returns temporary credentials for users authenticated via a SAML 2.0 compatible identity provider.

---

### 18. What is Attribute-Based Access Control (ABAC) in IAM?
A. Access based on user attributes
B. Access control using tags on principals and resources
C. Access based on IP address
D. Access based on time of day

**Answer:** B
**Explanation:** ABAC defines permissions based on attributes (tags) attached to users, roles, and resources, allowing permissions to scale automatically.

---

### 19. Which AWS Organizations feature restricts permissions across all accounts?
A. IAM Policies
B. Service Control Policies (SCPs)
C. Resource Policies
D. Permission Boundaries

**Answer:** B
**Explanation:** Service Control Policies (SCPs) specify the maximum permissions for member accounts in an organization.

---

### 20. What is IAM Access Analyzer used for?
A. Analyze costs
B. Identify resources shared with external entities
C. Monitor API calls
D. Encrypt data

**Answer:** B
**Explanation:** IAM Access Analyzer helps identify resources in your organization and account, such as S3 buckets or IAM roles, that are shared with an external entity.

---

### 21. Which IAM policy element is required for cross-account role assumption?
A. Principal in trust policy
B. Resource in IAM policy
C. Condition in bucket policy
D. Effect: Allow

**Answer:** A
**Explanation:** The Trust Policy of the role must explicitly allow the Principal (account or user) from the other account to assume the role.

---

### 22. What is the purpose of session policies in STS?
A. Encrypt sessions
B. Further restrict permissions during role assumption
C. Monitor sessions
D. Extend session duration

**Answer:** B
**Explanation:** Session policies are advanced policies passed during role assumption to further restrict (intersect) the permissions of the assumed role for that session.

---

### 23. What is the purpose of External ID in cross-account role assumption?
A. Encrypt data
B. Prevent confused deputy problem
C. Monitor access
D. Rotate credentials

**Answer:** B
**Explanation:** External ID is a condition used in the trust policy to prevent the "confused deputy" problem when a third party assumes a role in your account.

---

### 24. Which IAM policy variable references the source IP address?
A. ${aws:SourceIp}
B. ${aws:ClientIp}
C. ${aws:IpAddress}
D. ${aws:RequestIp}

**Answer:** A
**Explanation:** `${aws:SourceIp}` refers to the requester's IP address and can be used in Condition elements.

---

### 25. What is the key difference between resource-based and identity-based policies?
A. No difference
B. Resource-based attach to resources and specify principals; identity-based attach to identities
C. Resource-based are more secure
D. Identity-based are JSON only

**Answer:** B
**Explanation:** Resource-based policies (like Bucket Policies) are attached to resources and must specify the Principal. Identity-based policies are attached to users/roles/groups.

---

### 26. What is the purpose of IAM Permissions Boundaries?
A. Grant permissions
B. Set the maximum permissions that an identity-based policy can grant to an IAM entity
C. Restrict root user
D. Encrypt policies

**Answer:** B
**Explanation:** Permissions Boundaries are an advanced feature to set the maximum intersection of permissions that an identity-based policy can grant.

---

### 27. Which service allows you to centrally manage access to multiple AWS accounts and applications?
A. IAM
B. AWS IAM Identity Center (AWS SSO)
C. Cognito
D. Directory Service

**Answer:** B
**Explanation:** AWS IAM Identity Center (formerly AWS SSO) provides a central place to create or connect your workforce identities and manage access across AWS accounts.

---

### 28. Which IAM feature allows workloads outside of AWS (like GitHub Actions) to access AWS resources without long-term credentials?
A. IAM Users
B. IAM Roles Anywhere / Workload Identity Federation
C. Access Keys
D. Cross-Account Roles

**Answer:** B
**Explanation:** IAM Roles Anywhere (and OIDC federation) allows workloads outside AWS to assume IAM roles using X.509 certificates or OIDC tokens.

---

### 29. Do Service Control Policies (SCPs) affect the management account?
A. Yes
B. No
C. Only if explicitly attached
D. Only for root user

**Answer:** B
**Explanation:** SCPs do not affect the management account (master account) of the organization; they only affect member accounts.

---

### 30. Which AWS service helps you check if your IAM policies grant excessive permissions?
A. IAM Access Analyzer
B. IAM Access Advisor
C. Trusted Advisor
D. GuardDuty

**Answer:** A
**Explanation:** IAM Access Analyzer can validate policies and identify public or cross-account access. Access Advisor shows last accessed services.

---

### 31. What is the "Confused Deputy" problem?
A. User forgets password
B. An entity that doesn't have permission to perform an action coerces a more privileged entity to perform the action
C. Role assumption failure
D. MFA failure

**Answer:** B
**Explanation:** The confused deputy problem is a security issue where an entity with low privileges tricks a more privileged entity into performing an action on its behalf.

---

### 32. Which IAM condition key checks if the request was made via SSL/TLS?
A. aws:SecureTransport
B. aws:SourceIp
C. aws:UserAgent
D. aws:Protocol

**Answer:** A
**Explanation:** `aws:SecureTransport` is a boolean condition key that checks if the request was sent using SSL (HTTPS).

---

### 33. What is the maximum number of managed policies you can attach to an IAM role?
A. 5
B. 10
C. 20
D. 50

**Answer:** B
**Explanation:** By default, you can attach up to 10 managed policies to an IAM role (quota can be increased to 20).

---

### 34. Which feature allows you to use your existing Active Directory to manage access to AWS Management Console?
A. AD Connector
B. Simple AD
C. AWS IAM Identity Center (with AD source)
D. Cognito

**Answer:** C
**Explanation:** AWS IAM Identity Center can be connected to your existing Active Directory to provide single sign-on access to the AWS Console.

---

### 35. What happens if an SCP denies an action but an IAM policy allows it?
A. Action is Allowed
B. Action is Denied
C. Depends on account
D. Depends on region

**Answer:** B
**Explanation:** SCPs act as a filter. If an SCP denies an action, it is denied regardless of any Allow in IAM policies.

---

### 36. Which IAM entity is best for an application running on EC2?
A. IAM User with Access Keys
B. IAM Role
C. IAM Group
D. Root User

**Answer:** B
**Explanation:** Use an IAM Role (Instance Profile) for applications on EC2 to avoid storing long-term credentials.

---

### 37. What is the purpose of the IAM Credential Report?
A. List all users and status of their credentials
B. List all roles
C. List all policies
D. List all buckets

**Answer:** A
**Explanation:** The Credential Report lists all users in the account and the status of their various credentials (passwords, access keys, MFA).

---

### 38. Which IAM policy condition allows access only within a specific time range?
A. aws:CurrentTime
B. aws:EpochTime
C. aws:DateGreaterThan / aws:DateLessThan
D. aws:TimeWindow

**Answer:** C
**Explanation:** `aws:DateGreaterThan` and `aws:DateLessThan` conditions can restrict access based on the date and time of the request.

---

### 39. Can Service Control Policies (SCPs) restrict the root user of a member account?
A. Yes
B. No
C. Only for billing
D. Only for S3

**Answer:** A
**Explanation:** Yes, SCPs affect all principals in the member account, including the root user.

---

### 40. Which IAM feature allows you to grant permissions based on the organization ID?
A. aws:PrincipalOrgID
B. aws:OrgID
C. aws:SourceOrg
D. aws:Organization

**Answer:** A
**Explanation:** The `aws:PrincipalOrgID` condition key allows you to restrict access to principals belonging to a specific AWS Organization.

---

### 41. What is the purpose of IAM Access Advisor?
A. Advise on policies
B. Show service last accessed data to help identify unused permissions
C. Create policies
D. Analyze logs

**Answer:** B
**Explanation:** Access Advisor shows when an IAM entity last accessed an AWS service, helping you remove unused permissions (least privilege).

---

### 42. Which API call is used to simulate IAM policy evaluation?
A. SimulatePrincipalPolicy
B. TestPolicy
C. EvaluatePolicy
D. CheckPolicy

**Answer:** A
**Explanation:** `SimulatePrincipalPolicy` (part of IAM Policy Simulator) simulates how a policy would be evaluated for a given action and resource.

---

### 43. What is the maximum size of an inline policy?
A. 2 KB
B. 5 KB
C. 10 KB
D. 20 KB

**Answer:** C
**Explanation:** Inline policies can be up to 10,240 characters (10 KB) for users and roles (2 KB for groups).

---

### 44. Which IAM feature allows you to block public access to all S3 buckets in an account?
A. S3 Block Public Access (Account Level)
B. Bucket Policy
C. IAM Policy
D. SCP

**Answer:** A
**Explanation:** S3 Block Public Access settings can be applied at the account level to block public access for all buckets in the account.

---

### 45. What is the purpose of a Service-Linked Role?
A. Link services
B. A role linked directly to an AWS service with predefined permissions required by that service
C. Link accounts
D. Link users

**Answer:** B
**Explanation:** Service-Linked Roles are predefined by AWS services and include all the permissions the service needs to call other AWS services on your behalf.

---

### 46. Which condition key enforces that a request must come from a specific VPC endpoint?
A. aws:SourceVpce
B. aws:SourceVpc
C. aws:VpcId
D. aws:Endpoint

**Answer:** A
**Explanation:** `aws:SourceVpce` checks the ID of the VPC endpoint that the request is coming from.

---

### 47. How can you prevent a specific IAM role from being deleted?
A. Enable deletion protection
B. Add a Deny policy for iam:DeleteRole on the role resource
C. Lock the role
D. Use SCP

**Answer:** B
**Explanation:** You can attach a policy (SCP or Permission Boundary) that explicitly denies `iam:DeleteRole` for that specific role ARN.

---

### 48. What is the purpose of the `aws:RequestedRegion` condition key?
A. Restrict access to specific AWS regions
B. Check source region
C. Check destination region
D. Check latency

**Answer:** A
**Explanation:** `aws:RequestedRegion` allows you to deny requests to AWS services in regions other than those you specify.

---

### 49. Which IAM feature allows you to delegate permission management to developers without giving full admin access?
A. Permissions Boundaries
B. Inline Policies
C. Groups
D. Roles

**Answer:** A
**Explanation:** Permissions Boundaries allow you to delegate role creation to developers while ensuring they cannot grant the roles more permissions than the boundary allows.

---

### 50. What is the maximum number of IAM roles per account?
A. 100
B. 500
C. 1,000
D. 5,000

**Answer:** C
**Explanation:** Default limit is 1,000 IAM roles per account (can be increased).
