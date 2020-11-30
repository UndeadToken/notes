package main

import (
	"fmt"
	"net/http"
	"log"

	"github.com/julienschmidt/httprouter"
)

func main() {
	router := httprouter.New()
	router.GET("/api/v1/", hello)
	log.Fatal(http.ListenAndServe(":8000", router))
}

func hello(w http.ResponseWriter, r *http.Request, params httprouter.Params) {
	fmt.Println("Hello")
}

