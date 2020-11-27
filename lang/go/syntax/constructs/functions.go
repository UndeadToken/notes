package main

import (
  "fmt"
  "math"
)

func main() {
  foo := Point{1,2}
  bar := Point{3,4}

  bar.ScaleBy(4)

  // Point{1,2}.ScaleBy(1) compile error: can't take address of Point literal

  distance := foo.Distance(bar)

  fmt.Println(distance)
}

// anonymouse function
func foo() func() int {
  return func() int {
    return 0
  }
}

type Point struct{ X, Y float64 }

func (p Point) Distance(q Point) float64 {
  return math.Hypot(q.X - p.X, q.Y - p.Y)
}

func (p *Point) ScaleBy(factor float64) {
  p.X *= factor
  p.Y *= factor
}
