#!/bin/bash

shopt -s -o nounset

DIFF="/usr/bin/diff"

[ $# -ne 2 ] && echo "使用方法：$0 文件1 文件2" && exit 2

File1=$1
File2=$2

$DIFF $File1 $File2 &> /dev/null
$DIFF $File1 $File2

echo "#####"
echo $?
echo "#####"

exit $?


#全部转向到/dev/null
#不让本程序产生任何信息
#0-相同  1-不同
