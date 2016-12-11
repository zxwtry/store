#!/bin/bash
#
#1, 将大写文件名改成小写文件名，或将小写文件名改写成大写文件名
#2, 由执行时的情况决定使用哪个功能
#3, 这个程序本身不会被改名
#
#安装法：
#1, cp cod085_low2upper /usr/local/bin
#2, cd /usr/local/bin
#3, ln -sf low2upper upper2low
#
#函数区：
#low2upper
#upper2low
#ask_sure
#chk_dir_is_ok
#

low2upper() {
    for FILE in *
    do
        if [ "$FILE" != "LFNAME" -a "$FILE"  != "$UFNAME" ]; then
            mv -f "$FILE" `echo "$FILE" | tr '[a-z]' '[A-Z]'` 2> /dev/null
        fi
    done
}

upper2low() {
    for FILE in *
    do
        if [ "$FILE" != "LFNAME" -a "$FILE" != "$UFNAME" ]; then
            mv -f "$FILE" `echo "$FILE" | tr '[A-Z]' '[a-z]'` 2> /dev/null
        fi
    done
}

ask_sure() {
    echo '警告!!! 这个程序会把：$(pwd)中的文件，做大小写文件名的转换。'
    read -p "确定要进行吗？(y/n)" ANS
    case $ANS in
        [Yy]|[Yy][Ee][Ss])
            return 0
            ;;
        *) eexit 1
            ;;
    esac
}

chk_dir_is_ok() {
    NowDir=$(pwd)
    [ "$NowDir"="/" ] && return 1
    NowDir1=${NowDir#/}
    NowDir2=${NowDir1#*/}
    NowDir2=${NowDir2%%/*}
    case $NowDir1 in
        root|bin|dev|home|root|var|boot|etc|sbin|usr|lib)
            return 2;;
        *)
            case $NowDir2 in
            www|bin|doc|etc|games|include|info|lib|libexec|local|man|sbin|share|var|X11R6)
                return 3;;
            esac
    esac
    return 0
}

#主程序
LFNAME=low2upper
UFNAME=upper2low
NOWFILENAME=$(basename $0)

#先询问是否执行
ask_sure

#执行位置不可在重要的系统目录中
if ! chk_dir_is_ok;then
    echo "$(pwd)这个目录受到保护，不再在此执行大小写文件名转换。"
    exit 1
fi

if [ "$NOWFILENAME" = "$LFNAME" ]; then
    low2upper
elif [ "$NOWFILENAME" = "$UFNAME" ]; then
    upper2low
fi

echo
echo "转换完成"
echo
