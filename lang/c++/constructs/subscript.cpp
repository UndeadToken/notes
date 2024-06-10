#include <iostream>
#include <string>

using namespace std;

class Foo
{
private:
    char* Buffer;
    Foo() {}

public:
    Foo(const char* InitialInput)
    {
        if(InitialInput != NULL)
        {
            Buffer = new char [strlen(InitialInput) + 1];
            strcpy(Buffer, InitialInput);
        }
        else
            Buffer = NULL;
    }

    char& operator [] (int Index)
    {

    }
};

int main()
{


    return 0;
}
