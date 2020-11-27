package main

import (
  "fmt"
  "sync"
)

var mu sync.Mutex
var count int

func main() {
  for i := 0; i < 10; i++ {
    go foo()
  }
}

func foo() {
  mu.Lock()
  count++
  mu.Unlock()
}
