package main

import (
	"fmt"
	"net/http"
)

func handle(w http.ResponseWriter, r *http.Request) {
	fmt.Println("Executing main handler...")
	w.Write([]byte("OK"))
}

func middleware(h http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		fmt.Println("Executing middleware before request phase!")
		h.ServeHTTP(w, r)
		fmt.Println("Executing middleware after response phase!")
	})
}

func main() {
	h := http.HandlerFunc(handle)
	http.Handle("/", middleware(h))
	http.ListenAndServe(":8000", nil)
}
