#!/bin/sh
#encoding="utf-8"
base=/home/software/zookeeper
$base/bin/zkServer.sh start zoo1.cfg
$base/bin/zkServer.sh start zoo2.cfg
$base/bin/zkServer.sh start zoo3.cfg
