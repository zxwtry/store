#!/bin/bash
#Shell的结构

function show_name() {
    echo "今天是$1，贫道来自$2，去往$3拜佛求经"
}
name="$1"
address="东土大唐"
today=`date +%F`

if [ $# != 1 ]; then
    echo "Usage: . /$0 {使用者名称}"
    exit
fi

show_name "$today" "$address" "$name"

sleep 5

echo 

echo "Bye-Bye :-)"
