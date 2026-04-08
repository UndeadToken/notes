Postgres

psql 
pgenv
pg_ctl

initdb initialize the cluster

reload reload configuration

promote standby node / replica become detached from original primary through replication

pstree -p Postgres
ps -C Postgres -af

psql
-d the database name
-U The username
-h The host ipv4 or ipv6 or host name 

pgsql postgresql://foo@localhost:5432/template1

SELECT current_time \g

Ending a wql statement with a semicolon or \g will keep the content you are typing in the query buffer

\e will open default editor with content of last edited query

test.sql
SELECT current_database();
SELECT current_time;
SELECT current_role;

\i test.sql

\h Help
\?

\d list all user defined tables

postgresql.conf in PGDATA then restart with pg_ctl
listen_addresses = ‘*’


