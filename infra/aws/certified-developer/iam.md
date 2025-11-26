# AWS Certified Developer – Associate (DVA-C02) Exam IAM Cheat Sheet

---

### IAM Basics
- **IAM** = Identity and Access Management, **global service**.
- **Root account**: created by default, should not be used or shared.
- **Users**: people in your organization; can belong to multiple groups or none.
- **Groups**: contain users only; assign permissions at group level.

### Permissions
- **Policies** (JSON) define permissions for users/groups.
- Follow **least privilege principle**: give only required permissions.

**Policy Structure**:
- **Version**: always `"2012-10-17"`.
- **Id**: optional.
- **Statement**: required.
  - **Sid**: optional.
  - **Effect**: Allow or Deny.
  - **Principal**: account/user/role.
  - **Action**: allowed/denied actions.
  - **Resource**: resources affected.
  - **Condition**: optional conditions.

### Password Policy
- Minimum password length.
- Require uppercase, lowercase, numbers, symbols.
- Allow users to change passwords.
- Enforce password expiration and prevent reuse.

### Multi-Factor Authentication (MFA)
- Protect root and IAM users.
- Methods:
  - Virtual devices: Google Authenticator, Authy.
  - U2F Security Keys: YubiKey.
  - Hardware MFA devices: Gemalto, SurePassID (GovCloud).

### Access Methods
- **AWS Management Console**: password + MFA.
- **AWS CloudShell**
- **AWS CLI / SDK**: protected by **access keys** (users manage their own, secret).

**AWS CLI**
- Interact with AWS via commands.
- Scripts for automation.
- `aws configure` to set credentials.
- Example command: `aws iam list-users`.

**AWS SDK**
- Language-specific libraries (Python, Java, Node.js, etc.).
- Embedded in applications.
- Also for mobile/IoT devices.

### Roles for Services
- Allow AWS services to act on your behalf.
- Examples:
  - EC2 instance roles
  - Lambda function roles
  - CloudFormation roles

### Security & Monitoring Tools
- **IAM Credentials Report**: lists all users and credential status.
- **IAM Access Advisor**: shows services a user can access and last usage.

### Best Practices
- Avoid root account use.
- One AWS user per person.
- Use groups for permissions.
- Strong password policy + enforce MFA.
- Use roles for AWS services.
- Rotate access keys regularly.
- Audit permissions using IAM tools.
- Never share IAM users or keys.

### Shared Responsibility Model
**AWS Responsibilities**
- Infrastructure security, configuration, compliance validation.

**User Responsibilities**
- Manage users, groups, roles, policies.
- Enable MFA.
- Rotate keys.
- Apply least privilege.
- Monitor access patterns.

--- 
