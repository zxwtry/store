#!/bin/bash
j=110
echo "j=100"
echo $((${j:-8}+2))
j=
echo "j="
echo $((${j:-8}+2))
j="aa"
echo "j='aa'"
echo $((${j:-8}+2))
j=1.23
echo "j=1.23"
echo $((${j:-8}+2))
#运行结果
#j=100
#112
#j=
#10
#j='aa'
#2
#j=1.23
#./code019_算术运算_简介.sh: line 13: 1.23+2: syntax error: invalid arithmetic operator (error token is ".23+2")
