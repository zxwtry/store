#!/usr/bin/python
#encoding=utf-8
import httplib2
url="http://www.xjtu.edu.cn"
name="xjtu.html"
resp,cont=httplib2.Http().request(url)
fileHandle=open(name,'w')
fileHandle.write(cont)
fileHandle.close()
