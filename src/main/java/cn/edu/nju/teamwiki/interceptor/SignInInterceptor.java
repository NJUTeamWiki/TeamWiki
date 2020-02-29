package cn.edu.nju.teamwiki.interceptor;

import cn.edu.nju.teamwiki.api.Result;
import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.util.SessionUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author: xuyangchen
 * @date: 2020/2/12
 */
@Component
public class SignInInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(SignInInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!SessionUtil.hasUser(request.getSession())) {
            LOG.warn("No User Request");
            String content = JSON.toJSONString(Result.failure(ResultCode.USER_NOT_SIGNED_IN));
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.write(content);
            writer.flush();
            return false;
        }
        return true;
    }

}
