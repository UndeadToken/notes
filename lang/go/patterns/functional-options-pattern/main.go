package main

import (
	"fmt"
	"maps"
	"time"
)

type HttpClient struct {
	Timeout time.Duration
	Headers map[string]string
	Retries int
	Tls     bool
}

// Option defines the function type that will apply settings to HttpClient
type Option func(*HttpClient)

// NewHttpClient creates an HttpClient instance with functional options
func NewHttpClient(opts ...Option) *HttpClient {
	client := &HttpClient{
		Timeout: 30 * time.Second, // default value
		Headers: make(map[string]string),
		Retries: 3, // default value
		Tls:     false,
	}

	// Apply the provided options
	for _, opt := range opts {
		opt(client)
	}

	return client
}

func WithTls(c *HttpClient) {
	c.Tls = true
}

// WithTimeout allows you to set the client timeout
func WithTimeout(timeout time.Duration) Option {
	return func(c *HttpClient) {
		c.Timeout = timeout
	}
}

// WithHeaders allows you to add custom headers
func WithHeaders(headers map[string]string) Option {
	return func(c *HttpClient) {
		maps.Copy(c.Headers, headers)
		//for k, v := range headers {
		//	c.Headers[k] = v
		//}
	}
}

// WithRetries allows you to set the number of reconnection attempts
func WithRetries(retries int) Option {
	return func(c *HttpClient) {
		c.Retries = retries
	}
}

func main() {
	client := NewHttpClient(
		WithTimeout(10*time.Second),
		WithTls,
		WithHeaders(map[string]string{"Authorization": "Bearer token"}),
	)

	fmt.Printf("Timeout: %v, Headers: %v, Retries: %d\n", client.Timeout, client.Headers, client.Retries)
}
