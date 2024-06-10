package main

import "fmt"

func main() {
  foo := 1
  bar := &foo

  fmt.Println(bar)
  *bar = 2
  fmt.Println(*bar)
}
