#include <iostream>

// Type inference.
// Using auto, the Compilers Type Inference Capabilities.

// Usage in method.
void withoutAuto()
{
  for (vector<int>::const_iterator iterator = numbers.begin(); iterator < numbers.end(); ++ iterator)
    std::cout << iterator << std::endl;
}

void withAuto()
{
  for (auto iterator = numbers.begin(); iterator < numbers.end(); ++ iterator)
    std::cout << iterator << std::endl;
}

// Keyword usage.
int main()
{
  // The compiler attempts to identify a suitable type and assigns
  // the given variable the respective type.
  auto foo = true;
  auto bar = 1;
  auto fizz = "Hello";
  auto buzz = 0x023l;

  std::cout << buzz << std::endl;

  return 0;
}
