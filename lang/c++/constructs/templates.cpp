#include <iostream>
#include <string>

// template function
template <typename T=std::string>
int max(T a, T b)
{
    return a > b ? a : b;
}

// template class
template <typename T>
class Foo
{
private:
    T value;

public:
    Foo(const T& t) :value(t) {}

    void show()
    {
        std::cout << value << std::endl;
    }
};

// template static class
template <typename T>
class TestStatic
{
public:
    static int StaticValue;
};

// static member initialization
template <typename T> int TestStatic<T>::StaticValue;

int main()
{
    int a = 1, b = 2;

    std::cout << max(a, b) << std::endl;

    Foo<int> foo (24);
    foo.show();

    TestStatic<int> bar;
    bar.StaticValue = 83;
    std::cout << bar.StaticValue << std::endl; // TestStatic<int>::StaticValue = 83;

    return 0;
}
