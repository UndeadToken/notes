package main

import (
  "net/http"
  "encoding/json"
)

type validationHandler struct {
  next http.Handler
}

func NewValidationHandler(next http.Handler) http.Handler {
  return validationHandler{next:next}
}

func (h validationHandler) ServeHTTP(w http.ResponseWriter, r *http.Request) {
  var request helloWorldRequest
  decoder := json.NewDecoder(r.Body)

  err := decoder.Decode(&request)
  if err != nil {
    http.Error(w, "bad request", http.StatusBadRequest)
    return
  }

  h.next.ServeHTTP(w, r)
}

type helloWorldHandler struct {}

func newHelloWorldHandler() http.Handler {
  return helloWorldHandler{}
}

func (h helloWorldHandler) ServeHTTP(w http.ResponseWriter, r *http.Request) {
  response := helloWorldHandler{Message: "Hello " + name}

  encoder := json.NewEncoder(w)
  encoder.Encode(response)
}
