# SOLID Principles of object-oriented design

Idioms:
"Accept interfaces, return structs." 
"A little copying is better than a little dependency."

### Single responsibility principle (SRP)
In Any well designed system, objects should only have a single responsibility.

### Open/closed principle (OCP)
A software module should be open for extension but closed for modification.

### Liskov substitution (LSP)
If, for each object, O1 of type S there is an object O2 of type T such that for all programs P defined in terms of T, the behavior of P is unchanged when O1 is substituted for O2, then S is a subtype of T.

In layman's terms, two types are substitutable if their exhibited behavior follows exactly the same contract, thereby making it impossible for callers to distinguish between them.

### Interface Segregation principle (ISP)
Clients should not be forced to depend upon the interfaces that they do not use.

"The bigger the interface, the weaker the abstraction."

### Dependency Inversion principle (DIP)
High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.
