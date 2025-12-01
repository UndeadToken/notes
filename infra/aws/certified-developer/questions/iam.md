### 1. What is the default permission for a newly created IAM user?
A. Full access to all services
B. Read-only access
C. No permissions
D. Access to EC2 only

**Answer:** C
**Explanation:** New IAM users have no permissions by default (least privilege principle).

---

### 2. Which IAM entity can be attached to multiple users?
A. Inline Policy
B. User Policy
C. Group
D. Access Key

**Answer:** C
**Explanation:** Groups contain multiple users and policies are attached to groups for easier management.

---

### 3. What is the recommended password policy minimum length?
A. 6 characters
B. 8 characters
C. 12 characters
D. 16 characters

**Answer:** C
**Explanation:** AWS recommends minimum 12 characters for strong password policies.

---

### 4. Which MFA device type uses a physical hardware token?
A. Virtual MFA (Google Authenticator)
B. U2F Security Key (YubiKey)
C. SMS text message
D. Email code

**Answer:** B
**Explanation:** U2F Security Keys like YubiKey are physical hardware MFA devices.

---

### 5. What is the purpose of IAM Roles?
A. Store user credentials
B. Allow AWS services to act on your behalf
C. Encrypt data
D. Monitor API calls

**Answer:** B
**Explanation:** IAM Roles grant temporary credentials to AWS services (EC2, Lambda) to access other services.

---

### 6. Which IAM policy type is maintained and updated by AWS?
A. Customer Managed Policy
B. Inline Policy
C. AWS Managed Policy
D. Service Control Policy

**Answer:** C
**Explanation:** AWS Managed Policies are created and maintained by AWS, updated automatically.

---

### 7. What happens to an Inline Policy when the IAM user is deleted?
A. Policy is retained
B. Policy is deleted
C. Policy is transferred to root
D. Policy becomes orphaned

**Answer:** B
**Explanation:** Inline Policies are deleted automatically when the principal (user/role/group) is deleted.

---

### 8. Which IAM tool shows when a user last accessed a service?
A. IAM Credentials Report
B. IAM Access Advisor
C. CloudTrail
D. CloudWatch

**Answer:** B
**Explanation:** IAM Access Advisor shows service permissions and last access time.

---

### 9. What is the maximum number of IAM groups a user can belong to?
A. 1
B. 5
C. 10
D. Unlimited

**Answer:** C
**Explanation:** An IAM user can be a member of up to 10 groups.

---

### 10. Which IAM credential type is used for programmatic access?
A. Password
B. Access Keys (Access Key ID + Secret Access Key)
C. MFA token
D. SSH key

**Answer:** B
**Explanation:** Access Keys are used for CLI/SDK programmatic access to AWS.

---

### 11. What is the IAM policy evaluation logic?
A. ALLOW overrides DENY
B. DENY overrides ALLOW
C. First match wins
D. Random evaluation

**Answer:** B
**Explanation:** Explicit DENY always overrides ALLOW in IAM policy evaluation.

---

### 12. Which IAM feature generates a report of all users and credential status?
A. Access Advisor
B. Credentials Report
C. Policy Simulator
D. CloudTrail

**Answer:** B
**Explanation:** IAM Credentials Report lists all users and their credential status (passwords, access keys, MFA).

---

### 13. What is the best practice for AWS root account usage?
A. Use daily for all tasks
B. Share with team members
C. Avoid using; create IAM users instead
D. Use for development only

**Answer:** C
**Explanation:** Root account should not be used for daily tasks. Create IAM users with appropriate permissions.

---

### 14. Which IAM policy element specifies who can access the resource?
A. Action
B. Resource
C. Principal
D. Effect

**Answer:** C
**Explanation:** Principal specifies the account, user, role, or federated user allowed/denied access.

---

### 15. What is the purpose of IAM Policy Simulator?
A. Create new policies
B. Test and validate IAM policies before applying
C. Delete old policies
D. Encrypt policies

**Answer:** B
**Explanation:** Policy Simulator tests IAM policies to verify they work as intended before deployment.

---

### 16. Which IAM best practice improves security?
A. Share access keys
B. Use root account for daily tasks
C. Enable MFA for privileged users
D. Disable password rotation

**Answer:** C
**Explanation:** Enabling MFA adds an extra layer of security for privileged users.

---

### 17. What is the maximum number of managed policies that can be attached to an IAM user?
A. 5
B. 10
C. 20
D. Unlimited

**Answer:** B
**Explanation:** Up to 10 managed policies can be attached to a user, role, or group.

---

### 18. Which IAM feature allows temporary access to AWS resources?
A. Access Keys
B. IAM Roles with STS
C. Passwords
D. SSH Keys

**Answer:** B
**Explanation:** IAM Roles with STS (Security Token Service) provide temporary credentials.

---

### 19. What is the recommended approach for granting permissions?
A. Grant all permissions by default
B. Use least privilege principle
C. Share root credentials
D. Use inline policies only

**Answer:** B
**Explanation:** Least privilege principle grants only the minimum permissions needed.

---

### 20. Which IAM entity cannot be nested inside another?
A. Users in Groups
B. Groups in Groups
C. Policies in Roles
D. Roles in Users

**Answer:** B
**Explanation:** IAM Groups cannot contain other groups (no nesting allowed).

---

### 21. What is the difference between identity-based and resource-based policies?
A. Identity-based attach to users/roles, resource-based attach to resources
B. They are the same
C. Identity-based are JSON, resource-based are XML
D. Resource-based policies cannot use conditions

**Answer:** A
**Explanation:** Identity-based policies attach to IAM identities (users, groups, roles). Resource-based policies attach to resources (S3 buckets, SQS queues) and specify which principals can access them.

---

### 22. What is the purpose of IAM Permission Boundaries?
A. Encrypt IAM credentials
B. Set maximum permissions an identity can have
C. Define minimum required permissions
D. Monitor IAM activity

**Answer:** B
**Explanation:** Permission boundaries set the maximum permissions that an identity-based policy can grant to an IAM entity, even if the identity policy grants broader permissions.

---

### 23. Which IAM role type is created and managed by AWS services automatically?
A. Customer-managed role
B. Service-linked role
C. Cross-account role
D. Instance profile role

**Answer:** B
**Explanation:** Service-linked roles are predefined by AWS services and include all permissions the service requires. They're created/deleted automatically by the service.

---

### 24. What is required to enable cross-account access using IAM roles?
A. Share access keys between accounts
B. Trust policy in the role allowing the other account's principal
C. Copy IAM users to both accounts
D. Enable AWS Organizations

**Answer:** B
**Explanation:** Cross-account access requires a trust policy (assume role policy) that allows principals from another AWS account to assume the role.

---

### 25. Which IAM policy condition key restricts access based on source IP address?
A. aws:SourceIp
B. aws:IpAddress
C. aws:ClientIp
D. aws:NetworkOrigin

**Answer:** A
**Explanation:** The aws:SourceIp condition key restricts access based on the requester's IP address in CIDR notation.
