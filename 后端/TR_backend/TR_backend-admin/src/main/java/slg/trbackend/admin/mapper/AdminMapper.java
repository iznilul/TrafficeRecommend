package slg.trbackend.admin.mapper;

import slg.trbackend.admin.dto.Admin;
import org.springframework.stereotype.Repository;

/**
 * @Author: Devhui
 * @Date: 2020/3/16 19:43
 * @Email: devhui@ihui.ink
 * @Version: 1.0
 */

@Repository
public interface AdminMapper {
    Admin loginCheck(String username, String password);
}
