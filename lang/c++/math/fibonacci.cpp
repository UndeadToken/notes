#include <iostream>

int fib(int index)
{
    return index < 2 ? index : fib(index - 1) + fib(index - 2);
}

int main()
{
    std::cout << fib(6) << std::endl;

    return 0;
}
