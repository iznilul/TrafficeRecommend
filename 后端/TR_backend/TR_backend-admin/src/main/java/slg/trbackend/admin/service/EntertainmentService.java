package slg.trbackend.admin.service;

import slg.trbackend.admin.dto.Entertainment;
import slg.trbackend.admin.entity.QueryIndustry;

import java.util.List;

/**
 * @author Administrator
 */
public interface EntertainmentService {

    /**
     * 查找娱乐场所
     * @param queryIndustry
     * @return
     */
    List<Entertainment> queryEntertainmentListByRecommands(QueryIndustry queryIndustry);
}
