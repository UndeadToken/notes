**1. Which AWS STS API should you use to grant temporary credentials to a user authenticated through an external OpenID Connect (OIDC) identity provider?**  
A. AssumeRoleWithSAML  
B. GetSessionToken  
C. AssumeRoleWithWebIdentity  
D. GetFederationToken  

**Answer:** C  

---

**2. You have an IAM Role that allows read/write to an S3 bucket. The S3 bucket has an explicit deny for write actions for the same role. What is the outcome when the role tries to write to the bucket?**  
A. Write succeeds  
B. Write fails due to explicit deny  
C. Write succeeds if the IAM policy allows it  
D. Write fails unless the bucket policy is removed  

**Answer:** B  

---

**3. Which STS API returns the current IAM user or role identity making the API call?**  
A. GetCallerIdentity  
B. GetSessionToken  
C. AssumeRole  
D. DecodeAuthorizationMessage  

**Answer:** A  

---

**4. You want to enforce MFA for temporary credentials using AWS STS. Which API and IAM condition combination is required?**  
A. GetSessionToken + aws:MultiFactorAuthPresent:true  
B. AssumeRole + aws:MultiFactorAuthPresent:true  
C. GetFederationToken + aws:MultiFactorAuthRequired:true  
D. AssumeRoleWithWebIdentity + aws:MultiFactorAuthPresent:true  

**Answer:** A  

---

**5. Which of the following statements about IAM policy evaluation is correct?**  
A. ALLOW always overrides DENY  
B. DENY always overrides ALLOW  
C. IAM ignores explicit denies if the user has ALLOW in any policy  
D. Policies are evaluated in alphabetical order  

**Answer:** B  

---

**6. You want to create a dynamic S3 bucket policy allowing each user access only to their personal folder. Which variable can be used in the policy to refer to the current IAM username?**  
A. ${aws:userid}  
B. ${aws:username}  
C. ${s3:userid}  
D. ${s3:username}  

**Answer:** B  

---

**7. Which type of IAM policy is deleted automatically when the principal it is attached to is deleted?**  
A. Customer Managed Policy  
B. AWS Managed Policy  
C. Inline Policy  
D. Service Control Policy  

**Answer:** C  

---

**8. A Lambda function needs to assume an IAM role to write to an S3 bucket. Which permission must be included in the IAM policy attached to the Lambda execution role?**  
A. s3:PutObject  
B. iam:PassRole  
C. lambda:InvokeFunction  
D. sts:AssumeRole  

**Answer:** B  

---

**9. Which AWS Directory Service option allows users to authenticate using an on-premises Active Directory without storing passwords in AWS?**  
A. Simple AD  
B. AD Connector  
C. AWS Managed Microsoft AD  
D. AWS Cloud Directory  

**Answer:** B  

---

**10. What is the maximum duration temporary credentials issued via AssumeRole can be valid?**  
A. 15 minutes  
B. 1 hour  
C. 12 hours  
D. 36 hours  

**Answer:** B  

---

**11. You decode an AWS API authorization error using STS. Which API provides the ability to convert encoded error messages into readable form?**  
A. DecodeAuthorizationMessage  
B. GetCallerIdentity  
C. GetSessionToken  
D. GetFederationToken  

**Answer:** A  

---

**12. Which STS API would you use to obtain temporary credentials for a federated user authenticated outside of AWS?**  
A. AssumeRole  
B. GetFederationToken  
C. GetSessionToken  
D. AssumeRoleWithWebIdentity  

**Answer:** B  

---

**13. Which of the following is TRUE regarding AWS Managed Policies?**  
A. They are deleted automatically when the attached user is deleted  
B. They are maintained and updated automatically by AWS  
C. They can only be attached to a single user  
D. They cannot be reused across accounts  

**Answer:** B  

---

**14. If an IAM Role attached to an EC2 instance has no permissions, but the S3 bucket has an explicit allow for that role, what happens when the EC2 instance tries to read from the bucket?**  
A. Access is allowed  
B. Access is denied  
C. Access depends on AWS region  
D. Access requires temporary credentials  

**Answer:** A  

---

**15. Which authentication flow correctly represents a user on an on-prem AD accessing AWS resources via AWS Managed AD?**  
A. On-prem AD → AD Connector → Auth  
B. On-prem AD → trust → AWS Managed AD → Auth  
C. Simple AD → Proxy → AWS Managed AD → Auth  
D. On-prem AD → Simple AD → Auth  

**Answer:** B  

---

**16. What is the purpose of STS session tags?**  
A. Tag resources
B. Pass attributes during role assumption for ABAC (Attribute-Based Access Control)
C. Monitor sessions
D. Encrypt session data

**Answer:** B

---

**17. Which STS API is used for SAML 2.0 federation?**  
A. AssumeRoleWithWebIdentity
B. AssumeRoleWithSAML
C. GetFederationToken
D. AssumeRole

**Answer:** B

---

**18. What is Attribute-Based Access Control (ABAC) in IAM?**  
A. Access based on user attributes
B. Access control using tags on principals and resources
C. Access based on IP address
D. Access based on time of day

**Answer:** B

---

**19. Which AWS Organizations feature restricts permissions across all accounts?**  
A. IAM Policies
B. Service Control Policies (SCPs)
C. Resource Policies
D. Permission Boundaries

**Answer:** B

---

**20. What is IAM Access Analyzer used for?**  
A. Analyze costs
B. Identify resources shared with external entities
C. Monitor API calls
D. Encrypt data

**Answer:** B

---

**21. Which IAM policy element is required for cross-account role assumption?**  
A. Principal in trust policy
B. Resource in IAM policy
C. Condition in bucket policy
D. Effect: Allow

**Answer:** A

---

**22. What is the purpose of session policies in STS?**  
A. Encrypt sessions
B. Further restrict permissions during role assumption
C. Monitor sessions
D. Extend session duration

**Answer:** B

---

**23. What is the purpose of External ID in cross-account role assumption?**  
A. Encrypt data
B. Prevent confused deputy problem
C. Monitor access
D. Rotate credentials

**Answer:** B

---

**24. Which IAM policy variable references the source IP address?**  
A. ${aws:SourceIp}
B. ${aws:ClientIp}
C. ${aws:IpAddress}
D. ${aws:RequestIp}

**Answer:** A

---

**25. What is the key difference between resource-based and identity-based policies?**  
A. No difference
B. Resource-based attach to resources and specify principals; identity-based attach to identities
C. Resource-based are more secure
D. Identity-based are JSON only

**Answer:** B
