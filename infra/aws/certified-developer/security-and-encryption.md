# Security & Encryption

## Encryption in Flight (TLS / SSL)
- Data is encrypted before sending and decrypted after receiving
- TLS certificates provide HTTPS encryption
- Prevents MITM (man-in-the-middle) attacks

## Server-Side Encryption at Rest
- Data encrypted when received by the server and decrypted when accessed
- Stored in encrypted form using a key (data key)
- Server must manage keys securely

## Client-Side Encryption
- Data encrypted by client, never decrypted by server
- Server cannot decrypt the data
- Can use Envelope Encryption

---

## KMS (Key Management Service)
- AWS managed encryption keys integrated with IAM
- Audit key usage via CloudTrail
- Integrated with most AWS services: EBS, S3, RDS, SSM
- Avoid storing secrets in plaintext
- Supports SDK and CLI usage for encryption

### KMS Key Types
- Symmetric (AES-256): single key for encrypt/decrypt
- Asymmetric (RSA/ECC): public key for encrypt, private key for decrypt
- Key categories:
  - AWS Owned Keys: free (SSE-S3, SSE-SQS, SSE-DDB)
  - AWS Managed Keys: free (aws/service-name)
  - Customer Managed Keys: $1/month + API call costs
  - Imported Keys: $1/month, manual rotation
- Key rotation:
  - AWS-managed: automatic yearly
  - Customer-managed: enable automatic/on-demand
  - Imported: manual only

### Snapshot Cross-Region Encryption
- Copy EBS snapshot across regions using KMS re-encryption
- Example flow: `Volume encrypted with KMS A -> Snapshot -> Re-encrypt KMS B -> Volume in target region`

### KMS Key Policies
- Control access to keys (similar to S3 bucket policies)
- Default policy: full access to root user
- Custom policy: define users/roles, cross-account access

### Encryption CLI Example
```bash
aws kms encrypt --key-id alias/tutorial --plaintext fileb://example.txt --output text --query CiphertextBlob --region eu-west-2 > example-encrypted.base64
aws kms decrypt --ciphertext-blob fileb://example-encrypted --output text --query Plaintext --region eu-west-2 > example-decrypted.base64
