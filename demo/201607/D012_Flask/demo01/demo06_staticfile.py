#!/usr/bin/python
# -*- coding  : utf-8 -*-
from flask import Flask, url_for
app = Flask(__name__)

with app.test_request_context():
	print url_for('static', filename='a.html')

if (__name__ == '__main__'):
	app.run()

