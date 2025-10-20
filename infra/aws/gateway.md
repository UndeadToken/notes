API Gateway

API Gateway proxy requests:
Client -> API Gateway -> Lambda -> DynamoDB

- AWS Lambda + API Gateway: No infrastructure to manage
- Support for the WebSocket Protocol
- Handle API versioning (v1, v2 …)
- Handle different environments (dev, test, prod…)
- Handle security (Authentication and Authorization)
- Create API Keys, handle request throttling
- Swagger / OpenAPI import to quickly define APIs
- Transform and validate requests and responses
- Generate SDK and API specifications
- Cache API responses

Integrations High Level

- Lambda Function
    - Invoke Lambda function
    - Easy way to expose REST API backend by AWS Lambda
- HTTP
    - Expose HTTP endpoints in the backend
    - Example: internal HTTP API on premise, Application Load Balancer …
    - Why? Add rate limiting, caching, user authentications, API keys, etc…
- AWS Service
    - Expose any AWS API through the API Gateway
    - Example: start an AWS Step Function workflow, post a message to SQS
    - Why? Add authentication, deploy publicly, rate control

AWS Service Integration Kinesis Data Streams

Client -> API gateway -> Kinesis Data Streams -> Kinesis Firehose -> Amazon S3

Endpoint Types

- Edge-Optimized (default) for global clients
    - Requests are routed through the CloudFront Edge locations (improves latency)
    - The API Gateway still lives in only one region
- Regional:
    - For clients within the same region
    - Could manually combine with CloudFront (more control over the caching strategies and the distribution)
- Private:
    - Can only be accessed from your VPC using an interface VPC endpoint (ENI)
    - Use a resource policy to define access

Security

- User Authentication through
    - IAM Roles (useful for internal applications)
    - Cognito (identity for external users — example mobile users)
    - Custom Authoriser (your own logic)
- Custom Domain Name HTTPS security through integration with AWS
    - Certificate Manager (ACM)
        - If using Edge-Optimized endpoint, then the certificate must be in us-east-1
        - If using Regional endpoint, the certificate must be in the API Gateway Region
        - Must setup CNAME or A-alias record in Route 53

Deployment Stages

- Making changes in the API gateway does not mean they’re effective
- You need to make a “deployment for them to be in effect”
- It’s a common source of confusion
- Changes are deployed to “stages” (as many as you want)
- Use the naming you like for stages (dev, test, prod)
- Each stage has its own configuration parameters
- Stages can be rolled back as a history of deployments is kept

V1 client -> v1Stage -> Lambda v1
V1 client -> v2Stage -> Lambda v2

Stage Variables

- Stage variables are like environment variables for API gateway
- Use them to change often changing configuration values
- They can be used in 
    - Lambda function ARN
    - HTTP Endpoint
    - Parameter mapping templates
- Use cases:
    - Configure http endpoints your stages talk to (dev, prod, test…)
    - Pass configuration parameters to AWS Lambda through mapping templates
- Stage variables are passed to the “context” object in AWS Lambda
- Format:${stageVariables.variableName}

- We create a stage variable to indicate the corresponding Lambda alias
- Our API gateway will automatically invoke the right lambda function

Prod Stage -> prod Alias -> 95% -> v1
.. -> 5% -> v2

Test Stage -> Test Alias -> 100% -> v2

Dev Stage -> Dev Alias -> 100% -> $LATEST

Canary Deployments

- Possibility to enable canary deployments for any stage (usually prod)
- Choose the % of traffic the canary channel receives
- Metrics & Logs are separate (for better monitoring)
- Possibility to override stage variables for canary 
- This is blue / green deployments with AWS Lambda & API Gateway

Integration Types

- Integration Type MOCK
    - API Gateway returns a response without sending the request to the backend
- Integration Type HTTP / AWS (Lambda & AWS Services)
    - You must configure both the integration request and integration response
    - Setup data mapping using mapping template for the request & response

Client -> API Gateway + Mapping Templates -> SQS

- Integration Type AWS_PROXY (Lambda Proxy)
    - Incoming request from the client is the input to Lambda
    - The function is responsible for the logic of request / response
    - No mapping template, headers, query string parameters … are passed as arguments
- Integration Type HTTP_PROXY
    - No mapping template
    - The HTTP request is passed to the backend
    - The HTTP response from the backend is forwarded by API Gateway
    - Possibility to add HTTP Headers if need be (ex: API Key)

Client -> API Gateway -> (HTTP_PROXY) ALB

Mapping Templates

- Mapping templates can be used to modify request / responses
- Rename / Modify query string parameters
- Modify body content
- Add headers
- Uses Velocity Template Language (VTL): for loop, if etc…
- Filter output results (remove unnecessary data)
- Content-Type can be set to application/json or application/xml

JSON to XML with SOAP

- SOAP API are XML based, whereas REST API are JSON based

Client -> API Gateway + Mapping Template -> (XML Payload) SOAP API

In this case, API Gateway should:
- Extract data from the request: either path, payload or header
- Build SOAP message based on request data (mapping template)
- Call SOAP service and receive XML response
- Transform response to desired format (like JSON), and respond to the user

Query String Parameters

- http://example.com/path?name=foo&other=bar
- {“my_variable”: “foo”, “other_variable”: “bar”}

API Gateway — Open API Spec

- Common way of defining REST APIs using API definition as code
- Import existing OpenAPI 3.0 spec to API Gateway
    - Method
    - Method Request 
    - Integration Request
    - Method Response
    - + AWS extensions for API gateway and setup every single option
- Can export current API as OpenAPI spec
- OpenAPI specs can be written in YAML or JSON
- Using OpenAPI we can generate SDK for our applications

Request Validation

- You can configure API Gateway to perform basic validation of an API request before proceeding with the integration request
- When the validation fails, API Gateway immediately fails the request
    - Returns a 400-error response to the caller
- This reduces unnecessary response to the caller
- Checks:
    - The required request parameters in the URI, query string and headers of an incoming request are included and non-blank
    - The applicable request payload adheres to the configured JSON Scheme request model of the method

    - Setup request validation by importing OpenAPI definitions file

Caching API responses

- Caching reduces the number of calls made to the backend
- Default TTL is 330 secs min 0s max 3600s
- Possible to override cache settings per method
- Cache encryption option
- Cache capacity between 0.5GB to 237GB
- Cache is expensive, makes sense in production may not Mae sense in dev / test

Cache Invalidation

- Able to flush the entire cache (invalidate it) immediately 
- Clients can invalidate the cache with header: Cache-Control: max-age=0 with proper IAM authorization
- If you don’t impose an InvalidateCache policy or choose the Require authorization check box in the console any client can invalidate the API cache

Usage Plans & API Keys

- If you want to make an API available as an offering to your customers
- Usage Plan:
    - Who can access one or more deployed API stages and methods
    - How much and how fast they can access them
    - Uses API keys to identify API clients and meter access
    - Configure throttling limits and quota limits that are enforced on individual client
- API Keys
    - Alphanumeric string values to distribute to your customers
    - Can use with usage plans to control access
    - Throttling limits are applied to the API keys
    - Quotas limits is the overall number of maximum requests

Correct Order for API Keys

- To configure a usage plan
    - Create one or more APIs configure the methods to require an API key and deploy the APIs to stage
    - Generate or import API keys to distribute to application developers (your customers) who will be using your API
    - Create the usage plan with the desired throttle and quota limits
    - Associate API stages and API keys with the usage plan
    - Callers of the API must supply an assigned API key in the x-api-key header in requests to the api

Logging & Tracing

- CloudWatch Logs
    - Log contains information about request/response body
    - Enable CloudWatch logging at the Stage level (with Log Level — ERROR, DEBUG, INFO)
    - Can override settings on a per API basis
- X-Ray
    - Enable tracing to get extra information about requests in API Gateway
    - X-Ray API Gateway + AWS Lambda gives you the full picture

CloudWatch Metrics

- Metrics are by stage, possibility to enable detailed metrics
- CacheHitCount & CacheMissCount: efficiency of the cache
- Count: the total number of API requests in a given period
- IntegrationLatency: The time between when API Gateway relays a request to the backend and when it receives a response from the backend
- Latency: The time between when API Gateway receives a request from a client and when it returns a response to the client. The latency includes the integration latency and other API Gateway overhead.
- 4XXError (client-side) & 5XXError (server-side)

Gateway Throttling

- Account Limit
    - API Gateway throttles requests at 10,000rps across all API
    - Soft limit that can be increased upon request
- In case of throttling => 429 Too Many requests (returnable error)
- Can set Stage limit & Method limits to improve performance
- Or you can define Usage Plans to throttle per customer
- Just like Lambda Concurrency one API that is overloaded if not limited can cause the other APIs to be throttled

Errors

- 4xx means client errors
    - 400: Bad Request
    - 403: Access Denied, WAF filtered
    - 429: Quota Exceeded Throttle
- 5xx means server errors
    - 502: Bad Gateway Exception, usually for an incompatible output returned from a Lambda proxy integration backend and occasionally for out-of-order invocations due to heavy loads
    - 503: Service Unavailable Exception
    - 504: Integration Failure — ex Endpoint Request Timed-out Exception
    - API Gateway requests time out after 20 second maximum

CORS

- CORS must be enabled when you receive API calls from another domain
- The OPTIONS pre-flight request must contain the following headers:
    - Access-Control-Allow-Methods
    - Access-Control-Allow-Headers
    - Access-Control-Allow-Origin
- CORS can be enabled through the console


API Gateway Authentication & Authorization

IAM Permissions

- Create an IAM policy authorization and attach to User / Role
- Authentication = IAM | Authorization = IAM Policy
- Good to provide access within AWS (EC2, Lambda, IAM Users…)
- Leverages “Sig v4” capability where IAM credential are in headers

Resource Policies

- Resource policies (similar to Lambda Resource Policy)
- Allow for Cross-Account Access (Combined with IAM security)
- Allow for a specific IP Address

Cognito User Pools

- Cognito fully manages user lifecycle token expires automatically
- API gateway verifies identity automatically from AWS cognate
- No custom implementation required
- Authentication = Cognito User Pools | Authorization = API Gateway Methods

Lambda Authoriser (formerly Custom Authorizers)

- Token based authoriser (bearer token) ex JWT or OAuth
- A request parameter based Lambda authoriser (headers, query, string, stage, var)
- Lambda must return an IAM policy for the user, result policy is cached
- Authentication = External | Authorization = Lambda Function

Summary

- IAM
    - Great for users/ roles already within your AWS account + resource policy for cross account
    - Handle authentication + authorization
    - Leverages Signature v4
- Custom Authoriser
    - Great for 3rd Party tokens
    - Very flexible in terms of what IAM policy is returned
    - Handle Authentication verification + Authorization in the lambda function
    - Pay per Lambda invocation, results are cached
- Cognito User Pool
    - You manage your own user pool (can be backed by Facebook, Google login, etc…)
    - No need to write any custom code
    - Must implement authorization in the backend

HTTP API vs REST API

- HTTP APIS
    - Low-latency cost effective AWS Lambda proxy, HTTP proxy APIs and private integration (no data mapping)
    - Support OIDC and OAuth 2.0 authorization and built-in support for CORS
    - No usage plans and API keys
- REST APIs
    - All features (except native OpenID Connect / OAuth 20)

HTTP APIs much cheaper than REST apis. HTTP APIs don’t support Resource Policies.

Websocket API

- Two-way interactive communication between a users browser and a server.  Server can push information to the client this enables stateful application use cases.

- WebSocket APIs are often used in real-time applications such as chat applications, collaborations platforms multiplayer games and financial trading platforms.

PersistentConnection -> API Gateway -> Lambda (onConnect, sendMessage, onDisconnect) -> DynamoDB

Works with AWS Services (Lambda, DynamoDB) or HTTP endpoints

Routing

- Incoming JSON messages are routed to different backend
- If no routes => sent to $default
- You request a route selection expression to select the field on JSON to route from
- Sample expression $request.body.action
- The result is evaluated against the route keys available in your API Gateway
- The route is then connected to the backend you’ve setup through API Gateway

Architecture

- Create a single interface for all the micro services in your company
- Use API endpoints with various resources
- Apply a simple domain name and SSL certificates
- Can apply forwarding and transformation rules at the API Gateway level

Route53 Domain Registrar, DNS

API Gateway /service1 -> ELB -> ECS Cluster (Microservices)
API Gateway /service2 -> ELB -> EC2 (Auto Scaling)
API Gateway /docs -> S3

 
