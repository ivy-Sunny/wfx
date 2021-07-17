package com.ivy.controller.config;

import com.ivy.entity.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * LoginHandlerInceptor
 *
 * @Author: ivy
 * @CreateTime: 2021-07-16
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object userinfo = (UserInfo) session.getAttribute("userinfo");
        if (userinfo == null) {
            System.out.println(request.getContextPath());
            response.sendRedirect("login");
            return false;
        }
        return true;
    }
}
