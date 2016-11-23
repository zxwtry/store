#!/bin/bash

echo "\$@的初值：$@"
while shift
do
    [ -n "$1" ] && echo "shift 一次，\$@的变化：$@"
done
