#!/usr/bin/python
#encoding=utf-8
from flask import request, Flask, render_template
import sys
#需要导入request
app=Flask(__name__)
def valid_login(username, password):
	if username == 'zxwtry' and password == '123':
		return True
	return False
@app.route('/login', methods=['POST', 'GET'])
def login():
	reload(sys)
	sys.setdefaultencoding('utf-8')
	error='GET请求被禁止'
	if request.method == 'POST':
		#采用如下这种方式获得username和password，如果出现不存在上诉键值，会显示HTTP 400 Bad Request
		username=request.form['username']
		password=request.form['password']
		if valid_login(username, password):
			return render_template('demo11_request.html',  error=str(username+' 登录成功'))
		else:
			error='用户名或密码错误'
	else:
		#采用如下方式获取，可以避免HTTP 400 Bad Request，但是username和password是会在链接上显示的。
		username=request.args.get('username', 'default')
        password=request.args.get('password', 'default')
        nosuchel=request.args.get('nosuchel', 'default')
        print 'username: '+username
        print 'password: '+password
        print 'nosuchel: '+nosuchel
        if valid_login(username, password):
            return render_template('demo11_request.html',  error=str(username+' 登录成功'))
        else:
            error='用户名或密码错误'
	#当请求形式为"GET"或者认证失败则执行如下代码
	return render_template('demo11_request.html', error=error)
if __name__=='__main__':
	app.run()
