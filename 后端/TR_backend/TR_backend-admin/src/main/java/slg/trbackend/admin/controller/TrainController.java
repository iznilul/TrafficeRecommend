package slg.trbackend.admin.controller;


import slg.trbackend.admin.entity.ReturnRecommendRoute;
import slg.trbackend.admin.entity.TrainQuery;
import slg.trbackend.admin.service.impl.IndirectJourneysDealedServiceImpl;
import slg.trbackend.admin.service.impl.JourneysDealedServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
@RequestMapping("Train")
@Api(tags = "列车")
public class TrainController {

    /**
     * 直达查询
     */
    @Autowired
    JourneysDealedServiceImpl journeysDealedService;

    /**
     * 间接查询
     */
    @Autowired
    IndirectJourneysDealedServiceImpl indirectJourneysDealedService;

    @ApiOperation("列车查询 根据推荐值查询")
    @PostMapping("QueryTrainByRecommand")
    ResultKit<Object> queryByrecommand(@RequestBody TrainQuery trainQuery) {

        trainQuery.setStartAndEndCity(trainQuery.getStartCity()+"——"+trainQuery.getEndCity());
        ResultKit<Object> resultKit = new ResultKit<>();

        PageHelper.startPage(1, 3);
        List<ReturnRecommendRoute> returnRecommendRoutes = journeysDealedService.QueryJourneysDealedListByrecommand(trainQuery);
        new PageInfo(returnRecommendRoutes);

        PageHelper.startPage(1,3);
        List<ReturnRecommendRoute> indirectreturnRecommendRoutes = indirectJourneysDealedService.QueryIndirectJourneysDealedListByrecommand(trainQuery);
        new PageInfo(indirectreturnRecommendRoutes);

        returnRecommendRoutes.addAll(indirectreturnRecommendRoutes);
        resultKit.setCode(ResultCode.SUCCESS.code());
        resultKit.setMessage("查询成功");
        resultKit.setData(returnRecommendRoutes);
        return resultKit;
    }


    @ApiOperation("列车查询 根据价钱查询")
    @PostMapping("QueryTrainByPrice")
    ResultKit<Object> queryByPrice(@RequestBody TrainQuery trainQuery) {
        trainQuery.setStartAndEndCity(trainQuery.getStartCity()+"——"+trainQuery.getEndCity());
        ResultKit<Object> resultKit = new ResultKit<>();
        PageHelper.startPage(1, 3);
        List<ReturnRecommendRoute> returnRecommendRoutes = journeysDealedService.QueryJourneysDealedListByprice(trainQuery);
        new PageInfo(returnRecommendRoutes);
        PageHelper.startPage(1, 3);
        List<ReturnRecommendRoute> indirectreturnRecommendRoutes = indirectJourneysDealedService.QueryIndirectJourneysDealedListByprice(trainQuery);
        new PageInfo(indirectreturnRecommendRoutes);
        returnRecommendRoutes.addAll(indirectreturnRecommendRoutes);
        resultKit.setCode(ResultCode.SUCCESS.code());
        resultKit.setMessage("查询成功");
        resultKit.setData(returnRecommendRoutes);
        return resultKit;
    }

}
