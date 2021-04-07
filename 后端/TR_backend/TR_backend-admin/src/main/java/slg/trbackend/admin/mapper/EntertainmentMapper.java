package slg.trbackend.admin.mapper;

import slg.trbackend.admin.dto.Entertainment;
import slg.trbackend.admin.entity.QueryIndustry;

import java.util.List;

public interface EntertainmentMapper {

    List<Entertainment> queryEntertainmentListByRecommand(QueryIndustry queryIndustry);
}