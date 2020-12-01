package main

import (
	"context"
	"fmt"
	"log"

	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
	"gopkg.in/mgo.v2/bson"
)

type Container struct {
	Name string `bson:"name"`
	Ports []uint16 `bson:"ports"`
}

func connect() *mongo.Client {
	clientOptions :=
		options.Client().ApplyURI("mongodb://localhost:27017")
	client, err := mongo.Connect(context.TODO(), clientOptions)
	if err != nil {
		panic(err)
	}
	err = client.Ping(context.TODO(), nil)
	if err != nil {
		log.Fatal(err)
	}
	return client
}

func disconnect(client *mongo.Client) {
	err := client.Disconnect(context.TODO())
	if err != nil {
		panic(err)
	}
	fmt.Println("Disconnected from MongoDB")
}

func main() {
	client := connect()
	defer disconnect(client)

	fmt.Println("Connected to MongoDB successfully")
	collection := client.Database("appDB").Collection("containers")

	container := Container{
		Name: "MinIO",
		Ports: []uint16{1,2,3},
	}

	_, err := collection.InsertOne(context.TODO(), container)
	if err != nil {
		log.Fatal(err)
	}

	q := &Container{}
	filter := bson.M{"name": bson.M{"$eq": "MinIO"}}
	result := collection.FindOne(context.TODO(), filter)
	err = result.Decode(q)
	if err != nil {
		log.Fatal(err)
	}

	fmt.Println("Container: ", q)
}

