#!/bin/bash
#自动安装Apache和PHP的Script文件
#添加设定版本
ApacheVersion="httpd-2.2.11"
PHPVersion="php-5.3.0"
MYSQLHOME="/usr/loacl/mysql"

#解压
tar xvzf ${ApacheVersion}.tar.gz &&
tar xvzf ${PHPVersion}.tar.gz &&

#设定Apache
echo "Configure apache ...." &&
cd ${ApacheVersion} &&
./configure --prefix=/usr/local/apache2 --enable-so &&
make &&
make install &&

#设定/编译/安装PHP
cd ../${PHPVersion} &&
./configure \
        --with-apsx2=/usr/local/apache2/bin/apxs \
        --with-mysql=${MYSQLHOME} && make && make install &&

#复制php.ini到/usr/local/lib
cp -f php.ini-production /usr/bin/lib/php.ini &&

echo 
echo "Done!"
echo
