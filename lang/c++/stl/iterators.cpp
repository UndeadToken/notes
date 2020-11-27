#include <iostream>
#include <vector>

// Iterators
// Iterators in STL are template classes that in some ways are a generalization of pointers. These are template classes
// that give the programmer a handle by which he can work with and manipulate STL containers.

// Input Iterator
// One that can be dereferenced to reference an object. Input iterators of the purist kind garauntee read access only.

// Output Iterator
// One that allows the programmer to write to the collection. Output itertaors of the purist kind garauntee write access
// only.

// Iterators of the aforementioned types are further categorized into the following:
// Forward interator, Bidirectional iterator, Random access iterator

int main()
{
    std::vector<int> vec;

    vec.push_back(1);
    vec.push_back(2);
    vec.push_back(3);

    auto iter = vec.begin(); // std::vector<int>::iterator iter = vec.begin();

    while (iter != vec.end())
    {
        std::cout << *iter << std::endl;

        ++ iter;
    }

    return 0;
}
