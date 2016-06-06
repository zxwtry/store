#!/usr/sh
#encoding=utf-8
#你好，世界
var1="这是第一个变量"
echo $var1

#执行ls操作
echo "在sh里面执行ls操作的结果是："
ls

echo "在sh里面执行du -hs操作的结果是："
du -hs

echo "在sh里面执行ls | wc -l操作的结果是："
ls | wc -l

###这TM竟然也能执行，shell太TM强大了
echo "执行javac Main.java和 java Main"
javac Main.java
java Main

###传入数据进行计算
echo "相加得到的结果是"+${1}+${2}
