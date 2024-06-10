package main

type Foo struct {
  A int
  B int
}

type Bar struct {
  Foo // embedded
  fizz int
}

func main() {
  var foo Foo

  foo2 := Foo{1, 2}

  bar := Bar
  bar.A // equal to bar.Foo.A

  bar2 := Bar{Foo{1, 2}, 1}
}
