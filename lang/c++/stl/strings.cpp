#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>

// STL string classes
// STL supplies a template class that has been specially designed for string operations.
// std::basic_string<T> is used popularly in its two template specializations.
// includes std::string, std::wstring

int main()
{
    // c-style to string
    const char* constCStyleString = "Hello String!";
    std::string strFromConst = (constCStyleString); // or
    strFromConst = constCStyleString;

    // partial copy
    std::string str = "Hello copy!";
    std::string strCopy = std::string(str, 0, 5);
    std::cout << strCopy << std::endl;

    // initilaize characters
    std::string strRepeat = std::string(10, 'a');
    std::cout << strRepeat << std::endl;

    // pointy things
    char* pszCopy = new char[strlen(constCStyleString) + 1];
    strcpy(pszCopy, constCStyleString);
    std::cout << pszCopy << std::endl;
    delete[] pszCopy;

    // iterating
    std::string::const_iterator iter;
    for (iter = str.begin(); iter != str.end(); ++ iter)
    {
        std::cout << *iter << std::endl;
    }

    // concatenation
    std::string foo = "Hello ";
    std::string bar = "World";
    std::cout << foo.append(bar) << std::endl; // or foo + bar

    // find substring
    std::string strSub = "Hello Substring!";
    size_t charPos = strSub.find("Substring", 0);

    if (charPos != std::string::npos)
        std::cout << "Found at: " << charPos << std::endl;

    // truncating
    std::string strTrunc = "Hello Truncatable!";
    strTrunc.erase(0, 1);

    std::string::iterator truncIter = find(strTrunc.begin(), strTrunc.end(), '!');
    if (truncIter != strTrunc.end())
        strTrunc.erase(truncIter);

    std::cout << strTrunc << std::endl;

    // reverse
    reverse(strTrunc.begin(), strTrunc.end());
    std::cout << strTrunc << std::endl;

    // transform
    std::string strTrans = "Transformable!";
    transform(strTrans.begin(), strTrans.end(), strTrans.begin(), toupper);
    std::cout << strTrans << std::endl;

    return 0;
}
