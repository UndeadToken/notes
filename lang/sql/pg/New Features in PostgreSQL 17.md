
## Terminating long transactions

Previously used prior to Pg17 and could only be set per instance.
old_snapshot_threshold

A new variable which can be set per session with a default value of "unlimited" (0):

```sql
SHOW transaction_timeout;
```

```sql
SET transaction_timeout TO 5000; -- 5000 milliseconds
```

## Improved Event Triggers

```sql
SHOW event_triggers;
```

```sql
CREATE TABLE user_logins (
  id serial,
  who text
)
```

```sql
CREATE FUNCTION on_login_proc()
RETURNS event_trigger AS
$$
BEGIN
	INSERT INTO user_logins (who)
	VALUES (SESSION_USER);
	RAISE NOTICE 'you are welcome!';
END
$$ LANGUAGE plpgsql;
```

```sql
ALTER EVENT TRIGGER on_login_trigger ENABLE ALWAYS;
```

A buggy function on the login trigger can cause outages.

https://www.postgresql.org/docs/17/app-postgres.html

## Inspecting wait events in PostgreSQL

pg_wait_events provides an easy way to understand which events are there and what they mean.

\x
Expanded display is on

```sql
SELECT * FROM pg_wait_events WHERE name = 'DataFileFlush';
```

```sql
SELECT type, count(*) FROM pg_wait_events GROUP by ROLLUP (1) ORDER BY 1;
```

## Checkpoints & background writing

```sql
\d pg_stat_bgwriter
```

pg_stat_checkpointer view contains most of the information previously found in pg_stat_bgwriter.
```sql
\d pg_stat_checkpointer
```

### Improving pg_stat_statements

pg_stat_statements module is an extension for PostgreSQL that is shipped as part of the contrib package.

- CALL sattements now support parameters as palceholders
- Allows palcehodlers for savepoint and 2PC-related commands
- Tracks DEALLOCATE statements
- Adds support for local block I/O statistics
- Adds more details to JIT statistics
- Adds an optional argument to pg_stat_statements_reset()

## Adding Permissions for maintenance tasks

PostgreSQL 17 has added the MAINTAIN permission to a couple of commands, which allows us to execute various important tasks such as the following:

- VACUUM and ANALYZE
- CLUSTER
- REINDEX
- REFRESH MATERIALIZED VIEW
- LOCK TABLE

```sql
CREATE USER joe;
GRANT MAINTAIN ON ...
```

...tab completion will reveal the options e.g.

- ALL FUNCTIONS IN SCHEMA DATABASE
- TABLE
- ALL PROCEDURES IN SCHEMA
- DOMAIN
- LANGUAGE
- ROUTINE
- TABLESPACE
- ALL ROUTINES IN SCHEMA
- FOREIGN DATA WRAPPER
- LARGE OBJECT
- SCHEMA
- TYPE
- ALL SEQUENCES IN SCHEMA
- FOREIGN SERVER
- PARAMETER
- SEQUENCE
- ALL TABLES IN SCHEMA
- FUNCTION
- PROCEDURE

## COPY error handling

COPY is able to handle errors in a reasonably good way.

```sql
CREATE TABLE t_data (
  id int,
  data text
);
```

```sql
COPY t_data FROM '/tmp/file.txt' WITH (ON_ERROR 'ignore');
```

## Partitions

```sql
CREATE TABLE t_timeseries (
  id serial,
  d date,
  payload text
) PARTITION BY RANGE (d);

CREATE TABLE t_timeseries_2024 PARTITION OF t_timeseries FOR VALUES FROM ('2024-01-01') TO ('2025-01-01');
```

```sql
ALTER TABLE t_timeseries
  SPLIT PARTITION t_timeseries_2024
  INTO (
    PARTITION t_timeseries_2024_hl
      FOR VALUES FROM ('2024-01-01') TO ('2024-07-01'),
    PARTITION t_timeseries_2024_h2
      FOR VALUES FROM ('2024-07-01') TO ('2025-01-01')
  );
```

```sql
ALTER TABLE t_timeseries
MERGE PARTITIONS (
  t_timeseries_2024_h1,
  t_timeseries_2024_h2
)
INTO t_timeseries_2024l
```

## Tuning numbers into binary and octal values

\d \*to_bin\*
\d \*to_oct\*

```sql
SELECT to_bin(4711), to_oct(4711);
```

## Improving MERGE even more

```sql
CREATE TABLE t_demo (
  a int PRIMARY KEY,
  b int
);

INSERT INTO t_demo
VALUES (1, 4711), (2, 5822), (3, 6933);

CREATE TABLE t_source (
  a int PRIMARY KEY,
  b int
);

INSERT INTO t_source
VALUES (2, 6822), 
       (3, 6933), 
       (4, 1252);
```

```sql
MERGE INTO t_demo AS t1
USING t_source AS t2 
ON t1.a = t2.a
WHEN MATCHED THEN
    UPDATE SET b = t1.b * 100
WHEN NOT MATCHED THEN
    INSERT (a, b) VALUES (t2.a, t2.b)
WHEN NOT MATCHED BY SOURCE THEN
    DELETE
RETURNING t1.*, t2.*;”
```

```sql
... RETURNING merge_action(), t1.*, t2.*
```

## Additional JSON functionality

JSON_EXISTS(), JSON_QUERY(), JSON_VALUE()

JSON_TABLE similar to XMLTABLE turn a JSON document into a tabular format in one go.

```sql
SELECT jt.*
FROM customers,
	JSON_TABLE(
		js, '$.favourites[*]' COLUMNS (
			id FOR ORDINALITY,
			country text PATH '$.country',
			branch text PATH '$.industry[*].branch' WITH
			WRAPPER,
			ceo text PATH '$.company[*].ceo' WITH WRAPPER
		)
	) AS jt
```

## BRIN indexes in parellel

BRIN indexes are often used in data warehouses to quickly filter data without carrying the overhead of full-blown B-tree indexes.

## Replication & Backup addons

pg_dump backup or extract schema

### Incremental base backups

pg_basebackup

“Take a base backup every night and keep it for 7 days.”

summarize_wal on
wal_summary_keep_time = '7d'

A new process called summarizer was added to PostgreSQL that will track all of those blocks that have been changed and help pg_basebackup to only copy those blocks that have been touched.

```sh
pg_basebackup -h source_server.com \
	-D /data/full --checkpoint=fast
```

```sh
pg_basebackup -h source_server.com \
	--checkpoint=fast \
	--incremental=/data/full/backup_manifest \
	-D /backup/incremental
```

### Combine backup

pg_combinebackup --help

pg_combinebackup reconstructs full backups from incrementals.

```sql
pg_combinebackup -o /data/combined \
	/data/full \
	/backup/incremental
```

```sql
pg_combinebackup -o /data/combined \
	/data/full \
	/backup/incremental \
	/backup/incremental2 \
	/backup/incremental3
```

## Logical replication

In PostgreSQL, there are two types of replication: physical (binary) and logical (text) replication. While binary replication is ideal for all kinds of backup, logical replication has become more and more widespread in heterogeneous environments to achieve cross-cloud portability.

The trouble is that publications and subscriptions (the backbone of logical replication) were lost during pg_upgrades prior to PostgreSQL 17. This has now changed and has significantly eased the burden.

## pg_createsubscriber

In the new release, we can all enjoy a new command-line tool called pg_createsubscriber.

The initial sync phase can take quite a while – especially when the database instance is large. pg_createsubscriber has been designed to help solve this problem. It converts a physical standby (binary replication) and turns it into a logical standby by wiring all the publications, subscriptions, and so on for you.

For each database, replication set will be created and automatically configured. The command has to be executed on the target system.

## Breaking changes

Support for AIX has dropped.

---disable-thread-safety and MSSVC builds have been dropped.

Tooling removed from contirb section:
- adminpack
- snapshot too old (transaction_timeout)
- search_path is now fully secured during maintenance operations

