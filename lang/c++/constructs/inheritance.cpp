#include <iostream>

// : public class, derived class is a base class.
// : private class, derived class has a base class.

class Foo
{
private:
    int value;

public:
    explicit Foo(int v) :value(v)
    {

    }

    void show()
    {
        std::cout << "Hello from foo!" << std::endl;
    }
};

class Bar : public Foo
{
public:
    Bar() :Foo(1){} // initialise constructor with value 1.

    void show()
    {
        std::cout << "Hello from Bar!" << std::endl;
    }
};

int main()
{
    Foo* foo = new Foo(1);
    Bar* bar = new Bar();

    foo->show();
    bar->show();

    return 0;
}
