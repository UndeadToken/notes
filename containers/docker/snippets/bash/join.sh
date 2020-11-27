#!/bin/bash
SWARMWORKER="swarm-worker-"
for machine in `docker-machine ls --format {{.Name}} | grep $SWARMWORKER`; do
  docker-machine ssh $machine sudo docker swarm join --token <token> \ <ip:port>
done
