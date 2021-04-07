package slg.trbackend.admin.controller;

import slg.trbackend.admin.dto.TrainStation;
import slg.trbackend.admin.entity.QueryTrainStation;
import slg.trbackend.admin.service.impl.TrainStationServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
@Api(tags = "站点")
public class TrainStationController {
    @Autowired
    TrainStationServiceImpl trainStationServiceImpl;

    @ApiOperation("站点查询(通过名称)")
    @PostMapping("QueryTrainStationByName")
    ResultKit QueryTrainStationByName(QueryTrainStation queryTrainStation){
        ResultKit<Object> resultKit = new ResultKit<>();
        List<TrainStation> trainStations = trainStationServiceImpl.queryListTrainStation(queryTrainStation);
        resultKit.setCode(ResultCode.SUCCESS.code());
        resultKit.setMessage("查询站点成功");
        resultKit.setData(trainStations);
        return resultKit;
    }
}
