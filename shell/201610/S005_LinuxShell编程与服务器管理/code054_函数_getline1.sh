#!/bin/bash
i=100
getline(){
    local i=0
    while read line
    do
        let ++i
    done < ~/temp/$file
    echo "$file共有$i行"
}
file=$1
echo "echo \$? 的结果是：$?"
getline
echo "getline执行完毕"
echo "i是$i"
#输出i是100
