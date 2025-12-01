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
