#!/bin/bash

if grep -q zxwtry /etc/passwd; then
    echo "账号存在"
else
    echo "账号不存在"
fi
