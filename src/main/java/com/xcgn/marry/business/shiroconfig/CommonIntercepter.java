package com.xcgn.marry.business.shiroconfig;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * description: 添加拦截器解决跨域
 * version: 1.0 
 * date: 2019/11/12 10:50 
 * author: ajaxgo
 *
 * @return 
 */ 
@Component
public class CommonIntercepter implements HandlerInterceptor {

    /**
     * description: 自定义拦截，处理登录的post请求
     * version: 1.0 
     * date: 2019/11/25 18:09
     * author: ajaxgo
     * 
     * @param request
 * @param response
 * @param handler
     * @return boolean
     */ 
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //允许跨域,不能放在postHandle内
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (request.getMethod().equals("OPTIONS")) {
            response.addHeader("Access-Control-Allow-Methods", "GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Accept, Authorization");
        }
        return true;
    }
}