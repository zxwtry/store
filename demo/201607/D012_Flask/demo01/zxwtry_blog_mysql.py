#!/usr/bin/python
#encoding=utf-8

import MySQLdb as sql
import sys

def insert(title, text):
	try:
		conn=sql.connect(host='localhost', user='root', passwd='12356', port=3306, charset='utf8')
		cur=conn.cursor()
		#cur.execute("drop database flask if exists;")
		#cur.execute('create database flask')
		conn.select_db('flask')
		#cur.execute('drop table entries if exists;')
		#cur.execute('create table entries(id int primary key auto_increment, title varchar(60) not null, text varchar(60) not null) default charset=utf8;')
		#title=str(title).encode("utf-8")
		#text=str(text).encode("utf-8")
		#title=unicode(title)
		#text=unicode(text)
		#cur.execute('insert into entries(title, text) values("'+title+'", "'+text+'")')
		cur.execute('insert into entries(title, text) values("%s", "%s")' %(title, text))
		conn.commit()
		cur.close()
		conn.close()
	except sql.Error, e:
		print "MySQL error %d: %s" %(e.args[0], e.args[1])

if __name__ == '__main__':

	#reload(sys)
	#sys.setdefaultencoding("utf-8")
	#title=raw_input("输入title:")
	#text=raw_input("输入text:")
	insert("朱新伟啊啊", "马上吃饭")
