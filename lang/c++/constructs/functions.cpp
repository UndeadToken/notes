#include <iostream>

int foo(int i);

int main()
{
  int i = foo(1337);

  std::cout << i << std::endl;
}

int foo(int i)
{
  return i * 10;
}
