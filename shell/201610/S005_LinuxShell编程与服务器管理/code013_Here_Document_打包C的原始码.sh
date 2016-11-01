#!/bin/bash
echo "正在产生 hello.c...."
echo
cat <<'EOF' > hello.c
#include <stdio.h>
int main(){
    printf("hello world!\n");
    return 0;
}
EOF
echo "编译hello.c..."
echo
#编译hello.c，产生执行文件
gcc -o hello hello.c
#若编译成功，就执行
if [ $? -eq 0 ]; then
    echo "执行hello..."
    echo
    ./hello
else
    echo 'Compile ERROR: hello.c'
fi
