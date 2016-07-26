#!usr/bin/python
# -*- coding: utf-8 -*-
from flask import Flask

app = Flask(__name__)

@app.route('/sum/<int:a>/<int:b>')
def sum(a, b):
	return str(a+b)

if (__name__ == '__main__'):
	app.run()
