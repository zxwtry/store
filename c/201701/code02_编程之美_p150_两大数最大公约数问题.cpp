#include<stdio.h>

#define LL long long

//复杂度低，需要除法(运算量大)
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

//gcd1迭代次数少
//gcd2不需要除法
//结合gcd1和gcd2的优点
//1,如果x=k*a,y=k*b,那么gcd(x,y)=gcd(a,b)
//2,如果x=p*a且p是素数且y%p!=0,那么gcd(x,y)=gcd(a,y)
//最简单的方法：取p=2
//若x,y均为偶数,gcd(x,y)=2*gcd(x>>1, y>>1)
//若x为偶数,y为奇数,gcd(x,y)=gcd(x>>1, y)
//若x为奇数,y为偶数,gcd(x,y)=gcd(x, y>>1)
//若x为奇数,y为奇数,gcd(x,y)=gcd(x, x-y)
//因为x-y是一个偶数,下一步一定有除以2的操作
//最坏的情况下的时间复杂度是O(log(max(x,y)))
LL gcd3(LL x, LL y) {
    if (x < y)
        return gcd3(y, x);
    if (y == 0) {
        return x;
    } else {
        if ((x&0x1)==0) {
            if ((y&0x1)==0) {
                return (gcd3(x >> 1, y >> 1) << 1);
            } else {
                return gcd3(x >> 1, y);
            }
        } else {
            if ((y&0x1)==0) {
                return gcd3(x, y >> 1);
            } else {
                return gcd3(y, x - y);
            }
        }
    }
}

int main() {
    LL x = 16, y = 24;
    printf("%lld\r\n", gcd3(x, y));
}
