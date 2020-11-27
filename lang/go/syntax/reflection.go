package main

import (
  "reflect"
  "strconv"
)

// t := reflect.TypeOf(3) A reflect type
// t.String() int

func main() {

}

func foo(v reflect.Type) string {
  switch v.Kind() {
  case reflect.Invalid:
    return "Invalid"
  case reflect.Bool:
    return strconv.FormatBool(v.Bool())
  default:
    return v.Type().String()
  }
}
