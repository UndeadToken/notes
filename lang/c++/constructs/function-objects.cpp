#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

// Function objects
// On a conceptual level, functional objects are objects that work as functions.

// Unary function
// A function called with one argument. When a unary function returns a bool it is called a predicate.
template <typename T>
struct DisplayElement
{
public:
    int count;

    DisplayElement() :count(0) {}

    void operator () (const T& element)
    {
        ++ count;

        cout << element << ' ';
    }
};

template <typename T>
struct IsMultiple
{
    T divisor;

    IsMultiple (const T& divisor)
    {
        this->divisor = divisor;
    }

    bool operator () (const T& element) const
    {
        return ((element % divisor) == 0);
    }
};

// Binary function
// A function called with two arguments. A binary function that returns a bool is called a binary predicate.
template <typename T>
class Multiply
{
public:
    T operator () (const T& elem1, const T& elem2)
    {
        return (elem1 * elem2);
    }
};

int main()
{
    vector<int> vec{1,2,4,8,16,32,64,128};

    // Unary

    DisplayElement<int> result;
    result = for_each(vec.begin(), vec.end(), DisplayElement<int>());
    cout << result.count << endl;

    int divisor = 2;
    auto iter = find_if(vec.begin(), vec.end(), IsMultiple<int>(divisor));
    if (iter != vec.end())
    {
        cout << *iter << endl;
    }

    // Binary
    vector<int> vecResult;
    vecResult.resize(vec.size());
    transform(vec.begin(), vec.end(), vec.begin(), vecResult.begin(), Multiply<int>());
    for_each(vecResult.begin(), vecResult.end(), DisplayElement<int>());

    return 0;
}
