#include<unistd.h>
#include<stdio.h>

int main(void) {
    fork();
    fork() && fork() || fork();
    fork();
    printf("+");    //output 20 +
    return 0;
}
