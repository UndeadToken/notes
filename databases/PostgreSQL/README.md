# PostgreSQL

PostgreSQL is an open-source object-relational Database Management System (DBMS). 
PostgreSQL takes its name from its ancestor: Ingres. Post-ingress = Postgres. 
The project aimed to develop an object-relational database, where "object" the user would
have the capability to extend the database with their own objects
such as data types, functions etc...

PostgreSQL developers are commonly known as the PostgreSQL Global Development Group (PGDG). A single 
instance can contain  more than 4 billion individual databases, each with unlimited total
size and capacity for 1 billion tables, each containing 32 TB of data. 

Each table can have  1,600 columns, each 1 GB in size, with an unlimited number of multi-column indexes (up to
32-columns). PostgreSQL is fully ACID-compliant. It ships with a procedural language 
PL/PgSQL.

ACID is an acronym of properties, used to indicate that the database engine provides 
**atomicity**, **consistency**, **isolation** and **durability**. Atomicity means that 
a complex database operation is processed as a single instruction even when it is made
up of different operations.

PostgreSQL stores data in a binary format and thi format may change between major versions.

## Database Schemas

A database can be organized into namespaces, called schemas. A schema is a mnemonic name that 
the user can assign to organize database objects, such as tables, into a more structured
collection. Schemas cannot be nested, so they represent a flat namespace.

Database objects are represented by everything the user can create and manage within the 
database for instance tables, functions, triggers and data types. All objects belong to 
only one schema named as the user that created the object by default.

In PostgreSQL versions prior to 15, every new object belongs to the default public schema
if not specified otherwise. Since PostgreSQL 15, every user is assigned a personal schema
and objects belong to such a schema unless a different schema name is explicitly specified.

Users are defined at a cluster-wide level, which means they are not tied to a particular
database in the cluster. A user can connect with and manage any database in the cluster 
they are allowed to.

Normal Users:
These users are the ones who can connect to and handle databases and objects depending on
their privilege set.

Super Users:
These users can do anything with any database object.

PostgreSQL internal data, such as users, databases, namespaces, configuration, and 
database runtime status, is provided by means of **catalogs**: special tables and views
that represent information in a SQL-interactive way. Many catalogs are trimmed depending 
on the user who is inspecting them, with the exception that superusers usually see the
whole set of available information. PostgreSQL stores the user data (for example
tables) and its internal status on the local filesystem. It relies on the underlying
filesystem to implement persistence.

## Setup

```
sudo apt-get install -y postgresql-client
psql --version
```

https://www.pgadmin.org/download/pgadmin-4-apt/
https://github.com/PacktPublishing/Learn-PostgreSQL-Second-Edition
https://packt.link/gbp/9781837635641
https://www.postgresql.org/list/
