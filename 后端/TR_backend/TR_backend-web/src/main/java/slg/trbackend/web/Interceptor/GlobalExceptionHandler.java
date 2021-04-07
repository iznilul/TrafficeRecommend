package slg.trbackend.web.Interceptor;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.util.logging.resources.logging;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常捕获
 */
@ControllerAdvice // 控制器切面
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("errorCode", -200);
        map.put("errorType",e.toString());
        map.put("errorMsg", "系统错误");
        return map;
    }
}
