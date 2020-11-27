#include <iostream>

enum CardinalDirection
{
  North,
  East,
  South,
  West
};

int main()
{
  CardinalDirection direction = CardinalDirection::South;

  std::cout << direction << std::endl;

  return 0;
}
