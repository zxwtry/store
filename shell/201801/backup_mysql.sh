#!/bin/bash

#/usr/local/mysql/bin/mysqldump -uroot -p12356 -B test > /data/test.sql
#ubuntu
#将MySQL中的test库导出到/data/test.sql文件
#将test.sql文件压缩之后，保存到/data/bak目录下
/usr/bin/mysqldump -uroot -p12356 -B test > /data/test.sql
cd /data
tar zcf test.sql.tar.gz test.sql
mv test.sql.tar.gz bak/`date -d'-1 day' +%Y%m%d`.tar.gz
old=`date -d'-7 day' +%Y%m%d`
if [ -f /data/bak/$old.tar.gz ];
then
    rm -rf /data/bak/$old.tar.gz
fi
