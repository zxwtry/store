#!/bin/bash

declare -i i=0

for ((i=0;i<20;i++))
do
    touch ~/temp/$i.txt;
done


#执行结果：
#在/home/ubuntu/temp/目录中创建了20个txt文件
#文件名：0~19
