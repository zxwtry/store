#!/bin/bash
shopt -s extglob
read yname
case $yname in
    j@(ac|xy|pq)k|zxwtry) echo 'Long time no see.';;
    *) echo 'Hi!';;
esac
#输入jack jxyk jpqk zxwtry都是Long time no see.
#输入其他，都是Hi!
