package cn.edu.nju.teamwiki.interceptor;

import cn.edu.nju.teamwiki.api.Result;
import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.util.Constants;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author: xuyangchen
 * @date: 2020/2/12
 */
@Component
public class SignInInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute(Constants.SESSION_UID) == null) {
            String content = JSON.toJSONString(Result.failure(ResultCode.USER_NOT_LOGGED_IN));

            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.write(content);
            writer.flush();
            return false;
        }
        return true;
    }

}
