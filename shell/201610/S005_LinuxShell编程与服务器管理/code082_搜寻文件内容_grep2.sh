#!/bin/bash

if grep -qe '^anonymous_enable=NO' /etc/vsftpd.conf; then
    echo "vsftp不可匿名登录"
else
    echo "vsftp可匿名登录" 
fi
