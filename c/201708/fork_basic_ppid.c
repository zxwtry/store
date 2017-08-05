#include<unistd.h>
#include<stdio.h>

/*
    run output :
	    i=0 p ppid=7287   pid=11462  fpid=11463
		i=0 c ppid=11462  pid=11463  fpid=0
		i=1 p ppid=7287   pid=11462  fpid=11464
		i=1 p ppid=11462  pid=11463  fpid=11465
		i=1 c ppid=11463  pid=11465  fpid=0
		i=1 c ppid=11462  pid=11464  fpid=0
*/

int main(void) {
    int i = 0;
    for (i = 0; i < 2; i ++) {
        pid_t fpid = fork();
        if (fpid == 0) {
            printf("i=%d c ppid=%-5d  pid=%-5d  fpid=%d\n", i, getppid(), getpid(), fpid);
        } else {
            printf("i=%d p ppid=%-5d  pid=%-5d  fpid=%d\n", i, getppid(), getpid(), fpid);
        }
    }
    return 0;
}
