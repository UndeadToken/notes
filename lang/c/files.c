// File descriptors use a set of low level I/O functions.
// File streams are a higehr level form of buffered I/O that is built on the lower functions.
// NOTE: error checking not included.

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>

int main(int argc, int *argv[])
{
	int fd; // file descriptor
	char *buffer, *datafile;

  buffer = (char *) malloc(100);
	datafile = (char *) malloc(20);

	strcpy(datafile, (char *) argv[1]);
	strcpy(buffer, (char *) argv[2]);

	fd = open(datafile, O_WRONLY|O_CREAT|O_APPEND, S_IRUSR|S_IWUSR);

	write(fd, buffer, strlen(buffer));

	close(fd);

	free(buffer);
	free(datafile);

	printf("Done writing file.\n");

	return 0;
}
