#include<stdio.h>
int main(int argc, char * argv[]) {
    unsigned int i = 0;
    printf("The num of args is %d\n", argc);
    for (i = 0; i < argc; i ++) {
        printf("%s\n", argv[i]);
    }
    return 0;
}
