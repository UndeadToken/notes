# MongoDB

MongoDB is a NoSQL, non-relational key-value store, a JSON database. MongoDB is a distributed
system. By default, replica set of MongoDB is a three-node configuration. All three nodes are
data-bearing, which means that there is a complete copy of the database available on each node. 
Each database is hosted on a seprate instance or host which can be in the same availability 
zone, data centre or region. The default configuration is to ensure both redundancy and high 
availability.

- Flexibility and schema-less
- Scalability & performance
- Rich query language
- Developer-friendly data format
- Simplicity abd quick start

If one of the instances becomes unresponsive or unavailable, a healthy node is promoted to become
the primary node. The failover between members occurs automatically.

Write operations to MongoDB are propagated from the primary node to the secondary nodes via a 
process called replication. Replication in MongoDB is based on the RAFT consensus protocol. 
The write is recorded in the operations log (oplog) which is tailed by secondary nodes. Node election
occurs through a combination of randomized election timeouts and message exchanges. In MongoDB
there are settings for node priority. This priority is considered along with data freshness
 and response time when electing a primary node.

It is often true that the write operation is not written simultaneously to all nodes. If one of 
the mongod nodes falls behind, it will catchup or resync itself when it is able to do so
using th oplog to determine the gaps in its operations. The MongoDB system monitors the
replication lag between nodes to track this metric and assess whether the delay between primary
and secondary nodes is acceptable, if not it takes necessary action.


## Python Setup

```
pip install pymongo
```

## Resources

MongoDB 4.4
https://www.mongodb.com/docs/manual/installation/

MongoDB Atlas Search
https://www.mongodb.com/docs/atlas/getting-started/

MongoDB Shell
https://www.mongodb.com/docs/administration/install-community/

MongoDB Compass
https://www.mongodb.com/docs/compass/current/install/

Other:
https://www.mongodb.com/developer
https://learn.mongodb.com/
https://github.com/PacktPublishing/Mastering-MongoDB-7.0