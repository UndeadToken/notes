#include <iostream>
#include <vector>

class Foo
{
public:
	int Value;

	Foo(int v) :Value(v) {}
};

class FooFactory
{
private:
	std::vector<Foo*> cache;

public:
	Foo* Get(int v)
	{
		for (auto i : cache)
			if (i->Value == v)
				return i;

		Foo foo(v);

		cache.push_back(&foo);

		return &foo;
	}
};

int main()
{
	FooFactory factory;

	std::cout << factory.Get(1) << std::endl;
	std::cout << factory.Get(1) << std::endl;
	std::cout << factory.Get(2) << std::endl;
	std::cout << factory.Get(2) << std::endl;
	std::cout << factory.Get(3) << std::endl;
	
	return 0;
}