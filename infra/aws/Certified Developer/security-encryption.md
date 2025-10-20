Security & Encryption

Encryption in flight (TLS / SSL)

- Data is encrypted before sending and decrypted after receiving 
- TLS certificate help with encryption (HTTPS)
- Encryption in flight ensures no MITM (man in the middle attack) can happened

Server-side encryption at rest

- Data is encrypted after being received by the server
- Data is decrypted before being sent
- It is stored in an encrypted form thanks to a key (usually a data key)
- The encryption / decryption keys must be managed somewhere, and the server must have access to it

Client-side encryption

- Data is encrypted by the client and never decrypted by the server
- Data will be decrypted by a receiving client
- The server should not be able to decrypt the data
- Could leverage Envelope Encryption

KMS (Key Management Service)

- Anytime you hear "encryption" for an AWS service, it's most likely KMS
- AWS manages encryption keys for us
- Fully integrated with IAM for authorization
- Easy way to control access to your data
- Able to audit KMS Key usage using CloudTrail
- Seamlessly integrated into most AWS services (EBS, S3, RDS, SSM...)
- Never ever store your secrets in plaintext, especially in your code
    - KMS Key Encryption also available through API calls (SDK, CLI)
    - Encrypted secrets can be stored in the code / environment variables

KMS Key Types

- KMS keys is the new name of KMS Customer Master Key
- Symmetric (AES-256 Keys)
    - Single encryption key that is used to Encrypt and Decrypt
    - AWS services that are integrated with KMS use Symmetric CMKs
    - You never get access to the KMS Key unencrypted (must call KMS API to use)
- Asymmetric (RSA & ECC Key pairs)
    - Public (Encrypt) and Private Key (Decrypt) pair
    - Used for Encrypt/Decrypt or Sign/Verify operations
    - The public key is downloadable, but you can't access the Private Key unencrypted

- Types of KMS Keys
    - AWS Owned Keys (free): SSE-S3, SSE-SQS, SSE-DDB (default)
    - AWS Managed Key: free (aws/service-name, example: aws/rds or aws/ebs)
    - Customer managed keys created in KMS: $1 /m
    - Customer managed keys imported: $1/m
    - + pay for API call to KMS ($0.03 / 1000 calls)
- Automatic Key rotation
    - AWS-managed KMS key: automatic every 1 year
    - Customer-managed KMS Key: (must be enabled) automatic & on-demand
    - Imported KMS Key: only manual rotation possible using alias

Copying Snapshots across regions

(Region eu-west-2) -> EBS Volume Encrypted with KMS (KMS Key A) -> EBS Snapshot Encrypted with KMS -> KMS ReEncrypt with KMS Key B -> (Region ap-southeast-2) EBS Snapshot Encrypted with KMS -> EBS Volume Encrypted with KMS

KMS Key Policies

- Control access to KMS keys, "similar" to S3 bucket policies
- Difference: you cannot control access without them

- Default KMS Key Policy
    - Created if you don't provide a specific KMS Key Policy
    - Complete access to the key to the root suer = entire AWS account
- Custom KMS Key Policy
    - Define users, roles that can access the KMS key
    - Define who can administer the key
    - Useful for cross-account  access of your KMS key

1.) Create a snapshot, encrypted with your own kms customer managed key
2.) Attach a KMS key policy to authorise cross account access
3.) Share the encrypted snapshot
4.) (in target) Create a copy of the snapshot, encrypt it with a cmd in your account
5.) Create a volume from the snapshot

aws kms encrypt --key-id alias/tutorial --plaintext fileb://example.txt --output text --query CiphertextBlob --region eu-west-2 > example-encrypted.base64

cat example-encrypted |base64 > example-encrypted

certutil -code ./example-encrypted.base64 . example-encrypted

aws kms decrypt --cyphertext-blob files://example-encrypted --output text --query Plaintext > example-decrypted.base64 --region eu-west-2

Cat example-decrypted.base64 |base64 --decode > example-decrypted.txt

certutil -decode ./example-decrypted.base64 ./example-decrypted.txt

KMS Encryption Patterns and Envelope Encryption

Secret (ex: password) < 4km (limit for kms)

- KMS Encrypt API call has a limit of 4kb
- If you want to encrypt >4kb, we need to use Envelope Encryption
- The main API that will help us is the GenerateDataKey API
- For the exam: anything over 4kb of data that needs to be encrypted must use the Envelope Encryption == GenerateDataKey API

Encryption SDK

- The AWS Encryption SDK implemented Envelope Encryption for us
- The Encryption SDK also exists as a CLI tool we can install
- Implementations for Java, Python, C, Javascript
- Feature - Data Key Caching
    - Re-use keys instead of creating new ones for each encryption
    - Helps with reducing the number of calls to KMS with a security trade-off
    - Use LocalCryptoMaterialsCache (max age, max bytes, max number of messages)

KMS Symmetric -- API Summary

- Encrypt up to 4kb of data through KMS
- GenerateDataKey: generates a unique symmetric data key (DEK)
    - Returns a plaintext copy of the data key
    - AND a copy that is encrypted under the CMK that you specify
- GenerateDataKeyWithoutPlaintext
    - Generate a DEK to use at some point (not immediately)
    - DEK that is encrypted under the CMK that you specify (must use Decrypt later)
- Decrypt: decrypt up to 4kb of data (including Data Encryption Keys)
- GenerateRandom: Returns a random byte string

KMS Limits

- Request Quotas
    - When you exceed a request quota you get a ThrottlingException
- To respond, use exponential backoff (backoff and retry)
- For cryptographic operations, they share a quota
- This includes requests made by AWS on your behalf (ex:SSE-KMS)
- For GenerateDataKey, consider using DEK caching from the Encryption SDK
- You can request a Request Quotas increase through API or AWS support

KMS Request Quotas

10,000-30,000 depending on region

S3 Bucket Key for SSE-KMS encryption

- New setting to decrease...
    - Number of API calls made to KMS from S3 by 99%
    - Costs of overall KMS encryption with Amazon S3 by 99%
- This leverages data keys
    - A "S3 bucket key" is generated
    - That key us used to encrypt KMS objects with new data keys
- You will see less KMS CloudTrail events in CloudTrail

KMS -> S3 -> S3 Bucket Key -> Data Keys -> S3 Bucket

CloudHSM

- KMS => AWS Manages the software for encryption
- CloudHSM => AWS provisions encryption hardware
- Dedicated Hardware (HSM = Hardware Security Module)
- You manage your own encryption keys entirely (not AWS)
- HSM device is tamper resistant, FIPS 140-2 Level compliance
- Supports both symmetric and asymmetric encryption (SSL/TLS keys)
- Np free tier available
- Must use the CloudHSM Client Software
- Redshift supports CloudHSM for database encryption and key management
- Good option to use with SSE-C encryption

High Availability

- CloudHSM clusters are spread across Multi AZ (HA)
- Great for availability an d durability

Integration with AWS Services

- Through integration with AWS KMS
- Configure KMS Custom Key Store with CloudHSM
- Example: EBS, S3, RDS...

SSM Parameter Store

- Secure storage for configuration and secrets
- Optional Seamless Encryption using KMS
- Serverless, scalable, durable, easy SDK
- Version tracking of configurations / secrets
- Security through IAM
- Notifications with Amazon EventBridge
- Integration with CloudFormation

SSM Parameter Store Hierarchy

/my-department/
	my-app/
		dev/
			db-url
/aws/reference/secretesmanager/secret_ID_in_Secrets_Manager
/aws/service/ami-amazon-linux-latest/amzn2-ami-hvm-x86_64-gp2 (public)

Parameter Policies (for advanced policies)

- Allow to assign a TTL to a parameter (expiration data) to force updating or deleting sensitive data such as passwords
- Can assign multiple policies at a time

Secrets Manager

- Newer service, meant for storing secrets
- Capability to force rotation of secrets every x days
- Automate generation of secrets on rotation (uses Lambda)
- Integration with Amazon RDS (MySQL, PostreSQL, Aurora)
- Secrets are encrypted using KMS
- Mostly meant for RDS integration

Multi-Region Secrets

- Replicate secrets across multiple AWS Regions
- Secrets Manager keeps read replicas in sync with the primary secret
- Ability to promote a read replica Secret to a standalone Secret
- Use cases: multi-region apps, disaster recovery strategies, multi-region DB...

SSM Parameter Store vs Secrets Manager

- Secrets Manager ($$$
    - Automatic rotation of secrets with AWS Lambda
    - Lambda function is provided for RDS, Redshift, DocumentDB
    - KMS encryption is mandatory
    - Can integration with CloudFormation
- SSM Parameter Store ($)
    - Simple API
    - No secret rotation (can enable rotation using Lambda triggered by EventBridge)
    - KMS encryption is optional
    - Can integration with CloudFormation
    - Can pull a Secrets Manager secret using the SSM Parameter Store API

SSM Parameter Store vs Secrets Manager Rotation

- AWS Secrets Manager -> invoke Lambda -> RDS
- EventBridge -> Lambda -> SSM Parameter Store, Rds

CloudFormation -- Dynamic References

- Reference external values stored in Systems Manager Parameter Store and Secrets Manager within CloudFormation templates
- CloudFormation retrieves the value of the specified reference during create/update/delete operations
- For example: retrieve RDS DB Instance master password from secrets manager
- Supports 
    - ssm -- for plaintext values stored in SSM Parameter Store
    - ssm-secure -- for secure strings stored in ssm parameter store
    - secretsmanager -- for secret values stored in secrets manager

ManageMasterUserPassword -- creates admin secret implicitly
RDS, Aurora will manage the secret in Secrets manager and its rotation

GenerateStringKey: "password"

CloudWatch Logs Encryption

- You can encrypt CloudWatch logs with kms keys
- Encryption is enabled at the log group level, by associating a CMK with a log group either when you create the log group or after it exists
- You cannot associate a CMK with a log group using the CloudWatch console
- You must use the CloudWatch Logs API
    - associate-kms-key: if the log group already exists
    - create-log-group: if the log group doesn't exist yet

CodeBuild Security

- To access resources in your VPC, make sure you specify a VPC configuration for your CodeBuild
- Secrets in CodeBuild
    - Don't store them as plaintext in environment variables
    - Environment variables can reference parameter store parameters
    - Environment variables can reference secrets manager secrets

AWS Nitro Enclaves

- Process highly sensitive data in an isolated compute environment
    - Personally Identifiable information (PII), healthcare, financial
- Fully isolated virtual machines, hardened and highly constrained
    - Not a container; not persistent storage, no interactive access, no external networking
- Helps reduce the attack surface for sensitive data processing apps
    - Cryptographic Attestation -- only authorised code can be running in your Enclave
    - Only Enclaves can access sensitive data (integration with KMS)
- Use cases: securing private keys, processing credit cards, secure multi-party computation...

M
