.PHONY: all clean build run

# default target
all: build

# build docker image (compiles asm inside builder stage)
build:
	docker build --platform linux/arm64 -t arm64-hello .

# run the container
run:
	docker run --rm --platform linux/arm64 arm64-hello

# cleanup (optional)
clean:
	-docker rmi arm64-hello 2>/dev/null || true

