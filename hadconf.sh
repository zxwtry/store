#!/bin/sh
#scp /home/hadoopConfig/* node102://home/soft/
#scp /home/hadoopConfig/* node103://home/soft/
#scp /home/hadoopConfig/* node105://home/soft/
#scp /home/hadoopConfig/* node106://home/soft/
#scp /home/hadoopConfig/* node108://home/soft/
#scp /home/hadoopConfig/tar.sh node102:/root/
#scp /home/hadoopConfig/tar.sh node103:/root/
#scp /home/hadoopConfig/tar.sh node105:/root/
#scp /home/hadoopConfig/tar.sh node106:/root/
#scp /home/hadoopConfig/tar.sh node108:/root/

#jdk1="\nexport JAVA_HOME=/home/soft/jdk1.8.0_60\nexport JRE_HOME=/home/soft/jdk1.8.0_60/jre\nexport CLASSPATH=.:\$JAVA_HOME/lib/dt.jar:\$JAVA_HOME/lib/tools.jar\nexport PATH=\$JAVA_HOME/bin:\$JRE_HOME/bin:\$PATH\n"
#echo $jdk1 >>  /etc/profile
#update-alternatives --install /usr/bin/java java /home/soft/jdk1.8.0_60/bin/java 300  
#update-alternatives --install /usr/bin/javac javac /home/soft/jdk1.8.0_60/bin/javac 300
#update-alternatives --config java
#source /etc/profile
#java -version

hd1="\nexport HADOOP_HOME=/home/soft/hadoop-2.7.1\nexport PATH=\$PATH:\$HADOOP_HOME/bin:\$HADOOP_HOME/sbin\n"
hd2="\nexport JAVA_HOME=/home/soft/jdk1.8.0_60\n#export HADOOP_INSTALL= /home/soft/hadoop-2.7.1\n#export PATH=\$PATH: /home/soft/hadoop-2.7.1/bin\n"

echo $hd1 >>  /etc/profile
echo $hd2 >>  /home/soft/hadoop-2.7.1/etc/hadoop/hadoop-env.sh

source /home/soft/hadoop-2.7.1/etc/hadoop/hadoop-env.sh



