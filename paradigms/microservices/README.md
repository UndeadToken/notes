# Microservices

All internal microservice code will be used and shared among the development team;
class methods are abstractions or attributes and can all be part of the public
interface shared between teams. This is because of the convinience to notify and make
changes in the event of possible refactoring.

The published interface is what the developers release. The published interface is
what will be consumed by the internet.

- Published versioned interfaces

Applications where all business rules are on the same codebase are called monoliths.
