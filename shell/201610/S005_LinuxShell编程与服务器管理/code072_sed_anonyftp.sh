#!/bin/bash

#修改vsftpd的配置文件，切换；'开启/关闭' 匿名FTP服务

if [ $# -ne 1 ]; then
    echo "使用方法：$0 on 或　$0 off"
    exit 1
fi

OPT=$1
case "$OPT" in
    [Oo][Nn]) CMD='YES';;
    [Oo][Ff][Ff]) CMD='NO';;
    *)
    echo '选项格式错误!请用on或off来切换匿名登录的开关。'
    exit 1;
    ;;
esac

VSFTPD_conf='/etc/vsftpd.conf'
TMP_file="tmp/tmp.$$"

sed s/^.*anonymous_enable=.*/anonymous_enable=$CMD/$VSFTPD_conf > $TMP_file
mv -f $TMP_file $VSFTPD_conf

#想要关闭匿名登录，执行：
#./code072_sed_anonyftp.sh off
#
#想要开启匿名登录，执行：
#./code072_sed_anonyftp.sh on
#
#想让设定生效，得重新启动vsftpd才行，
#service vsftpd restart
#或者
#/etc/init.d/vsftpd restart
