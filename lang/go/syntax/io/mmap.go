package main

import (
	"fmt"
	"os"

	"golang.org/x/sys/unix"
)

func mmapRead(filename string) ([]byte, error) {
	f, err := os.Open(filename)
	if err != nil {
		return nil, err
	}
	defer f.Close()

	stat, err := f.Stat()
	if err != nil {
		return nil, err
	}

	data, err := unix.Mmap(
		int(f.Fd()),
		0,                // offset
		int(stat.Size()), // length
		unix.PROT_READ,
		unix.MAP_SHARED,
	)
	return data, err
}

func mmapWrite(filename string, size int) ([]byte, func() error, error) {
	f, err := os.OpenFile(filename, os.O_RDWR|os.O_CREATE, 0644)
	if err != nil {
		return nil, nil, err
	}

	if err := f.Truncate(int64(size)); err != nil {
		return nil, nil, err
	}

	data, err := unix.Mmap(
		int(f.Fd()),
		0,
		size,
		unix.PROT_READ|unix.PROT_WRITE,
		unix.MAP_SHARED,
	)
	if err != nil {
		return nil, nil, err
	}

	unmap := func() error {
		return unix.Munmap(data)
	}

	return data, unmap, nil
}

func main() {
	// Write.
	buf, unmap, err := mmapWrite("mapped.bin", 1024)
	if err != nil {
		panic(err)
	}
	defer unmap()

	copy(buf[:11], []byte("Hello mmap"))

	// Read.
	data, err := mmapRead("bigfile.bin")
	if err != nil {
		panic(err)
	}

	fmt.Println("first 64 bytes:", data[:64])
}
