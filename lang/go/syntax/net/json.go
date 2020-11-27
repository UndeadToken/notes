package main

import (
  "net/http"
  "encoding/json"
  "log"
)

// Change output field `json:"message"`
// Exclude field `json:"-"`
// Exclude if empty `json:",omitempty"`
// Convert to string and rename `json:"id, string"`

type Request struct {
  Name string `json:"name"`
}

type Response struct {
  Message string `json:"message"`
}

func main() {
  http.HandleFunc("/", index)
  log.Fatal(http.ListenAndServe("localhost:8000", nil))
}

func index(w http.ResponseWriter, r *http.Request) {
  var request Request
  decoder := json.NewDecoder(r.Body)

  err := decoder.Decode(&request)
  if err != nil {
    http.Error(w, "Bad Request", http.StatusBadRequest)
    return
  }

  response := Response{Message:"Hello " + request.Name}

  encoder := json.NewEncoder(w)
  encoder.Encode(&response)
}
