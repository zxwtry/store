#!/usr/bin/python
#encoding=utf-8

from flask import Flask, request
from werkzeug import secure_filename

app=Flask(__name__)

@app.route("/upfile", methods=['POST', 'GET'])
def upfile():
	if request.method=='POST':
		f=request.files['files']
		f.save("/home/zxwtry/"+secure_filename(f.filename))
	return "success"

if __name__=='__main__':
	app.run()
