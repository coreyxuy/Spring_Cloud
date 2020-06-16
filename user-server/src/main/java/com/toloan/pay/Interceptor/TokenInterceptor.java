package com.toloan.pay.Interceptor;

import com.toloan.pay.pojo.User;
import com.toloan.pay.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ：Corey
 * 15:43 2018/8/16
 */
@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (matchPath(request.getServletPath())){
            String token = request.getHeader("token");
            String userId = request.getHeader("userId");
            if (StringUtils.isBlank(token)){
                return false;
            }
            if (redisService.exists(token)){
                Object s = redisService.getObject(token);
                if (s instanceof User){
                    String reUserId = ((User) s).getId() + StringUtils.EMPTY;
                    if (StringUtils.equals(reUserId,userId)){
                        return true;
                    }
                }
            }
            return false;
        }

        return false;
    }

    private boolean matchPath(String servletPath) {
        if (servletPath.indexOf("api")!=-1){
            return true;
        }else
        {
            return false;
        }


    }


}
