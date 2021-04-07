package slg.trbackend.admin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import slg.trbackend.admin.dto.Restaurant;
import slg.trbackend.admin.entity.QueryIndustry;
import slg.trbackend.admin.service.impl.RestaurantServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import slg.trbackend.common.base.ResultKit;
import slg.trbackend.common.utils.ResultCode;

import java.util.List;

@RestController
@RequestMapping("Restaurant")
@Api(tags = "餐厅")
public class RestaurantController {
    @Autowired
    RestaurantServiceImpl restaurantServiceImpl;

    @ApiOperation("地点查询（可选择是否根据价钱排序）")
    @PostMapping("QueryRestaurantListByPrice")
    ResultKit<Object> QueryRestaurantListByPrice(QueryIndustry queryIndustry) {
        ResultKit<Object> resultKit = new ResultKit<>();
        if (queryIndustry.getSize() != null) {
            PageHelper.startPage(1, queryIndustry.getSize());
        }
        List<Restaurant> restaurants = restaurantServiceImpl.QueryRestaurantListByPrice(queryIndustry);
        if (queryIndustry.getSize() != null) {
            new PageInfo<>(restaurants);
        }
        resultKit.setCode(ResultCode.SUCCESS.code());
        resultKit.setMessage("查询酒店成功");
        resultKit.setData(restaurants);
        return resultKit;
    }

    @ApiOperation("地点查询(通过推荐值)")
    @PostMapping("QueryRestaurantListByRecommends")
    ResultKit<Object> QueryRestaurantListByRecommends(QueryIndustry queryIndustry) {
        ResultKit<Object> resultKit = new ResultKit<>();
        if (queryIndustry.getSize() != null) {
            PageHelper.startPage(1, queryIndustry.getSize());
        }
        List<Restaurant> restaurants = restaurantServiceImpl.QueryRestaurantListByRecommends(queryIndustry);
        if (queryIndustry.getSize() != null) {
            new PageInfo<>(restaurants);
        }
        resultKit.setCode(ResultCode.SUCCESS.code());
        resultKit.setMessage("查询景点成功");
        resultKit.setData(restaurants);
        return resultKit;
    }


}
