#!/usr/bin/python
#encoding=utf-8

from flask import Flask, render_template

app = Flask(__name__)

@app.errorhandler(404)
def page_not_found(error):
	return render_template("demo15_error_page.html"),404

if __name__=='__main__':
	app.run()
