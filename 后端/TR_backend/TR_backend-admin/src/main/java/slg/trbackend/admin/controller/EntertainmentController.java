package slg.trbackend.admin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import slg.trbackend.admin.dto.Entertainment;
import slg.trbackend.admin.entity.QueryIndustry;
import slg.trbackend.admin.service.impl.EntertainmentServiceImpl;
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
@RequestMapping("Entertainment")
@Api(tags = "娱乐场所")
public class EntertainmentController {

    @Autowired
    EntertainmentServiceImpl entertainmentServiceImpl;

    @ApiOperation("地点查询通过推荐值")
    @PostMapping("queryEntertainmentListByRecommands")
    ResultKit<Object> queryEntertainmentListByRecommands( QueryIndustry queryIndustry) {
        ResultKit<Object> resultKit = new ResultKit<>();
        if (queryIndustry.getSize() != null) {
            PageHelper.startPage(1, queryIndustry.getSize());
        }
        List<Entertainment> entertainments = entertainmentServiceImpl.queryEntertainmentListByRecommands(queryIndustry);
        if (queryIndustry.getSize() != null) {
            new PageInfo(entertainments);
        }
        resultKit.setCode(ResultCode.SUCCESS.code());
        resultKit.setMessage("查询景点成功");
        resultKit.setData(entertainments);
        return resultKit;
    }


}
