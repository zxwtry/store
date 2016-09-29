# coding=utf-8

import matplotlib.pyplot as pl  
 
if __name__ == '__main__':    
    file1 = open("/home/zxwtry/data/a.csv", 'r')
    line = file1.readline()
    list_str = line.split(",")
    print len(list_str)
    file2 = open("/home/zxwtry/data/b.csv", 'r')
    line2 = file2.readline()
    list_str2 = line2.split(",")
    print len(list_str2)
    file1.close()
    file2.close()
    f_arr2 = []
    sum2 = 0.0
    for str_now2 in list_str2:
        append_2 = float(str_now2)
        f_arr2.append(append_2)
        if append_2 > 0:
            sum2 += append_2
        else:
            sum2 += - append_2
    f_arr = []
    sum1 = 0.0
    for str_now in list_str:
        append_1 = -float(str_now)
    	f_arr.append(append_1)
        if append_1 > 0:
            sum1 += append_1
        else:
            sum1 += - append_1
    scale = sum1 / sum2; 
    print1 = []
    for f_1 in f_arr:
        print1.append(f_1/scale)
    x_arr = range(len(list_str))
    pl.plot(x_arr, print1, 'k')
    pl.plot(x_arr, f_arr2, 'r')
    pl.show()
    
