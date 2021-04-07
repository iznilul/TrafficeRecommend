package slg.trbackend.admin.mapper;

import slg.trbackend.admin.dto.Hospital;
import slg.trbackend.admin.entity.QueryIndustry;

import java.util.List;

public interface HospitalMapper {

    List<Hospital> QueryHospitelListByCommand(QueryIndustry queryIndustry);
}