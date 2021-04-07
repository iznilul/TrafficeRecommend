package slg.trbackend.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import slg.trbackend.admin.dto.Hospital;
import slg.trbackend.admin.entity.QueryIndustry;
import slg.trbackend.admin.service.impl.HospitalServiceImpl;
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
@RequestMapping("Hospital")
@Api(tags = "医院")
public class HospitalController {

    @Autowired
    HospitalServiceImpl hospitalServiceImpl;

    @ApiOperation("地点查询通过推荐值")
    @PostMapping("QueryHospitalListByReCommands")
    ResultKit<Object> QueryHospitelListByReCommands( QueryIndustry queryIndustry) {
        ResultKit<Object> resultKit = new ResultKit<>();
        if (queryIndustry.getSize() != null) {
            PageHelper.startPage(1, queryIndustry.getSize());
        }
        List<Hospital> attractions = hospitalServiceImpl.QueryHospitelListByReCommands(queryIndustry);
        if (queryIndustry.getSize() != null) {
            new PageInfo<>(attractions);
        }
        resultKit.setCode(ResultCode.SUCCESS.code());
        resultKit.setMessage("查询医院成功");
        resultKit.setData(attractions);
        return resultKit;
    }

}
