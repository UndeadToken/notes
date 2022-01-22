# Microservices

All internal microservice code will be used and shared among the development team;
class methods are abstractions or attributes and can all be part of the public
interface shared between teams. This is because of the convinience to notify and make
changes in the event of possible refactoring.

The published interface is what the developers release. The published interface is
what will be consumed by the internet.

- Published versioned interfaces
An efficient version control to indicate something, deprecated is key. Not only
that, but it will also indicate what the new version is and the deprecated version
will be deactivated permanently.

- Small published interfaces
A large payload is much more susceptible to change than a more specialized payload.
Applying the concepts of DDD on these payloads is very healthy.

- Published external interfaces
Do not create the concept of published interfaces for internal development teams.
This creates a slow process of change and implementation features.

Applications where all business rules are on the same codebase are called monoliths.

- Never share libraries between microservices
- Strong delimitation of microservice domains
- Establish a cient-server relationship between microservices
- Deploy in  separate containers

Empathetic about the need to use ubiquitous language for communicating between those responsible
for the business and the engineering team responsible for the development. This language consists of
terms that are part of everyday conversations between business experts and development teams. Everyone
should use the same terms in spoken language, spoken language and the signing of microservices. 

The home page should seek breaking news with the title and description.

- Microserice News
- Endpoint recent news
- Payload with attribute title and description

This type of communication will mitigate errors in understanding requirements and maintain the general knowledge application unison. With the ubiquitous language, interactions have standardized terms whereas words indicate something new.

#### Context Maps
These are the communication paths between microservices with appropriate interactions between microservice teams. After the analysis of the areas are already defined, the team can choose to be dependent on another team for the domain language.

### Anti-corruption Layer (ACL)
This is the function that translates foreign concepts for an internal model to provide loose coupling between the domains.

### Interchange context:
This provides an environment for both teams and discusses the meaning of each foreign term and translates the languages of microservices.

### Patterns

OOP:
- Code alignment with the business
- Favoring of reuse
- Minimal coupling
- Putting the domain model to work
- Model building blocks-driven design
- Refactoring to deeply understand the model
- Strategic design

MVC - Model View Controller
HMVC - Hierarchical Model View Controller
MTV - Model Template View

### Monolith
Business domains coupled in a singular codebase.

Disadvantages of monoliths:
- Merges that are difficult to apply
- Feature implementation may become increasingly more complicated
- Application scalability
- Deploying features without affecting what is already online is challenging
- Architectural changes are always complex

Advantages of microservices:
- An exclusive business domain for each microservice, facilitating the implementation of new features
- Better definition of business without cyclic dependency between them
- Independent deployment
- Simplicity to identify errors
- Technological independence amongst microservices 
- Indepdendence between teams
- Implementation of isolation
- Possible scalability for each microservice
- 

### The Scale Cube
The concept of a scale cube shows that there are basically three forms of
scalability.

Y-Axis - Functional Decomposition
A verb or route is used by the balancer to identify where to go with the request.

Client <-> Balancer
  -> News -> app
  -> Users -> app
  ...

X-Axis - Horizonal Decomposition
The x-axis targets Horizontal scalability with the same application server
replicated n times in full and in a balanced order of 1/n.

Client <-> Balancer -> app, app, app

Z-Axis - Data Partitioning
Similar to the x-axis it distributes exactly the same the code on each server.
The big difference is that each server responds to a specific subset of data.
Provides scalability and the data which is typically used with regions as opposed
to verbs where by varied regioned data is provided per route.

Client <-> Balancer
  -> News[A...G] -> app
  -> News[H...O] -> app
  ...

### Resources

Asynchronous message brokers
- RabbitMQ
- ActiveMQ
- ZeroMQ
- Kafka
- Redis

### Endpoints

Fragment web endpoints for example in place of `getUser` create  an orchestrator
of the smaller information `getUserIdentification`, `getUserAddress`, `getUserContacts`
etc... This kind of startegy is called endpoint builder where the heavy point
of information actually is compositions of other lighter data sources.

### Anemic Domains

- The microservice cannot perform the task itself with only the data received
- The microservice needs to fetch data from more than one endpoint to perform a task
- The microservice does not have a self sufficient entity model
- The microservice waits for the completion of a task in another microservice to
  follow up what you need to do
- The microservice needs to share resources with other external microservices;
  these resources can be cached to the sample database

### Fat Domains

When microservices perform more tasks than they should.

e.g. When a user service handles AAA (Authentication, Autorization, and Account)

### Considerations

- Profieciency
- Performance
- Development practicality
- Ecosystem
- Scalability cost

### Tools

#### Caching

- Varnish
- Memcahced
- Redis


#### Logging

- logrus (Go) https://github.com/Sirupsen/logrus

#### Handlers

- fasthttp (Go) https://github.com/valyala/fasthttp
- fasthttprouter (Go) https://github.com/buaazp/fasthttprouter
- gorilla/mux (Go) https://github.com/gorilla/mux

#### Middleware

- negorni (Go) https://urfave/negroni

#### Testing

- testify (Go) https://sretchr/testify

#### Package managers

- godep https://github.com/tools/godep

#### Database

- https://github.com/jmoiron/sqlx
#### Syncronous communication

- MessagPack (http://msgpack.org)
- gRPC (https://grpc.io)
- Apache avro https://avro.apache.org
- Apache Thrift https://thrift.apache.org

#### Message Brokers

- ActiveMQ
- RabbitMQ
- Kafka

#### Monitoring

- graphite with grafana and prometheus
- Nagios
- Zabbix
- Sentry

#### CI (Continuous Integration) builds

- Travis CI
- Jenkins
- Bitbucket Pipelines
- Gitlab / github ...

#### Benchmarking

- Apache benchmark
- WRK
- Locust

