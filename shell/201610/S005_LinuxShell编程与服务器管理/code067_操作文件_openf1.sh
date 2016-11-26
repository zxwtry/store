#!/bin/bash

datafile='/home/ubuntu/temp/a.txt'
exec 3<>$datafile
while read <&3
do
    echo $REPLY
done
exec 3<&-

#/home/ubuntu/temp/a.txt文件内容如下：
#读取文件的第一行
#读取文件的第二行
#读取文件的第三行
#执行结果如下：
#./code067_操作文件_openf1.sh 
#读取文件的第一行
#读取文件的第二行
#读取文件的第三行
