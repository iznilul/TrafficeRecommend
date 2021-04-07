package slg.trbackend.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import slg.trbackend.admin.dto.Hotel;
import slg.trbackend.admin.entity.QueryIndustry;
import slg.trbackend.admin.service.impl.HotelServiceImpl;
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



/**
 * @author Administrator
 */
@RestController
@RequestMapping("Hotel")
@Api(tags = "旅馆")
public class HotelController {

    @Autowired
    HotelServiceImpl hotelServiceImpl;

    @ApiOperation("地点查询（可选择是否根据价钱排序）")
    @PostMapping("queryHotelByPrice")
    ResultKit<Object> queryHotelByPrice(QueryIndustry queryIndustry) {

        ResultKit<Object> resultKit = new ResultKit<>();
        PageHelper.startPage(1, queryIndustry.getSize());
        List<Hotel> hotels = hotelServiceImpl.QueryHotelListByPrice(queryIndustry);
        new PageInfo<>(hotels);
        resultKit.setCode(ResultCode.SUCCESS.code());
        resultKit.setMessage("查询酒店成功");
        resultKit.setData(hotels);
        return resultKit;
    }

    @ApiOperation("地点查询(通过推荐值)")
    @PostMapping("queryHotelByRecommends")
    ResultKit<Object> queryHotelByRecommadn(QueryIndustry queryIndustry) {
        ResultKit<Object> resultKit = new ResultKit<>();
        if (queryIndustry.getSize() != null) {
            PageHelper.startPage(1, queryIndustry.getSize());
        }
        List<Hotel> hotels = hotelServiceImpl.QueryHotelListByRecommends(queryIndustry);
        if (queryIndustry.getSize() != null) {
            new PageInfo<>(hotels);
        }
        resultKit.setCode(ResultCode.SUCCESS.code());
        resultKit.setMessage("查询景点成功");
        resultKit.setData(hotels);
        return resultKit;
    }



}
