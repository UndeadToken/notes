# Tests

### Unit Tests
By definition, a unit is the smallest possible bit of code that we can test.

### terms

- A stub is the simplest test pattern and don't contain any real logic, they provide fixed answers to calls that are performed through the course of a test

- A spy is nothing more than a stub that keeps a detailed log of all the methods that are invoked on it

net/http/httptest.ResponseRecorder

// e.g. a spy representation to record items.
type spyFoo {
    published []...
}

func (p *spyFoo) Publish(a string) error {
    p.published = append(p.published, ...)
    return nil
}

- Mocks extend stubs with a list of calls the mock is expected to receive, their order and expected value as well as specify different return values for each method invocation depending on th argument

gomock

```
go get github.com/golang/mock/gomock
go install github.com/golang/mock/mockgen
```

The mockgen tool is responsible for analyzing either individual Go files or entire packages and generating mocks for all (or specific) interfaces that are defined within them.

- Source code scanning: We pass a Gi file to mockgen, which is then parsed in order to detect interface definitions.

- Reflection-assisted mode: We pass a package and a list of interfaces to mockgen. The tool uses the Go reflection package to analyze the structure of each interface.

```
mockgen \
    -destination mock/foo.go \
    github.com/foo \
    FOO
```
args: destination, package, interface

```
// Create a controller to manage all our mock objects and make sure
   // that all expectations were met before completing the test
   ctrl := gomock.NewController(t)
   defer ctrl.Finish()
   // Obtain a mock instance that implements API and associate it with the
   controller.
   api := mock_dependency.NewMockAPI(ctrl)


gomock.InOrder(
       api.EXPECT().
           ListDependencies("proj0").Return([]string{"proj1", "res1"}, nil),
       api.EXPECT().
           DependencyType("proj1").Return(dependency.DepTypeProject, nil),
       api.EXPECT().
           DependencyType("res1").Return(dependency.DepTypeResource, nil),
       api.EXPECT().
           ListDependencies("proj1").Return([]string{"res1", "res2"}, nil),
       api.EXPECT().
           DependencyType("res2").Return(dependency.DepTypeResource, nil),
)
```

