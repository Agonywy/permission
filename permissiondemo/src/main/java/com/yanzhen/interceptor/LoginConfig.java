package com.yanzhen.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration  //配置注解
/**登录相关的配置*/
public class LoginConfig implements WebMvcConfigurer {
    @Override
    //注册加入拦截器的方法
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        InterceptorRegistration registration;
        registration = registry.addInterceptor(new LoginInterceptor());
        //拦截所有的路径
        registration.addPathPatterns("/**");
        //不拦截的路径信息
        registration.excludePathPatterns(
                "/login",       //登录页面不拦截
                "/loginIn",     //对于登录请求不拦截
                "/verifyCode",  //验证码不拦截
                "/**/*.js",     //所有的js不需要拦截
                "/**/*.css",    //所有的css不需要拦截
                "/**/*.png",    //所有的图片不需要拦截
                "/**/*.html",   //所有的html页面也不需要拦截
                "/**/*.woff",
                "/**/*.ttf"
        );
    }
}