#include<stdlib.h>
#include<stdio.h>
#include<fcntl.h>
int main(void) {
	int fd, temp;
	fd = open("./opentest", O_RDWR|O_CREATE, S_IRWXU);
	printf("%d\n", fd);
	temp = close(fd);
	return 0;
}

