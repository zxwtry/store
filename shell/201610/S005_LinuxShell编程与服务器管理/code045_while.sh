#!/bin/bash
declare -i i=1
declare -i sum=0
while ((i<=10))
do
    let sum+=i
    let ++i
done
echo $sum
