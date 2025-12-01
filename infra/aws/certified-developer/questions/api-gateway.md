### 1. A developer wants to expose a backend Lambda function using API Gateway and have the entire HTTP request passed directly into the Lambda handler. Which integration type should they choose?  
A. AWS Service Integration  
B. Lambda non-proxy integration  
C. AWS_PROXY  
D. MOCK Integration  

---

### 2. A global application experiences high latency for users in Europe. The API Gateway endpoint is deployed in us-east-1. Which endpoint type improves performance without deploying APIs to multiple regions?  
A. Regional  
B. Private  
C. Edge-Optimized  
D. HTTP API  

---

### 3. A developer wants API Gateway to validate JSON body structure before invoking a Lambda backend. What feature should they enable?  
A. Mapping Templates  
B. Authorizers  
C. Request Validation  
D. Usage Plans  

---

### 4. A REST API method should return a predefined static JSON response for testing. No backend should be used. Which integration is appropriate?  
A. HTTP integration  
B. MOCK integration  
C. AWS Service integration  
D. HTTP_PROXY integration  

---

### 5. A Lambda authorizer is added to an API Gateway method. What does the authorizer primarily evaluate?  
A. Request throttling rules  
B. API usage quotas  
C. Custom authentication logic (JWT, OAuth, headers)  
D. Mapping template transformation rules  

---

### 6. A developer wants to reference an environment-specific database endpoint inside a Lambda function invoked by API Gateway. Which feature should they use?  
A. Lambda Layers  
B. Stage Variables  
C. Resource Policies  
D. Deployment History  

---

### 7. A client receives HTTP 429 errors from API Gateway. What is the most likely cause?  
A. Invalid JSON payload  
B. Missing API key  
C. Request throttling exceeded  
D. Backend integration timeout  

---

### 8. An API Gateway REST API needs to support SOAP backend services using JSON input from the client. Which feature enables this transformation?  
A. Usage Plans  
B. Mapping Templates (VTL)  
C. Lambda Authorizers  
D. AWS Service Proxy Integration  

---

### 9. Which API Gateway endpoint type requires a VPC Endpoint and is restricted by a resource policy?  
A. Regional  
B. Private  
C. Edge-Optimized  
D. HTTP API  

---

### 10. A company wants to limit each customer to 1,000 requests per day and require a unique key for access. Which combination provides this?  
A. Resource Policies + API Keys  
B. API Keys + Usage Plans  
C. Stage Variables + Cognito  
D. Lambda Authorizers + CloudWatch  

---

### 11. A REST API is deployed but the new changes are not visible to users. What did the developer likely forget?  
A. Create API Keys  
B. Regenerate SDK  
C. Deploy the API to a stage  
D. Add a Lambda authorizer  

---

### 12. A backend receives malformed requests because certain body fields need to be renamed before the request is forwarded. Which API Gateway feature solves this?  
A. Mapping Templates  
B. Request Validation  
C. Usage Plans  
D. X-Ray Tracing  

---

### 13. What is the maximum timeout for an API Gateway REST API integration?  
A. 10 seconds  
B. 15 seconds  
C. 20 seconds  
D. 30 seconds  

---

### 14. Which API Gateway type supports OAuth and OIDC natively and is lower cost with lower latency?  
A. REST API  
B. WebSocket API  
C. Private API  
D. HTTP API  

---

### 15. A WebSocket API routes messages based on information in the request body. What key does API Gateway use to determine the route?  
A. $message.route  
B. $request.action  
C. $request.body.action  
D. $websocket.route  

---

### 16. A developer wants to secure API Gateway access for internal AWS services only (no external users). Which option is the simplest?  
A. Cognito User Pools  
B. Lambda Authorizer  
C. IAM Authorization  
D. API Keys  

---

### 17. After enabling CORS, the browser still blocks requests from another domain. What is the MOST likely missing configuration?  
A. Allowing “X-API-Key” header  
B. Adding OPTIONS method response headers  
C. Adding Usage Plan permissions  
D. Enabling X-Ray tracing  

---

### 18. Which CloudWatch metric records backend latency only, excluding API Gateway processing time?  
A. Count  
B. Latency  
C. IntegrationLatency  
D. BackendTime  

---

### 19. A client calls API Gateway without an API key and receives 403 Forbidden. What is the likely cause?  
A. Throttling exceeded  
B. Missing IAM credentials  
C. API method requires an API key  
D. Invalid CORS configuration  

---

### 20. A developer wants full two-way communication for a real-time multiplayer game. Which API Gateway type is required?  
A. REST API  
B. HTTP API  
C. WebSocket API  
D. Private API  
