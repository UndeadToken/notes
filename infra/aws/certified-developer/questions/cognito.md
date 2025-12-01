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

---

### 26. What is the maximum number of custom attributes per user pool?
A. 10
B. 25
C. 50
D. 100

**Answer:** C
**Explanation:** User pools support up to 50 custom attributes.

---

### 27. Which Cognito feature provides temporary AWS credentials?
A. User Pools
B. Identity Pools (Federated Identities)
C. App Clients
D. Groups

**Answer:** B
**Explanation:** Identity Pools provide temporary AWS credentials for authenticated and unauthenticated users.

---

### 28. What is the maximum token validity period for ID tokens?
A. 5 minutes
B. 1 hour
C. 1 day
D. 30 days

**Answer:** C
**Explanation:** ID and access tokens can have validity from 5 minutes to 1 day.

---

### 29. Which Cognito authentication flow is most secure?
A. USER_PASSWORD_AUTH
B. USER_SRP_AUTH (Secure Remote Password)
C. CUSTOM_AUTH
D. ADMIN_NO_SRP_AUTH

**Answer:** B
**Explanation:** USER_SRP_AUTH uses Secure Remote Password protocol, never sending passwords over the network.

---

### 30. What is the purpose of Cognito Pre-Authentication Lambda trigger?
A. Run before authentication
B. Custom validation before allowing sign-in
C. Modify authentication
D. Log authentication

**Answer:** B
**Explanation:** Pre-Authentication trigger allows custom validation logic before allowing user sign-in.

---

### 31. Which Cognito feature allows custom authentication challenges?
A. MFA
B. Custom Authentication Flow (CUSTOM_AUTH)
C. Password policies
D. User migration

**Answer:** B
**Explanation:** CUSTOM_AUTH flow enables custom authentication challenges using Lambda triggers.

---

### 32. What is the maximum number of groups per user pool?
A. 100
B. 1,000
C. 10,000
D. Unlimited

**Answer:** C
**Explanation:** User pools support up to 10,000 groups.

---

### 33. Which Cognito token contains user attributes?
A. Access Token
B. ID Token
C. Refresh Token
D. Session Token

**Answer:** B
**Explanation:** ID Token contains user attributes (claims) as a JWT.

---

### 34. What is the purpose of Cognito Post-Confirmation Lambda trigger?
A. Confirm users
B. Run custom logic after user confirmation
C. Send confirmation emails
D. Validate confirmation

**Answer:** B
**Explanation:** Post-Confirmation trigger runs after user confirms registration (email/phone verification).

---

### 35. Which Cognito feature prevents brute force attacks?
A. MFA
B. Advanced Security Features (adaptive authentication)
C. Password policies
D. Account lockout

**Answer:** B
**Explanation:** Advanced Security Features detect and block suspicious sign-in attempts using risk scoring.

---

### 36. What is the maximum refresh token validity period?
A. 1 day
B. 30 days
C. 1 year
D. 10 years

**Answer:** D
**Explanation:** Refresh tokens can have validity from 1 hour to 10 years (3650 days).

---

### 37. Which Cognito identity provider supports SAML 2.0?
A. User Pools
B. Identity Pools
C. Both A and B
D. Neither

**Answer:** A
**Explanation:** User Pools support SAML 2.0 federation with enterprise identity providers.

---

### 38. What is the purpose of Cognito Pre-Token Generation Lambda trigger?
A. Generate tokens
B. Modify token claims before generation
C. Validate tokens
D. Encrypt tokens

**Answer:** B
**Explanation:** Pre-Token Generation trigger allows modifying or adding claims to ID and access tokens.

---

### 39. Which Cognito feature allows passwordless authentication?
A. MFA
B. Custom Authentication Flow with CUSTOM_CHALLENGE
C. Social sign-in
D. SAML

**Answer:** B
**Explanation:** Custom Authentication Flow with CUSTOM_CHALLENGE enables passwordless auth (magic links, biometrics, etc.).

---

### 40. What is the maximum number of users per user pool?
A. 10,000
B. 100,000
C. 1 million
D. 40 million

**Answer:** D
**Explanation:** User pools support up to 40 million users.

---

### 41. Which Cognito token is used to obtain new tokens?
A. ID Token
B. Access Token
C. Refresh Token
D. Session Token

**Answer:** C
**Explanation:** Refresh Token is used to obtain new ID and access tokens without re-authentication.

---

### 42. What is the purpose of Cognito User Migration Lambda trigger?
A. Migrate users between pools
B. Migrate users from existing system during sign-in
C. Export users
D. Import users

**Answer:** B
**Explanation:** User Migration trigger migrates users from existing systems during first sign-in without requiring password reset.

---

### 43. Which Cognito feature provides email/SMS verification?
A. MFA
B. User Pool Verification (email/phone)
C. Custom verification
D. Third-party verification

**Answer:** B
**Explanation:** User Pools provide built-in email and phone number verification.

---

### 44. What is the maximum number of app clients per user pool?
A. 10
B. 100
C. 1,000
D. 10,000

**Answer:** C
**Explanation:** User pools support up to 1,000 app clients.

---

### 45. Which Cognito authentication flow is used for server-side applications?
A. Implicit Grant
B. Authorization Code Grant
C. Client Credentials
D. Device Flow

**Answer:** B
**Explanation:** Authorization Code Grant is recommended for server-side applications (most secure).

---

### 46. What is the purpose of Cognito Identity Pool authentication providers?
A. Authenticate users
B. Map external identities to AWS credentials
C. Provide MFA
D. Verify emails

**Answer:** B
**Explanation:** Authentication providers (Cognito User Pools, Facebook, Google, SAML, OIDC) map external identities to temporary AWS credentials.

---

### 47. Which Cognito feature allows custom email/SMS messages?
A. Custom Message Lambda trigger
B. SES integration
C. SNS integration
D. Templates

**Answer:** A
**Explanation:** Custom Message Lambda trigger customizes email and SMS verification/MFA messages.

---

### 48. What is the maximum number of identity providers per user pool?
A. 10
B. 50
C. 100
D. 300

**Answer:** D
**Explanation:** User pools support up to 300 identity providers (SAML, OIDC, social).

---

### 49. Which Cognito feature prevents account enumeration attacks?
A. MFA
B. PreventUserExistenceErrors setting
C. Password policies
D. Rate limiting

**Answer:** B
**Explanation:** PreventUserExistenceErrors returns generic error messages to prevent attackers from discovering valid usernames.

---

### 50. What is the purpose of Cognito Define Auth Challenge Lambda trigger?
A. Define authentication
B. Determine next challenge in custom authentication flow
C. Validate challenges
D. Create challenges

**Answer:** B
**Explanation:** Define Auth Challenge trigger determines the next challenge in a custom authentication flow.

