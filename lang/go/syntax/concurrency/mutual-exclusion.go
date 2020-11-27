// A semaphore that counts only to one is called a binary sempahore

// Acquire token: sema <- struct{}{}
// Release token: <-sema

// Alternatively... use Mutex.

// sync.RWMutex mu.RLock(), mu.RUnlock() (Readers lock)

package main

import "sync"

var (
  mu sync.Mutex // guards balance
  balance int
)

func Deposit(amount int) {
  mu.Lock()
  balance = balance + amount
  defer mu.Unlock()
}

func Balance() int {
  mu.Lock()
  defer mu.Unlock()
  b := balance
  return b
}
