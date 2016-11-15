#!/bin/bash
tmp=$(ifconfig | grep 'inet addr')
r=${tmp/inet addr:/}
ip=${r/ Bcast*/}
echo $ip
