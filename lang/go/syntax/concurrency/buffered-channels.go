// A buffered channel has a queue of elements. The queue's maximum size is
// determined when it is created, by the capacity argument to `make`. If the
// channel is full the send operation blocks its goroutine until space is made
// available by another goroutines receive. Conversly if a channel is empty, a
// receive operation blocks until a value is sent by another goroutine.

// A send operation on a buffered channel sends an element to the back of the
// queue.

// A receive operation removes an element from the front of the queue.

// Determine capacity of a channel: cap(ch)
// Determine the length of a channel: len(ch)

// Return the result of the fastest goroutine to respond.
func mirroredQuery() string {
  responses := make(chan string, 3)
  go func() { responses <- request("asia.gopl.io") }()
  go func() { responses <- request("europe.gopl.io") }()
  go func() { responses <- request("americas.gopl.io") }()
  return <-responses // return the quickest response
}

func request(hostname string) (response string) { /** ... **/ }
