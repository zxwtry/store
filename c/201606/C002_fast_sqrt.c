#include<stdio.h>
// 结果并不是非常理想，
//可能原因是在64位系统进行的测试。
float fast_sqrt(float x) {
    unsigned x_bits = 0;
    x_bits = *((unsigned *)&x);
    x_bits = (x_bits >> 1) + 532369198;
    return *((float*)&x_bits);
}
int main() {
    printf("aabb\r\n");
    float x = 36.0f;
    printf("%f\r\n", fast_sqrt(x));
    x = 49.0f;
    printf("%f\r\n", fast_sqrt(x));
    return 0;
}
