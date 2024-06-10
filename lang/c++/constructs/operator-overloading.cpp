#include <iostream>

// Unary operators are performed on a single operand.
// operators that function on two operands are called binary operators

class Foo
{
private:
    int value;

public:
    Foo(int InputValue) :value(InputValue) {}

    // unary increment operator (prefix)
    Foo& operator ++ ()
    {
        ++value;

        return *this;
    }

    // unary increment operator (postfix)
    Foo operator ++ (int)
    {
        Foo copy (value);

        ++value;

        return copy;
    }

    // unary decrement operator (prefix)
    Foo& operator -- ()
    {
        value--;

        return *this;
    }

    // unary decrement operator (postfix)
    Foo operator -- (int)
    {
        Foo copy (value);

        --value;

        return copy;
    }

    // binary addition operator
    Foo operator + (int theta)
    {
        value += theta;

        return *this;
    }

    // binary subtraction operator
    Foo operator - (int theta)
    {
        value -= theta;

        return *this;
    }

    // string concat
    /*FooString operator + (const FooString& str)
    {
        FooString newStr;

        if (str.buffer != NULL) {
            newStr.buffer = new char[GetLength() + strlen(str.buffer) + 1];
            strcpy(newStr.buffer, buffer);
            strcat(newStr.buffer, str.buffer);
        }
    }*/

    //augmented assignment
    void operator += (int theta)
    {
        value += theta;
    }

    // overloading equality
    bool operator == (const Foo& foo)
    {
        return value == foo.value;
    }

    // function operator
    void operator () (int a, int b)
    {
        std::cout << (a + b) << std::endl;
    }

    operator int()
    {
        return value;
    }

    operator double()
    {
        return (double) value;
    }

    void show()
    {
        std::cout << value << std::endl;
    }
};

int main()
{
    Foo foo (24);

    foo.show();

    ++foo;
    foo.show();

    foo++;
    foo.show();

    --foo;
    foo.show();

    foo--;
    foo.show();

    Foo bar = foo + 11;
    bar.show();

    bar = foo - 11;
    bar.show();

    foo += 80;
    foo.show();

    std::cout << (int) foo << std::endl;
    std::cout << (double) foo << std::endl;

    std::cout << (foo == bar) << std::endl;
    foo = bar + 0;
    std::cout << (foo == bar) << std::endl;

    foo(26, 4);

    return 0;
}
