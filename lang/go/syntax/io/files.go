package main

import (
  "io/ioutil"
  "fmt"
  "os"
  "strings"
)

// in, err := os.Open(infile)
// out, err := os.Create(outfile)
// ioutil.TempDir("", "scratch")
// ioutil.ReadAll(file)
// os.Stat(path)
// os.MkdirAll(dir, 0755)

func main() {
  for _, filename := range os.Args[1:] {
    data, err := ioutil.ReadFile(filename)

    if err != nil {
      fmt.Fprintf(os.Stderr, "%v\n", err)
      continue
    }

    for _, line := range strings.Split(string(data), "\n") {
      fmt.Printf("%s", line)
    }
  }
}
