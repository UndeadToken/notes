package main

import (
	"bufio"
	"encoding/json"
	"fmt"
	"io"
	"os"
)

type Config struct {
	Version int    `json:"version"`
	Name    string `json:"name"`
}

func main() {
	// Write file.
	err := os.WriteFile("foo.txt", []byte("sdfsadf"), 0644)
	if err != nil {
		panic(err)
	}

	// Read file.
	data, err := os.ReadFile("foo.txt")
	if err != nil {
		panic(err)
	}
	fmt.Println(string(data))

	// Open file.
	f, err := os.OpenFile("bar.txt", os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err != nil {
		panic(err)
	}
	defer f.Close()

	_, err = f.WriteString("\nAppended line")
	if err != nil {
		panic(err)
	}

	// Buffered file.
	f, err = os.Open("largefile.txt")
	if err != nil {
		panic(err)
	}
	defer f.Close()

	scanner := bufio.NewScanner(f)
	for scanner.Scan() {
		fmt.Println(scanner.Text())
	}

	if err := scanner.Err(); err != nil {
		panic(err)
	}

	// Buffered writer.
	f, err = os.Create("buf.txt")
	if err != nil {
		panic(err)
	}
	defer f.Close()

	w := bufio.NewWriter(f)
	_, err = w.WriteString("Buffered Write!\n")
	if err != nil {
		panic(err)
	}
	w.Flush()

	// Stream copy.
	src, err := os.Open("input.bin")
	if err != nil {
		panic(err)
	}
	defer src.Close()

	dst, err := os.Create("output.bin")
	if err != nil {
		panic(err)
	}
	defer dst.Close()

	_, err = io.Copy(src, dst)
	if err != nil {
		panic(err)
	}

	// Write struct.
	cfg := Config{Version: 1, Name: "foo"}
	b, err := json.MarshalIndent(cfg, "", "  ")
	if err != nil {
		panic(err)
	}
	os.WriteFile("cfg.json", b, 0644)

	// Read struct.
	var cfg2 Config
	b, err = os.ReadFile("cfg.json")
	if err != nil {
		panic(err)
	}

	err = json.Unmarshal(b, &cfg2)
	if err != nil {
		panic(err)
	}

	// Async writer.
	done := make(chan error, 1)
	go func() {
		err := os.WriteFile("fizz.txt", []byte("abc"), 0644)
		done <- err
	}()

	if err := <-done; err != nil {
		panic(err)
	}

	// Async reader.
	lines := make(chan string)
	errc := make(chan error, 1)

	go func() {
		defer close(lines)
		defer close(errc)

		f, err := os.Open("fizz.txt")
		if err != nil {
			errc <- err
			return
		}
		defer f.Close()

		sc := bufio.NewScanner(f)
		for sc.Scan() {
			lines <- sc.Text()
		}
		errc <- sc.Err()
	}()

	for line := range lines {
		fmt.Println(">", line)
	}

	if err := <-errc; err != nil {
		panic(err)
	}
}
