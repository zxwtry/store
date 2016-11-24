#!/bin/bash
pairs(){
    echo "共有$#个参数传入本函数"
    echo "参数值：$@"
}

pairs 100 90 80 70 60

echo "本程序命令行的参数值：$@"
