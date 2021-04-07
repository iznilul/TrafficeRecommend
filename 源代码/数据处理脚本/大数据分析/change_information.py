# encoding=UTF-8
import os
import sys
import findspark
findspark.init()
from pyspark.sql import functions as F
from pyspark.sql import SparkSession
'''
@author: Fawkes
@function:对路程和时间进行加权处理
'''
# 创建编译环境
# os.environ['SPARK_HOME'] = '/export/servers/spark-2.4.3'
# sys.path.append('/export/servers/spark-2.4.3/python/lib')
# 创建SparkSession(enableHiveSupport 确保能支持Hive)
sqlSession = SparkSession.builder.master("local").appName("project").enableHiveSupport().getOrCreate()

#去除DataFrame的recommand列中为null的数据
def to_null(c):
	return F.when(~(F.col(c).isNull()), F.col(c))
#本文件的主程序,用于对行程计算推荐值
def change_all_information(db, tb):
	# 读取数据库中的数据
	tableDF = sqlSession.read.jdbc(
		properties={"driver": "com.mysql.jdbc.Driver"}
		, url="jdbc:mysql://192.168.1.228:3307/" + db + "?user=root&password=123", table=tb, lowerBound=1,
		upperBound=10000000, numPartitions=10)
	# 筛选,去除不正确的数值
	aiminfo = tableDF.filter(
		(tableDF['The_duration'] > 0) & (tableDF['The_price'] > 0))
	# 加权处理
	# 保留两位小数 F为 pyspark.sql.function
	recommand1 = F.bround(100 - (aiminfo['The_duration'] / 3000 * 0.9 + aiminfo['The_price'] / 100 * 0.1), scale=2)
	recommand2 = F.bround(100-(aiminfo['The_duration']/3000 * 0.7 + aiminfo['The_price']/100 * 0.3), scale=2)
	recommand3 = F.bround(100 - (aiminfo['The_duration']/3000 * 0.5 + aiminfo['The_price']/100 * 0.5), scale=2)
	recommand4 = F.bround(100 - (aiminfo['The_duration']/3000 * 0.3 + aiminfo['The_price']/100 * 0.7), scale=2)
	recommand5 = F.bround(100 - (aiminfo['The_duration'] / 3000 * 0.1 + aiminfo['The_price'] / 100 * 0.9), scale=2)
	# 添加新的列 recommand
	aiminfo = aiminfo.withColumn("recommand1", recommand1)
	aiminfo = aiminfo.withColumn("recommand2", recommand2)
	aiminfo = aiminfo.withColumn("recommand3", recommand3)
	aiminfo = aiminfo.withColumn("recommand4", recommand4)
	aiminfo = aiminfo.withColumn("recommand5", recommand5)
	# print(aiminfo)

# 将数据覆写新的表,若不存在该表,则创建
	aiminfo.write.jdbc(
	properties={"driver": "com.mysql.jdbc.Driver"},
	url="jdbc:mysql://192.168.1.228:3307/" + db + "?user=root&password=123", table="indirectjourneys_dealed", mode="overwrite")

# 测试数据
change_all_information('baidutraffice', 'journeys_indirect')

