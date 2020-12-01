# RabbitMQ

Advanced Message Queueing Protocol (AMQP)

- Publish/Subscribe 
- Topic/Subscription
- Routing messages
- Remote Procedure Call (RPC)

```
docker run --hostname rabbitmq-host --name rabbitmq-server -p 5672:5672 -p
   15672:15672 rabbitmq:3
```

go get github.com/streadway/amqp

