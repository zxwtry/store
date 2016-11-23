#!/bin/bash

#把一个大于等于2的正整数，分解成质数的乘积

shopt -s -o nounset

declare -i Num=1
declare -i i
declare -i cnt

while [[ $Num -lt 2 ]]
do
    read -p "请输入一个2以上的正整数：" Num
done

i=2

echo -n $Num '= '
while ((Num>=i))
do
    cnt=0
    tmp=Num%i
    while [[ $tmp -eq 0 ]]
    do
        ((Num/=i))
        ((cnt++))
        tmp=Num%i
    done
    
    if [[ $cnt -gt 0 ]]; then
        echo -n $i
        [ $cnt -gt 1 ] && echo -n '^'$cnt
        [ $Num -gt 1 ] && echo -n ' * '
    fi
    
    ((i>=3 ? i+=2 : i++))
done
echo
