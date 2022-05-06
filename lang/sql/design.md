Requirement Analysis:
- What the database is needed for
- What data will be stored
- How the items relate to eachother

Conceptual Design:
- distill the database requirements into a formal description of the database design (modeling)

Logical Design:
- Map the database design onto an actual database management system and database tables

The Entity Relationship Model (ER):
The entity relationship modelling approach involves drawing an Entity Relationship Diagram (ERD).

1:1 one-to-one
1:N one-to-many
M:N many-to-many

The number of entities on either side of the relationship (the cardinality of the relationship) define the key constraints of the relationship. 

Map nouns to entities and verbs to relations.

Intermediate entities (associate entitity). e.g. Flight M -> Books -> N -> Passenger.
