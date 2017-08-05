#include<unistd.h>
#include<stdio.h>

int main(void) {
    pid_t fpid;
    fpid = fork();
    if (fpid < 0) {
        printf("error in fork!");
    } else if (fpid == 0) {
        printf("i am child process, my porcess id is %d\n", getpid());
    } else {
        printf("i am parent process, my porcess id is %d\n", getpid());
    }
    return 0;
}
