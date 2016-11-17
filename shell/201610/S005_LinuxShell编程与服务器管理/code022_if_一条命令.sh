#!/bin/bash

if grep -q "rm" ~/temp/test.sh; then
    echo "find rm command"
else
    echo "not find"
fi

#运行结果：
#如果test.sh不存在，会报错
