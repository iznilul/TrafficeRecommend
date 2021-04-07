from mysqlSetting import *
from getJson import getjson
from journeySetting import *
def get_and_save_journey():
	cur.execute(dropJourney)
	cur.execute(createJourney)
	# cur.execute(addJourney)               #建表操作
	journey_number=0
	for eachjourney in JOURNEYS:
		origin__lat=str(eachjourney[0][0])
		origin__lng = str(eachjourney[1][0])                       #这里调用配置文件里的JOURNEYS来对城市挨个爬取
		destination__lat = str(eachjourney[2][0])
		destination__lng = str(eachjourney[3][0])
		decodes=getjson(origin__lat,origin__lng,destination__lat,destination__lng)
		for eachone in decodes:                                       #下面都是对json的截取，
			try:
				origin_city_name=eachone["result"]["origin"]["city_name"]
				# print("origin_city:"+origin_city_name)
			except:
				origin_city_name=None
			try:
				destination_city_name = eachone["result"]["destination"]["city_name"]
				# print("destination_city:"+destination_city_name)
			except:
				destination_city_name = None
			try:
				journey_name=origin_city_name+"——"+destination_city_name
			except:
				continue
			journey_number = journey_number + 1
			print("journey_number:" + str(journey_number))
			try:
				routes=eachone["result"]["routes"]
			except:
				routes=None
			route_number=0
			for route in routes:
				try:
					The_price=route["price"]
					# print("The_total_price:"+str(The_price))
				except:
					The_price=None
				route_number=route_number+1
				try:
					steps=route["steps"]
				except:
					steps=None
				for step_s in steps:
					for step in step_s:
						try:
							duration = step["duration"]
							# print('The_duration:'+str(duration))
						except:
							duration= None
						try:
							vehicle_number = step["vehicle_info"]["type"]
							if vehicle_number==1:
								vehicle_type="火车"
							if vehicle_number==2:
								vehicle_type="飞机"
							if vehicle_number==3:
								vehicle_type="公交"
							if vehicle_number==4:
								vehicle_type="驾车"
							if vehicle_number==5:
								vehicle_type="步行"
							if vehicle_number==6:
								vehicle_type="大巴"
							# print("The_type:"+vehicle_type)
						except:
							vehicle_type= None
						try:
							vehicle_detail=step["vehicle_info"]["detail"]
						except:
							vehicle_detail=None
						if vehicle_number==1:
							try:
								name=vehicle_detail["name"]
								# print("vehicle_name:"+name)
							except:
								name=None
							try:
								arrive_station=vehicle_detail["arrive_station"]
								# print("arrive_station_name:"+arrive_station)
							except:
								arrive_station=None
							try:
								departure_station=vehicle_detail["departure_station"]
								# print("departure_station_name:"+departure_station)
							except:
								departure_station=None
							try:
								arrive_time=vehicle_detail["arrive_time"][0]+":"+vehicle_detail["arrive_time"][1:3]+":"+vehicle_detail["arrive_time"][4:6]
								# print("arrive_time:"+arrive_time)
							except:
								arrive_time=None
							try:
								departure_time=vehicle_detail["departure_time"][0]+":"+vehicle_detail["departure_time"][1:3]+":"+vehicle_detail["departure_time"][4:6]
								# print("departure_time:"+departure_time)
							except:
								departure_time=None
							try:
								cur.execute(saveJourney, (journey_number, journey_name, route_number, duration, The_price,
													   vehicle_type, name, departure_station, arrive_station,
													   departure_time, arrive_time))
								conn.commit()
							except Exception as err:
								print(err)
						elif vehicle_number==2:
							try:
								name=vehicle_detail["name"]
								print("vehicle_name:"+name)
							except:
								name=None
							try:
								arrive_station=vehicle_detail["arrive_station"]
								print("arrive_station_name:"+arrive_station)
							except:
								arrive_station=None
							try:
								departure_station=vehicle_detail["departure_station"]
								print("departure_station_name:"+departure_station)
							except:
								departure_station=None
							try:
								arrive_time=vehicle_detail["arrive_time"][0]+","+vehicle_detail["arrive_time"][1:2]+","+vehicle_detail["arrive_time"][4:5]
								print("arrive_time:"+arrive_time)
							except:
								arrive_time=None
							try:
								departure_time=vehicle_detail["departure_time"][0]+":"+vehicle_detail["departure_time"][1:3]+":"+vehicle_detail["departure_time"][4:6]
								print("departure_time:"+departure_time)
							except:
								departure_time=None