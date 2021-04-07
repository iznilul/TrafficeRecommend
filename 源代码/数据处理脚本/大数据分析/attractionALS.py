import findspark
findspark.init()
import pymysql
from pyspark.sql import SparkSession
from pyspark.sql import Row
from pyspark.mllib.recommendation import ALS

connect=pymysql.connect(host='192.168.1.228',port=3307,user='root',passwd='123',db='baidutraffice',charset='utf8')
cursor=connect.cursor()

table='attractionUser'
DROP = "drop table if exists %s" % table
create = "create table %s (userId int,attractionId int,recommend float)" % table
insert = "insert into "+ table +" values(%s,%s,%s)"
spark = SparkSession.builder.master("local").appName("attractionALS").getOrCreate()

df=spark.read.text('file:///export/servers/pycharm_project/attraction.txt')
attrs_rdd1=df.rdd.map(lambda x:x[0].split(',')).map(lambda x:Row(userId=1,attractionId=x[0],recommend1=x[8]))
attrs_rdd2=df.rdd.map(lambda x:x[0].split(',')).map(lambda x:Row(userId=2,attractionId=x[0],recommend2=x[9]))

rdd1=attrs_rdd1.map(lambda x:(x[2],x[0],x[1]))
rdd2=attrs_rdd2.map(lambda x:(x[2],x[0],x[1]))
model1=ALS.train(rdd1,10,10,0.01)
model2=ALS.train(rdd2,10,10,0.01)

attrs1 = model1.recommendProducts(1,500)
attrs2 = model2.recommendProducts(2,500)
for i in attrs2:
    print(i)


cursor.execute(DROP)
cursor.execute(create)
for a1 in attrs1:
    cursor.execute(insert,(a1[0],a1[1],a1[2]))
connect.commit()

for a2 in attrs2:
    cursor.execute(insert, (a2[0], a2[1], a2[2]))
connect.commit()
