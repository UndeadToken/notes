```sql
SELECT now(), now();
```

Keep in mind that the now() function will return the transaction time. The SELECT statement will, therefore, always return two identical timestamps. If you want the real time, consider using clock_timestamp() instead of now().

```sql
BEGIN
```

```
Command: BEGIN
Description: start a transaction block
Syntax:
 BEGIN [ WORK | TRANSACTION ] [ transaction_mode [, ...] ]
where transaction_mode is one of:
  ISOLATION LEVEL { SERIALIZABLE | REPEATABLE READ | READ COMMITTED | READ UNCOMMITTED }
    READ WRITE | READ ONLY
    [ NOT ] DEFERRABLE
```

The BEGIN statement will ensure that more than one command is packed into a transaction.

```sql
BEGIN;
SELECT now();
SELECT now();
COMMIT;
```

```sql
\h COMMIT
```

You can just use COMMIT, COMMIT WORK, or COMMIT TRANSACTION. All three commands have the same meaning. If this is not enough, there’s more – the END command is identical to COMMIT and can be used interchangeably.

ROLLBACK is the counterpart of COMMIT. Instead of successfully ending a transaction, it will simply stop the transaction without ever making things visible to other transactions, as shown in the following code.

```sql
\h ROLLBACK
```

Some applications use ABORT instead of ROLLBACK (those two commands are interchangeable in PostgreSQL). The meaning is the same. What is really useful in PostgreSQL is the idea of transaction chains. COMMIT AND CHAIN will help you to achieve exactly that.

```sql
SHOW transaction_read_only;
```

Display the content of the transaction_read_only setting. It is Off because, by default, we are in read/write mode.

Start a read-only transaction using BEGIN. This will automatically adjust the transaction_read_only variable.

Commit the transaction using AND CHAIN, and then PostgreSQL will automatically start a new transaction featuring the same properties as the previous transaction.

```sql
BEGIN TRANSACTION READ ONLY;
SELECT 1;
COMMIT AND CHAIN;
SHOW transaction_read_only;
COMMIT AND NO CHAIN;
SHOW transaction_read_only;
COMMIT;
```

## Handling errors inside a transaction

In any proper database, an instruction similar to this will instantly error out and make the statement fail.

```sql
BEGIN;
SELECT 1;
SELECT 1 / 0;
-- ERROR : division by zero
SELECT 1;
-- ERROR: current transaction is aborted, commands ignored until end of transaction block
SELECT 1;
-- ERROR: current transaction is aborted, commands ignored until end of transaction block
COMMIT;
-- ROLLBACK
```

### Savepoint

In professional applications, it can be pretty hard to write reasonably long transactions without ever encountering a single error. To solve this problem, users can utilize something called SAVEPOINT

```sql
\h SAVEPOINT
```

```
Description: define a new savepoint within the current transaction 
Syntax:
SAVEPOINT savepoint_name
URL: https://www.postgresql.org/docs/17/sql-savepoint.html
```

```sql
 BEGIN
 SELECT 1;
 SAVEPOINT a;
 SELECT 2 / 0;
 -- ERROR: division by zero
 SELECT 2;
 -- ERROR: current transaction is aborted, commands ignored until end of transaction block
ROLLBACK TO SAVEPOINT a;
-- ROLLBACK
SELECT 3;
COMMIT;
```

If you want to remove a savepoint from inside a transaction, there’s the RELEASE SAVEPOINT command.

```sql
\h RELEASE
```


## Transactional DDLs

DDLs - commands that change the data structure inside a transaction block. PostgreSQL does not commit the current transaction by default unlike traditional DDLs.

Apart from some minor exceptions (DROP DATABASE, CREATE TABLESPACE, DROP TABLESPACE...) all DDLs in PostgreSQL are transactional.

```sql
BEGIN;
CREATE TABLE t_test (id int);

ALTER TABLE t_test ALTER COLUMN id TYPE int8;

\d t_test

ROLLBACK;

\d t_test
-- Did not find any relation named "t_test"
```


## Basic Locking

```sql
CREATE TABLE t_test (id int);
INSERT INTO t_test VALUES (0);
```

multi-version concurrency control (MVCC)

Two transactions are opened. The first one will change a row. However, this is not a problem, as the second transaction can proceed. It will return to the old row as it was before UPDATE. 

A transaction will only see data if it has been committed by the write transaction before the initiation of the read transaction. One transaction cannot inspect the changes that have been made by another active connection. A transaction can see only those changes that have already been committed.

Write transactions won’t block read transactions.

PostgreSQL will only lock rows affected by UPDATE. So, if you have 1,000 rows, you can theoretically run 1,000 concurrent changes on the same table.

## Avoiding typical mistakes and explicit locking

```sql
\h LOCK
```

*ACCESS SHARE*

This type of lock is taken by reads and conflicts only with ACCESS EXCLUSIVE, which is set by DROP TABLE, and so on. Practically, this means that SELECT cannot start if a table is about to be dropped. This also implies that DROP TABLE has to wait until a reading transaction is complete.

*ROW SHARE*

PostgreSQL takes this kind of lock in the case of SELECT FOR UPDATE or SELECT FOR SHARE. It conflicts with EXCLUSIVE and ACCESS EXCLUSIVE.

*ROW EXCLUSIVE* 

This lock is taken by INSERT, UPDATE, and DELETE. It conflicts with SHARE, SHARE ROW EXCLUSIVE, EXCLUSIVE, and ACCESS EXCLUSIVE.

*SHARE UPDATE EXCLUSIVE*

This kind of lock is taken by CREATE INDEX CONCURRENTLY, ANALYZE, ALTER TABLE, VALIDATE, and some other flavors of ALTER TABLE, as well as by VACUUM (not VACUUM FULL). It conflicts with the SHARE UPDATE EXCLUSIVE, SHARE, SHARE ROW EXCLUSIVE, EXCLUSIVE, and ACCESS EXCLUSIVE lock modes.

*SHARE* 

When an index is created, SHARE locks will be set. These conflict with ROW EXCLUSIVE, SHARE UPDATE EXCLUSIVE, SHARE ROW EXCLUSIVE, EXCLUSIVE, and ACCESS EXCLUSIVE.

*SHARE ROW EXCLUSIVE* 

This one is set by CREATE TRIGGER and some forms of ALTER TABLE and conflicts with everything except ACCESS SHARE.

*EXCLUSIVE* 

This type of lock is by far the most restrictive one. It protects against reads and writes alike. If this lock is taken by a transaction, nobody else can read or write to the table that’s been affected.

ACCESS EXCLUSIVE: This lock prevents concurrent transactions from reading and writing.

e.g. SELECT max(id) used in INSERT INTO X VALUES (y) where y is max would result in duplicate entries for identity concurrent requests solved with a lock.

```sql
BEGIN;

LOCK TABLE product IN ACCESS EXCLUSIVE MODE;

SELECT pid, wait_event_type, wait_event, query FROM pg_stat_activity WHERE datname = 'test';
```

What we can see here is the query causing the lock, as well as the query waiting on the lock (as shown in the wait event).

```sql
CREATE TABLE t_invoice (ID INT PRIMARY KEY);
CREATE TABLE t_watermark (id int);
INSERT INTO t_watermark VALUES (0);

WITH x AS (UPDATE t_watermark SET id = id + 1 RETURNING *) 
INSERT INTO t_invoice SELECT * FROM x RETURNING *;
```

## FOR SHARE and FOR UPDATE

Wrong:

```sql
BEGIN;
SELECT * FROM invoice WHERE processed = false;
-- application magic happens here
UPDATE invoice SET processed = true ...
COMMIT;
```

The problem here is that two people might select the same unprocessed data. Changes that are made to these processed rows will then be overwritten. In short, a race condition will occur.

SELECT FOR UPDATE

```sql
BEGIN;
SELECT * FROM invoice WHERE processed = false FOR UPDATE;
-- application magic will happen here
UPDATE invoice SET processed = true ...
COMMIT;
```

If one SELECT FOR UPDATE command is waiting for another SELECT FOR UPDATE command, you will have to wait until the other one completes (COMMIT or ROLLBACK). If the first transaction doesn’t want to end for whatever reason, the second transaction possibly waits forever. To avoid this, we can use SELECT FOR UPDATE NOWAIT.

Alternative to NOWAIT use lock_timeout.

```sql
SET lock_timeout TO 5000;
```

SELECT FOR UPDATE SKIP LOCKED

```sql
CREATE TABLE t_flight AS SELECT * FROM generate_series(1, 200) AS id;
```

Transaction 1:

```sql
BEGIN;
SELECT * FROM t_flight LIMIT 2 FOR UPDATE SKIP LOCKED;
-- returns 1 and 2
```

Transaction 2:

```sql
SELECT * FROM t_flight LIMIT 2 FOR UPDATE SKIP LOCKED;
-- returns 3 and 4
```

Keep in mind that waiting is the slowest form of execution. If only one transaction can be active at a time, it is pointless to buy ever more expensive servers if your real problems are caused by locking and conflicting transactions in general.

However, there’s more. In some cases, FOR UPDATE can have unintended consequences. Most people are not aware of the fact that FOR UPDATE will have an impact on foreign keys.

```sql
CREATE TABLE t_currency (
      id      int,
      name    text,
      PRIMARY KEY (id)
);

INSERT INTO t_currency VALUES (1, 'EUR');
INSERT INTO t_currency VALUES (2, 'USD');

CREATE TABLE t_account (
      id            int,
      currency_id   int REFERENCES t_currency (id)
                        ON UPDATE CASCADE
                        ON DELETE CASCADE,
      balance       numeric
);

INSERT INTO t_account VALUES (1, 1, 100);
INSERT INTO t_account VALUES (2, 1, 200);
```

Although there is a SELECT FOR UPDATE command on accounts, the UPDATE command on the currency table will be blocked. This is necessary because, otherwise, there is a chance of breaking the foreign key constraint altogether.

*FOR NO KEY UPDATE*

This one is pretty similar to FOR UPDATE. However, the lock is weaker, and therefore, it can coexist with SELECT FOR SHARE.

*FOR SHARE FOR UPDATE* 

is pretty strong and works on the assumption that you are definitely going to change rows. FOR SHARE is different because more than one transaction can hold a FOR SHARE lock at the same time.

*FOR KEY SHARE* 

This behaves similarly to FOR SHARE, except that the lock is weaker. It will block FOR UPDATE but will not block FOR NO KEY UPDATE.

## Transaction Isolation Levels

By default, PostgreSQL runs in the READ COMMITTED transaction isolation mode. This means that every statement inside a transaction will get a new snapshot of the data, which will be constant throughout the query.

A SQL statement will operate on the same snapshot and will ignore changes by concurrent transactions while it is running.

If you want to avoid this, you can use TRANSACTION ISOLATION LEVEL REPEATABLE READ. In this transaction isolation level, a transaction will use the same snapshot throughout the entire transaction.

Transaction 1:

```sql
BEGIN TRANSACTION ISOLATION LEVEL REPEATABLE READ;

SELECT sum(balance) FROM t_account; -- 300

SELECT sum(balance) FROM t_account; -- 300

COMMIT;
```

Transaction 2:

```sql
...
BEGIN TRANSACTION LEVEL REPEATABLE READ;

INSERT INTO t_account (balance) VALUES (100);

COMMIT;

SELECT sum(balance) FROM t_account; -- 400
```

The first transaction will freeze its snapshot of the data and provide us with constant results throughout the entire transaction.

Repeatable read is not more expensive than read committed. There is no need to worry about performance penalties. For normal online transaction processing (OLTP), read committed has various advantages because changes can be seen much earlier and the odds of unexpected errors are usually lower.

### Considering serializable snapshot isolation transactions

Transaction isolation levels.

- Serializable snapshot isolation (SSI) transactions
- Read committed
- Repeatable read
- Read Uncommitted is not supported in PostgreSQL

Consider using serializable isolation only when you have a decent understanding of what is going on inside the database engine.

## Observing deadlocks and similar issues

Deadlocks are an important issue and can happen in every database. Basically, a deadlock will happen if two transactions have to wait on each other.

```sql
CREATE TABLE t_deadlock (id int);
INSERT INTO t_deadlock VALUES (1), (2);
```

Transaction 1:

```sql
BEGIN;
UPDATE t_deadlock SET id = id * 10 WHERE id = 1;
UPDATE t_deadlock SET id = id * 10 WHERE id = 2;
-- waiting on transaction 2 ...
-- ...
COMMIT;
```

Transaction 2:

```sql
BEGIN;
UPDATE t_deadlock SET id = id * 10 WHERE id = 2;
UPDATE t_deadlock SET id = id * 10 WHERE id = 1;
-- Waiting on transaction 1 ...
-- Deadlock will be resolved after 1 second (deadlock_timeout)
ROLLBACK;
```

```
psql: ERROR: deadlock detected
DETAIL: Process 91521 waits for ShareLock on transaction 903;
   blocked by process 77185.
 Process 77185 waits for ShareLock on transaction 905;
 blocked by process 91521.
 HINT: See server log for query details.
 CONTEXT: while updating tuple (0,1) in relation "t_deadlock”
```

ctid, which is a unique identifier of a row in a table. It tells us about the physical position of a row inside a table.

```sql
SELECT ctid, * FROM t_deadlock WHERE ctid = '(0, 1)';
-- ctid | id
-- ---------
-- (0, 1) | 10
-- 1 row
```
## References

https://www.cybertec-postgresql.com
https://wiki.postgresql.org/wiki/Serializable
