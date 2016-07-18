//EACCES:	权限不够
//ENOSPC:	没有多余的磁盘空间
#include<string.h>
#include<stdio.h>
#include<errno.h>
int main(int argc, char *argv[]) {
    fprintf(stderr, "EACCES:%s\n", strerror(EACCES));
	//EACCES:Permission denied
    errno = ENOSPC;
    perror(argv[0]);
	//./c005: No space left on device
    return 0;
}
