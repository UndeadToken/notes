#include <iostream>

// Declare constructor private to disallow copying.
// Declare destructure private to disallow allocation on the stack and store on the heap instead.

class Foo
{
private:
    int value;
    double secret;

public:
    Foo()
    {
       value = 4;
       secret = 2;
    }

    // overloaded constructor via initialization list
    Foo(int a, int b, int c)
        :value(a * b * c), secret(c)
    {
        std::cout << value << std::endl;
    }

    // destructor.
    ~Foo()
    {
        std::cout << "am dead" << std::endl;
    }

    void setValue(int v)
    {
        value = v;
    }

    int getValue()
    {
        return value;
    }
};

int main()
{
    Foo* foo = new Foo();
    Foo bar(1, 2, 3);// or.. new Foo(1, 9, 2);

    std::cout << foo->getValue() << std::endl;
    std::cout << bar.getValue() << std::endl;

    foo->setValue(1);

    // -> dereferences the pointer, this can also be done using the dereference operator.
    std::cout << (*foo).getValue() << std::endl;

    return 0;
}
