#include<stdio.h>

int main() {
    int i = -1;
    unsigned int j = 1;
//    int v = (int) j;
//    printf("v is %d\n", v);
//    if (i < j) 
//        printf("a\n");
//    else
//        printf("b\n");
//    if (j > i)
//        printf("c\n");
//    else
//        printf("d\n");
//    output: 
//              v is 1
//              b
//              d

    printf("i < j is %d\n", (i < j));
    printf("i > j is %d\n", (i > j));
    printf("j > i is %d\n", (j > i));
    printf("j < i is %d\n", (j < i));
//    output:
//			i < j is 0
//			i > j is 1
//			j > i is 0
//			j < i is 1
//    signed int convert to unsigned int			
    return 0;
}
