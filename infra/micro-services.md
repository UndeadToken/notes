EDA (Event Driven Architecture)

Microservices require loose coupling preventing failure propagation and latency. The death start anti-pattern is mitigated through the use of an event bus. Services emit events to a shared event broker and are handled by the services that are subscribed to them to handle reactive actions and shared state.

- Services enforce policies locally using attributes attached to the request or resource
- The caller attaches request attributes (tags), and the resource may have its own tags
- No service needs global knowledge of others—everything flows as metadata

Ownership vs Identity

The separate of ownership and identity is as follows.

The user id is referenced where identity is required i.e through authorization.

Ownership of data references the tenant id of which a given user belongs to. 

Brand > Team(s) > Tenant > User

Event-driven enrichment

Persist minimal info; emit events; authoritative service enriches asynchronously.

The API gateway passes tags as arbitrary values that serve as metadata for domains to apply constraints.

Each service keeps its own copy of the data it needs for local processing as a local materialized view or cache.

Local "promotion" of attributes

- Each service owns certain attributes (user info, system info, resource info).
- When a resource is persisted locally, the service decides which of its attributes are relevant for ABAC / filtering.
- These attributes are promoted to tags.

ABAC (Attribute Based Access Control)

Loose coupling between services is promoted through EDE as above which comes with tags. Tags are authoritative state metadata defined by the owning service that is likely to be used in authorization or filtering.

Firstly, identity attributes are parsed from the authentication token in the API gateway and added as headers when the request is forwarded to respective services.

X-Attr-Access-UserID: 1
X-Attr-Access-TenantID: "..."
X-Attr-Brand-BrandName: "Slipway"
X-Attr-System-Env: prod
X-Attr-System-Service: payments

- When a service, such as the support service, requires data from another it may persist the user id as a tag on the resource then emit an event to indicate that it has done so.

event.reference-persisted
{
  "referenceType": "user",
  "referenceID": 1,
  "kind": "ticket",
  "service": "support",
  "timestamp": "2026-01-16T16:37:46.456Z"
}

- The service that owns the resource that was persisted as a tag responds by taking the resource data and emitting it as shared state

event.propagate-resource
{
  "referenceType": "user",
  "referenceID": 1,
  "service": "user",
  "propagated":
    "tags": ["user:id:1", "user:foo:cake"],
    "metadata": {
      "id": 1,
      "name": "John Doe",
      "foo": "cake",
      ...
    }
  }
  "timestamp": "2026-01-16T16:37:46.456Z"
}

- The support service then handles the event and persists the shared state data as metadata and tags for the resource which is eventually consistent

- The support service can then resolve user data in their apis without tight coupling, can authorise resources by user id without relying on the authorization or user service and can filter tickets by user without knowing what a user is and without consulting the user service

- This process works the same with any resources, the authoritative resource responds by sharing its state and local state data is eventually consistent

Entitlements & Capabilities

Each service has a bounded context in that it owns its own products and announces them when created. Whether manual or through billing rules the billing service subscribes to such announcements and populates its internal product catalogue with pricing.

When a user purchases products the payment/cart/billing service, whichever owns the responsibility of such purchases, emits an event to announce entitlement grants for the user and the capabilities and options confined within it. Similarly the service would revoke such grants.

For free products the billing service emits the entitlements marking it as free allowing customers to utilise capabilities within a service without consulting other services.

- Admin creates product within service A, service A emits an event to announce the product and its details
- The billing service subscribed to the announcement event adds the product to its internal catalogue
- Whether as an automated pricing rule or manually the product is marked as free
- The billing service emits an event to grant the entitlement and capabilities
- Service A handles the event and adds the entitlement locally thus enabling users to utilise the capabilities for the product while adhering to any given limitations defined by the entitlement capability options

Eventually Consistent State

Shared state is eventually consistent which means if a resource is created with reference to a user or example the user data is not immediately available to the frontend application as part of the UI. For example a user creates a ticket and navigates to the ticket page. 

- The support ticket details are available once the support service responds with the shared state via SSE (or immediately when not using CQRS)

- The user details, shown in a pending UI state, are available once the user detail state is propagated and shared via SSE events

A dedicated service listens to events and sends data to clients via Server Sent Events to update their UI state without polling APIs.
--
1. Application Layer Gateway 2. Caching 3. Circuit Breaker 4. Command-Query Responsibility Segregation (CQRS) 5. Database Sharding 6. Event Sourcing 7. Failover 8. Load Balancing 9. Message Broker 10. Migration 11. Monitoring 12. Queuing 13. Replication 14. Resource Pooling 15. Retry 16. Scalability 17. Scheduling 18. Serverless Computing 19. Service Discovery 20. Service-Oriented Architecture (SOA) 21. Throttling 22. Virtualization

1. Model–View–Controller (MVC) 2. Singleton 3. Observer 4. Factory 5. Command 6. Adapter 7. Facade 8. Iterator 9. Strategy 10. Template Method 11. Composite 12. State 13. Proxy 14. Flyweight 15. Chain of Responsibility 16. Mediator 17. Memento

1. Golden Hammer: Relying on a single technology or approach to solve all problems. 2. Not Invented Here: Preferring to develop solutions from scratch instead of using existing components or frameworks. 3. Copy and Paste Programming: Reusing the same code in multiple places without rethinking the problem or creating a reusable solution. 4. Shotgun Surgery: Making multiple changes to the same piece of code to fix a problem instead of refactoring. 5. Cargo Cult Programming: Using a design or code pattern without understanding why it works or what its limitations are. 6. Vendor Lock-In: Relying on a single vendor for all business solutions instead of considering multiple options. 7. Rigidity: Writing code that is difficult to adapt to changing requirements or environments. 8. Feature Creep: Adding more features than necessary to a project, resulting in bloated code and complexity. 9. Spaghetti Code: Writing code without any structure or organization, making it difficult to debug, maintain, or extend. 10. Premature Optimization: Spending too much time optimizing code that has not been proven to be a bottleneck.
