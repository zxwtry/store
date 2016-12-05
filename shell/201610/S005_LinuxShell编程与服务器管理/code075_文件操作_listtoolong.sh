#!/bin/bash

shopt -s -o nounset

DestDir=~/temp

while read f
do
    echo $f
done < <(find $DestDir -name '*.txt')

#执行结果：
#./code075_文件操作_listtoolong.sh 
#/home/ubuntu/temp/14.txt
#/home/ubuntu/temp/9.txt
#/home/ubuntu/temp/3.txt
#/home/ubuntu/temp/16.txt
#/home/ubuntu/temp/11.txt
#/home/ubuntu/temp/10.txt
#/home/ubuntu/temp/15.txt
#/home/ubuntu/temp/6.txt
#/home/ubuntu/temp/12.txt
#/home/ubuntu/temp/13.txt
#/home/ubuntu/temp/1.txt
#/home/ubuntu/temp/4.txt
#/home/ubuntu/temp/5.txt
#/home/ubuntu/temp/18.txt
#/home/ubuntu/temp/19.txt
#/home/ubuntu/temp/7.txt
#/home/ubuntu/temp/0.txt
#/home/ubuntu/temp/17.txt
#/home/ubuntu/temp/2.txt
#/home/ubuntu/temp/8.txt
