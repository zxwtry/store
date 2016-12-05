#!/bin/bash

declare -i i=0

for ((i=0;i<100000;i++))
do
    touch ~/temp/$i.txt
done

DirCnt=$(ls -A ~/temp/*.txt)
echo $DirCnt

#执行过程如下：
#./code076_文件操作_Argument_list_too_long.sh 
#./code076_文件操作_Argument_list_too_long.sh: line 10: /bin/ls: Argument list too long

#getconf ARG_MAX
#2097152
#表示参数行的最大长度
