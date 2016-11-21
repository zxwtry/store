#!/bin/bash

set -o

if [ -o history ]; then
    echo "Bash选项history开启"
else
    echo "Bash选项history关闭"
fi
