package slg.trbackend.admin.service;

import slg.trbackend.admin.dto.Hospital;
import slg.trbackend.admin.entity.QueryIndustry;

import java.util.List;

public interface HospitalService {
    /**
     * 查找医院
     * @param queryIndustry
     * @return
     */
    List<Hospital> QueryHospitelListByReCommands(QueryIndustry queryIndustry);

}

