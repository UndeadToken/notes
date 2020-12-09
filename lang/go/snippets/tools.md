# Tools

gofmt -r ‘a[b:len(a)] -> a[len(a):b]’ example.go

go get golang.org/x/tools/cmd/goimports

gorename, gomvpkg
```
go get golang.org/x/tools/cmd/gorename
go get golang.org/x/tools/cmd/gomvpkg
```

Rename foo to bar and update all imports for packages depending on foo.
```
gomvpkg -from foo -to bar
```