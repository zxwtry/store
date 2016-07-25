#!/usr/bin/python
#encoding=utf-8
from flask import Flask
app = Flask(__name__)

@app.route('/')
def index():
	return "Index Page"

@app.route('/hello')
def hello():
	return "Hello World"

@app.route('/user/<username>')
def show_user_profile(username):
	#显示用户的名称
	return 'User %s' %username

@app.route('/post/<int:post_id>')
#int:是将string转换成int
def show_post(post_id):
	#显示提交整型的用户"id"
	return 'Post %d' %post_id

@app.route('/aabbcc/')
def aabbcc():
	return 'aabbcc'

@app.route('/ddeeff')
def ddeeff():
	return 'ddeeff'

@app.route('/gghhii')
def gghhii():
	return 'gghhii'

@app.route('/gghhii/')
def gghhii2():
	return 'gghhii2'

if (__name__ == '__main__'):
	app.run()
