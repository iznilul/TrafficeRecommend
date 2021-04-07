package slg.trbackend.admin.service.impl;

import slg.trbackend.admin.dto.TrainStation;
import slg.trbackend.admin.entity.QueryTrainStation;
import slg.trbackend.admin.mapper.TrainStationMapper;
import slg.trbackend.admin.service.TrainStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Administrator
 */
@Service
public class TrainStationServiceImpl implements TrainStationService {
    @Autowired
    TrainStationMapper trainStationMapper;
    @Override
    public List<TrainStation> queryListTrainStation(QueryTrainStation queryTrainStation) {
        List<TrainStation> trainStations = trainStationMapper.queryListTrainStation(queryTrainStation);
        return trainStations;
    }
}
