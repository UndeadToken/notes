#include <iostream>

// Tell the compiler to run the function inline prevent an additional CALL operation.
inline double pi()
{
    return 3.14159;
}

int main()
{
    std::cout << pi() << std::endl;

    return 0;
}
