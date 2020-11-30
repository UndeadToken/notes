# RPC (Remote Procedure Call)

RPC is a mechanism to delegate work to a remote server in an understandable fashion. RPC is an inter-process communication that exchanges information between various distributed systems.

1. Clients prepare function name and arguments to send
2. Clients send them to an RPC server by dialing the connection
3. The server receives the function name and arguments
4. The server executes the remote process
5. The message will be sent back to the client
6. The client collects the data from the request and uses it appropriately

# Libs

net/rpc
net/rpc/jsonrpc

