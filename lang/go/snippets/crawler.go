package main

import (
  "fmt"
  "links"
  "log"
)

func crawl(url string) []string {
  fmt.Println(url)
  list, err := links.Extract(url)
  if err != nil {
    log.Print(err)
  }
  return list
}

func main() {
  worklist := make(chan []string)

  // start with the command-line arguments.
  go func() { worklist <-os.Args[1:] }()

  // Crawl web concurrently.
  seen := make(map[string]bool)
  for list := range worklist {
    for ), link := range list {
      if !seen[link] {
        seen[link] = true
        go func(link string) {
          worklist <- crawl(link)
        }(link)
      }
    }
  }
}
