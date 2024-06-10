#include <stdio.h>

void *cmalloc(unsigned int size);

int main()
{
	int *heap_ptr;
	
	// Allocate 4-bytes on heap (typecast to integer as malloc returns a void pointer). 
	heap_ptr = (int *) malloc(4);

	*heap_ptr = 12;

	printf("%d@%p", *heap_ptr, heap_ptr);

	free(heap_ptr);

	return 0;
}

*void *cmalloc(unsigned int size)
{
	void *ptr;

	ptr = malloc(size);
	
	if (ptr == NULL) {
		fprintf(stderr, "Error: Could not allocate heap memory.\n");    
		exit(-1);
	}

	return ptr;
}
