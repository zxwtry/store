#!/bin/bash
PL="root:x:0:0:root:/root:/bin/bash"

#重新定义IFS，要以':'为分隔字符
IFS=':'

#j代表第几个栏数
j=0

#以循环分析各字段
for i in $PL
do
j=$((j+1)) #j增加1
echo 第$j个字段是$i
done
