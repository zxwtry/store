#!/usr/bin/python
#-*- coding : utf-8 -*-
from flask import Flask, render_template,url_for

app = Flask(__name__)

@app.route('/main/')
@app.route('/main/<name>')
def mymain(name=None):
	return render_template('demo10_green.html', name=name)

if (__name__ == '__main__'):
	app.run(host='0.0.0.0')
