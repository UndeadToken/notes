package main

import (
  "fmt"
  "log"
  "time"
  "net/http"
  "os"
  "errors"
  "bufio"
)

// EOF is the rror returned by Read when no more input is available
// var EOF = errors.New("EOF")

func main() {
  log.SetPrefix("wait:")
  log.SetFlags(0)

  if err := WaitForServer(os.Args[1]); err != nil {
    log.Fatalf("Site is down: %v\n", err)
  }
}

func WaitForServer(url string) error {
  const timeout = 1 * time.Minute
  deadline := time.Now().Add(timeout)

  for tries := 0; time.Now().Before(deadline); tries++ {
    _, err := http.Head(url)
    if err == nil {
      return nil
    }
    log.Printf("Server not responding (%s); retrying...", err)
    time.Sleep(time.Second << uint(tries))
  }
  return fmt.Errorf("Server %s failed to respond after %s", url, timeout)
}

func read() {
  in := bufio.NewReader(os.Stdin)
  for {
    r, _, err := in.readRune()
    if err == io.EOF {
      break // finished reading
    }
    if err != nil {
      return fmt.Errorf("read failed: %v", err)
    }
  }
}
