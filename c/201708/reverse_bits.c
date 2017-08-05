#include<stdio.h>
#include<limits.h>

int reverseBit2(int v) {
    int a = 0;
    unsigned int u = v;
    int b = 32;
    while (u != 0) {
        a = (a << 1) + (u & 1);
        u >>= 1;
        b --;
    }
    return a << b;
}

int main(void) {
    int v;
    scanf("%d", &v);
    printf("fun is %02X\n", reverseBit2(v));
    int r = v;
    int s = sizeof(v) * CHAR_BIT - 1;
    //printf("sizeof v is %d\n", (int)sizeof(v));  4
    for (v >>= 1; v; v >>=1) {
        r <<= 1;
        r |= v & 1;
        s --;
    }
    printf("ans is %02X\n", r<<= s);
    printf("1 < 2 is %d\n", (1 < 2));
    printf("-(1 < 2) is %d\n", -(1 < 2));
    return 0;
}
