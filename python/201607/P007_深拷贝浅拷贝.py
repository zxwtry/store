#!/usr/bin/python
#encoding=utf-8
import copy
#example01:python中的引用是对对象的引用　
#note:不能在str后面用+增加list(或int)
def example01():
    a=[1,2,3,'a','b','c']
    b=a
    print "a is : " + str(a)
    print "b is : " + str(b)
    print "id(a) is : " + str(id(a))
    print "id(b) is : " + str(id(b))
    a.append('d')
    print "在对a进行append之后"
    print "a is : " + str(a)
    print "b is : " + str(b)
    print "id(a) is : " + str(id(a))
    print "id(b) is : " + str(id(b))

#example02:想要b和a的地址空间不同
#需要import copy
#copy.copy()的使用
#拷贝之后的规律
#常量，地址会变(int, str)
#非常量，地址不变
def example02():
    a=[1,2,3,['a','b','c'],"abc"]
    b=a
    c=copy.copy(a)
    print "id(a) is : " + str(id(a))
    print "id(b) is : " + str(id(b))
    print "id(c) is : " + str(id(c))
    print "a中第一个元素的地址 : " + str(id(a[0]))
    print "b中第一个元素的地址 : " + str(id(b[0]))
    print "c中第一个元素的地址 : " + str(id(c[0]))
    #将常量修改，看结果
    #结果是修改常量，只修改父地址一样的
    a[0]=100
    print "将常量修改之后的结果是："
    print "a is : " + str(a)
    print "b is : " + str(b)
    print "c is : " + str(c)
    print "id(a) is : " + str(id(a))
    print "id(b) is : " + str(id(b))
    print "id(c) is : " + str(id(c))
    print "a中第一个元素的地址 : " + str(id(a[0]))
    print "b中第一个元素的地址 : " + str(id(b[0]))
    print "c中第一个元素的地址 : " + str(id(c[0]))
    #将常量修改，看结果
    #结果是修改常量，只修改父地址一样的
    a[4]="efg"
    print "将常量修改之后的结果是："
    print "a is : " + str(a)
    print "b is : " + str(b)
    print "c is : " + str(c)
    print "id(a) is : " + str(id(a))
    print "id(b) is : " + str(id(b))
    print "id(c) is : " + str(id(c))
    print "a中第一个元素的地址 : " + str(id(a[0]))
    print "b中第一个元素的地址 : " + str(id(b[0]))
    print "c中第一个元素的地址 : " + str(id(c[0]))
    #修改列表
    #a,b,c列表地址永远一样
    a[3].append("w");
    print "将列表修改之后的结果是："
    print "a is : " + str(a)
    print "b is : " + str(b)
    print "c is : " + str(c)
    print "id(a) is : " + str(id(a))
    print "id(b) is : " + str(id(b))
    print "id(c) is : " + str(id(c))
    print "a中第三个元素的地址 : " + str(id(a[3]))
    print "b中第三个元素的地址 : " + str(id(b[3]))
    print "c中第三个元素的地址 : " + str(id(c[3]))
    
#深拷贝
#所有元素的地址都不一样
#同样是是用copy包
def example03():
    a=[1,2,3,['a','b','c'],"abc"]
    b=a
    c=copy.deepcopy(a)
    print "id(a) is : " + str(id(a))
    print "id(b) is : " + str(id(b))
    print "id(c) is : " + str(id(c))
    print "a中第一个元素的地址 : " + str(id(a[0]))
    print "b中第一个元素的地址 : " + str(id(b[0]))
    print "c中第一个元素的地址 : " + str(id(c[0]))
    #将常量修改，看结果
    #结果是修改常量，只修改父地址一样的
    a[0]=100
    print "将常量修改之后的结果是："
    print "a is : " + str(a)
    print "b is : " + str(b)
    print "c is : " + str(c)
    print "id(a) is : " + str(id(a))
    print "id(b) is : " + str(id(b))
    print "id(c) is : " + str(id(c))
    print "a中第一个元素的地址 : " + str(id(a[0]))
    print "b中第一个元素的地址 : " + str(id(b[0]))
    print "c中第一个元素的地址 : " + str(id(c[0]))
    #将常量修改，看结果
    #结果是修改常量，只修改父地址一样的
    a[4]="efg"
    print "将常量修改之后的结果是："
    print "a is : " + str(a)
    print "b is : " + str(b)
    print "c is : " + str(c)
    print "id(a) is : " + str(id(a))
    print "id(b) is : " + str(id(b))
    print "id(c) is : " + str(id(c))
    print "a中第一个元素的地址 : " + str(id(a[0]))
    print "b中第一个元素的地址 : " + str(id(b[0]))
    print "c中第一个元素的地址 : " + str(id(c[0]))
    #修改列表
    #a,b,c列表地址永远一样
    a[3].append("w");
    print "将列表修改之后的结果是："
    print "a is : " + str(a)
    print "b is : " + str(b)
    print "c is : " + str(c)
    print "id(a) is : " + str(id(a))
    print "id(b) is : " + str(id(b))
    print "id(c) is : " + str(id(c))
    print "a中第三个元素的地址 : " + str(id(a[3]))
    print "b中第三个元素的地址 : " + str(id(b[3]))
    print "c中第三个元素的地址 : " + str(id(c[3]))

example03()
