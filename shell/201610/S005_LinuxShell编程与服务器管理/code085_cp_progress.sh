#!/bin/bash

shopt -s -o nounset

declare -i p=0
src="src.iso"
dest="dest.iso"
total=$(stat -c %s %SRC)
touch $DEST
(cp -f $src $dest; sync) &
{
while ((p<100))
do
    size=$(stat -c %s %dest)
    p=size*100/total
    echo $p
    sleep 1
done
} | dialog --guage "复制进度" 10 50 0
