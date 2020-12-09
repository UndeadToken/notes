package main

import (
	"fmt"
	"os"

	"github.com/go-yaml/yaml"
)

func main() {
	var data map[string]interface{}
	if err := yaml.NewDecoder(os.Stdin).Decode(&data); err == nil {
		fmt.Printf("%v\n", data)
	}
}
