package com.jxpxxzj.webbank.auth;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);

            if (authPassport == null || !authPassport.validate()) {
                return true;
            } else {
                HttpSession session = request.getSession();
                if (session.getAttribute("account") != null) {
                    return true;
                } else {
                    response.sendRedirect("/login");
                    return false;
                }
            }
        } else {
            return true;
        }
    }
}
