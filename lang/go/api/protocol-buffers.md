# Protocol Buffer (protobufs) & gRPC

Services can implement a Remote Procedure Call (RPC) and use a protocol buffer as a data exchange format. A protocol buffer is a strongly typed specification language. Protocol buffers allow us to define the data contract between multiple systems. Think of a protocol buffer as a data structure with types.

### HTTP2

- Flow control between sender and receiver
- Better compression of HTTP headers
- Single TCP connection for bidirectional streaming
- Server push support for sending files on one TCP connection Support from all major browsers

Google:

"Protocol buffers are a flexible, efficient, automated mechanism for serializing structured data—think XML, but smaller, faster, and simpler. You define how you want your data to be structured once, then you can use the specially generated source code to easily write and read your structured data to and from a variety of data streams and using a variety of languages. You can even update your data structure without breaking deployed programs that are compiled against the "old" format."


### Advantages

- They have a strong interface
- They are a lot smaller than text-based data formats
- They are usually faster than JSON/XML when it comes to serialization/deserialization
- They are less ambiguous because of type and order
- They generate data access classes that are easier to use programmatically

### proto3

#### Message

A message is a resource that is transmitted to the receiver.
The fields listed below are Scalar types.

```
syntax 'proto3';

message NetworkInterface {
	int index = 1;
	int mtu = 2; # Maximum Transmission Unit (MTU)
	string = 3;
	string hardwareaddr = 4;
}
```

#### Types

|Go type|Protobuf Type|
|float32|float|
|float64|double|
|uint32|fixed32|
|uint64|fixed64|
|[]byte|bytes|

#### Default Values

|Protobuf Type|Default Value|
|string|""|
|bytes|empty bytes[]|
|bool|emty bytes[]|
|int,int32,int64,float,double|0|
|enum|0|
                    
# Enumerations and repeated fields

Enumerations (enum) provide the ordering of numbers for a given set of elements.

allow_alias can be used to define values that can have the same value in the data.

```
syntax 'proto3';

message Schedule{
	option allow_alias = true;
	enum Days{
		SUNDAY = 0;
		MONDAY = 1;
		TUESDAY = 2;
		WEDNESDAY = 3;
		THURSDAY = 4;
		FRIDAY = 5;
		SATURDAY = 0;
	}
}
```
Repeated fields define arrays/lists.
```
message Site{
	string url = 1;
    int latency = 2;
    repeated string proxies = 3;
}
```

#### Nested Fields

```
message Site {
	string url = 1;
	int latency = 2;
	repeated Proxy proxies = 3;
}
```

```
message Proxy {
	string url = 1;
	int latency = 2;
}
```

### Compiling

Protobuf file extensions are .proto.

1. Install the protoc command-line tool and the proto library.
2. Write a protobuf file with the .proto extension.
3. Compile the file so that it targets a programming language (in our case, it is Go).
4. Import structs from the generated target file and add the necessary data. 5. Serialize the data into binary format and send it to the receiver.
6. On a remote machine, the receiver deserializes the data and decodes data.

`brew install protobuf`

```
# Make sure you grab the latest version
   curl -OL https://github.com/protocolbuffers/protobuf/releases/download/
   v3.11.3/protoc-3.11.3-linux-x86_64.zip
   # Unzip
   unzip protoc-3.11.3-linux-x86_64.zip -d protoc3
   # Move only protoc* to /usr/bin/
   sudo mv protoc3/bin/protoc /usr/bin/protoc
```

```
syntax = "proto3";
package protofiles;

message Person {
	string name = 1;
    int32 id = 2; // Unique ID number for this person.
    string email = 3;
    enum PhoneType {
    	MOBILE = 0;
        HOME = 1;
        WORK = 2;
	}
    message PhoneNumber {
    	string number = 1;
        PhoneType type = 2;
	}
    repeated PhoneNumber phones = 4;
}
// Our address book file is just one of these.
message AddressBook {
	repeated Person people = 1;
}
```

#### Command

https://github.com/golang/protobuf

protoc --go_out=. * *.proto

#go get -u github.com/golang/protobuf/{proto,protoc-gen-go}
#go get google.golang.org/grpc/cmd/protoc-gen-go-grpc
#go install google.golang.org/grpc/cmd/protoc-gen-go-grpc

vim ~/.zshrc
export GO_PATH=~/go
export PATH=$PATH:/$GO_PATH/bin

#### Future versions will require in the proto file.
option go_package = "github.com/myuser/myprotos/team";

go get github.com/golang/protobuf/proto

### gRPC

gRPC is a transport mechanism that sends and receives messages between two systems. gRPC is specially designed to transfer data in the form of protocol buffers. 
A service in gRPC is an RPC contract. It takes a message and returns another message.

```
go get google.golang.org/grpc
go get -u github.com/golang/protobuf/protoc-gen-go
```

Services are only used in gRPC.

```
protoc -I protofiles/ protofiles/transaction.proto --
   go_out=plugins=grpc:protofiles
```
