Cognito

- Give users an identity to interact with our ebook or mobile application
- Cognito User Pools:
    - Sign in functionality for app users
    - Integrate with API Gateway & Application Load Balancer
- Cognito Identity Pools (Federated Identity)
    - Provide AWS credentials to users so they can access AWS resources directly
    - Integrate with Cognito User Pools as an identity provider
- Cognito vs IAM: hundreds of users, mobile users, authenticate with SAML

Cognito User Pools (CUP)

- Create a server less database of user for your web & mobile apps
- Simple login: Username (or email) / password combination
- Password reset
- Email & Phone Number Verification
- Multi-factor authentication (MFA)
- Federated identities: users from Facebook, Google, SAML…
- Feature: block users if their credentials are compromised elsewhere
- Login sends back. A JSON Web Token (JWT)

Mobile App, Web App -> Cognito User Pools -> Database of users

Federation through Third Party Identity Provider (IdP)
(SAML, Google, Facebook, OpenID Connect)

Integrations

- CUP integrates with API Gateway and Application Load Balancer

Client -> Cognito User Pool
Client -> Api Gateway -> Cognito User Pool (Evaluate) -> API Gateway to e.g. Lambda

Client -> ALB + Listeners & Rules -> Backend Target Group

Lambda Triggers

- CUP can invoke a Lambda function synchronously on these triggers

- Authentication Events
    - Pre Authentication Lambda Trigger
        - Custom validation to accept or deny the sign-in request
    - Post Authentication Lambda Trigger
        - Event logging for custom analytics
    - Pre Token Generation Lambda Trigger
        - Augment or suppress token claims

- Sign Up
    - Pre Sign-up Lambda Trigger
        - Custom welcome messages or event logging for custom analytics
    - Post Confirmation Lambda Trigger
        - Custom welcome messages or event logging for custom analytics
    - Migrate user Lambda Trigger
        - Migrate a user from an existing user directory to user pools

- Messages
    - Custom Message Lambda Trigger
        - Migrate a user from an existing user directory to user pools

- Token Creation
    - Pre Token generation Lambda Trigger
        - Add or remove attributes in Id tokens

https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-identity-pools-working-with-aws-lambda-triggers.html

Hosted Authentication UI

- Cognito has a hosted authentication UI that you can add to your app to handle sign-up and sign-in workflows
- Using the hosted UI, you have a foundation for integration with social logins, OIDC or SAML
- Can customise with a custom logo and custom CSS

- For custom domains, you must create an ACM certificate in us-east-1
- The custom domain must be defined in the “App Integration section”

Adaptive Authentication

- Block sign-ins or require MFA if the login appears suspicious
- Cognito examines each sign-in attempt and generates a risk score (low, medium, high) for how likely the sign-in request is to be from a malicious attacker
- Users are prompted for a second MFA only when risk is detected
- Risk score is based on different factors such as if the user has used the same, device, location or IP Address
- Checks for compromised credentials, account takeover protection, and phone and email verification 
- Integration with CloudWatch logs (sign-in attempts, risk score, failed challenges…)

ID Token; JWT — JSON Web Token

- CUP issues a JWT token (Base64 encoded)
    - Header
    - Payload
    - Signature
- The signature must be verified to ensure the JWT can be trusted
- Libraries can help you verify the validity of JWT tokens issued by Cognito User Pools
- The Payload will contain the user information (sub UUID, given_name, email, phone_number, attributes…)

Application Load Balancer — User Authentication

- Your Application Load Balancer can securely authenticate users
    - Offload the work of authentication users to your load balancer
    - Your applications can focus on their business logic
- Authenticate users through:
    - Identity Provider (IdP): OpenIP Connect (OIDC) compliant
    - Cognito User Pools:
        - Social IdPs, such as Amazon, Facebook, or Google
        - Corporate identities using SAML, LDAP, or Microsoft AD
- Must use an HTTPS listener to set authenticate-oidc & authenticate-cognito rules
- OnUnauthenticatedRequest — authenticate (default), deny, allow

Auth through Cognito User Pools

- Create Cognito User Pool, Client and Domain
- Make sure an ID token is returned
- Add the social or Corporate IdP if needed
- Several URL redirections are necessary
- Allow your Cognito User Pool Domain on your IdP app’s callback URL for example:
    - https://domain-prefix.auth.region.amazoncognito.com/saml2/idpresponse
    - https://user-pool-domain/oauth2/idpresponse 

OIDC Auth

Client -> ALB 
Client -> Auth endpoint
Client -> ALB -> Token Endpoint
ALB -> User Info Endpoint
Redirect request to e.g. ECS

Auth through an identity provider (IdP) that is OpenID Connect (OIDC) Compliant

- Configure a Client ID & Client Secret
- Allow redirect from OIDC to your Application Load Balancer DNS name (AWS provided) and CNAME (DNS Alias of your app)
    - https://DNS/oauth2/idpresponse
    - https://CNAME/oauth2/idpresponse

Cognito Identity Pools (Federated Identities)

- Users outside of AWS environment and want access to resources like DynamoDB
- Get identities for “users” so they obtain temporary AWS credentials
- Your identity pool (e.,g. Identity source) can include
    - Public Providers (Login with Amazon, Facebook, Google, Apple)
    - Users in an Amazon Cognito User pool
    - OpenID Connect Providers & SAML Identity Providers
    - Developer Authenticated Identities (custom login server)
    - Cognito Identity Pools allow for unauthenticated (guest) access

- Users can then access AWS services directly or through API Gateway
    - The IAM policies applied to the credentials are defined in Cognito
    - They can be customised based on the user_id for fine grained control

IAM Roles

- Default IAM Roles for authenticated and guest users
- Define rules to choose the role for each user based on the user’s ID
- You can partition your users’ access using policy variables

Cognito User Pools vs Cognito Identity Pools

- Cogntio User Pools (for authentication = identity verification)
    - Database of users for your web and mobile application
    - Allows to federate logins through Public Social, OIDC, SAML…
    - Can customise the hosted UI for authentication (including the logo)
    - Has triggers with AWS Lambda during the authentication flow
    - Adapt the sign-in experience to different risk levels (MFA, adaptive authentication, etc…)
- Cognito Identity Pools (for authorization = access control)
    - Obtain AWS credentials for your users
    - Users can login through Public Social, OIDC, SAML & Cognito User Pools
    - Users can be unauthenticated (guests)
    - Users are mapped to IAM roles & policies can leverage policy variables
- CUP + CIP = authentication + authorization

