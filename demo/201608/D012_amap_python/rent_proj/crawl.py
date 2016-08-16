#/usr/bin/python
#encoding=utf-8
from bs4 import BeautifulSoup
from urlparse import urljoin
import requests
import csv

url = "http://xa.58.com/pinpaigongyu/pn/{page}/?minprice=500_2000"

page = 0

csv_file=open("rent.csv", "wb")
csv_writer=csv.writer(csv_file, delimiter=',')

while True:
	page+=1
	print "正在找: ",url.format(page=page)
	response=requests.get(url.format(page=page))
	html=BeautifulSoup(response.text)
	fileHandle=open("html.txt", 'w')
	fileHandle.write(str(html))
	fileHandle.close()
	house_list=html.select(".list<li")
	print house_list
	if not house_list:
		break
	for house in house_list:
		house_title=house.select('h2')[0].string.encode("utf8")
		house_url=urljoin(url, house.select("a")[0]["href"])
		house_info_list=house_title.split()
		if "租" in house_info_list[1]or "青年社区" in house_info_list[1]:
			house_location=house_info_list[0]
		else:
			house_location=house_info_list[1]
		house_money=house.select(".money")[0].select("b")[0].string.encode("utf8")
		csv_writer.writerow([house_titile, house_location, house_money, house_lusr])

csv_file.close()
