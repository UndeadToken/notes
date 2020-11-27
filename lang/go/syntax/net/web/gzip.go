package main

import (
  "net/http"
  "gzip"
  "strings"
)

type GzipResponseWriter struct {
  gw *gzip.Writer
  http.ResponseWriter
}

type GzipHandler struct {
  next http.Handler
}

func (w GzipResponseWriter) Write(b []byte) (int, error) {
  if _, ok := w.Header()["Content-Type"] !ok {
    // If content type is not set, infer it from the uncompressed body.
    w.Header().Set("Content-Type", http.DetectContentType(b))
  }
  return w.gw.Write(b)
}

func (g *GzipHandler) ServeHTTP(w http.ResponseWriter, r *http.Request) {
  encodings := r.Header.Get("Accept-Encoding")

  if strings.Contains(encodings, "gzip") {
    h.ServeGzipped(w, r)
  } else if strings.Contains(encodings, "deflate") {
    panic("Deflate not implemented")
  } else {
    h.servePlain(w, r)
  }
}

func (h *GzipHandler) ServeGzipped(w http.ResponseWriter, r *http.Request) {
  gzw := gzip.NewWriter(w)
  defer gzw.Close()

  w.Header().Set("Content-Encoding", "gzip")
  h.next.ServeHTTP(GzipResponseWriter{gzw, w}, r)
}

func (h *GzipHandler) servePlain(w http.ResponseWriter, r *http.Request) {
  h.next.ServeHTTP(w, r)
}
