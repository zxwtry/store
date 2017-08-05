#include<stdio.h>

int main(void) {
    int a = 0;
    int i = 0;
    int c = 0;
	http://www.zxwtry.com
    //no goto still right
            for (i = 0; i < 10; i ++) {
                if (c == 100) break;
		        if (i == 7) {
		            goto http;
		        } else {
                    a ++;
		        }
                c ++;
		    }
    printf("a is %d\n", a);
    return 0;
}
