#include <iostream>
#include <vector>

void doWhileLoop()
{
    int foo = -10;

    do
    {
        std::cout << foo << std::endl;

        foo++;

    } while (foo < 1);
}

void whileLoop()
{
    int foo = 1;

    while(foo < 10) {
        std::cout << foo++ << std::endl;
    }
}

void forLoop()
{
    int foo[] = {1,2,3,4};

    for (int i = 0; i<4; i++) {
        std::cout << foo[i] << std::endl;
    }
}

void forEachLoop()
{
    std::vector<int> foo = {1,2,3,4,5};

    for(int bar : foo) {
        std::cout << bar << std::endl;
    }
}

void withoutLoopExpression()
{
    int value;

    for(value = -10; (value != 4);) {
        std::cout << value << ',';

        if (value > 0) {
            value = 4;
        } else {
            value ++;
        }
    }

    std::cout << value << std::endl;
}

int main()
{
    doWhileLoop();
    whileLoop();
    forLoop();
    forEachLoop();
    withoutLoopExpression();

    return 0;
}
