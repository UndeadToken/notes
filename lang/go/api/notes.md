# Notes

### httprouter
go get github.com/julienschmidt/httprouter

import "github.com/julienschmidt/httprouter"

### gorilla/mux

go get -u github.com/gorilla/mux

### Install Swagger
docker pull swaggerapi/swagger-ui

docker run --rm -p 80:8080 -e SWAGGER_JSON=/app/openapi.json -v $PWD:/app swaggerapi/swagger-ui
