#include<stdio.h>

#define LL long long

LL gcd1(LL x, LL y) {
    return y == 0l ? x : gcd1(y, x % y);
}


int main() {
    LL x = 16, y = 24;
    printf("%lld\r\n", gcd1(x, y));
}
