# Notes

### httprouter
go get github.com/julienschmidt/httprouter

import "github.com/julienschmidt/httprouter"

### gorilla/mux

go get -u github.com/gorilla/mux

### gorilla/handlers

go get "github.com/gorilla/handlers"

### gorilla/rpc

go get github.com/gorilla/rpc

```
curl -X POST \
               http://localhost:1234/rpc \
               -H 'cache-control: no-cache' \
               -H 'content-type: application/json' \
               -d '{
               "method": "JSONServer.GiveBookDetail",
               "params": [{
               "ID": "1234"
               }],
               "id": "1"
}'
```

### Negroni (Alternative to handlers)

(github.com/urfave/negroni)

### Install Swagger
docker pull swaggerapi/swagger-ui

docker run --rm -p 80:8080 -e SWAGGER_JSON=/app/openapi.json -v $PWD:/app swaggerapi/swagger-ui

### Alice
Painless middleware

go get github.com/justinas/alice

