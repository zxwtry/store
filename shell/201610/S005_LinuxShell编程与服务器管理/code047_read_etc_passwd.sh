#!/bin/bash
echo "aa"+$IFS+"bb"
ifs_save=$IFS
IFS=':'
while read f1 f2 f3 f4 f5 f6 f7
do
    echo "账号：$f1，  login Shell是：$f7"
done < /etc/passwd
#使用done < "/etc/passwd"，一样
IFS=$ifs_save
echo "aa"+$IFS+"bb"
