package slg.trbackend.admin.service;

import slg.trbackend.admin.dto.Admin;

/**
 * @Author: Devhui
 * @Date: 2020/3/31 21:00
 * @Email: devhui@ihui.ink
 * @Version: 1.0
 */
public interface AdminService {
    /**
     * 检查登录
     * @param username
     * @param password
     * @return
     */
    Admin loginCheck(String username, String password);
}
