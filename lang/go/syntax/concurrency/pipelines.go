package main

// Pipelins connect goroutines that the output of one is the input to another

import "fmt"

func main() {
  naturals := make(chan int)
  squares := make(chan int)

  // Counter
  go func() {
    for x := 0; x < 100; x++ {
      naturals <- x
    }
    close(naturals)
  }()

  go func() {
    for {
      x, ok := <-naturals
      if !ok {
        break // Channel was closed and drained
      }
      squares <- x * x
    }
    close(squares)
  }()

  for x := range squares {
    fmt.Println(x)
  }
}
