# Domain Driven Design

A domain model provides a ubiquitous language that ties domain experts and
technologists together. Domain-drvien design is both a way of thinking and a set
of priorities, aimed at accelerating software projects that have to deal with
complicated domains.

Extreme programming recognizes the importance of design decisions, but it
strongly resists upfront design. Instead it puts an admirable effort into
communication and improving the project's ability to change course rapidly. With
that ability to react, developers can use the "simplest thing that could work"
at any stage of the project and then continuousy refactor, making many small
design improvements, ultimately arriving at a design that fits the true
customer's needs. It avoids "Analysis Parlaysis".

A domain model is not a particular digram; it is the idea that the digram is
intended to display.

- The model and the ehar of the design shape eachother
- The model is the backbone of the lanbguage used by all team members
- The model is distilled knowledge

Anti-corruption layer (ACL) is the function that translates foreign concepts for
an internal model to provide loose coupling between the domains.

Interchange context provides an environment for both teams and discusses the meaning
of each foreign term and translates the language of microservices.

The difference in meanings or representations for the same attribute is known as
a semantic gap.

Context maps are the communication paths between microservices with appropriate
interactions between microservices teams. After the analysis of the areas are
already defined the team can choose to be dependent on another team for domain
language.
