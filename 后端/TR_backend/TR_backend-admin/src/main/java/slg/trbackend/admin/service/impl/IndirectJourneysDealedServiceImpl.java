package slg.trbackend.admin.service.impl;

import slg.trbackend.admin.entity.ReturnRecommendRoute;
import slg.trbackend.admin.entity.TrainQuery;
import slg.trbackend.admin.mapper.IndirectJourneysDealedMapper;
import slg.trbackend.admin.service.IndirectJourneysDealedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class IndirectJourneysDealedServiceImpl implements IndirectJourneysDealedService {

    @Autowired
    IndirectJourneysDealedMapper indirectJourneysDealedMapper;

    @Override
    public List<ReturnRecommendRoute> QueryIndirectJourneysDealedListByrecommand(TrainQuery trainQuery) {
        List<ReturnRecommendRoute> returnRecommendRoutes = indirectJourneysDealedMapper.queryIndirectJourneysDealedListByrecommand(trainQuery);
        return returnRecommendRoutes;
    }

    @Override
    public List<ReturnRecommendRoute> QueryIndirectJourneysDealedListByprice(TrainQuery trainQuery) {
        List<ReturnRecommendRoute> returnRecommendRoutes = indirectJourneysDealedMapper.queryIndirectJourneysDealedListByPrice(trainQuery);
        return returnRecommendRoutes;
    }
}
