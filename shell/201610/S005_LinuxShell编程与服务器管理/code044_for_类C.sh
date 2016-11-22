#!/bin/bash
declare -i i sum
for ((i=1;i<=10;i=i+1))
do
    let sum+=i
done
echo $sum
