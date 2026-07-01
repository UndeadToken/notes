IAM: Users & Groups  
  
IAM is a global service  
  
- IAM = Identity and Access Management, Global service  
- Root account created by default, shouldn’t be used or shared  
- Users are people within your organisation, and can be grouped  
- Groups only contain users, not other groups  
- Users don’t have to belong to a group, and a user can belong to multiple groups  
  
IAM: Permissions  
  
- Users or Groups can be assigned JSON documents called policies  
- These policies define the permissions of the users  
- In AWS you apply the least privilege principle: don’t give more permissions than user needs  
  
IAM: Policies inheritance  
  
IAM: Policies structure  
  
- Consists of Version: policy language, always include “2012-10-17”  
- Id: an identifier for the policy (optional)  
- Statement” one or more individual statements (required)  
  
Statements consist of:  
  
- Sid: an identifier for the statement (optional)  
- Effect: whether the statement allows or denies access (Allow, Deny)  
- Principle: account/user/role to which this policy applied to  
- Action: list of actions this policy allows or denies  
- Resource: a list of resources to which the actions applied to  
- Condition: conditions for when this policy is in effect (optional)  
  
IAMReadOnlyAccess  
  
IAM: Password Policy  
  
IAM: Password Policy  
  
Access Management > Account Settings > Password Policy  
  
- Strong password = higher security for your account  
- In AWS, you can setup a password policy:  
    - Set a minimum password length  
    - Require specific character types  
        - Including uppercase letters  
        - Lowercase letters  
        - Numbers  
        - Non-alphanumeric characters  
    - Allow all IAM users to change their own passwords  
    - Require users to change their password after some time (password expiration)  
    - Prevent password re-use  
  
Multi Factor Authentication - MFA  
  
- Users have access to your account and can possibly change configurations or delete resources in your AWS account  
- You want to protect your Root Accounts and IAM users  
- MFA = password you know + security device you own  
    - Virtual Devices  
        - Google Authenticator  
        - Authy  
    - Universal 2nd Factor (U2F) Security Key  
        - YubiKey by Yubico (3rd party)  
	- Hardware Key Fob MFA Device	  
	  - Gemalto (3rd party)  
        - Hardware Key Fob MFA Device for AWS GovCloud (US)  
		- SurePassID (3rd party)  
  
Access  
  
To access AWS, you have three options:  
- AWS Management Console (protected by password + MFA)  
- AWS CloudShell  
- AWS Command Line Interface (CLI): protected by access keys   
- AWS Software Developer Kit (SDK) - for code: protected by access keys  
  
- Access Keys are generated through the AWS Console  
- Users manage their own access keys  
- Access Keys are secret, just like a password  
  
AWS CLI  
  
- A tool that enables you to interact with AWS services using commands in your command-line shell  
- Direct access to the public API’s of AWS services  
- You can develop scripts to manage your resources  
- It’s open-source https://github.com/aws/aws-cli  
- Alternative to using AWS Management Console  
  
https://docs.aws.amazon.com/cli/v1/userguide/install-macos.html  
  
Setup cli access:  
aws configure  
  
commands:  
aws iam list-users  
  
AWS SDK  
  
- AWS Software Development Kit (AWS SDK)  
- Language-specific API’s (Set of libraries)  
- Enables you to access and manage AWS services programattically  
- Embedded within your application  
- Supports  
    - SDKs (Javascript; Python, PHP, .NET, Java, Go, Node.js, C++)  
    - Mobile Device SDKs (Android, iOS, …)  
    - IoT Device SDKs (Embedded C, Arduino, …)  
  
IAM: Roles for Services  
  
Roles are ways for AWS entities to do stuff on AWS  
  
- Some AWS services will need to perform actions on your behalf  
- To do so, we will assign permissions to AWS services with IAM Roles  
- Common roles:  
    - EC2 Instance Roles  
    - Lambda Function Roles  
    - Roles for CloudFormation  
  
IAM: Security Tools  
  
- IAM Credentials Report (account-level)  
    - A report that lists all your account’s users and the status of their various credentials  
- IAM Access Advisor (user-level)  
    - Access advisor shows the service permissions granted to a user and when those services were last accessed  
    - You can use this information to revise your policies  
  
IAM: Guidelines & Best Practices  
  
- Don’t use the root account except for AWS account setup  
- One physical user = One AWS user  
- Assign users to groups and assign permissions to groups  
- Create a strong password policy  
- Use and enforce the use of Multi Factor Authentication (MFA)  
- Create and use Roles for giving permissions to AWS services  
- Use Access Keys for Programmatic Access (CLI/SDK)  
- Audit permissions of your account using IAM Credentials Report & IAM Access Advisor  
- Never share IAM users & Access Keys  
  
IAM: Shared Responsibility Model for IAM  
  
AWS Responsibilities:  
- Infrastructure (global network security)  
- Configuration and vulnerability analysis  
- Compliance validation  
  
User Responsibilities  
- Users, Groups, Roles, Policies management and monitoring  
- Enable MFA on all accounts]  
- Rotate all your keys often  
- Use IAM tools to apply appropriate permissions  
- Analyse access patterns & review permissions  
  
  
