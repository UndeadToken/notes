package main

import "fmt"

type Notifiable interface {
  Notify(message string)
}

type User struct{}
type Customer struct{}

func (u User) Notify(message string) {
  fmt.Println(message)
}

func (c Customer) Notify(message string) {
  fmt.Println("Customer:", message)
}

func main() {
  user := User{}
  customer := Customer{}

  user.Notify("Hello")
  customer.Notify("World")
}
