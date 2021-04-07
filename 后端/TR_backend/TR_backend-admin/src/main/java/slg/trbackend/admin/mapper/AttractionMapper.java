package slg.trbackend.admin.mapper;

import org.springframework.stereotype.Repository;
import slg.trbackend.admin.dto.Attraction;
import slg.trbackend.admin.entity.QueryIndustry;

import java.util.List;

@Repository
public interface AttractionMapper {

    /**
     * 通过推荐值查询景点
     * @param queryIndustry
     * @return
     */
    List<Attraction> queryAttractionListByRecommends(QueryIndustry queryIndustry);
}