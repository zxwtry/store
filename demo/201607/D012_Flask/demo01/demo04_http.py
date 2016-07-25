#!/usr/bin/python
#encoding=utf-8
from flask import Flask
app = Flask(__name__)
@app.route("/login", methods=['GET','POST'])
def login():
	if request.method == 'POST':
		return 'POST METHOD'
	else:
		return 'GET METHOD'
if (__name__ == '__main__'):
	app.run()
