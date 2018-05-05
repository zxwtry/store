# coding=utf-8

from img2html.converter import Img2HTMLConverter

converter = Img2HTMLConverter('')

html = converter.convert('/f/tmp/img/chrysanthemum.jpg')

print(html)
