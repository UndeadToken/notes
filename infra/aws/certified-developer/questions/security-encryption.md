### 1. Which AWS service manages encryption keys?
A. IAM
B. KMS (Key Management Service)
C. Secrets Manager
D. Certificate Manager

**Answer:** B
**Explanation:** AWS KMS creates and manages encryption keys for AWS services.

---

### 2. What is the difference between symmetric and asymmetric KMS keys?
A. No difference
B. Symmetric uses one key, asymmetric uses public/private key pair
C. Symmetric is faster
D. Asymmetric is more secure

**Answer:** B
**Explanation:** Symmetric (AES-256) uses single key for encrypt/decrypt. Asymmetric (RSA/ECC) uses public/private keys.

---

### 3. Which KMS key type is free?
A. Customer Managed Keys
B. AWS Managed Keys
C. AWS Owned Keys
D. Imported Keys

**Answer:** C
**Explanation:** AWS Owned Keys are free (used by services like S3, SQS, DynamoDB for default encryption).

---

### 4. What is the cost for Customer Managed KMS keys?
A. Free
B. $1/month + API calls
C. $5/month
D. $10/month

**Answer:** B
**Explanation:** Customer Managed Keys cost $1/month plus API call charges.

---

### 5. Which encryption method encrypts data before sending to AWS?
A. Server-Side Encryption
B. Client-Side Encryption
C. In-Transit Encryption
D. KMS Encryption

**Answer:** B
**Explanation:** Client-Side Encryption encrypts data on client before sending to AWS.

---

### 6. What is the purpose of Envelope Encryption?
A. Encrypt envelopes
B. Encrypt data key with master key for performance
C. Double encryption
D. Encrypt metadata

**Answer:** B
**Explanation:** Envelope Encryption encrypts data with data key, then encrypts data key with master key (improves performance).

---

### 7. Which S3 encryption method uses AWS-managed keys?
A. SSE-S3
B. SSE-KMS
C. SSE-C
D. Client-Side

**Answer:** A
**Explanation:** SSE-S3 uses AWS-managed keys (AES-256) for server-side encryption.

---

### 8. Which S3 encryption method requires HTTPS?
A. SSE-S3
B. SSE-KMS
C. SSE-C (Customer-provided keys)
D. All of them

**Answer:** C
**Explanation:** SSE-C requires HTTPS because customer provides encryption keys in request.

---

### 9. What is the purpose of KMS Key Rotation?
A. Improve performance
B. Automatically rotate encryption keys for security
C. Reduce costs
D. Backup keys

**Answer:** B
**Explanation:** Automatic key rotation changes the backing key annually while keeping same key ID.

---

### 10. Which KMS feature controls who can use keys?
A. IAM Policies
B. Key Policies
C. Both A and B
D. Neither

**Answer:** C
**Explanation:** Both IAM Policies and Key Policies control access to KMS keys.

---

### 11. What is the default Key Policy for KMS?
A. Deny all
B. Allow root user full access
C. Allow all IAM users
D. No default policy

**Answer:** B
**Explanation:** Default Key Policy grants root user full access to the key.

---

### 12. Which AWS service stores secrets like database passwords?
A. KMS
B. Secrets Manager
C. Parameter Store
D. IAM

**Answer:** B
**Explanation:** Secrets Manager stores and rotates secrets (passwords, API keys, tokens).

---

### 13. What is the difference between Secrets Manager and Parameter Store?
A. No difference
B. Secrets Manager has automatic rotation, Parameter Store doesn't
C. Parameter Store is more expensive
D. Secrets Manager is faster

**Answer:** B
**Explanation:** Secrets Manager provides automatic secret rotation. Parameter Store is simpler and cheaper.

---

### 14. Which encryption protects data in transit?
A. KMS
B. TLS/SSL
C. AES-256
D. RSA

**Answer:** B
**Explanation:** TLS/SSL encrypts data in transit (HTTPS, SSL connections).

---

### 15. What is the purpose of AWS Certificate Manager (ACM)?
A. Manage KMS keys
B. Provision and manage SSL/TLS certificates
C. Encrypt data
D. Store secrets

**Answer:** B
**Explanation:** ACM provisions, manages, and deploys SSL/TLS certificates for AWS services.

---

### 16. Which KMS operation encrypts data?
A. Encrypt
B. Decrypt
C. GenerateDataKey
D. CreateKey

**Answer:** A
**Explanation:** Encrypt API encrypts plaintext data using a KMS key.

---

### 17. What is the maximum data size for KMS Encrypt API?
A. 4 KB
B. 16 KB
C. 64 KB
D. 256 KB

**Answer:** A
**Explanation:** KMS Encrypt can encrypt up to 4 KB directly. Use envelope encryption for larger data.

---

### 18. Which KMS feature allows cross-account key access?
A. IAM Policies
B. Key Policies with cross-account principals
C. Resource Policies
D. Not possible

**Answer:** B
**Explanation:** Key Policies can grant access to principals in other AWS accounts.

---

### 19. What is the purpose of KMS Grant?
A. Grant money
B. Temporary, programmatic access to KMS keys
C. Permanent access
D. Encrypt data

**Answer:** B
**Explanation:** Grants provide temporary, programmatic permissions to use KMS keys.

---

### 20. Which encryption method is used for EBS volumes?
A. SSL/TLS
B. KMS (AES-256)
C. RSA
D. Client-side

**Answer:** B
**Explanation:** EBS volumes use KMS keys with AES-256 encryption for data at rest.

---

### 21. What is AWS CloudHSM used for?
A. Manage IAM users
B. Dedicated hardware security module for cryptographic operations
C. Encrypt S3 objects
D. Store secrets

**Answer:** B
**Explanation:** CloudHSM provides dedicated hardware security modules (HSM) for regulatory compliance and custom key management.

---

### 22. Which AWS service provides isolated compute environments for sensitive workloads?
A. Lambda
B. Fargate
C. Nitro Enclaves
D. EC2 Dedicated Hosts

**Answer:** C
**Explanation:** AWS Nitro Enclaves provide isolated compute environments within EC2 instances for processing highly sensitive data.

---

### 23. What is the purpose of KMS Multi-Region Keys?
A. Reduce latency
B. Replicate keys across regions for disaster recovery and global applications
C. Increase security
D. Reduce costs

**Answer:** B
**Explanation:** Multi-Region Keys are replicated across multiple regions with the same key material for disaster recovery and low-latency access.

---

### 24. Which Parameter Store tier supports parameter policies and higher throughput?
A. Standard
B. Advanced
C. Premium
D. Enterprise

**Answer:** B
**Explanation:** Advanced tier supports parameter policies (expiration, notifications), higher throughput, and larger parameter values.

---

### 25. What is AWS Signer used for?
A. Sign API requests
B. Code signing for Lambda functions and IoT devices
C. Sign SSL certificates
D. Sign CloudFormation templates

**Answer:** B
**Explanation:** AWS Signer ensures code integrity and authenticity through code signing for Lambda, IoT, and container images.

---

### 26. What is the maximum size of a KMS key policy?
A. 4 KB
B. 32 KB
C. 64 KB
D. 128 KB

**Answer:** B
**Explanation:** KMS key policy document size limit is 32 KB.

---

### 27. Which service rotates database credentials automatically?
A. KMS
B. Secrets Manager
C. Systems Manager Parameter Store
D. IAM

**Answer:** B
**Explanation:** Secrets Manager automatically rotates credentials for RDS, Redshift, and DocumentDB using Lambda.

---

### 28. What is the purpose of AWS WAF?
A. Firewall for VPC
B. Protect web applications from common exploits (SQLi, XSS)
C. DDoS protection
D. Network firewall

**Answer:** B
**Explanation:** AWS WAF protects web applications from common web exploits like SQL injection and cross-site scripting.

---

### 29. Which KMS key type is dedicated to a specific AWS account?
A. AWS Managed Key
B. Customer Managed Key (CMK)
C. AWS Owned Key
D. Shared Key

**Answer:** B
**Explanation:** Customer Managed Keys (CMKs) are created and managed by you, dedicated to your account.

---

### 30. What is the maximum size of a secret in Secrets Manager?
A. 4 KB
B. 10 KB
C. 64 KB
D. 1 MB

**Answer:** C
**Explanation:** Secrets Manager secrets can be up to 64 KB in size.

---

### 31. Which service provides DDoS protection?
A. WAF
B. Shield
C. GuardDuty
D. Inspector

**Answer:** B
**Explanation:** AWS Shield (Standard and Advanced) provides protection against Distributed Denial of Service (DDoS) attacks.

---

### 32. What is the purpose of KMS Grants?
A. Grant access
B. Delegate temporary permissions to use a KMS key
C. Grant money
D. Grant roles

**Answer:** B
**Explanation:** Grants allow you to programmatically delegate temporary permissions to use a KMS key to AWS services or principals.

---

### 33. Which service detects intelligent threats and anomalies?
A. WAF
B. Shield
C. GuardDuty
D. Macie

**Answer:** C
**Explanation:** GuardDuty uses machine learning to detect threats, anomalies, and unauthorized behavior in your AWS environment.

---

### 34. What is the maximum number of KMS keys per account?
A. 1,000
B. 10,000
C. 100,000
D. Unlimited (100,000 default)

**Answer:** D
**Explanation:** Default limit is 100,000 Customer Managed Keys per region (can be increased).

---

### 35. Which service discovers sensitive data in S3?
A. GuardDuty
B. Macie
C. Inspector
D. Detective

**Answer:** B
**Explanation:** Amazon Macie uses machine learning to discover and protect sensitive data (PII) in S3 buckets.

---

### 36. What is the purpose of KMS Envelope Encryption?
A. Encrypt envelopes
B. Encrypt data key with a master key (KMS key)
C. Encrypt emails
D. Double encryption

**Answer:** B
**Explanation:** Envelope Encryption encrypts the data key (which encrypts the data) using a KMS key, allowing efficient encryption of large data.

---

### 37. Which WAF feature blocks traffic from specific countries?
A. IP Set
B. Geo Match Condition
C. String Match
D. Size Constraint

**Answer:** B
**Explanation:** Geo Match Condition allows blocking or allowing traffic based on geographic location (country).

---

### 38. What is the maximum size of data KMS can encrypt directly (Encrypt API)?
A. 4 KB
B. 32 KB
C. 1 MB
D. 10 MB

**Answer:** A
**Explanation:** KMS Encrypt API can encrypt up to 4 KB of data directly. Use Envelope Encryption for larger data.

---

### 39. Which service manages SSL/TLS certificates?
A. KMS
B. ACM (AWS Certificate Manager)
C. IAM
D. Secrets Manager

**Answer:** B
**Explanation:** ACM provisions, manages, and deploys public and private SSL/TLS certificates.

---

### 40. What is the purpose of AWS Inspector?
A. Inspect packets
B. Automated security assessment for EC2 and ECR (vulnerabilities, exposure)
C. Inspect logs
D. Inspect code

**Answer:** B
**Explanation:** Inspector automatically scans EC2 instances and ECR repositories for software vulnerabilities and unintended network exposure.

---

### 41. Which KMS feature allows keys to be used in multiple regions?
A. Global Keys
B. Multi-Region Keys
C. Replicated Keys
D. Cross-Region Keys

**Answer:** B
**Explanation:** Multi-Region Keys are replicated across regions and have the same key ID, allowing easier cross-region data access.

---

### 42. What is the maximum number of WAF rules per Web ACL?
A. 10
B. 50
C. 100
D. Unlimited (based on WCU)

**Answer:** D
**Explanation:** Number of rules is limited by Web ACL Capacity Units (WCU), typically allowing many rules (default 1500 WCU).

---

### 43. Which service provides centralized security management?
A. Security Hub
B. GuardDuty
C. Shield
D. IAM

**Answer:** A
**Explanation:** Security Hub aggregates alerts and findings from various security services into a centralized dashboard.

---

### 44. What is the purpose of KMS Key Rotation?
A. Rotate keys physically
B. Automatically generate new backing key material for the KMS key
C. Delete old keys
D. Share keys

**Answer:** B
**Explanation:** Automatic key rotation generates new key material every year (for CMKs) while retaining old material for decryption.

---

### 45. Which service analyzes root cause of security issues?
A. GuardDuty
B. Detective
C. Inspector
D. Macie

**Answer:** B
**Explanation:** Amazon Detective analyzes log data to visualize and identify the root cause of security findings.

---

### 46. What is the maximum validity period for ACM certificates?
A. 90 days
B. 1 year
C. 13 months
D. 3 years

**Answer:** C
**Explanation:** ACM managed certificates are valid for 13 months and renewed automatically.

---

### 47. Which KMS permission allows creating data keys?
A. kms:Encrypt
B. kms:Decrypt
C. kms:GenerateDataKey
D. kms:CreateKey

**Answer:** C
**Explanation:** kms:GenerateDataKey permission allows generating data keys for envelope encryption.

---

### 48. What is the purpose of AWS Network Firewall?
A. Firewall for EC2
B. Managed network firewall for VPCs (stateful inspection, IPS)
C. WAF
D. Security Group

**Answer:** B
**Explanation:** Network Firewall provides managed, stateful network firewall and intrusion prevention for VPCs.

---

### 49. Which service protects against bot attacks?
A. Shield
B. WAF Bot Control
C. GuardDuty
D. Inspector

**Answer:** B
**Explanation:** AWS WAF Bot Control provides managed rule groups to detect and block common bot traffic.

---

### 50. What is the maximum number of Secrets Manager secrets per account?
A. 1,000
B. 10,000
C. 50,000
D. 500,000

**Answer:** D
**Explanation:** Default limit is 500,000 secrets per region per account.

