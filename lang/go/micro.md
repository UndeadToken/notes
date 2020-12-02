# Go Micro

dep init
dep ensure -add "github.com/micro/go-micro"

go get -u github.com/golang/protobuf/protoc-gen-go
go get github.com/micro/protoc-gen-micro

```
protoc -I=. --micro_out=. --go_out=. proto/encryption.proto
```

### Logging

```
func logWrapper(fn server.HandlerFunc) server.HandlerFunc {
             return func(ctx context.Context, req *proto.Request,
              rsp *proto.Response) error {
             fmt.Printf("encryption request at time: %v", time.Now())
             return fn(ctx, req, rsp)
             }
}
```

```
service := micro.NewService(
            micro.Name("encrypter"),
            // wrap the client
            micro.WrapClient(logWrap),
            )
```

https://micro.mu/docs/go-micro.html#wrappers.

https://opentracing.io/

https://micro.mu/ docs/go-web.html

