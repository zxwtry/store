#!/bin/bash

#建立临时文件
TMP_file=$(mktemp)

#运用临时文件
echo "Hello world!" > $TMP_file

#输出临时文件目录
echo  "临时文件是：$TMP_file"

#清理
[ -f "$TMP_file" ] && rm -f $TMP_file
