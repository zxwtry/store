#!/usr/bin/python
#encoding=utf-8
from flask import Flask
#导入的这个类Flask，实例化的将会是WSGI应用
#第一个参数应该是：应用模块的名称
#如果使用的是单一的模块，
app = Flask(__name__)

@app.route('/')
def hello_world():
	return "Hello World!"

@app.route('/main')
def hello_world2():
	return "Hello World2!"

#表明该脚本被Python解释器直接执行的时候才会运行，而不是作为模块导入的时候
if __name__ == '__main__':
	app.run()
