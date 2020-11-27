#include <iostream>

// it's possible to chain catch clauses.
// std::bad_alloc& exp for memory operations.
// char* exp for exception message. also const char* exp.
// std::exception& exp catch bad_alloc, bad_cast etc.. with message from exp.what().
// throw exceptions with `throw "something is fudged!"`

class CustomException: public std::exception
{
    std::string Reason;

public:
    CustomException(const char* why):Reason(why) {}

    // redefine virtual function to return 'Reason'
    virtual const char* what() const throw()
    {
        return Reason.c_str();
    }
};

int main()
{
    throw CustomException("Expect the probably not unexepected.");

    try {
      // something something dark side...
    } catch (...) {

    }

    return 0;
}
