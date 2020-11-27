#include <iostream>
#include <bitset>

using namespace std;

int main()
{
  int value = 101;

  bitset<8> bits (value);
  bitset<8> bitsnot = (~value);
  bitset<8> bitsand = (value & value);
  bitset<8> bitsor = (value | value);
  bitset<8> bitsxor = (0x0F ^ value);

  cout << bitsxor << endl;
  cout << (value << 1) << endl;
  cout << (value >> 1) << endl;

  return 0;
}
