#!/bin/bash
PS3="请选择："
select f in *
do
    echo "你输入的编号是$REPLY，选择的文件是：$f"
    break
    #如果break打开，那么一次结束
done
#修改PS3，自定义提示符号。
#从1开始
#Ctrl-D结束
