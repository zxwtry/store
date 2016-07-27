#!/usr/bin/python
#encoding=utf-8

from flask import Flask, request

app=Flask(__name__)

@app.route("/upfile", methods=['POST', 'GET'])
def upfile():
	if request.method=='POST':
		f=request.files['files']
		f.save("/home/zxwtry/tmp.txt")
	return "success"

if __name__=='__main__':
	app.run()
