#!/usr/bin/python
#encoding=utf-8
from flask import Flask, render_template, make_response,request

app=Flask(__name__)

@app.route('/get')
def index_getCookies():
	my_cookies=request.cookies.get('username')
	print '已经获得了cookies: '+str(my_cookies)
	return 'success'

@app.route('/set')
def index_setCookies():
	my_make_response=make_response(render_template('demo13_make_response.html', username='zxwtry'))
	my_make_response.set_cookie('username', 'cookie for zxwtry time 201607')
	return my_make_response

if __name__=='__main__':
	app.run()
