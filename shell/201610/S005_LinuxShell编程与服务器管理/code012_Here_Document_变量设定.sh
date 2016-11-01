#!/bin/bash
WOW="WOW, great!"
var=$(cat <<HERE
Line 1 is good
They are tencent, alibaba and baidu.
$WOW
HERE)

echo $var
