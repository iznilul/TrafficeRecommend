package slg.trbackend.admin.service.impl;

import slg.trbackend.admin.dto.Admin;
import slg.trbackend.admin.mapper.AdminMapper;
import slg.trbackend.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Devhui
 * @Date: 2020/3/31 21:00
 * @Email: devhui@ihui.ink
 * @Version: 1.0
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin loginCheck(String username, String password) {
        return adminMapper.loginCheck(username, password);
    }
}
