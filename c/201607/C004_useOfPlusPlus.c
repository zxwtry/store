#include<stdio.h>
int main() {
    int j = 5, q, j1, j2, j3;
    j1 = ++ j;
    j2 = ++ j;
    j3 = ++ j;
    q = j1 + j2 + j3;
    printf("%d %d %d %d\n", j1, j2, j3, q);
    return 0;
}
