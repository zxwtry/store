#!/bin/bash

shopt -s -o nounset

host=${1:?"请提供主机域名或IP"}
file=${2:?"请提供保存的文件"}
port=80

if [[ ! $file == /* ]]; then
    file=/$file
fi

exec 6<>/dev/tcp/$host/$port
echo -e "GET $file HTTP/1.1" >&6
echo -e "Host: $host" >&6
echo -e "Connection: close\n" >&6

savefile=${file##*/}

if [ -z "$savefile" ]; then
    savefile='index.html'
fi

cat <&6 >$savefile

exec 6>&-
exec 6<&-
