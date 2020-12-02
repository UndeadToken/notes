package main

import (
	"context"
	"log"

	proto "../protofiles"
	micro "github.com/micro/go-micro"
)

// ProcessEvent processes a weather alert
func ProcessEvent(ctx context.Context, event *proto.Event) error {
	log.Println("Got alert:", event)
	return nil
}

func main() {
	// Create a new service
	service := micro.NewService(micro.Name("weather_client"))
	// Initialise the client and parse command line flags
	service.Init()
	micro.RegisterSubscriber("alerts", service.Server(), ProcessEvent)

	if err := service.Run(); err != nil {
		log.Fatal(err)
	}
}

