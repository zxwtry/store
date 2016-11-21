#!/bin/bash
shopt -s extglob
read cmd
if [[ $cmd == @(declare|typeset) ]];then
    echo "Match."
fi
#只要输入的是delcare typeset中一个，就"Match."
