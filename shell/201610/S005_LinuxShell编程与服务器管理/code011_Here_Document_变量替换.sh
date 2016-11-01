#!/bin/bash
From="From: me@example.edu.cn"
To="To: you@example.edu.cn"
Subject="Subject: hello world"
Msg="吃饭睡觉"
Em="20161101.txt"
cat > $Em <<HERE
$From
$To
$Subject

$Msg
HERE
