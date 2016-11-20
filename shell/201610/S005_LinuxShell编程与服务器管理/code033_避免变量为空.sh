#!/bin/bash

name=$1


if [[ "$name" = 'zxwtry' ]]; then
    echo "你是zxwtry"
else
    echo "你不是zxwtry"
fi

echo "现在name是$name"

if [[ $name = 'zxwtry' ]]; then
    echo "你是zxwtry"
else
    echo "你不是zxwtry"
fi

if [ $name = 'zxwtry' ]; then
#如果name为空，这里会报错，但仍会继续执行。
    echo "你是zxwtry"
else
    echo "你不是zxwtry"
fi
