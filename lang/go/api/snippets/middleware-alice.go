package main

import (
	"github.com/justinas/alice"
	"log"
	"net/http"
	"strconv"
	"time"
)

func handle(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("Hello Alice"))
}

func setServerTimeCookie(handler http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		handler.ServeHTTP(w, r)
		// Setting cookie to every API response
		cookie := http.Cookie{Name: "Server-Time(UTC)",
			Value: strconv.FormatInt(time.Now().Unix(), 10)}
		http.SetCookie(w, &cookie)
		log.Println("Currently in the set server time middleware")
	})
}


func main() {
	h := http.HandlerFunc(handle)
	chain := alice.New(setServerTimeCookie).Then(h)
	http.Handle("/", chain)
	http.ListenAndServe(":8000", nil)
}

