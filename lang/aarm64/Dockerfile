# Build stage
FROM arm64v8/ubuntu:24.04 AS builder

RUN apt-get update && \
    DEBIAN_FRONTEND=noninteractive apt-get install -y --no-install-recommends \
        build-essential ca-certificates && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /src
COPY snippets/hello_world.s .

# ensure /out exists
RUN mkdir -p /out

# build static ELF
RUN gcc -nostdlib -static -o /out/hello hello_world.s

# Final image
FROM scratch
COPY --from=builder /out/hello /hello
ENTRYPOINT ["/hello"]

