#include <iostream>
#include <set>

template <typename T>
struct SortDescending
{
    bool operator ()(const T& lhs, const T& rhs) const
    {
        return (lhs > rhs);
    }
};

int main()
{
    using namespace std;

    set<int> setIntegers;
    multiset<int> msetIntegers;

    set<int, SortDescending<int>> setIntegers2;
    multiset<int, SortDescending<int>> msetIntegers2;

    set<int> setIntegers3(setIntegers);
    multiset<int> msetIntegers3(setIntegers.begin(), setIntegers.end());

    return 0;
}
