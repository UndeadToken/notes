package main

import (
  "fmt"
  "time"
)

// case <-ch
// case x := <-ch
// case ch <- y

func main() {
  abort := make(chan struct{})
  go func() {
    time.Sleep(5 * time.Second)
    abort <- struct{}{}
  }()

  fmt.Println("Commencing countdown.")
  for i := 10; i > 0; i-- {
    select {
    case <-abort:
      fmt.Println("Launch aborted!")
      return
    default:
      fmt.Println(i)

    time.Sleep(1 * time.Second)
    }
  }
}
