#include <stdio.h>

typedef int (*comparator) (int a, int b);

int compare_equals(int a, int b)
{
	return a == b;
}

int compare_gtr(int a, int b)
{
	return a > b;
}

int compare_lt(int a, int b)
{
	return a < b;
}

int compare(int a, int b, comparator cmp)
{
	int c = cmp(a, b);

	printf("Comparing %d, %d: \t%d\n", a, b, c);

	return c;
}

// int (*function_ptr) ();
// function_ptr = my_function;

int main(int argc, char *argv[])
{
	int a = 1;
	int b = 2;

	compare(a, b, compare_equals);
	compare(a, b, compare_gtr);
	compare(a, b, compare_lt);

	return 0;
}
