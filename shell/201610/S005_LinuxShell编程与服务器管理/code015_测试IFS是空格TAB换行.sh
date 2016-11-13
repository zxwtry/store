#!/bin/bash
echo "输出IFS的第一个字符"
echo "_${IFS:0:1}_"
echo "输出IFS的第二个字符"
echo "_${IFS:1:1}_"
echo "输出IFS的第三个字符"
echo "_${IFS:2:1}_"
#输出的结果如下：
#输出IFS的第一个字符
#_ _
#输出IFS的第二个字符
#_   _
#输出IFS的第三个字符
#_
#_
