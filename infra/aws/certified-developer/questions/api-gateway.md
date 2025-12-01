### 1. A developer wants to expose a backend Lambda function using API Gateway and have the entire HTTP request passed directly into the Lambda handler. Which integration type should they choose?  
A. AWS Service Integration  
B. Lambda non-proxy integration  
C. AWS_PROXY  
D. MOCK Integration  

**Answer:** C  
**Explanation:** AWS_PROXY (Lambda proxy integration) passes the entire HTTP request as-is to Lambda without transformation.

---

### 2. A global application experiences high latency for users in Europe. The API Gateway endpoint is deployed in us-east-1. Which endpoint type improves performance without deploying APIs to multiple regions?  
A. Regional  
B. Private  
C. Edge-Optimized  
D. HTTP API  

**Answer:** C  
**Explanation:** Edge-Optimized endpoints use CloudFront edge locations to cache and serve requests globally with lower latency.

---

### 3. A developer wants API Gateway to validate JSON body structure before invoking a Lambda backend. What feature should they enable?  
A. Mapping Templates  
B. Authorizers  
C. Request Validation  
D. Usage Plans  

**Answer:** C  
**Explanation:** Request Validation validates request body, headers, and query parameters against a defined schema before invoking the backend.

---

### 4. A REST API method should return a predefined static JSON response for testing. No backend should be used. Which integration is appropriate?  
A. HTTP integration  
B. MOCK integration  
C. AWS Service integration  
D. HTTP_PROXY integration  

**Answer:** B  
**Explanation:** MOCK integration returns a predefined response without calling any backend service.

---

### 5. A Lambda authorizer is added to an API Gateway method. What does the authorizer primarily evaluate?  
A. Request throttling rules  
B. API usage quotas  
C. Custom authentication logic (JWT, OAuth, headers)  
D. Mapping template transformation rules  

**Answer:** C  
**Explanation:** Lambda authorizers execute custom authentication/authorization logic using JWT tokens, OAuth, headers, or other custom mechanisms.

---

### 6. A developer wants to reference an environment-specific database endpoint inside a Lambda function invoked by API Gateway. Which feature should they use?  
A. Lambda Layers  
B. Stage Variables  
C. Resource Policies  
D. Deployment History  

**Answer:** B  
**Explanation:** Stage Variables act like environment variables and can be passed to Lambda functions to configure environment-specific settings.

---

### 7. A client receives HTTP 429 errors from API Gateway. What is the most likely cause?  
A. Invalid JSON payload  
B. Missing API key  
C. Request throttling exceeded  
D. Backend integration timeout  

**Answer:** C  
**Explanation:** HTTP 429 "Too Many Requests" indicates throttling limits have been exceeded (default 10,000 rps account limit).

---

### 8. An API Gateway REST API needs to support SOAP backend services using JSON input from the client. Which feature enables this transformation?  
A. Usage Plans  
B. Mapping Templates (VTL)  
C. Lambda Authorizers  
D. AWS Service Proxy Integration  

**Answer:** B  
**Explanation:** Mapping Templates using Velocity Template Language (VTL) can transform JSON to XML/SOAP and vice versa.

---

### 9. Which API Gateway endpoint type requires a VPC Endpoint and is restricted by a resource policy?  
A. Regional  
B. Private  
C. Edge-Optimized  
D. HTTP API  

**Answer:** B  
**Explanation:** Private endpoints are only accessible via VPC endpoints and controlled by resource policies.

---

### 10. A company wants to limit each customer to 1,000 requests per day and require a unique key for access. Which combination provides this?  
A. Resource Policies + API Keys  
B. API Keys + Usage Plans  
C. Stage Variables + Cognito  
D. Lambda Authorizers + CloudWatch  

**Answer:** B  
**Explanation:** API Keys identify clients and Usage Plans define quotas (requests per day) and throttling limits per key.

---

### 11. A REST API is deployed but the new changes are not visible to users. What did the developer likely forget?  
A. Create API Keys  
B. Regenerate SDK  
C. Deploy the API to a stage  
D. Add a Lambda authorizer  

**Answer:** C  
**Explanation:** Changes to API Gateway are not live until deployed to a stage (dev, test, prod, etc.).

---

### 12. A backend receives malformed requests because certain body fields need to be renamed before the request is forwarded. Which API Gateway feature solves this?  
A. Mapping Templates  
B. Request Validation  
C. Usage Plans  
D. X-Ray Tracing  

**Answer:** A  
**Explanation:** Mapping Templates can modify request/response structure, rename fields, and transform data before forwarding.

---

### 13. What is the maximum timeout for an API Gateway REST API integration?  
A. 10 seconds  
B. 15 seconds  
C. 20 seconds  
D. 30 seconds  

**Answer:** D  
**Explanation:** API Gateway has a maximum integration timeout of 29 seconds (often rounded to 30s in documentation).

---

### 14. Which API Gateway type supports OAuth and OIDC natively and is lower cost with lower latency?  
A. REST API  
B. WebSocket API  
C. Private API  
D. HTTP API  

**Answer:** D  
**Explanation:** HTTP API supports OAuth/OIDC natively, has lower latency, and is cheaper than REST API.

---

### 15. A WebSocket API routes messages based on information in the request body. What key does API Gateway use to determine the route?  
A. $message.route  
B. $request.action  
C. $request.body.action  
D. $websocket.route  

**Answer:** C  
**Explanation:** WebSocket API routes messages based on `$request.body.action` or a custom route selection expression.

---

### 16. A developer wants to secure API Gateway access for internal AWS services only (no external users). Which option is the simplest?  
A. Cognito User Pools  
B. Lambda Authorizer  
C. IAM Authorization  
D. API Keys  

**Answer:** C  
**Explanation:** IAM Authorization is the simplest for internal AWS services/users with IAM credentials.

---

### 17. After enabling CORS, the browser still blocks requests from another domain. What is the MOST likely missing configuration?  
A. Allowing "X-API-Key" header  
B. Adding OPTIONS method response headers  
C. Adding Usage Plan permissions  
D. Enabling X-Ray tracing  

**Answer:** B  
**Explanation:** CORS requires OPTIONS method with proper response headers (Access-Control-Allow-Methods, Access-Control-Allow-Headers, Access-Control-Allow-Origin).

---

### 18. Which CloudWatch metric records backend latency only, excluding API Gateway processing time?  
A. Count  
B. Latency  
C. IntegrationLatency  
D. BackendTime  

**Answer:** C  
**Explanation:** IntegrationLatency measures only the backend integration time, while Latency includes API Gateway processing time.

---

### 19. A client calls API Gateway without an API key and receives 403 Forbidden. What is the likely cause?  
A. Throttling exceeded  
B. Missing IAM credentials  
C. API method requires an API key  
D. Invalid CORS configuration  

**Answer:** C  
**Explanation:** HTTP 403 Forbidden when missing an API key indicates the method is configured to require an API key.

---

### 20. A developer wants full two-way communication for a real-time multiplayer game. Which API Gateway type is required?  
A. REST API  
B. HTTP API  
C. WebSocket API  
D. Private API  

**Answer:** C  
**Explanation:** WebSocket API provides full two-way real-time communication between client and server.  

---

### 21. What is the purpose of Canary deployments in API Gateway?
A. Test new API versions with a small percentage of traffic
B. Encrypt API requests
C. Monitor API performance
D. Cache API responses

**Answer:** A
**Explanation:** Canary deployments route a small percentage of traffic to a new deployment version for testing before full rollout.

---

### 22. Which API Gateway feature restricts access to specific AWS accounts or VPCs?
A. Usage Plans
B. Resource Policies
C. Lambda Authorizers
D. Stage Variables

**Answer:** B
**Explanation:** Resource Policies control which AWS accounts, VPCs, or IP ranges can access the API.

---

### 23. What is the default cache TTL for API Gateway caching?
A. 30 seconds
B. 60 seconds
C. 300 seconds (5 minutes)
D. 3600 seconds (1 hour)

**Answer:** C
**Explanation:** API Gateway caching has a default TTL of 300 seconds (5 minutes), configurable from 0 to 3600 seconds.

---

### 24. A custom domain name is configured for API Gateway. Which AWS service manages the SSL/TLS certificate?
A. IAM
B. ACM (AWS Certificate Manager)
C. KMS
D. Secrets Manager

**Answer:** B
**Explanation:** ACM (AWS Certificate Manager) provides and manages SSL/TLS certificates for custom domain names in API Gateway.

---

### 25. What does the $context variable provide in API Gateway mapping templates?
A. Database connection strings
B. Request and response metadata (request ID, source IP, stage, etc.)
C. Lambda function code
D. API deployment history

**Answer:** B
**Explanation:** $context provides runtime information like request ID, source IP, stage, resource path, HTTP method, and more for use in mapping templates and logging.

---

### 26. What is the default throttle limit for API Gateway REST APIs per account per region?
A. 1,000 requests per second
B. 5,000 requests per second
C. 10,000 requests per second
D. Unlimited

**Answer:** C
**Explanation:** Default steady-state limit is 10,000 requests per second with a burst of 5,000 requests.

---

### 27. Which API Gateway authorization type uses JWT tokens?
A. IAM
B. Cognito User Pools
C. Lambda Authorizer
D. API Keys

**Answer:** B
**Explanation:** Cognito User Pools use JWT tokens for authorization in API Gateway.

---

### 28. What is the maximum timeout for API Gateway Lambda integration?
A. 3 seconds
B. 15 seconds
C. 29 seconds
D. 5 minutes

**Answer:** C
**Explanation:** API Gateway has a maximum integration timeout of 29 seconds for all integrations including Lambda.

---

### 29. Which API Gateway feature allows real-time two-way communication?
A. REST API
B. HTTP API
C. WebSocket API
D. GraphQL API

**Answer:** C
**Explanation:** WebSocket API enables real-time, two-way communication between clients and backend.

---

### 30. What is the purpose of API Gateway Usage Plans?
A. Plan API development
B. Control and monitor API usage with throttling and quotas
C. Plan deployments
D. Monitor errors

**Answer:** B
**Explanation:** Usage Plans define throttling limits, quotas, and associate API keys with stages for access control.

---

### 31. Which API Gateway deployment type is cheaper and has lower latency?
A. REST API
B. HTTP API
C. WebSocket API
D. All same cost

**Answer:** B
**Explanation:** HTTP APIs are up to 71% cheaper and have lower latency than REST APIs.

---

### 32. What is the maximum payload size for API Gateway?
A. 1 MB
B. 6 MB
C. 10 MB
D. 100 MB

**Answer:** C
**Explanation:** Maximum payload size is 10 MB for both request and response.

---

### 33. Which API Gateway feature validates requests before reaching the backend?
A. Request Validators
B. Lambda Authorizers
C. Mapping Templates
D. Stage Variables

**Answer:** A
**Explanation:** Request Validators validate request parameters and body against a model before invoking the backend.

---

### 34. What is the purpose of API Gateway Mock Integration?
A. Test APIs
B. Return responses without calling backend
C. Mock data
D. All of the above

**Answer:** D
**Explanation:** Mock Integration returns static responses without invoking a backend, useful for testing and development.

---

### 35. Which API Gateway caching metric indicates cache effectiveness?
A. CacheHitCount and CacheMissCount
B. Latency
C. IntegrationLatency
D. Count

**Answer:** A
**Explanation:** CacheHitCount and CacheMissCount metrics show how effectively the cache is being used.

---

### 36. What is the maximum cache TTL for API Gateway?
A. 300 seconds
B. 3600 seconds (1 hour)
C. 86400 seconds (24 hours)
D. No limit

**Answer:** B
**Explanation:** Maximum cache TTL is 3600 seconds (1 hour).

---

### 37. Which API Gateway feature allows gradual traffic shifting?
A. Canary Deployments
B. Blue/Green Deployments
C. Rolling Deployments
D. A/B Testing

**Answer:** A
**Explanation:** Canary Deployments gradually shift traffic to a new deployment using percentage-based routing.

---

### 38. What is the purpose of API Gateway VPC Link?
A. Connect to internet
B. Private integration with resources in VPC
C. Connect VPCs
D. Monitor VPC traffic

**Answer:** B
**Explanation:** VPC Link enables private integration between API Gateway and resources in VPC (NLB, ALB, ECS).

---

### 39. Which API Gateway authorization type executes custom logic?
A. IAM
B. Cognito
C. Lambda Authorizer (Custom Authorizer)
D. API Keys

**Answer:** C
**Explanation:** Lambda Authorizers execute custom authorization logic using Lambda functions.

---

### 40. What is the difference between TOKEN and REQUEST Lambda Authorizers?
A. No difference
B. TOKEN receives token; REQUEST receives full request context
C. TOKEN is faster
D. REQUEST is more secure

**Answer:** B
**Explanation:** TOKEN authorizers receive only the auth token. REQUEST authorizers receive headers, query strings, stage variables, and request context.

---

### 41. Which API Gateway feature prevents API abuse?
A. Throttling and Usage Plans
B. Caching
C. CORS
D. Mapping Templates

**Answer:** A
**Explanation:** Throttling and Usage Plans limit request rates to prevent API abuse and control costs.

---

### 42. What is the purpose of API Gateway Binary Media Types?
A. Compress responses
B. Support binary payloads (images, PDFs, etc.)
C. Encrypt data
D. Convert formats

**Answer:** B
**Explanation:** Binary Media Types configuration allows API Gateway to handle binary payloads like images, PDFs, and videos.

---

### 43. Which API Gateway stage variable use case is most common?
A. Store secrets
B. Reference different backend endpoints per stage (dev, prod)
C. Store user data
D. Cache configuration

**Answer:** B
**Explanation:** Stage variables commonly reference different Lambda function versions or backend endpoints for different stages.

---

### 44. What is the maximum number of stages per API?
A. 5
B. 10
C. 50
D. Unlimited

**Answer:** B
**Explanation:** Maximum of 10 stages per API in API Gateway.

---

### 45. Which API Gateway integration type provides the most control over request/response transformation?
A. Lambda Proxy
B. Lambda Custom (non-proxy)
C. HTTP Proxy
D. AWS Service

**Answer:** B
**Explanation:** Lambda Custom integration provides full control over request/response transformation using mapping templates.

---

### 46. What is the purpose of API Gateway Access Logging?
A. Log API calls to CloudWatch Logs
B. Monitor performance
C. Debug issues
D. All of the above

**Answer:** D
**Explanation:** Access Logging sends detailed logs to CloudWatch for monitoring, debugging, and compliance.

---

### 47. Which API Gateway feature enables cross-origin requests?
A. CORS (Cross-Origin Resource Sharing)
B. IAM
C. API Keys
D. Resource Policies

**Answer:** A
**Explanation:** CORS configuration allows API Gateway to accept requests from different domains.

---

### 48. What is the maximum number of resources per REST API?
A. 100
B. 300
C. 500
D. 1,000

**Answer:** B
**Explanation:** Maximum of 300 resources per REST API.

---

### 49. Which API Gateway metric indicates backend performance?
A. Latency
B. IntegrationLatency
C. Count
D. 4XXError

**Answer:** B
**Explanation:** IntegrationLatency measures the time between API Gateway sending a request to the backend and receiving a response.

---

### 50. What is the purpose of API Gateway Resource Policies?
A. Control access to API
B. Define who can invoke API (cross-account, IP restrictions, VPC endpoints)
C. Monitor resources
D. Manage deployments

**Answer:** B
**Explanation:** Resource Policies control who can invoke the API, supporting cross-account access, IP whitelisting, and VPC endpoint restrictions.

