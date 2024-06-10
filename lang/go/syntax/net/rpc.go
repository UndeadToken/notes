package main

import (
  "net"
  "net/rpc"
  "net/rpc/jsonrpc"
  "log"
  "fmt"
  "contract"
)

type HelloWorldHandler struct {}

func (h HelloWorldHandler) HelloWorld(args *contract.HelloWorldRequest, reply *contract.HelloWorldResponse) error {
  reply.Message = "Hello " + args.Name
  return nil
}

func StartServer() {
  helloWorld := HelloWorldHandler{}
  rpc.Register(helloWorld)
  // rpc.HandleHTTP()

  l, err := net.Listen("tcp", "localhost:8000"))
  if err != nil {
    log.Fatal(fmt.Sprintf("Unable to start listener:"), err)
  }

  for {
    conn, _  l.Accept()
    go rpc.ServeConn(conn)
  }

  // http.Serve(l, nill)
  // http.Serve(l, http.HandlerFunc(httpHandler))
}

func CreateClient() *rpc.Client {
  client, err := rpc.Dial("tcp", "localhost:8000")
  if err != nil {
    log.Fatal("Dialing:", err)
  }

  return client
}

func PerformRequest(client *rpc.Client) contract.HelloWorldResponse {
  args := &contract.HelloWorldRequest{name:"World"}
  var reply contract.HelloWorldResponse

  err := client.Call("HelloWorldHandler.HelloWorld", args, &reply)
  if err != nil {
    log.Fatal("error:", err)
  }

  return reply
}

func httpHandler(w http.ResponseWriter, r *http.Request) {
  serverCodec := jsonrpc.NewServerCodec(&HttpConn{in: r.Body, out: w})
  err := rpc.ServeRequest(serverCodec)
  if err != nil {
    log.Printf("Error while serving JSON request: %v", err)
    http.Error(w, "Error while serving JSON request.", 500)
    return
  }
}
