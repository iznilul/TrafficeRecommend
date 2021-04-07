package slg.trbackend.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import slg.trbackend.admin.dto.Admin;
import slg.trbackend.admin.service.AdminService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import slg.trbackend.common.base.ResultKit;
import slg.trbackend.common.utils.JwtUtils;
import slg.trbackend.common.utils.RedisUtil;
import slg.trbackend.common.utils.ResultCode;

import java.util.HashMap;
import java.util.UUID;

/**
 * @Author: Devhui
 * @Date: 2020/3/14 20:25
 * @Email: devhui@ihui.ink
 * @Version: 1.0
 */

@RestController
@RequestMapping("auth")
@Api(tags = "人员登陆授权")
public class AuthController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RedisUtil redisUtil;


    @ApiOperation("管理员用户登录")
    @PostMapping("login")
    ResultKit<Object> login(@RequestBody  @ApiParam(value = "login",name = "输入账号密码",example = "aaa")String param ) {
        JSONObject json = JSON.parseObject(param);
        String username = (String) json.get("username");
        String password = (String) json.get("password");
        System.out.println(json);
        ResultKit<Object> resultKit = new ResultKit<>();
        Admin admin = adminService.loginCheck(username, password);
        System.out.println(admin);
        if (admin != null) {
            // 签发token
            String token = JwtUtils.createJWT(UUID.randomUUID().toString(), admin.getUsername());
            System.out.println(token);
            redisUtil.set(token,UUID.randomUUID(),10000);
            HashMap<String, Object> map = new HashMap<>();
            map.put("token", token);
            map.put("user", admin);

            resultKit.setCode(ResultCode.SUCCESS.code());
            resultKit.setMessage("登录成功");
            resultKit.setData(map);
        } else {
            resultKit.setCode(ResultCode.WRONG_UP.code());
            resultKit.setMessage("登录失败，账号或密码错误！");
        }
        return resultKit;
    }

}
