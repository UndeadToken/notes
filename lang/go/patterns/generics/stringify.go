package generics

import "fmt"

func StringifyAll[E any](s []E, stringify func(E) string) []string {
	out := make([]string, len(s))
	for i, v := range s {
		out[i] = stringify(v)
	}
	return out
}

func StringerAll[E fmt.Stringer](s []E) []string {
	out := make([]string, len(s))
	for i, v := range s {
		out[i] = v.String()
	}
	return out
}

func doStringify() {
	// time.Time.String has type func(time.Time) string
	//strings := StringifyAll(times, time.Time.String)

	// strconv.Itoa has type func(int) string
	// strings := StringifyAll(ints, strconv.Itoa)
}
