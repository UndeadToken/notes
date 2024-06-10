#include <iostream>
#include <bitset>
#include <vector>

using namespace std;

// Bit Flags
// Bits can be a very efficient way of storing settings and flags.

int main()
{
    // bitsets
    bitset<4> bt;
    bitset<5> bt2 ("10101");
    bitset<8> bt3 = (256);
    bitset<8> bt4 = (bt3);

    // vectors
    vector<bool> vec (10, true);

    return 0;
}
