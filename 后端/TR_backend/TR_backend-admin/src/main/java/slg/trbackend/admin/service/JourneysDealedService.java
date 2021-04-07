package slg.trbackend.admin.service;

import slg.trbackend.admin.entity.ReturnRecommendRoute;
import slg.trbackend.admin.entity.TrainQuery;

import java.util.List;

/**
 * @author Administrator
 */
public interface JourneysDealedService {

    /**
     * 查找列车通过推荐值
     * @param trainQuery
     * @return
     */
    List<ReturnRecommendRoute> QueryJourneysDealedListByrecommand(TrainQuery trainQuery);

    /**
     * 查找列车通过价格
     * @param trainQuery
     * @return
     */
    List<ReturnRecommendRoute> QueryJourneysDealedListByprice(TrainQuery trainQuery);
}
