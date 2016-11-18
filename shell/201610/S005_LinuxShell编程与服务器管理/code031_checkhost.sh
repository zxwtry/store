#!/bin/bash
[ -e "/etc/hosts" ] || (echo '/etc/hosts文件不存在.'; exit 1)
if [ "$?" -eq 1 ]; then
    exit
fi
echo "/etc/hosts文件存在，后续继续执行下去．"
