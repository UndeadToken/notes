package main

import (
  "fmt"
  "os"
)

func main() {
  foo, bar := "", ""
  for _, arg := range os.Args[1:] {
    foo += bar + arg
    bar = " "
  }
  fmt.Println(foo)
}
