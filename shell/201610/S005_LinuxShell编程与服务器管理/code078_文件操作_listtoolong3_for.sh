#!/bin/bash

shopt -s -o nounset

DestDir=~/temp

for f in $DestDir/*.txt
do
    echo $f
done

#$DestDir/*.txt并不会展开成某一个命令的参数行
#没有参数过长的问题。
