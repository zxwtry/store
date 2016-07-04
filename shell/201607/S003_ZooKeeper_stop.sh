#!/bin/sh
#encoding="utf-8"
base=/home/software/zookeeper
$base/bin/zkServer.sh stop zoo1.cfg
$base/bin/zkServer.sh stop zoo2.cfg
$base/bin/zkServer.sh stop zoo3.cfg
