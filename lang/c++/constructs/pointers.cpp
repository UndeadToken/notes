#include <iostream>

// notes:
// a pointer that points to a block of memory is called a void pointer.
// pointers contain random values until initialized. always initialize.
// determine address of a variable using the Reference Operator or "address-of operator" "&".
// the dereference operator / indirection operator is used to fetch a value from a pointer "*".

// Incrementing a pointer points the pointer to the next type, not the next byte.

// Constant pointers have three kinds.
// 1.) data pointed to is constant and cannot be changed:
//     const int* foo = &bar;
// 2.) address contained in pointer is constant, but the data is not.
//     int* const foo = &bar;
// 3.) both address and value are constant.
//     const int* const foo = &bar;

// Arrays are accessed differently.
// int numbers[4] = {1,2,3};
// int* pNumbers = numbers; // Points to first element in array.
// pNumbers[index] // or...
// *(numbers + index) // Access any index in the array through the pointer.

int main()
{
    int foo = 24;

    int* pFoo = &foo;

    std::cout << "Address: " << pFoo << std::endl;
    std::cout << "Value: " << *pFoo << std::endl;

    *pFoo = 32;

    std::cout << "Value: " << *pFoo << std::endl;

    return 0;
}
