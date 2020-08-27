package com.yanzhen.interceptor;

import com.yanzhen.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器,对于请求处理进行拦截
 */
public class LoginInterceptor implements HandlerInterceptor {
    //preHandle()预处理方法,是在请求之前调用的处理
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登录
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null){
            //用户存在就return true;
            return true;
        }
        //用户不存在就跳转到登录页面中去
        response.sendRedirect(request.getContextPath()+"/login");
        return false;
    }
}
