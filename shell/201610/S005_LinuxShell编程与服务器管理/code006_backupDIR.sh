#!/bin/bash
A="/root/temp/test1"
B="/root/temp/test2"
cd $A
tar cvf - . | tar xvf - -C $B

#先切花难道test1
#tar cvf - . 打包test2的内容，其中-代表把打包结果往标准输出中丢
#接着通过管道，由tar xvf -解包，-C把解包内容放入test2目录。
#达成备份test1的目的
#必须保证有test1和test2
