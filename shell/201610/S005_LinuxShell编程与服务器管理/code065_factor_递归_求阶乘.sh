#!/bin/bash

#function也可以使用递归功能
#5! = 5 * 4 * 3 * 2 * 1

function factor_in() {
    local tmp
    local tmp1

    #tmp存储传入函数的整数值
    tmp="$1"

    #如果传入的整数是1，就显示1
    if [ $tmp -eq 1 ];then
        echo -n " 1 "
        r=1
    else
    #如果传入值不是1，则在这个区域处理
    echo -n "$tmp * "
    tmp1=$tmp
    tmp=$(($tmp-1))
    factor_in $tmp
    r=$(($tmp1 * $r))
    fi
}

if [ $# -ne 1 ]; then
    echo "使用方法：$0 正整数"
    exit 1
fi

#显示结果：
echo 
echo -n $1"! = "
factor_in $1
echo -n "= $r"
echo

#执行结果：
#./code065_factor_递归_求阶乘.sh 6
#
#6! = 6 * 5 * 4 * 3 * 2 *  1 = 720
#
