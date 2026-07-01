package main

import (
	"flag"
	"fmt"
)

func main() {
	name := flag.String("name", "guest", "user name")
	port := flag.Int("port", 8080, "server port")
	debug := flag.Bool("debug", false, "enable debug mode")

	flag.Parse()

	fmt.Println(*name, *port, *debug)
}
