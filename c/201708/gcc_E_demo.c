#include<stdio.h>

/*
#include<zxwtry.h>
//add gcc -E gcc_E_demo.c or cpp gcc_E_demo.c compilation terminated    
*/

int main(void) {
    #ifdef DEBUG
        printf("DEBUG is defined!\n");
        //gcc -DDEBUG gcc_E_demo.c
        //output
    #endif
    #ifdef zxwtry
        printf("zxwtry is defined!\n");
        //gcc -Dzxwtry gcc_E_demo.c
        //output
    #endif
    zxwtry  //gcc -E or cpp  success no error
    return 0;
}
