import requests
import json
from placeSetting import places
from mysqlSetting import *
import random
import os
if os.path.exists('restaurant.txt'):
    os.remove('restaurant.txt')
cur.execute(DROP)
cur.execute(CREATE)

def getjson(loc):
	decodes=[]
	for page_num in range(2):
		headers={'User-Agent':"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Acoo Browser; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0; .NET CLR 3.0.04506)"}
		pa={'q':'餐厅',
			'region':loc,
			'scope':'2',
			'page_size':100,
			'page_num':page_num,
			'output':'json',
			'ak':' '
		}
		try:
			r=requests.get("http://api.map.baidu.com/place/v2/search",params=pa,headers=headers)
			decodejson = json.loads(r.text)
			decodes.append(decodejson)
		except Exception as e:
			pass
	return decodes
def get_and_save():
	i=0
	for place in places:
		print(place)
		decodes=getjson(place)
		for decodejson in decodes:
			if decodejson['results']:
				for eachone in decodejson["results"]:
					i+=1
					try:
						name=eachone["name"]
						# print(name)
					except:
						name=None
					try:
						province=eachone["province"]
						# print(province)
					except:
						province=None
					try:
						city=eachone["city"]
						# print(city)
					except:
						city=None
					try:
						area=eachone["area"]
						# print(area)
					except:
						area=None
					try:
						address=eachone["address"]
						# print(address)
					except:
						address=None
					try:
						location_lat=eachone["location"]["lat"]
						# print(location_lat)
					except:
						location_lat=None
					try:
						location_lng=eachone["location"]["lng"]
						# print(location_lng)
					except:
						location_lng=None
					try:
						price=eachone["detail_info"]["price"]
						# print(price)
					except:
						price=None
					# print("\n")
					# print("\n")
					try:
						a = random.uniform(1, 5)
						b = random.uniform(1, 5)
						cur.execute(SAVEIN, (str(
							i) , name , province , city , area , address , str(
							location_lat) , str(location_lng) , price , str(round(a, 1)) , str(
							round(b, 1)) ))
						conn.commit()
						with open('D:\python\s\BD\\restaurant.txt', 'a') as f:  # 设置文件对象
							f.write(str(i) + ',' + name + ',' + province + ',' + city + ','
									+ area + ',' + address + ',' + str(location_lat) + ',' + str(location_lng) + ','
									+ price + ',' + str(round(a,1)) + ',' + str(round(b,1)) + '\n')
					except Exception as err:
						# print(err)
						pass

if __name__=="__main__":
	# print(getjson("鞍山"))
	get_and_save()