# Versioning

### Semantic Versioning
MAJOR.MINOR.PATCH

patch: backward-compatible bug fix
minor: new functionality (if new version backwards compatible)
major: Breaking changes

### Managing versions

version directories:
e.g. $GOPATH/
    github.com
        foo-as-a-service
            foo
                v1
                    bar
                v2
                    fizz
                        buzz
                    bar
### Branches / tags
gopkg.in allows easy versioning.
```
go get -u gopkg.in/foo/bar.v1

import "gopkg.in/foo/bar.v1
```

Compare versions:
```
// SemVer contains the major, minor, patch components of a semantic version
   // string.
   type SemVer [3]int
   // GreaterThan returns true if the receiver version is greater than other.
   func (sv SemVer) GreaterThan(other SemVer) bool {
       for i, v := range sv {
           if v != other[i] {
               return v > other[i]
           }
}
       return false
   }
```
### Vendoring
GO15VENDOREXPERIMENT
godep, govendor, glide, gvt

The output of the dep constraints solver is the highest possible supported version across all dependencies.

go get -u github.com/golang/dep/cmd/dep
dep init
dep 
dep ensure ...
dep ensure -vendor-only

gopkg.toml serves as a manifest

github.com/golang/dep/gps

go mod init
go mod vendor (for backwards compatibility for populating vendor directories)

go mod init foo

Go od will require the minimum supported version for packages unless :
- go get -u: To upgrade to the most recent minor or patch release
- go get -u=patch: To upgrade to the most recent patch release
- go get package-name@version: To force the specified version for the package

