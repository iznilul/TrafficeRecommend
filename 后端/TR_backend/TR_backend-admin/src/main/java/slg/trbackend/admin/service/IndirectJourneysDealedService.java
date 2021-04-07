package slg.trbackend.admin.service;

import slg.trbackend.admin.entity.ReturnRecommendRoute;
import slg.trbackend.admin.entity.TrainQuery;

import java.util.List;

/**
 * @author Administrator
 */
public interface IndirectJourneysDealedService {

    /**
     * 查找列车通过推荐值(间接)
     * @param trainQuery
     * @return
     */
    List<ReturnRecommendRoute> QueryIndirectJourneysDealedListByrecommand(TrainQuery trainQuery);

    /**
     * 查找列车通过价格(间接)
     * @param trainQuery
     * @return
     */
    List<ReturnRecommendRoute> QueryIndirectJourneysDealedListByprice(TrainQuery trainQuery);
}
