#!/bin/bash
getline() {
    local i=0
    while read line
    do
        let ++i
    done < $1
    echo "$1共有$i行"
}

file=$2
getline $file
echo "执行完毕"
