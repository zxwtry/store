#!/usr/bin/python
#encoding=utf-8

from flask import abort, redirect, url_for, Flask

app=Flask(__name__)

@app.route('/')
def index():
	return redirect(url_for('login'))

@app.route('/login')
def login():
	abort(401)
	return "login"

if __name__=='__main__':
	app.run()
