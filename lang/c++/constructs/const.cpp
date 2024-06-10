#include <iostream>

// Do not use as is deprecated.
#define pi 3.41

constexpr double pi();

int main()
{
  const int foo = 1;

  std::cout << foo << std::endl;

  std::cout << pi() << std::endl;

  return 0;
}

// Return contant value.
constexpr double pi()
{
  return 22.0 / 7;
}
