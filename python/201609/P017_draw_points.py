#!/bin/python3
# -*- coding: utf-8 -*-
import re
import matplotlib.pyplot as plt
def getAllPoint(s):
    fs=open(s)
    l1=[]
    l2=[]
    l3=[]
    while True:
        try:
            line=fs.next()
            mo=re.match("([^ ]+) ([^ ]+) ([^ ]+)",line)
            l1.append(mo.group(1))
            l2.append(mo.group(2))
            l3.append(mo.group(3))
        except Exception,e:
            print("文件读取完成")
            break
    fs.close()
    d={}
    d['l1']=l1
    d['l2']=l2
    d['l3']=l3
    return d

def plotPoint(x, y):
    l=len(x)
    for i in range(l):
        plt.plot(float(y[i]),float(x[i]),'#FF00FFo')
    plt.legend()
    plt.show()
    

if __name__=="__main__":
    d=getAllPoint("../data/data_format.txt")
    plotPoint(d['l2'],d['l3'])
