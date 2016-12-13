#!/bin/bash

shopt -s -o nounset

filename="test.tgz"
host="192.168.1.1"
user="zxwtry"
passwd="iamsillyb"

cd /root
ftp -n $host <<AUTOEOF
quot USER $user
quot PASS $passwd
binary
put $filename
quit
AUTOEOF

