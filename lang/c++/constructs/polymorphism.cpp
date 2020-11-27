#include <iostream>

class Base
{
public:
    virtual void show() = 0; // pure virtual method, must be implemented.
};

class Foo: public virtual Base
{
public:
    void show()
    {
        std::cout << "Hello, Foo" << std::endl;
    }

    Foo()
    {
        std::cout << "Constructing, Foo" << std::endl;
    }

    virtual ~Foo()
    {
        std::cout << "Destructing, Foo" << std::endl;
    }
};

class Bar : public Foo
{
public:
    void show()
    {
        std::cout << "Hello, Bar" << std::endl;
    }

    Bar()
    {
        std::cout << "Constructing, Bar" << std::endl;
    }

    ~Bar()
    {
        std::cout << "Destructing, Bar" << std::endl;
    }
};

int main()
{
    Foo* foo = new Foo();
    foo->show();
    delete foo;

    Bar* bar = new Bar();
    bar->show();
    delete bar;

    return 0;
}
