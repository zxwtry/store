#!/bin/bash

shopt -s -o nounset
declare -a KEY
declare -a VALUE
declare -i k=1

while read N V
do
    KEY[$k]=$N
    VALUE[$k]=$V
    echo "${KEY[$k]} = ${VALUE[$k]}"
    ((k++))
done < <(awk 'BEGIN{FS=":"} /\w:\w/ {print $1, $2}' ./code083_conf.conf)

