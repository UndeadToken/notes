package main

import "net/http"

func handler(w http.ResponseWriter, r *http.Request) {
  if r.Method == "OPTIONS" {
    w.Header().Add("Access-Control-Allow-Origin", "*")
    w.Header().Add("Access-Control-Allow-Methods", "GET")
    w.WriteHeader(http.StatusNoContent) // 204 No Content
    return
  }
}
