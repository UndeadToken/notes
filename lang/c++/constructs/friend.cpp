#include <iostream>

class Foo
{
public:
    Foo()
    {
        value = 10;
    }

    int getValue()
    {
        return value;
    }

private:
    int value;

    friend class Bar;

    friend void thingy(Foo* foo);
};

class Bar
{
public:
    static void thingy(Foo* foo)
    {
        foo->value = 5;
    }
};

void thingy(Foo *foo) {
    foo->value = 2;
}

int main()
{
    Foo* foo = new Foo();

    std::cout << foo->getValue() << std::endl;

    thingy(foo);
    std::cout << foo->getValue() << std::endl;

    Bar::thingy(foo);
    std::cout << foo->getValue() << std::endl;

    return 0;
}
