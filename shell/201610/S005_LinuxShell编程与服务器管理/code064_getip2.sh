#!/bin/bash

MYLIB_DIR='.'

if [ ! -d "$MYLIB_DIR" ];then
    MYLIB_DIR='.'
fi

. $MYLIB_DIR/code063_mylib1.sh

_getip eth0

ip=${FUNREPLY[0]}

if [ -n "$ip" ]; then
    echo "主机的IP是：$ip"
else
    echo "找不到IP"
fi

#执行结果
#./code064_getip2.sh 
#主机的IP是：192.168.100.1
