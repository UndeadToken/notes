# Nginx

### Load Balancer

|Load-balancing method|Description|
|Round Robin|The incoming requests are uniformly distributed across servers based on the criteria of server weights.|
|Least Connection|Requests are sent to the server that is currently serving the least number of clients|
|Ip Hash|This is used to send the requests from a given client's IP to the given server. Only when that server is not available is it given to another server.|
|Least Time|A request from the client is sent to the machine with the lowest average latency (the time-to-serve client) and the least number of active connections.|

```
http {
	upstream cluster {
		least_conn;
    	server site1.mysite.com weight=5;
        server site2.mysite.com weight=2;
        server backup.mysite.com backup;
	} 
}

server {
       location / {
           proxy_pass http://cluster;
       }
}
```

### Rate limiting

```
limit_conn_zone client_type zone=zone_type:size;
```

|Client type|Zone type|
|$binary_remote_address|addr|
|$server_name|servers|

e.g. 8m or 16m
```
http {
	limit_conn_zone $server_name zone=servers:10m;
}
```

```
server {
	limit_conn servers 1000;
}
```

```
server {
	location /foo {
		limit_conn addr 10; // Limit 10 connections per client.
		limit_rate 50k; // Bandwidth constraint.
	}
}
```

### Security

```
location /api {
	deny 192.168.1.2;
	allow 192.168.1.1/24;
	allow 127.0.0.1;
	deny all;
}
```



