
package slg.trbackend.web.Interceptor;
import com.alibaba.fastjson.JSON;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import slg.trbackend.common.base.ResultKit;
import slg.trbackend.common.base.TokenConstant;
import slg.trbackend.common.utils.MainUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: Devhui
 * @Date: 2019-12-05 20:39
 * @Version 1.0
 */

@Component
public class MainInterceptor implements HandlerInterceptor {
    /**
     * 预处理回调方法，实现处理器的预处理
     * 返回值：true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
     */


    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
            throws Exception {
        System.out.println("开始拦截.........");
        // Authorization
        String token = req.getHeader(TokenConstant.HEADER_TOKEN);
        System.out.println(token);
        ResultKit checkToken = MainUtils.checkToken(token);
        System.out.println(checkToken);
        if (checkToken.getCode() == 200) {
            System.out.println("true");
            return  true;
        } else {
            // 返回token无效结果
            returnJson(checkToken, resp);
            return false;
        }
    }

    /**
     * 后处理回调方法，实现处理器（controller）的后处理，但在渲染视图之前
     * 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    /**
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，
     * 如性能监控中我们可以在此记录结束时间并输出消耗时间，
     * 还可以进行一些资源清理，类似于try-catch-finally中的finally，
     * 但仅调用处理器执行链中
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

    /**
     * token无效返回信息
     *
     * @param response
     */
    private void returnJson(ResultKit resultKit, HttpServletResponse response) {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(403);
        try {
            writer = response.getWriter();
            String jsonString = JSON.toJSONString(resultKit);
            writer.print(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
