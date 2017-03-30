#!/bin/bash

#if git status chinese path is like \276 
#run git config --global core.quotepath false

#not exist
file_name=$0
#if run ./a.sh remove ./
file_name=${file_name##*./}

if [ -f ".gitignore" ];then
    #exist
    sign=0
    exec 3<>".gitignore"
    while read <&3
    do
        if [ "$REPLY" == "$file_name" ];then
            sign=1
            break
        fi
    done
    exec 3<&-
    if [ $sign == 0 ];then
        echo "$file_name" >> .gitignore
    fi
else
    echo ".gitignore" >> .gitignore
    echo "$file_name" >> .gitignore
fi

git_status=$(git status)
git_status_len=${#git_status}
git_status_cut_tail=${git_status%%nothing added to commit*}
git_status_cut_tail_cut_head=${git_status_cut_tail##*will be committed)}
git_status_cut_tail_cut_head_len=${#git_status_cut_tail_cut_head}

#check nothing
check_nothing=$(echo $git_status_cut_tail_cut_head | grep "nothing to commit, working directory clean")
if [ ${#check_nothing} != 0 ];then
    echo "nothing to commit"
else
    #check changes to be committed
    check_to_be_committed=${git_status##*<file>...\" to unstage)}
    if [ ${#check_to_be_committed} != ${#git_status} ];then
        check_use=$(echo ${check_to_be_committed#*: })
        check_file=$(echo ${check_use%% *})
        if [ ${#check_file} != 0 ];then
            git commit -m "add $check_file"
        fi
    fi
    
    #check need to add commit
    if [ $git_status_len != $git_status_cut_tail_cut_head_len ];then 
        remain_commit=$(echo $git_status_cut_tail_cut_head)
        while(( ${#remain_commit} > 1 && ${#to_commit} != ${#remain_commit}))
        do
            to_commit=${remain_commit%% *}
            #echo $to_commit
            git add $to_commit
            git commit -m "add $to_commit"
            remain_commit=$(echo ${remain_commit#* })
        done
    fi
fi
git push origin master
