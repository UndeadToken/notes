package main

import (
  "fmt"
  "log"
  "encoding/json"
)

// decode: json.Unmarshal([]byte(myJsonString), &myvar)

type Foo struct {
  Fizz string
  Buzz int
}

func main() {
  var foos = []Foo{
    {Fizz:"foo", Buzz:1}, {Fizz:"bar", Buzz:2},
  }

  data, err := json.Marshal(foos)
  if err != nil {
    log.Fatalf("JSON marshaling failed: %s", err)
  }

  fmt.Printf("%s\n", data)
}
