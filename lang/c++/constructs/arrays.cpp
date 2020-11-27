#include <iostream>
#include <vector>

int main()
{
  // 1 dimensional.
  int foo[5] = {0};

  int bar[] = {1, 2, 3, 4};

  char characters[5];

  // 2 dimensional.
  int x[3][5];

  int y[2][3] = {{1,2,3},{1,2,3}};

  std::cout << bar[1] << std::endl;

  std::cout << y[1][2] << std::endl;

  // Dynamic arrays.
  std::vector<int> fizz;

  fizz.push_back(1);

  std::cout << fizz.size() << std::endl;

  std::vector<int> a(3);
  std::vector<int> b{ 1, 2, 3 };

  return 0;
}
