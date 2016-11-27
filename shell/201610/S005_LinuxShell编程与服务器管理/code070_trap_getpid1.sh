#!/bin/bash
if [ $# -ne 1 ];then
    echo "使用方法： $0 进程名称关键字"
    exit 1
fi

proc=$1
pid=$(ps auxw | grep $proc | grep -v grep | grep -v $0 | awk '{print $2}')
if [ -n '$pid' ]; then
    echo $pid
else
    echo "找不到此进程"
fi

#执行结果如下：
#./code070_trap_getpid1.sh sshd
#21116 21237 21268 21286 21316 21336 21367 21382 21413
