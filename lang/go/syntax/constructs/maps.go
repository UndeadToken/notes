package main

func main() {
  m := make(map[string]int)

  foo := map[string]int {
    "a": 1,
    "b": 2
  }

  delete(foo, "b")
}
