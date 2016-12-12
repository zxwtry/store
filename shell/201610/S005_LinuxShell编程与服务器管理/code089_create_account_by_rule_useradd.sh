#!/bin/bash

shopt -s -o nounset
ACTno=${1:?"错误!请提供需要建立的账号数"}
PKey=''
ACT=''
ACTprefix='stu'
ACTlist='accounts.txt'
declare -i k okact=0

#产生随机的字符串
gen_key() {
    KeyLen=${1:?"错误！请提供需要产生的字符串长度"}
    declare -i N I
    declare -i KeyLen=9
    PKey=''
    AFB='ABCDEFGHIJKLMNOPQRST'
    for ((I=0; I<KeyLen; I++))
    do
        N=$(head -1 /dev/urandom | od -N 2 | head -1 | awk '{print $2 * 1}')
        ((N%=${#AFB}))
        PKey=$PKey${AFB:$N:1}
    done
}

echo "-----------------------" >> $ACTlist

for ((k=1; k<=$ACTno; k++))
do
    ACT="$ACTprefix$k"
    gen_key 6
#    adduser --quiet --disabled-password --gecos '' $ACT
    groupadd -g 173 $ACT
    useradd -d /home/$ACT -g 173 -s /bin/bash -m $ACT
    if [ $? -eq 0 ]; then
        echo "$ACT:$PKey" | chpasswd
        echo "账号：$ACT | 密码：$PKey" >> $ACTlist
        echo "---------------------" >> $ACTlist
        ((okact++))
        echo "账号 $ACT建立完成..."
    fi
done

echo "共建立 $okact个账号"
echo "请查看 $ACTlist这个文件"
