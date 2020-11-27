#include <iostream>

void foo(double& bar)
{
    bar *= bar;
}

int main()
{
    double a = 1.4;

    foo(a);

    std::cout << a << std::endl;

    return 0;
}
