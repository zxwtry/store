#!/bin/sh
#encoding=utf-8
echo "192.168.160.150   centos0" >> /etc/hosts
echo "192.168.160.151   centos1" >> /etc/hosts
echo "192.168.160.152   centos2" >> /etc/hosts
echo "192.168.160.153   centos3" >> /etc/hosts
#第二个文件
#!/bin/sh
scp S004_hosts.sh root@centos1:/root
scp S004_hosts.sh root@centos2:/root
scp S004_hosts.sh root@centos3:/root
