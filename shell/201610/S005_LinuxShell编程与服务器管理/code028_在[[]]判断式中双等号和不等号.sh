#!/bin/bash
a="str"
if [[ $a == ??? ]]; then
    echo "Match"
fi
#运行的结果：
#输出：Mathch
#意思是说，用$a的值，对比样式???(3个字符的字符串)

if [[ $a == "???" ]]; then
    echo "Match"
else
    echo "Not Match"
fi
#运行的结果：
#输出：Not Mathch
#意思是说，用$a的值，去判断是否是和"???"相同

str="abc 123 987 what u want."
if [[ "$str" == *. ]]; then
    echo "变量str是一字符串，则最后的一个字符是."
else
    echo "不相符"
fi
#运行的结果是：
#变量str是一字符串，则最后的一个字符是.
#意思是说，字符串str和样式*.做对比，
#*.这个样式的意思是说，任意长度的字符串，且最后一个字符是.。
