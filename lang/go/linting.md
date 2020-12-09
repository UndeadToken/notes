# Linting

lint:
       golangci-lint run \
         --no-config --issues-exit-code=0 --deadline=30m \
         --disable-all --enable=deadcode  --enable=gocyclo --enable=golint \
         --enable=varcheck --enable=structcheck --enable=errcheck \
         --enable=dupl --enable=ineffassign \
         --enable=unconvert --enable=goconst --enable=gosec
         