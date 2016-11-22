#!/bin/bash
PS3="请选择："
menu="/home/ubuntu/ /home/ubuntu/github/"
select f in $menu
do
    echo "你键入的编号是$REPLY，选择的目录是：$f"
done
