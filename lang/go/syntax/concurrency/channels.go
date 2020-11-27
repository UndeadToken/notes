package main

// operations:
// send, receive, close

// ch <- x    A send statement
// x = <-ch   A receive expression in an assignment statement
// <-ch       A receive statement; result is discarded

// to close a channel: close(ch)
// a channel created with a simple call to make is called an unbuffered channel
// unless the second arg to make is provided (capacity) in which case it creates
// a buffered channel.

// ch = make(chan int)     ubuffered channel
// ch = make(chan int, 0)  unbuffered channel
// ch = make(chan int, 3)  buffered channel with capacity 3

// A send operation on an unbuffered channel blocks the sending goroutine until
// another goroutine executes a corresponding receive on the same channel.
// Conversely if a the receive operation was attempted first, the receiving
// goroutine is blocked until another goroutine performs a send on the same channel.

// Communication over an unbuffered channel causes the sending and receiving
// goroutines to synchronize, because of this they are known as synchronous channels.

import (
  "net"
  "io"
  "log"
  "os"
  "fmt"
)

func main() {
  messages := make(chan string)

  go func() {
    messages <- "ping"
  }()

  msg := <-messages
  fmt.Println(msg)
}

func dial() {
  conn, err := net.Dial("tcp", "localhost:8000")
  if err != nil {
    log.Fatal(err)
  }
  done := make(chan struct{})
  go func() {
    io.Copy(os.Stdout, conn) // NOTE: ignoring errors
    log.Println("done")
    done <- struct{}{} // signal the main goroutine
  }()
  //mustCopy(conn, os.Stdin)
  conn.Close()
  <-done // wait for background goroutine to finish
}
