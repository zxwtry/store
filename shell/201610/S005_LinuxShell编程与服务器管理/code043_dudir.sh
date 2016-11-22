#!/bin/bash
DIR="/home/ubuntu/"
cd $DIR
for f in $(ls $DIR)
do
    [ -d $f ] && du -hs $f
done
#运行结果
#20M    github
#40K temp
