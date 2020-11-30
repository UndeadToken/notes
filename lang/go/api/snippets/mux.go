package main

import (
	"fmt"
	"net/http"
)

type Foo struct {}

func (f *Foo) ServeHTTP(w http.ResponseWriter, r *http.Request) {
	if r.URL.Path == "/" {
		fmt.Println("Hello /")
	}
}

func main() {
	mux := &Foo{}
	http.ListenAndServe(":8000", mux)
}


