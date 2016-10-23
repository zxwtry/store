#!/bin/bash
#自动安装Apache和PHP的Script文件

#解压
tar xvzf httpd-2.2.11.tar.gz &&
tar xvzf php-5.3.0.tar.gz &&

#设定Apache
echo "Configure apache ...." &&
cd http-2.2.11 &&
./configure --prefix=/usr/local/apache2 --enable-so &&
make &&
make install &&

#设定/编译/安装PHP
cd ../php-5.3.0 &&
./configure \
        --with-apsx2=/usr/local/apache2/bin/apxs \
        --with-mysql=/usr/loacl/mysql && make && make install &&

#复制php.ini到/usr/local/lib
cp -f php.ini-production /usr/bin/lib/php.ini &&

echo 
echo "Done!"
echo
