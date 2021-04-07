package slg.trbackend.admin.mapper;

import slg.trbackend.admin.dto.Restaurant;
import slg.trbackend.admin.entity.QueryIndustry;

import java.util.List;

/**
 * @author Administrator
 */
public interface RestaurantMapper {

    /**
     * 查找饭店  (可选择是否通过价钱排序)
     * @param queryIndustry
     * @return
     */
    List<Restaurant> queryRestaurantList(QueryIndustry queryIndustry);

    /**
     * 根据推荐值进行排序
     * @param queryIndustry
     * @return
     */
    List<Restaurant> queryRestaurantListByRecommends(QueryIndustry queryIndustry);
}