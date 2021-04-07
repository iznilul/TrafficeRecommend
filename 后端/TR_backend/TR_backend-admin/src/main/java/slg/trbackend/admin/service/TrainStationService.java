package slg.trbackend.admin.service;

import slg.trbackend.admin.dto.TrainStation;
import slg.trbackend.admin.entity.QueryTrainStation;

import java.util.List;

/**
 * 列车查询类
 * @author Administrator
 */
public interface TrainStationService {

    /**
     * 查询区域站点
     * @param queryTrainStation
     * @return
     */
    List<TrainStation> queryListTrainStation(QueryTrainStation queryTrainStation);
}
