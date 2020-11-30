package main

import (
	"fmt"
	"github.com/gorilla/mux"
	"log"
	"net/http"
	"time"
)

// queryParams := r.URL.Query()

// r.HandlerFunc("/articles/{category}/{id:[0-9]+}", ArticleHandler).Name("articleRoute")
// url, err := r.Get("articleRoute").URL("category", "books", "id", "123")
// fmt.Printf(url.Path) // prints /articles/books/123

// r.PathPrefix("/static/").Handler(http.StripPrefix("/static/",
//   http.FileServer(http.Dir("/tmp/static"))))

// r.StrictSlash(true)
// r.Path("/articles/").Handler(ArticleHandler)

// r.UseEncodedPath()                   http://localhost:8000/books/2
// r.NewRoute().Path("/category/id")    http://localhost:8000/books%2F2

// text/template HTMLEscapeString

func ArticleHandler(w http.ResponseWriter, r *http.Request) {
	vars := mux.Vars(r)
	w.WriteHeader(http.StatusOK)
	fmt.Fprintf(w, "Category is: %v\n", vars["category"])
	fmt.Fprintf(w, "ID is: %v\n", vars["id"])
}
func main() {
	r := mux.NewRouter()
	r.HandleFunc("/articles/{category}/{id:[0-9]+}", ArticleHandler)
	srv := &http.Server{
		Handler:      r,
		Addr:         "127.0.0.1:8000",
		WriteTimeout: 15 * time.Second,
		ReadTimeout:  15 * time.Second,
	}
	log.Fatal(srv.ListenAndServe())
}
