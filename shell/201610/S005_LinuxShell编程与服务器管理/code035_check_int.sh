#!/bin/bash
declare -i len
len=$1

if [ $len -eq 100 ];then
    echo "长度为100"
else
    echo "长度不是100"
fi
