#include <iostream>

// notes:
// operator delete cannot be invoked on any address contained in a pointer, rather only those that have been returned
// by `new` and only those that have not already been released by `delete`.

// Operators new and delete allocate memory from the free store. This is a memory abstraction in the form of a pool of
// memory where your application can allocate (that is, reserve) memory to de-allocate (that is, release) memory from.

int main()
{
    // Use the new keyword to allocate new memory blocks. This returns a pointer.
    // e.g. Type* Pointer = new Type;
    //      Type* Pointer = new Type[NumElements];
    int* pNumber = new int;
    int* pNumbers = new int[10];

    // Release memory allocated for the above instances.
    delete pNumber;
    delete[] pNumbers;

    return 0;
}
