#include <stdio.h>

#define MAX_DATA 100

int main(int argc, char *argv[])
{
	printf("Enter a thing: ");
	char thing[MAX_DATA];
	char *in = fgets(thing, MAX_DATA, stdin);

	printf("Your thing %s", thing);


	printf("Enter another thang: ");
	int thang;
	int rc = fscanf(stdin, "%d", &thang);
	printf("You entered %d", thang);


	return 0;
}
