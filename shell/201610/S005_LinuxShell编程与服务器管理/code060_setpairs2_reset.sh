#!/bin/bash

echo "本程序名称：$0"
echo "共有$#个参数"
echo "参数值：$@"
echo "------------"
echo "重置参数----"
set 66 88
echo "重置后，共有$#个参数"
echo "重置后，参数值：$@"
