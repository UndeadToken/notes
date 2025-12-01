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
