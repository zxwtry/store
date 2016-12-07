#!/bin/bash

DIFF="/usr/bin/diff"

fe(){
    f1=$1
    f2=$2
    $DIFF $f1 $f2 &> /dev/null
    return $?
}

if fe Day01.note Dayno2.note ; then
    echo "文件内容相同"
else
    echo "文件内容不同"
fi
