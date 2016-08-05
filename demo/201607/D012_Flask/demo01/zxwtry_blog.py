#!/usr/bin/python
#encoding=utf-8

from __future__ import with_statement
from contextlib import closing
from flask import Flask, request, session, url_for, g,\
		 render_template, redirect, abort, flash

app=Flask(__name__)
app.config.from_object(__name__)
app.config.from_envvar("FLASKR_SETTINGS", silent=True)


if __name__=='__main__':
	app.run(host='0.0.0.0')
