#!/usr/bin/python
#encoding=utf-8

from flask import Flask, make_response, render_template

app=Flask(__name__)

@app.route('/kkk')
def kkk():
	resp = make_response(render_template("demo15_error_page.html"))
	resp.headers['aaa']='bbb'
	return resp

if __name__=='__main__':
	app.run(host='0.0.0.0')
