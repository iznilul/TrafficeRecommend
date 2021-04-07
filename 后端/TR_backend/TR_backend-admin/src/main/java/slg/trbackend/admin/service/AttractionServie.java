package slg.trbackend.admin.service;

import slg.trbackend.admin.dto.Attraction;
import slg.trbackend.admin.entity.QueryIndustry;


import java.util.List;

/**
 * @author Administrator
 */
public interface AttractionServie {
    /**
     * 查找景点(根据推荐值推荐)
     * @param queryIndustry
     * @return
     */
    List<Attraction> QueryAttractionListByRecommends(QueryIndustry queryIndustry);

}
