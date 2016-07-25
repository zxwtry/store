#!/usr/bin/python
#encoding=utf-8
from flask import Flask
#导入的这个类Flask，实例化的将会是WSGI应用
#第一个参数应该是：应用模块的名称
#如果使用的是单一的模块，第一个参数应该使用__name__。因为如果踏以单独应用启动
#或作为模块导入，名称将会不同(__main__对应于实际导入的名称)
app = Flask(__name__)

#装饰器route()告诉Flask哪个URL才能触发我们的函数
@app.route('/')
def hello_world():
	return "Hello World!"

@app.route('/main')
def hello_world2():
	return "Hello World2!"

#表明该脚本被Python解释器直接执行的时候才会运行，而不是作为模块导入的时候
if __name__ == '__main__':
	#	app.run()
	#下面的代码会让操作系统去监听所有公开的IP
	app.debug = True
	app.run(host='0.0.0.0')
