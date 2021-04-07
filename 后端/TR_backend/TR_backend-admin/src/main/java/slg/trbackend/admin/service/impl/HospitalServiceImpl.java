package slg.trbackend.admin.service.impl;

import slg.trbackend.admin.dto.Hospital;
import slg.trbackend.admin.entity.QueryIndustry;
import slg.trbackend.admin.mapper.HospitalMapper;
import slg.trbackend.admin.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {


    @Autowired
    HospitalMapper hospitalMapper;

    @Override
    public List<Hospital> QueryHospitelListByReCommands(QueryIndustry queryIndustry) {
        List<Hospital> hospitals = hospitalMapper.QueryHospitelListByCommand(queryIndustry);
        return hospitals;
    }


}
