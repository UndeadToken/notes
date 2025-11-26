# API Gateway Overview
- Acts as a proxy: `Client -> API Gateway -> Lambda / HTTP / AWS Services -> Backend (DB, SQS, S3…)`
- Key benefits:
  - Serverless, no infrastructure to manage (Lambda + API Gateway)
  - Supports WebSocket for real-time apps
  - API versioning and multiple environments (dev/test/prod)
  - Security: Authentication & Authorization
  - Request throttling, API Keys, caching
  - Swagger/OpenAPI import
  - Request/response transformation and validation
  - SDK generation

---

## Integration Types

| Type                  | Description                                                                                  | Notes |
|-----------------------|----------------------------------------------------------------------------------------------|-------|
| **Lambda Function**    | Expose REST API backed by Lambda                                                             | Can use proxy or non-proxy integration |
| **HTTP**               | Forward API requests to internal HTTP endpoints or ALB                                       | Can add auth, throttling, caching |
| **AWS Service**        | Invoke AWS service APIs (SQS, Step Functions, Kinesis…)                                      | Can secure, throttle, expose publicly |
| **AWS_PROXY**          | Lambda proxy: request passed as-is to Lambda                                                | No mapping templates needed |
| **HTTP_PROXY**         | HTTP request passed as-is to backend                                                        | Optional headers |
| **MOCK**               | API Gateway returns a predefined response without backend                                   | Useful for testing |

---

## Endpoint Types
- **Edge-Optimized**: For global clients; uses CloudFront; only one region.
- **Regional**: For same-region clients; can manually add CloudFront.
- **Private**: Access via VPC endpoint only; controlled by resource policy.

---

## Security
- **IAM Roles**: Internal AWS users/services.
- **Cognito User Pools**: Managed user identity for external users; automatic token verification.
- **Lambda Authorizer**: Custom logic (JWT, OAuth, headers) for authentication/authorization.
- **Custom Domain & HTTPS**: Use ACM; certificate region depends on endpoint type.

---

## Deployment Stages
- Changes are not live until deployed to a stage.
- Stages: `dev`, `test`, `prod` (custom names allowed).
- Stage variables act like environment variables:
  - Passed to Lambda via `${stageVariables.variableName}`
  - Can configure Lambda alias or endpoint per stage
- Canary Deployments:
  - Gradual traffic split between versions
  - Separate logs/metrics
  - Override stage variables for canary

---

## Mapping Templates
- Modify requests/responses (rename fields, convert JSON↔XML, add headers)
- Uses **Velocity Template Language (VTL)**
- Supports SOAP integration with JSON clients

---

## API Definition
- OpenAPI (Swagger) import/export supported
- Can define REST methods, requests, responses
- Enables SDK generation
- Request validation reduces unnecessary backend calls

---

## Caching
- Reduce backend calls, configurable TTL (0–3600s)
- Cache capacity: 0.5GB–237GB
- Can flush cache manually or via `Cache-Control` header
- Can be expensive, best for prod

---

## Usage Plans & API Keys
- Control access, rate, and quota for customers
- API Keys: alphanumeric, distributed to clients
- Steps:
  1. Configure API methods to require API key
  2. Deploy API
  3. Generate/distribute API keys
  4. Create usage plan, associate stages and keys

---

## Logging, Tracing & Metrics
- **CloudWatch Logs**: Request/response body, log level per stage
- **X-Ray**: Tracing for Lambda + API Gateway
- Metrics: Count, Latency, IntegrationLatency, 4XX/5XX errors, Cache hits/misses

---

## Throttling
- Account limit: 10,000 rps total
- Stage/method limits or usage plans for finer control
- 429 response on throttling

---

## Error Codes
- **4XX**: Client errors (400 Bad Request, 403 Access Denied, 429 Throttle)
- **5XX**: Server errors (502 Bad Gateway, 503 Service Unavailable, 504 Integration Timeout)
- Maximum API Gateway timeout: 20s

---

## CORS
- Required for cross-domain calls
- OPTIONS request must include:
  - `Access-Control-Allow-Methods`
  - `Access-Control-Allow-Headers`
  - `Access-Control-Allow-Origin`
- Can enable via console

---

## HTTP API vs REST API

| Feature                  | HTTP API                   | REST API                          |
|---------------------------|---------------------------|----------------------------------|
| Cost & latency            | Cheaper, low latency       | Higher                            |
| Lambda/HTTP proxy         | Yes                        | Yes                               |
| Usage plans/API Keys       | No                         | Yes                               |
| OAuth/OIDC support         | Yes                        | No (native)                       |
| Resource policies          | No                         | Yes                               |

---

## WebSocket API
- Two-way communication (browser ↔ server)
- Common for chat, multiplayer games, collaboration tools
- Routes messages via `$request.body.action` or `$default`
- Backend: Lambda, DynamoDB, HTTP endpoints

---

## Architecture Patterns
- Single API Gateway as entry point for microservices
- Use domain names, SSL certs, forwarding, transformation at API Gateway
- Example routing:
  - `/service1 -> ELB -> ECS`
  - `/service2 -> ALB -> EC2`
  - `/docs -> S3`
