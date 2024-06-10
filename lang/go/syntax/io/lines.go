package main

import (
  "bufio"
  "fmt"
  "os"
)

func main() {
  files := os.Args[1:]

  for _, arg := range files {
    f, err := os.Open(arg)
    if err != nil {
      fmt.Fprintf(os.Stderr, "%v\n", err)
      continue
    }
    countLines(f)
  }
}

func countLines(f *os.File) {
  input := bufio.NewScanner(f)
  for input.Scan() {
    fmt.printf("%d", input.Text())
  }
}
