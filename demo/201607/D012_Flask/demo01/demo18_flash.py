#!/usr/bin/python
#encoding=utf-8

from flask import Flask, flash

app=Flask(__name__)

@app.route('/flash')
def flash():
	flash()
	return "aabb"

if __name__=='__main__':
	app.run(host='0.0.0.0')
