package main

import (
  "fmt"
  "log"
  "net/http"
)

var upgrader = websocket.Upgrader{
  ReadBufferSize: 1024,
  WriteBufferSize: 1014
}

func homePage(w http.ResponseWriter, r *http.Request) {
  fmt.Fprintf(w, "Home Page")
}

func wsEndpoint(w http.ResponseWriter, r *http.Request) {
  upgrader.CheckOrigin = func(r *http.Request) bool { return true }

  ws, err := upgrader.Upgrade(w, r, nil)
  if err != nil {
    log.Println(err)
  }

  log.Println("Client connected")

  reader(ws)
}

func reader(conn *websocket.Conn) {
  for {
    messageType, p, err := conn.ReadMessage()
    if err != nil {
      log.Println(err)
      return
    }

    fmt.Println(string(p))

    //err = ws.WriteMessage(1, []byte("Hi Client"))
    if err := conn.WriteMessage(messageType, p); err != nil {
      log.Println(err)
      return
    }
  }
}

func setupRoutes() {
  http.HandleFunc("/", homePage)
  http.HandleFunc("/ws", wsEndpoint)
}

func main() {
  fmt.Println("Hello World")
  setupRoutes()
  log.Fatal(http.ListenAndServe(":8080", nil))
}
