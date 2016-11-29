#!/bin/bash

#修改vsftp的配置文件，开放匿名ftp服务

VSFTPD_conf='/etc/vsftpd.conf'
TMP_file="/tmp/tmp.$$"

#将anonymous_enable选项，设成YES，这样，vsftpd就会开启匿名FTP登入的功能。
sed s/^.*anonymous_enable=.*/anonymous_enable=YES/ $VSFTPD_conf > $TMP_file
mv -f $TMP_file $VSFTPD_conf
