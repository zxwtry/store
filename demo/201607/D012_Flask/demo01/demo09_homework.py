#!/usr/bin/python
#encoding=utf-8
from flask import Flask, render_template

app = Flask(__name__)

@app.route('/main/')
@app.route('/main/<name>')
def mymain(name = None):
	return render_template('demo09_green.html', name=name)

if (__name__ == '__main__'):
	app.run()
