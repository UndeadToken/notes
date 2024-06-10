#include <algorithm>
#include <iostream>
#include <vector>
#include <list>

using namespace std;

// Algorithms
// Provides finding, sorting and reversing utilities.
// STL algorithms can be broadly classified into two types: non-mutating and mutating algoritms.
// includes std::find, std::find_if, std::reverse, std::remove_if, std::transform
// see also copy, copy_if, replace, partition, stable_partition, upper_bound, lower_bound

int main()
{
    vector<int> vec {1, 2, 3};

    auto iter = find(vec.begin(), vec.end(), 2);

    if (iter != vec.end())
    {
        int position = distance(vec.begin(), iter);
        cout << "value: " << *iter << endl;
        cout << "position: " << position << endl;
    }

    // random initialization
    vector<int> vec2 (10);
    generate(vec2.begin(), vec2.end(), rand);

    list<int> list1 (10);
    generate_n(list1.begin(), 5, rand);

    return 0;
}
