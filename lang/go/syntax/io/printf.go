package main

import "fmt"

// %d        decimal integer
// %x,%o,%b  integer in hexidecimal, octal, binary
// %f,%g,%e  floating-point number: 3.141593 3.141592653589793 3.141593e+00
// %t        boolean: true or false
// %c        rune (Unicode code point)
// %s        string
// %q        quoted string "abc" or rune "c"
// %v        any value in a natural format
// %T        type of any value
// %%        literal percent sign (no operand)

func main() {
  foo := "Hello, Go!"
  bar := 100
  fizz := 3.14
  buzz := 3.1415926535897

  fmt.Printf("%s: %d, %f, %g\n", foo, bar, fizz, buzz)
}
