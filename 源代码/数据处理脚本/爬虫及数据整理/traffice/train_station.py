import requests
import json
import pymysql
from placeSetting import *
TABLE7='train_station'
DROP7="drop table if exists %s"%TABLE7
CREATE7='create table %s(name varchar(255),province varchar(255),' \
	   'city varchar(255),area varchar(255),address varchar(255),' \
	   'location_lat float,location_lng float)'%TABLE7
SAVEIN7='insert into '+TABLE7+' values(%s,%s,%s,%s,%s,%s,%s)'
conn=pymysql.connect('localhost','root','123','baidutraffice')
cur=conn.cursor()
cur.execute(DROP7)
cur.execute(CREATE7)
def getjson(loc):
	decodes=[]
	for page_num in range(1):
		headers={'User-Agent':"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Acoo Browser; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0; .NET CLR 3.0.04506)"}
		pa={'query':'火车站',
			'tag':'火车站',
			'region':loc,
			'scope':'2',
			'page_size':20,
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
	for place in places:
		print(place)
		decodes=getjson(place)
		for decodejson in decodes:
			if decodejson['results']:
				for eachone in decodejson["results"]:
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
					# print("\n")
					# print("\n")
					try:
						cur.execute(SAVEIN7,(name,province,city,area,address,location_lat,
							location_lng,))
						conn.commit()
					except Exception as err:
						print(err)

if __name__=="__main__":
	# # print(getjson("北京"))
	get_and_save()