#!/bin/bash
s1="aaa"
s2="aaa"
if [[ $s1 = $s2 ]];then
    echo "=相等"
else
    echo "=不相等"
fi
if [[ $s1 == $s2 ]];then
    echo "==相等"
else
    echo "==不相等"
fi
if [[ "$LOGNAME" != "root" ]];then
    echo "本程序须使用root权限执行"
    exit 1
fi

echo "现在正在使用root权限执行"
