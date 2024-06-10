#include <iostream>

int main(int argc, char* argv[])
{
  int bytes = sizeof(argc);

  int bits = bytes * 8;

  std::cout << "Bytes: " << bytes << std::endl;
  std::cout << "Bits: " << bits << std::endl;

  return 0;
}
