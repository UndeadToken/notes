#include <iostream>
#include <memory> // include this to use std::unique_ptr

// A smart pointer is a class with overloaded operators
// std::auto_ptr is deprecated

class Foo
{
private:
    int Value;

public:
    Foo(int InputValue):Value(InputValue) {};

    void show()
    {
        std::cout << Value << std::endl;
    }
};

int main()
{
    std::unique_ptr<int> pDynamicAllocInteger(new int);
    *pDynamicAllocInteger = 42;

    // use smart pointer type like an int
    std::cout << *pDynamicAllocInteger << std::endl;

    std::unique_ptr<Foo> pFoo(new Foo(24));
    pFoo->show();

    return 0;
}
