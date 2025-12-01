### 1. Which Cognito service provides authentication (sign-in/sign-up) for web and mobile apps?
A. Cognito Identity Pools
B. Cognito User Pools
C. Cognito Sync
D. Cognito Streams

**Answer:** B
**Explanation:** Cognito User Pools provide authentication with username/password, MFA, and federated identities.

---

### 2. Which Cognito service provides temporary AWS credentials to access AWS resources?
A. Cognito User Pools
B. Cognito Identity Pools (Federated Identities)
C. Cognito Sync
D. IAM

**Answer:** B
**Explanation:** Cognito Identity Pools provide temporary AWS credentials for users to access services like S3, DynamoDB.

---

### 3. What token format does Cognito User Pools return after successful authentication?
A. SAML
B. OAuth
C. JWT (JSON Web Token)
D. API Key

**Answer:** C
**Explanation:** Cognito User Pools return JWT tokens (ID token, access token, refresh token).

---

### 4. Which Cognito User Pool trigger runs custom validation before sign-in?
A. Pre Authentication
B. Post Authentication
C. Pre Sign-up
D. Post Confirmation

**Answer:** A
**Explanation:** Pre Authentication Lambda trigger validates and accepts/denies sign-in requests.

---

### 5. An application needs to authenticate users via Google and Facebook. Which Cognito feature supports this?
A. MFA
B. Federated Identities
C. User Groups
D. Custom Attributes

**Answer:** B
**Explanation:** Cognito supports federated identities from social providers (Google, Facebook, Apple) and SAML/OIDC.

---

### 6. Which service can Cognito User Pools integrate with for authentication?
A. API Gateway only
B. Application Load Balancer only
C. Both API Gateway and ALB
D. Neither

**Answer:** C
**Explanation:** Cognito User Pools integrate with both API Gateway and ALB for authentication.

---

### 7. What is the purpose of Cognito Adaptive Authentication?
A. Encrypt user data
B. Detect suspicious sign-ins and require MFA
C. Sync user data across devices
D. Manage user groups

**Answer:** B
**Explanation:** Adaptive Authentication generates risk scores and prompts for MFA on suspicious sign-ins.

---

### 8. Which Cognito Identity Pool feature allows unauthenticated access?
A. Anonymous access
B. Guest access
C. Public access
D. Open access

**Answer:** B
**Explanation:** Identity Pools support guest (unauthenticated) access with limited IAM permissions.

---

### 9. A Cognito User Pool needs a custom domain. Where must the ACM certificate be located?
A. Same region as User Pool
B. us-east-1
C. Any region
D. eu-west-1

**Answer:** B
**Explanation:** Custom domains for Cognito User Pools require ACM certificates in us-east-1.

---

### 10. Which IAM policy variable allows row-level access control in DynamoDB via Cognito?
A. ${cognito:username}
B. ${aws:userid}
C. ${cognito-identity.amazonaws.com:sub}
D. ${dynamodb:LeadingKeys}

**Answer:** C
**Explanation:** Use ${cognito-identity.amazonaws.com:sub} in IAM policies for fine-grained access control.

---

### 11. What is the maximum number of custom attributes per Cognito User Pool?
A. 10
B. 25
C. 50
D. 100

**Answer:** C
**Explanation:** Cognito User Pools support up to 50 custom attributes.

---

### 12. Which Cognito User Pool feature blocks sign-ins if credentials are compromised elsewhere?
A. MFA
B. Adaptive Authentication
C. Compromised Credentials Protection
D. Account Takeover Protection

**Answer:** C
**Explanation:** Cognito can detect and block compromised credentials found in data breaches.

---

### 13. An ALB authenticates users via Cognito. What header contains the user information?
A. X-Amzn-User-Id
B. X-Amzn-OIDC-Data
C. X-Forwarded-User
D. Authorization

**Answer:** B
**Explanation:** ALB passes user claims in X-Amzn-OIDC-Data header after Cognito authentication.

---

### 14. Which Cognito User Pool trigger modifies JWT token claims before generation?
A. Pre Token Generation
B. Post Authentication
C. Pre Authentication
D. Custom Message

**Answer:** A
**Explanation:** Pre Token Generation trigger adds or suppresses token claims.

---

### 15. What is the default token expiration for Cognito ID tokens?
A. 5 minutes
B. 1 hour
C. 24 hours
D. 30 days

**Answer:** B
**Explanation:** ID tokens expire after 1 hour by default (configurable 5 min - 24 hours).

---

### 16. Which Cognito feature allows customizing email and SMS messages?
A. Custom Message Lambda trigger
B. Message templates
C. SNS integration
D. SES integration

**Answer:** A
**Explanation:** Custom Message Lambda trigger customizes verification and MFA messages.

---

### 17. A mobile app needs to sync user preferences across devices. Which Cognito feature helps?
A. Cognito User Pools
B. Cognito Identity Pools
C. Cognito Sync
D. AppSync

**Answer:** C
**Explanation:** Cognito Sync synchronizes user data across devices (deprecated, use AppSync instead).

---

### 18. Which identity provider protocol does Cognito User Pools support?
A. SAML 2.0 and OIDC
B. LDAP
C. Kerberos
D. RADIUS

**Answer:** A
**Explanation:** Cognito User Pools support SAML 2.0 and OpenID Connect (OIDC) identity providers.

---

### 19. What happens when a Cognito refresh token expires?
A. User is automatically re-authenticated
B. User must sign in again
C. New refresh token is issued
D. Access token remains valid

**Answer:** B
**Explanation:** When refresh tokens expire, users must sign in again to obtain new tokens.

---

### 20. Which Cognito User Pool feature allows grouping users for access control?
A. User Attributes
B. User Groups
C. User Pools
D. Identity Pools

**Answer:** B
**Explanation:** User Groups allow assigning IAM roles and organizing users for access control.

---

### 21. What is the Cognito Hosted UI used for?
A. Managing user pools
B. Providing ready-to-use sign-in/sign-up pages
C. Monitoring authentication
D. Configuring identity providers

**Answer:** B
**Explanation:** Hosted UI provides customizable, ready-to-use authentication pages without building custom UI.

---

### 22. Which Cognito User Pool feature allows different apps to have different permissions?
A. User Groups
B. App Clients
C. Identity Pools
D. Resource Servers

**Answer:** B
**Explanation:** App Clients represent different applications accessing the User Pool with specific read/write attribute permissions.

---

### 23. Which Lambda trigger migrates users from an existing user directory to Cognito?
A. Pre Authentication
B. User Migration
C. Pre Sign-up
D. Post Confirmation

**Answer:** B
**Explanation:** User Migration trigger allows lazy migration of users from existing systems during sign-in.

---

### 24. What is Cognito Advanced Security Features used for?
A. Encrypting user data
B. Risk-based adaptive authentication and compromised credential detection
C. Managing user groups
D. Syncing data across devices

**Answer:** B
**Explanation:** Advanced Security Features provide risk scoring, adaptive authentication, and compromised credential checks.

---

### 25. How can you revoke Cognito tokens before they expire?
A. Delete the user
B. Call GlobalSignOut or AdminUserGlobalSignOut
C. Change user password
D. Tokens cannot be revoked

**Answer:** B
**Explanation:** GlobalSignOut (user) or AdminUserGlobalSignOut (admin) invalidates all tokens for a user.
