#!/bin/bash
for ((i=1;i<=10;i++))
do
    for ((j=1;j<=10;j++))
    do
        r=$((i+j))
        if [ $r -eq 12 ]; then
            continue 2
        fi
        echo $r
    done
done
