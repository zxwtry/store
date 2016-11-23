#!/bin/bash
#把$2的内容转向附加到$1指定的内容中

appendfile() {
    echo "$2" >> "$1"
}

Dir=~/temp
OutFile="$Dir/a.txt"

#如果目录不存在，则开新目录
[ -e $Dir ] || mkdir -p $Dir

appendfile $OutFile "函数也可以这样用"
appendfile $OutFile "这是函数的另外一种用法"
appendfile $OutFile "Over"

