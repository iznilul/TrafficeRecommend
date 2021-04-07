package slg.trbackend.admin.service.impl;

import slg.trbackend.admin.dto.Restaurant;
import slg.trbackend.admin.entity.QueryIndustry;
import slg.trbackend.admin.mapper.RestaurantMapper;
import slg.trbackend.admin.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantMapper requestMapping;

    @Override
    public List<Restaurant> QueryRestaurantListByPrice(QueryIndustry queryIndustry) {
        List<Restaurant> restaurants = requestMapping.queryRestaurantList(queryIndustry);
        return restaurants;
    }

    @Override
    public List<Restaurant> QueryRestaurantListByRecommends(QueryIndustry queryIndustry) {
        List<Restaurant> restaurants = requestMapping.queryRestaurantListByRecommends(queryIndustry);
        return restaurants;
    }


}
