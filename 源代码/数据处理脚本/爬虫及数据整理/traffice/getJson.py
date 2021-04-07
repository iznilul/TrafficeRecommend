import requests
import json
def getjson(origin_lat,origin_lng,destination_lat,destination_lng):     #传入四个参数，起点经纬度和重点经纬度
	decodes=[]
	for page_index in range(1,2):          #注意这里，如果多爬点页数，可以把range调大一些，现在是爬2页
		headers={'User-Agent':"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Acoo Browser; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0; .NET CLR 3.0.04506)"}
		pa={'origin':origin_lat+","+origin_lng,                       #pa里的请求参数包装到url里通过发送get请求来得到json结果
			'destination':destination_lat+","+destination_lng,
			'page_size':20,            #这里的page——size根据数量需要可以调大一些
			'page_index':page_index,
			'ak':' '   #我的ak值
		}
		try:
			r=requests.get("http://api.map.baidu.com/direction/v2/transit",params=pa,headers=headers)
			decodejson = json.loads(r.text)
			decodes.append(decodejson)
		except Exception as e:
			pass
	return decodes           #返回json结果
