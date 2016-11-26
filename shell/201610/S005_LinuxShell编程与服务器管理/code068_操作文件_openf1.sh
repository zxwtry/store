#!/bin/bash

datafile="/home/ubuntu/temp/a.txt"
exec 3<&0           #备份标准输入，放在文件代码3
exec < $datafile
while read
do
    echo $REPLY
done
exec 0<&3 3<&-      #还原标准输入，关闭文件代码3


#/home/ubuntu/temp/a.txt文件的内容如下：
#读取文件的第一行
#读取文件的第二行
#读取文件的第三行
#执行结果：
#./code068_操作文件_openf1.sh 
#读取文件的第一行
#读取文件的第二行
#读取文件的第三行
