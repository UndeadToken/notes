Cognito

- Give users an identity to interact with our ebook or mobile application
- Cognito User Pools:
    - Sign in functionality for app users
    - Integrate with API Gateway & Application Load Balancer
- Cognito Identity Pools (Federated Identity):
    - Provide AWS credentials to users so they can access AWS resources directly
    - Integrate with Cognito User Pools as an identity provider
- Cognito vs IAM: hundreds of users, mobile users, authenticate with SAML

Cognito User Pools (CUP)

- Create a serverless database of users for your web & mobile apps
- Simple login: Username (or email) / password combination
- Password reset
- Email & Phone Number Verification
- Multi-factor authentication (MFA)
- Federated identities: users from Facebook, Google, SAML…
- Feature: block users if their credentials are compromised elsewhere
- Login sends back a JSON Web Token (JWT)

Mobile App, Web App -> Cognito User Pools -> Database of users

Federation through Third Party Identity Provider (IdP)
- SAML, Google, Facebook, OpenID Connect

Integrations

- CUP integrates with API Gateway and Application Load Balancer
- Client -> Cognito User Pool
- Client -> API Gateway -> Cognito User Pool (Evaluate) -> API Gateway -> Lambda
- Client -> ALB + Listeners & Rules -> Backend Target Group

Lambda Triggers

- CUP can invoke a Lambda function synchronously on these triggers:
    - Authentication Events:
        - Pre Authentication Lambda Trigger: Custom validation to accept or deny the sign-in request
        - Post Authentication Lambda Trigger: Event logging for custom analytics
        - Pre Token Generation Lambda Trigger: Augment or suppress token claims
    - Sign Up:
        - Pre Sign-up Lambda Trigger: Custom welcome messages or event logging for custom analytics
        - Post Confirmation Lambda Trigger: Custom welcome messages or event logging for custom analytics
        - Migrate user Lambda Trigger: Migrate a user from an existing user directory to user pools
    - Messages:
        - Custom Message Lambda Trigger: Migrate a user from an existing user directory to user pools
    - Token Creation:
        - Pre Token generation Lambda Trigger: Add or remove attributes in Id tokens

[Reference](https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html)

Hosted Authentication UI

- Cognito has a hosted authentication UI for sign-up and sign-in workflows
- Supports social logins, OIDC or SAML
- Can customise with a logo and CSS
- Custom domains require ACM certificate in us-east-1
- Custom domain must be defined in “App Integration” section

Adaptive Authentication

- Block sign-ins or require MFA if login appears suspicious
- Cognito generates a risk score (low, medium, high) per sign-in attempt
- Users prompted for second MFA only if risk detected
- Risk score considers device, location, IP address, and previous login patterns
- Checks for compromised credentials, account takeover protection, and phone/email verification
- Integrates with CloudWatch logs for analytics

ID Token / JWT

- CUP issues JWT token (Base64 encoded):
    - Header, Payload, Signature
- Signature must be verified
- Payload contains user info: sub UUID, given_name, email, phone_number, attributes

Application Load Balancer Authentication

- ALB can offload authentication to Cognito or IdP
- Authenticate through:
    - Identity Provider (OIDC)
    - Cognito User Pools (social or corporate IdPs)
- Requires HTTPS listener
- OnUnauthenticatedRequest: authenticate (default), deny, allow

Auth through Cognito User Pools

- Create Cognito User Pool, Client, and Domain
- Ensure ID token is returned
- Add social or corporate IdP if needed
- URL redirections required
- Allow Cognito User Pool Domain on IdP app’s callback URLs:
    - https://domain-prefix.auth.region.amazoncognito.com/saml2/idpresponse
    - https://user-pool-domain/oauth2/idpresponse 

OIDC Auth

- Client -> ALB -> Auth endpoint
- Client -> ALB -> Token Endpoint
- ALB -> User Info Endpoint
- Redirect request to app (e.g., ECS)
- Configure Client ID & Client Secret
- Redirect from OIDC to ALB DNS name and CNAME

Cognito Identity Pools (Federated Identities)

- Provide temporary AWS credentials for users outside AWS environment
- Identity sources can include:
    - Public providers (Amazon, Facebook, Google, Apple)
    - Cognito User Pools
    - OpenID Connect & SAML providers
    - Developer Authenticated Identities (custom login server)
- Supports unauthenticated (guest) access
- Users can access AWS services directly or via API Gateway
- IAM policies applied via Cognito; can be user-specific using policy variables

IAM Roles

- Default IAM roles for authenticated and guest users
- Rules define role assignment per user ID
- Policy variables allow fine-grained access

Cognito User Pools vs Identity Pools

- **User Pools** (Authentication):
    - Database for web/mobile users
    - Federate logins via social, OIDC, SAML
    - Hosted UI customization
    - Lambda triggers during authentication
    - Adaptive authentication & MFA
- **Identity Pools** (Authorization):
    - Obtain AWS credentials for users
    - Supports social, OIDC, SAML & Cognito User Pools
    - Guest access
    - IAM roles mapped to users with policy variables
- **CUP + CIP = authentication + authorization**
