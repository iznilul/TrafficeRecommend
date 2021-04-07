package slg.trbackend.admin.controller;

import slg.trbackend.admin.entity.QueryIndustry;
import slg.trbackend.admin.entity.QueryIndustryList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import slg.trbackend.admin.dto.*;
import slg.trbackend.admin.service.impl.*;
import slg.trbackend.common.utils.CglibBean;
import slg.trbackend.common.utils.MyException;

import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("PlaceBase")
@Api(tags = "全地点")
public class PlaceBaseController {


    @Autowired
    AttractionServiceImpl attractionService;

    @Autowired
    HotelServiceImpl hotelServiceImpl;

    @Autowired
    HospitalServiceImpl hospitalServiceImpl;

    @Autowired
    RestaurantServiceImpl restaurantServiceImpl;

    @Autowired
    EntertainmentServiceImpl entertainmentServiceImpl;

    @ApiOperation("地点查询2 测试二")
    @PostMapping("QueryPlaceBase")
    Object query2(@RequestBody QueryIndustryList queryIndustryList) throws ClassNotFoundException, MyException {


        //设置查询类的属性
        QueryIndustry queryIndustry = new QueryIndustry();
        queryIndustry.setScenicAreaArea(queryIndustryList.getScenicAreaArea());
        queryIndustry.setScenicAreaCity(queryIndustryList.getScenicAreaCity());
        queryIndustry.setScenicAreaProvince(queryIndustryList.getScenicAreaProvince());

        if (queryIndustryList.getSize() != null){
            queryIndustry.setSize(queryIndustryList.getSize());
        }

        //新建类的属性
        HashMap propertyMap = new HashMap();


        //获取查询的所有类型
        String[] locationType = queryIndustryList.getLocationType();
        for (String Type : locationType) {
            //判断属于什么类型   建立属性
                propertyMap.put(Type, Class.forName("java.util.List"));
        }

        // 生成动态 Bean
        CglibBean bean = new CglibBean(propertyMap);
        for (String Type : locationType) {
            //判断属于什么类型    插入属性值
            switch (Type) {
                case "hotel": {
                    List<Hotel> hotels = hotelServiceImpl.QueryHotelListByRecommends(queryIndustry);
                    bean.setValue(Type, hotels);
                    break;
                }
                case "hospital": {
                    List<Hospital> hospitals = hospitalServiceImpl.QueryHospitelListByReCommands(queryIndustry);
                    bean.setValue(Type, hospitals);
                    break;
                }
                case "restaurant": {
                    List<Restaurant> restaurants = restaurantServiceImpl.QueryRestaurantListByRecommends(queryIndustry);
                    bean.setValue(Type, restaurants);
                    break;
                }
                case "attraction": {
                    List<Attraction> attractions = attractionService.QueryAttractionListByRecommends(queryIndustry);
                    bean.setValue(Type, attractions);
                    break;
                }
                case "entertainment": {
                    List<Entertainment> entertainments = entertainmentServiceImpl.queryEntertainmentListByRecommands(queryIndustry);
                    bean.setValue(Type, entertainments);
                    break;
                }
                default:{
                    throw new MyException("无此类型");
                }
            }
        }
        // 获得bean的实体
        Object object = bean.getObject();
        return object;
    }
}
