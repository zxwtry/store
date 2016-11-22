#!/bin/bash
ifs_save=$IFS
IFS=':'
cat /etc/passwd | {
    while read f1 f2 f3 f4 f5 f6 f7
    do
        echo "账号：$f1   login Shell 是：$f7"
    done
}
