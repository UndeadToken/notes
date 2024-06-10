#include <iostream>

// Substitute variable types.
typedef unsigned int STRICTLY_UNSIGNED_INTEGER;

int main()
{
  STRICTLY_UNSIGNED_INTEGER foo = 4532;

  std::cout << sizeof(foo) << std::endl;

  return 0;
}
