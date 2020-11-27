package main

import "testing"

// go test -v -run="none" -bench=. -benchtime="5s" -benchmem

func TestFoo(t *testing.T) {
  t.Error(`failed...`)
}

func BenchmarkFoo(b *testing.B) {
  for i := 0; i < b.N; i++ {

  }
}
