package main

// The defer statement defers the execution of the statement until
// the surrounding function has returned, however is evaluated immediately

import "fmt"

func main() {
  defer fmt.Println("world")
  fmt.Println("hello")
}
