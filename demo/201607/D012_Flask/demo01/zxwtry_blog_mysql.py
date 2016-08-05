#!/usr/bin/python
#encoding=utf-8

import MySQLdb as sql

def insert(title, text):
	try:
		conn=sql.connect(host='localhost', user='root', passwd='12356', port=3306, charset='utf8')
		cur=conn.cursor()
		conn.select_db('flask')
		cur.execute('insert into entries(title, text) values("%s", "%s")' %(title, text))
		conn.commit()
		cur.close()
		conn.close()
	except sql.Error, e:
		print "MySQL error %d: %s" %(e.args[0], e.args[1])

def drop_create_database():
	try:
		conn=sql.connect(host='localhost', user='root', passwd='12356', port=3306, charset='utf8')
		cur=conn.cursor()
		cur.execute('drop database if exists flask')
		cur.execute('create database flask')
		conn.commit()
		cur.close()
		conn.close()
	except sql.Error, e:
		print "MySQL error %d: %s" %(e.args[0], e.args[1])

def drop_create_table():
	try:
		conn=sql.connect(host='localhost', user='root', passwd='12356', port=3306, charset='utf8')
		cur=conn.cursor()
		conn.select_db('flask')
		cur.execute('drop table if exists entries');
		cur.execute('create table entries(id int primary key auto_increment, title varchar(60) not null, text varchar(60) not null) default charset=utf8')
		conn.commit()
		cur.close()
		conn.close()
	except sql.Error, e:
		print "MySQL error %d: %s" %(e.args[0], e.args[1])


if __name__ == '__main__':
	#insert("朱新伟啊啊", "马上吃饭")
	#drop_create_database()
	drop_create_table()
