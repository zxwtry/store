#include<stdio.h>

#define LL long long

LL gcd1(LL x, LL y) {
    return y == 0l ? x : gcd1(y, x % y);
}

//考虑到大数相除运算量很大，改成相减
LL gcd2(LL x, LL y) {
    if (x < y)
        return gcd2(y, x);
    if (y == 0)
        return x;
    return gcd2(x - y, y);
}

int main() {
    LL x = 16, y = 24;
    printf("%lld\r\n", gcd2(x, y));
}
