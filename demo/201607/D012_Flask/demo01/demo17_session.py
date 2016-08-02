#!/usr/bin/python
#encoding=utf-8

from flask import Flask, request, session, url_for, redirect, escape

app=Flask(__name__)

@app.route('/')
def index():
	if 'username' in session:
		return "Your name is %s" % escape(session['username'])
	return redirect(url_for('login'))

@app.route('/login', methods=['GET', 'POST'])
def login():
	if request.method=='POST':
		session['username']=request.form['username']
		return redirect(url_for('index'))
	else:
		return 	'''
				<html>
					<body>
						<form action="login" method="POST">
							<input type="text" name="username"><br/>
							<input type="submit">
						</form>
					</body>
				</html>
				'''

@app.route('/logout')
def logout():
	session.pop('username', None)
	return redirect(url_for('index'))

app.secret_key="hello zxw"

if __name__ == '__main__':
	app.run(host='0.0.0.0')


"""
	import os
	os.urandom(20)
	将返回的str拷入app.secrect_key中
"""
