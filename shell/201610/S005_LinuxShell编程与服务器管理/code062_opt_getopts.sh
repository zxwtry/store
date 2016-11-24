#!/bin/bash

while getopts u:ah opt
do
    case $opt in
    u)
        echo "提供了选项参数u和参数：$OPTARG"
    ;;
    a)
        echo "提供了选项a"
    ;;
    h)
        echo "提供了选项h"
    ;;
    *)
        echo "还提供了$opt"
    ;;
    esac
done

#运行方式如下：
#./code062_opt_getopts.sh -u Jack -a -h
#提供了选项参数u和参数：Jack
#提供了选项a
#提供了选项h
#
#运行方式如下：
#./code062_opt_getopts.sh -u Jack -a -h -d
#提供了选项参数u和参数：Jack
#提供了选项a
#提供了选项h
#./code062_opt_getopts.sh: illegal option -- d
#还提供了?
