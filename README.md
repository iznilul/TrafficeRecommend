# TrafficeRecommendSystem交通推荐系统

交通出行推荐系统，基于Springboot+pySpark+Vue

这个项目其实很久之前就做好了，只是一直没有开源QvQ

为了让自己绿出强大，俺决定开源再写个md

 [TOC]

## 项目技术支持

>开发工具：IDEA2019.3 ，WebStorm2019.3 ，Pycharm2019.3
>
>数据库：mysql5.7
>
>浏览器：chrome
>
>其他技术
>
>>Springboot2.1
>>
>>Vue
>>
>>mybatis
>>
>>Pyspark
>>
>>ALS模型算法
>>
>>BaiduMap地图组件
>>
>>Maven
>>
>>
>
>

## 项目介绍

这就是一个很简单的，前后端分离的推荐系统

运用ALS算法模型计算数据，根据用户选择的推荐值后端从数据库取出传给前端，地图组件渲染呈现给用户

没了QvQ

## 项目架构

B/S架构，前后端分离

前端湿湿一大坨

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1gos1miil5fj30d00eo0t5.jpg)

<<<<<<< HEAD


=======
>>>>>>> 2021.03.22
npm run serve启动



![img](http://ww1.sinaimg.cn/large/006LiLY3ly1gos1miiwe3j30jr061wen.jpg)



后端分三个模块，admin业务处理，common工具类，web保存配置

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1gos1mikfs6j30ed05ojrj.jpg)

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1goryipyi1ij309u0cwgly.jpg)

数据处理脚本，分析需要和虚拟机连接，爬虫需要百度地图api的ak值

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1gos1miqq90j30cz0mjgmr.jpg)

## 项目展示

首页

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1gos1mj2ywhj31h90p74ng.jpg)

在旅馆里搜索上海和浦东新区，返回

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1gos1mj0oovj30vu0mwqil.jpg)

广东省深圳市的景点

<<<<<<< HEAD

=======
>>>>>>> 2021.03.22
![img](http://ww1.sinaimg.cn/large/006LiLY3ly1gos1miy7rqj314m0ge1cv.jpg)

北京市到上海市的火车路线

![img](http://ww1.sinaimg.cn/large/006LiLY3ly1gos1miwv1tj30yo0k2n55.jpg)

