#!/usr/bin/python
#encoding=utf-8

from flask import Flask

app=Flask(__name__)

@app.route('/')
def index():
	app.logger.debug('I am from zxwtry')
	return 'index'

if __name__ == '__main__':
	app.run()
