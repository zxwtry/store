# coding=utf-8

import string
import matplotlib.pyplot as pl  
import numpy as np
 
if __name__ == '__main__':    
    file = open("/home/zxwtry/data/09281421.csv", 'r')
    line = file.readline()
    list_str = line.split(",")
    print len(list_str)
    f_arr = []
    for str_now in list_str:
    	f_arr.append(-float(str_now))
    x_arr = range(len(list_str))
    pl.plot(x_arr, f_arr, 'k')
    pl.show()
