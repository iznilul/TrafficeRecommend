package slg.trbackend.admin.service.impl;

import slg.trbackend.admin.dto.Attraction;
import slg.trbackend.admin.entity.QueryIndustry;
import slg.trbackend.admin.mapper.AttractionMapper;
import slg.trbackend.admin.service.AttractionServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionServiceImpl implements AttractionServie {

    @Autowired
    AttractionMapper attractionMapper;

    @Override
    public List<Attraction> QueryAttractionListByRecommends(QueryIndustry queryIndustry) {
        List<Attraction> attractions = attractionMapper.queryAttractionListByRecommends(queryIndustry);
        return attractions;
}
}
