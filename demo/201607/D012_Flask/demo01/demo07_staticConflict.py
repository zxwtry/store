#!/usr/bin/python
#-*- coding : utf-8 -*-
from flask import Flask 
app = Flask(__name__)

@app.route('/static/A')
def staticDef():
	return "This is not static file!"

if (__name__ == '__main__'):
	app.run()
