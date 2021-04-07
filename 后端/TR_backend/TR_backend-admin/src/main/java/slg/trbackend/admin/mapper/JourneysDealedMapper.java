package slg.trbackend.admin.mapper;

import slg.trbackend.admin.entity.ReturnRecommendRoute;
import slg.trbackend.admin.entity.TrainQuery;

import java.util.List;

/**
 * @author 查询列车
 */
public interface JourneysDealedMapper {

    /**
     * 通过推荐值查找路线
     * @param trainQuery
     * @return
     */
    List<ReturnRecommendRoute>  queryJourneysDealedListByrecommand(TrainQuery trainQuery);

    /**
     * 通过价钱查找路线
     * @param trainQuery
     * @return
     */
    List<ReturnRecommendRoute>  queryJourneysDealedListByPrice(TrainQuery trainQuery);
}