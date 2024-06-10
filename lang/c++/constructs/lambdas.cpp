#include <iostream>
#include <vector>
#include <algorithm>

int main()
{
    std::vector<int> vec{1,2,3,4};

    for_each(vec.begin(), vec.end(), [](int& i) {
        std::cout << i << std::endl;
    });

    // Lambda expression with state via capture lists
    int divisor = 2;
    auto iter = find_if(vec.begin(), vec.end(), [divisor](int& dividend) {
        return ((dividend % divisor) == 0);
    });

    if (iter != vec.end())
    {
        std::cout << *iter << std::endl;
    }

    return 0;
}
