package slg.trbackend.admin.mapper;

import slg.trbackend.admin.dto.TrainStation;
import slg.trbackend.admin.entity.QueryTrainStation;

import java.util.List;

public interface TrainStationMapper {
    int insert(TrainStation record);

    int insertSelective(TrainStation record);

    List<TrainStation> queryListTrainStation(QueryTrainStation queryTrainStation);
}