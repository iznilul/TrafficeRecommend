package slg.trbackend.admin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import slg.trbackend.admin.dto.Attraction;
import slg.trbackend.admin.entity.QueryIndustry;
import slg.trbackend.admin.service.impl.AttractionServiceImpl;
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
@RequestMapping("Attraction")
@Api(tags = "景点")
public class AttractionController {

    @Autowired
    AttractionServiceImpl attractionService;

    @ApiOperation("地点查询通过推荐值")
    @PostMapping("QueryAttractionByRecommends")
    ResultKit<Object> QueryAttractionByRecommends(QueryIndustry queryIndustry) {
        ResultKit<Object> resultKit = new ResultKit<>();
        if (queryIndustry.getSize() != null){
            PageHelper.startPage(1, queryIndustry.getSize());
        }
        List<Attraction> attractions = attractionService.QueryAttractionListByRecommends(queryIndustry);
        if (queryIndustry.getSize() != null) {
            new PageInfo<>(attractions);
        }
        resultKit.setCode(ResultCode.SUCCESS.code());
        resultKit.setMessage("查询景点成功");
        resultKit.setData(attractions);
        return resultKit;
    }

}
