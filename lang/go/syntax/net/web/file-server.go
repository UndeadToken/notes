package main

import (
  "net/http"
  "log"
)

func main() {
  http.Handle("/", http.FileServer(http.Dir("./")))
  log.Fatal(http.ListenAndServe("localhost:8000", nil))
}
