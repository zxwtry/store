#include<stdio.h>

int max(int x, int y) {
    return x ^ ((x ^ y) & -(x < y));
}

int min(int x, int y) {
    return y ^ ((x ^ y) & -(x < y));
}

int main(void) {
    int x, y;
    scanf("%d %d", &x, &y);
    printf("max is %d\n", max(x, y));
    printf("min is %d\n", min(x, y));
    return 0;
}
