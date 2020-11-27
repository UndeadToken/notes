#include <iostream>

struct Foo
{
    explicit Foo(int age): age(age) {};

    int getAge()
    {
        return age;
    }

private:
    int age;
};

int main()
{
    Foo foo(100);

    std::cout << foo.getAge() << std::endl;

    return 0;
}
