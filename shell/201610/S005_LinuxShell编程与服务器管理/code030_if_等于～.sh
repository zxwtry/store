#!/bin/bash
a="str"
if [[ $a =~ ... ]]; then
    echo "Match"
fi
#...代表3个任意字符的样式

a="str"
if [[ $a =~ .{3} ]]; then
    echo "Match"
fi
#.{3}代表任意字符的个数有3个

str='abc 123 987 what u want.'
if [[ "$str" =~ .+\. ]]; then
    echo "变量str是一字符串，则最后一个字符是'.'"
fi
#.+代表任意长度的字符串，\.则转义，代表'.'

#执行结果：
#Match
#Match
#变量str是一字符串，则最后一个字符是'.'
