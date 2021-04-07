package slg.trbackend.admin.service;

import slg.trbackend.admin.dto.Restaurant;
import slg.trbackend.admin.entity.QueryIndustry;

import java.util.List;

public interface RestaurantService {

    /**
     * 查找餐厅(根据价钱)
     * @param queryIndustry
     * @return
     */
    List<Restaurant> QueryRestaurantListByPrice(QueryIndustry queryIndustry);

    /**
     * 查找餐厅(根据推荐值推荐)
     * @param queryIndustry
     * @return
     */
    List<Restaurant> QueryRestaurantListByRecommends(QueryIndustry queryIndustry);
}
