#!/bin/bash

#变量要先声明后才能使用
shopt -s -op nounset

#m用来暂存取得的6个号码
m=

#
#函数区
#

#取得一个1~42的号码
function GetLOTO() {
    local r
    r=$(( $RANDOM % 43 ))
    if [ $r -eq 0 ];then
        r=$[ r+1 ]
    fi

    #使每一个号码都用二位数来表示
    #不足10者，在其前面补0
    if [ $r -le 9 ];then
        echo "0$r"
    else
        echo $r
    fi
}


function GenNumAndCheckRepeat(){
    local n
    #取得6个号码，并且予以排序
    m=$({ GetLOTO; GetLOTO; GetLOTO; GetLOTO; GetLOTO; GetLOTO; }  | sort -n )

    #把这6个号码暂时copy一份给n
    n="$m"

    #检查这6个号码有无重复
    n=$(echo $n | tr ' ' '\n' | uniq -d)

    #如果$n为空，表示没有重复，则传回真(0)
    if [ -z "$n" ];then
        return 0
    else
        return 1
    fi
}

#
#主程序
#

#判断使用者是否提供组数
if [ $# -ne 1 ];then
    echo "使用方法：$0 组数"
    exit
fi

#组数要介于1~99组
if [ "$1" -lt 1 -o "$1" -gt 99 ];then
    echo "使用方法：$0 [1-99]组"
    exit
fi

#i为累计的组数
declare -i i=1 j

#当i小于或等于组数时，使用while循环产生下一组抽奖号码
while [ $i -le "$1" ]
do
    #取得6个号码
    GenNumAndCheckRepeat

    #如果有重复，则丢弃这6个号码
    if [ $? -ne 0 ];then
        continue;
    fi
    
    #调整输出格式
    j=$i
    if [ $j -le 9 ]; then
        echo "第0$j组："
    else
        echo "第$j组"
    fi
    
    #执行到此，表示该组号码没有重复，予以显示出来
    echo $m

    #组数加1
    i=$[ i + 1 ]
done


#执行结果如下：
#./code066_loto_抽奖程序.sh 4
#第01组：
#01 03 06 07 14 25
#第02组：
#07 09 10 32 34 35
#第03组：
#02 06 16 25 27 39
#第04组：
#10 15 19 29 35 41
