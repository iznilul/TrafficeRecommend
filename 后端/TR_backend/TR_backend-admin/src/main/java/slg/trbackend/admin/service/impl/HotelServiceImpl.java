package slg.trbackend.admin.service.impl;

import slg.trbackend.admin.dto.Hotel;
import slg.trbackend.admin.entity.QueryIndustry;
import slg.trbackend.admin.mapper.HotelMapper;
import slg.trbackend.admin.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelMapper hotelMapper;

    @Override
    public List<Hotel> QueryHotelListByPrice(QueryIndustry queryIndustry) {
        List<Hotel> hotels = hotelMapper.queryHotelListByPrice(queryIndustry);
        return hotels;
    }

    @Override
    public List<Hotel> QueryHotelListByRecommends(QueryIndustry queryIndustry) {
        List<Hotel> hotels = hotelMapper.queryHotelListByRecommends(queryIndustry);
        return hotels;
    }
}
