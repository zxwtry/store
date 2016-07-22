#include<sys/time.h>
#include<unistd.h>
#include<stdio.h>
int main() {
    struct timeval time1, time2;
    struct timezone timez;
    int i, tmp;
    gettimeofday(&time1, &timez);
    printf("%d\n", time1.tv_usec);
    for (i = 0; i < 10000; i ++) {
        tmp = i +1900;
        tmp = tmp * tmp;
    }
    gettimeofday(&time2, &timez);
    printf("程序使用时间：%d\n", (time2.tv_usec - time1.tv_usec));
    return 0;
}

