package slg.trbackend.admin.service.impl;

import slg.trbackend.admin.dto.Entertainment;
import slg.trbackend.admin.entity.QueryIndustry;
import slg.trbackend.admin.mapper.EntertainmentMapper;
import slg.trbackend.admin.service.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class EntertainmentServiceImpl implements EntertainmentService {

    @Autowired
    EntertainmentMapper entertainmentMapper;
    @Override
    public List<Entertainment> queryEntertainmentListByRecommands(QueryIndustry queryIndustry) {
        List<Entertainment> entertainments = entertainmentMapper.queryEntertainmentListByRecommand(queryIndustry);
        return entertainments;
    }
}
