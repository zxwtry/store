#!/usr/bin/python
#encoding=utf-8
import urllib
import re
base="http://www.xxx.cn"
def downloadAnImageFromURL(url, name):
    urllib.urlretrieve(url, "/home/data/univ/"+name)
def downloadJPGFromLine(con):
    s1=r"img src=\"([0-9a-z/]+).jpg\""
    res=re.findall(s1,con)
    for rei in res:
        print rei
        s2=r"/([0-9a-z]+)$"
        res2=re.findall(s2, rei)[0]
        downloadAnImageFromURL(base+rei+".jpg",res2+".jpg")
def downloadPNGFromLine(con):
    s1=r"img src=\"([0-9a-z/]+).png\""
    res=re.findall(s1,con)
    for rei in res:
        s2=r"/([0-9a-z]+)$"
        res2=re.findall(s2, rei)[0]
        downloadAnImageFromURL(base+rei+".png",res2+".png")
def downloadGIFFromLine(con):
    s1=r"img src=\"([0-9a-z/]+).gif\""
    res=re.findall(s1,con)
    for rei in res:
        s2=r"/([0-9a-z]+)$"
        res2=re.findall(s2, rei)[0]
        downloadAnImageFromURL(base+rei+".gif",res2+".gif")
con_read=open("con1.txt","r")
while True:
    con=con_read.readline()
    if con:
        downloadJPGFromLine(con)
        downloadPNGFromLine(con)
        downloadGIFFromLine(con)
    else:
        break
con_read.close()
