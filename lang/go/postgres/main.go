package main

import (
    "database/sql"
    "log"

    _ "github.com/lib/pq" // To register the driver.
)

func main() {
    // Or as URL: postgresql://localhost/pqgo
    db, err := sql.Open("postgres", "host=localhost dbname=pqgo connect_timeout=5")
    if err != nil {
        log.Fatal(err)
    }
    defer db.Close()

    // db.Open() only creates a connection pool, and doesn't actually establish
    // a connection. To ensure the connection works you need to do *something*
    // with a connection.
    err = db.Ping()
    if err != nil {
        log.Fatal(err)
    }
}
