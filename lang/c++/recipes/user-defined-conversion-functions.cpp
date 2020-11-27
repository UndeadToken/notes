#include <iostream>

// Every constructor without the `explicit` specifier is considered a converting constructor.
// Such a constructor defines an implicit conversion from the type or types of its arguments 
// to the type of the class.

// The `explicit` specifier disallows implicit constructions of objects of a class type.
// Constructors that take an std::initializer_list having initializations using {} will 
// resolve to that constructor with implicit type conversions i.e {1, 1.0}.

struct Foo
{
	Foo(int const a, double const b) {}
};

int main()
{
	// Allowed.
	Foo foo = { 1, 2.0 };

	// No longer allowed.
	//Foo bar({ 1, 2.0 });

	return 0;
}