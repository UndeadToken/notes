package main

import (
  "fmt"
)

type Celsius float64
type Fahrenheit float64

const (
  AbsoluteZeroC Celsius = -273.15
  FreezingC Celsius = 0
  BoilingC Celsius = 100
)

func CToF(c Celsius) Fahrenheit {
  return Fahrenheit(c * 9 / 5 + 32)
}

func FToC(f Fahrenheit) Celsius {
  return Celsius((f - 32) * 5 / 9)
}

func (c Celsius) String() string {
  return fmt.Sprintf("%gC", c)
}

func gcd(x, y int) int {
  for y != 0 {
    x, y = y, x%y
  }
  return x
}

func fib(n int) int {
  x, y := 0, 1
  for i := 0; i < n; i++ {
    x, y := y, x+y
  }
  return x
}
