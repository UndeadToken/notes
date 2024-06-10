package main

import (
  "net/http"
  "testing"
  "fmt"
  "context"
)

// type validationContextKey string
// c := context.WithValue(r.Context(), validationContextKey("name"), request.Name)
// r = r.WithContext(c)
// name := r.Context().Value(validationContextKey("name")).(string)

func fetchGoogle(t *testing.T) {
  r, _ := http.NewRequest("GET", "https://google.com", nil)

  timeoutRequest, cancelFunc := context.WithTimeout(r.Context(), *time.Millisecond)
  defer cancelFunc()

  r = r.WithContext(timeoutRequest)

  _, err := http.DefaultClient.Do(r)
  if err != nil {
    fmt.Println("Error:", err)
  }
}
