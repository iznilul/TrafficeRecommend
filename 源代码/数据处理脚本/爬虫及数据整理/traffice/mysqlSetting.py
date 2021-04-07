import pymysql
MYSQL_HOST='localhost'
MYSQL_ROOT='root'
MYSQL_PASSWORD='123'
MYSQL_DATABASE='baidutraffice'
conn=pymysql.connect(MYSQL_HOST,MYSQL_ROOT,MYSQL_PASSWORD,MYSQL_DATABASE,port=3307)   #连接数据库，想连自己的可以改配置文件
cur=conn.cursor()
# ****************************************************
TABLE='restaurant'
DROP="drop table if exists %s"%TABLE
CREATE='create table %s(restaurantId int,name varchar(255),province varchar(255),' \
	   'city varchar(255),area varchar(255),address varchar(255),' \
'location_lat float,location_lng float,'\
	   'price varchar(255),recommend1 varchar(255),recommend2 varchar(255))'%TABLE
# ADD="create index na on %s(name,area)"%TABLE
SAVEIN='insert into '+TABLE+' (restaurantId,name,province,city,area,address,location_lat,' \
							'location_lng,price,' \
							'recommend1,recommend2) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)'
#*******************************************************************************************************
TABLE1='hotel'
DROP1="drop table if exists %s"%TABLE1
CREATE1='create table %s(hotelId int,name varchar(255),province varchar(255),' \
	   'city varchar(255),area varchar(255),address varchar(255),' \
'location_lat float,location_lng float,'\
	   'price varchar(255),recommend1 varchar(255),recommend2 varchar(255))'%TABLE1
ADD1="create index na on %s(name,area)"%TABLE1
SAVEIN1='insert into '+TABLE1+' (hotelId,name,province,city,area,address,location_lat,' \
							'location_lng,price,' \
							'recommend1,recommend2) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)'
# ***********************************************************************************
tableAttraction='attraction'
dropAttraction="drop table if exists %s"%tableAttraction
createAttraction='create table %s(attractionId int,name varchar(255),province varchar(255),' \
	   'city varchar(255),area varchar(255),address varchar(255),' \
'location_lat float,location_lng float,'\
	   'recommend1 varchar(255),recommend2 varchar(255))'%tableAttraction
addAttraction="create index na on %s(name,area)"%tableAttraction
saveAttraction='insert into '+tableAttraction+' (attractionId,name,province,city,area,address,location_lat,' \
							'location_lng,' \
							'recommend1,recommend2) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)'
# ***********************************************************************************
TABLE3='hospital'
DROP3="drop table if exists %s"%TABLE3
CREATE3='create table %s(hospitalId int,name varchar(255),province varchar(255),' \
	   'city varchar(255),area varchar(255),address varchar(255),' \
'location_lat float,location_lng float,'\
	   'recommend1 varchar(255),recommend2 varchar(255))'%TABLE3
ADD3="create index na on %s(name,area)"%TABLE3
SAVEIN3='insert into '+TABLE3+' (hospitalId,name,province,city,area,address,location_lat,' \
							'location_lng,' \
							'recommend1,recommend2) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)'
# *******************************************************************************************

TABLE5='entertainment'
DROP5="drop table if exists %s"%TABLE5
CREATE5='create table %s(entertainmentId int,name varchar(255),province varchar(255),' \
	   'city varchar(255),area varchar(255),address varchar(255),' \
'location_lat float,location_lng float,'\
	   'recommend1 varchar(255),recommend2 varchar(255))'%TABLE5
ADD5="create index na on %s(name,area)"%TABLE5
SAVEIN5='insert into '+TABLE5+' (entertainmentId,name,province,city,area,address,location_lat,' \
							'location_lng,' \
							'recommend1,recommend2) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)'

# ***********************************************************************************************************

tableJourney="journeys"
dropJourney="drop table if exists %s"%tableJourney
createJourney='create table %s(journey_number smallint,journey_name varchar(255),route_number smallint,' \
		 'The_duration mediumint,The_price smallint,The_type varchar(255),' \
		 'vehicle_name varchar(255),departure_station_name varchar(255),' \
		 'arrive_station_name varchar(255),departure_time varchar(255),arrive_time varchar(255))'%tableJourney
addJourney="create index va on %s(vehicle_name,arrive_time)"%tableJourney
saveJourney='insert into '+tableJourney+' (journey_number,journey_name,route_number,The_duration,The_price,' \
								'The_type,vehicle_name,departure_station_name,arrive_station_name,' \
								'departure_time,arrive_time)' \
								'values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)'
# ****************************************************************************************
