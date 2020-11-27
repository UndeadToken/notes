#include <iostream>

// macro constants
#define PI 3.14159

// macro functions
#define SQUARE(x) ((x) * (x))

/*
 * Macro multiple inclusion guard.
 *
 * #ifndef HEADER1_H_
 * #define HEADER1_H_
 * #include <header1.h>
 * #endif
 */

#include <assert.h>

int main()
{
    std::cout << PI << std::endl;

    std::cout << SQUARE(6) << std::endl;

    assert(1 != NULL);

    return 0;
}
