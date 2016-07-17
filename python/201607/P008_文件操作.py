#!/usr/bin/python
#encoding=utf-8

#文件是/home/test.txt
filename="/home/test.txt"
#文件的打开file或者open
#区别file是一个类
def eg01():
    fo=open(filename)
    #print fo输出的信息是：
    #<open file '/home/test.txt', mode 'r' at 0x7fa6440654b0>
    #print fo.read()能够读取文件中的信息，而且是全部读出来
    #关闭文件读取
    fo.close()
    
    f1=file(filename)
    #print f1输出的信息是：
    #<open file '/home/test.txt', mode 'r' at 0x7f964cbee540>
    #print f1.read()能够读取文件中的信息，而且是全部读出来
    f1.close()

#python文件操作mode
#r default 只读
#r+     读写
#w      写入，先删除原文件，再重新写入
#w+     读写，先删除原文件，再重新写入
#a      写入，在文件末尾追加新的内容
#a+     读写，在文件末尾追加新的内容
#b      打开二进制文件，可以与r,w,a,+结合使用
#U      支持所有的换行符号,"\r" “\n” "\r\n"
#需要向文件中写数据
#出现一个问题：
#fo.open(filename, "a+")
#fo.write("good luck!\n")
#fo.flush()
#print fo.read()
#输出的是空行
#应该是reset或者是定位到文件的某个位置的问题。
def eg02():
    fo=open(filename, 'a+')
    print fo.read()
    fo.write('good luck!\n')
    fo.flush()
    fo.close()
    
eg02()
