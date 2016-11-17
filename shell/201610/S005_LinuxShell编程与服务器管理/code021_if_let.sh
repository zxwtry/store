#!/bin/bash

#数学

declare -i a b
a=$1;b=$2

if let "a<b"; then
    echo "$a小于$b"
elif let "a>b"; then
    echo "$a大于$b"
else
    echo "$a等于$b"
fi
