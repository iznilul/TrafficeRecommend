package slg.trbackend.admin.service;
import slg.trbackend.admin.dto.Hotel;
import slg.trbackend.admin.entity.QueryIndustry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    /**
     * 查找旅馆（根据价钱）
     * @param queryIndustry
     * @return
     */
    List<Hotel> QueryHotelListByPrice(QueryIndustry queryIndustry);

    /**
     * 查找旅馆(根据推荐值推荐)
     * @param queryIndustry
     * @return
     */
    List<Hotel> QueryHotelListByRecommends(QueryIndustry queryIndustry);
}
