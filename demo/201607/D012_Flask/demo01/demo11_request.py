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
		if valid_login(request.form['username'], request.form['password']):
			return render_template('demo11_request.html',  error=str(request.form['username']+'登录成功'))
		else:
			error='用户名或密码错误'
	#当请求形式为"GET"或者认证失败则执行如下代码
	return render_template('demo11_request.html', error=error)

if __name__=='__main__':
	app.run()
