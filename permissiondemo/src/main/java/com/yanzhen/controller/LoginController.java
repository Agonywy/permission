package com.yanzhen.controller;


import com.yanzhen.codeutil.IVerifyCodeGen;
import com.yanzhen.codeutil.SimpleCharVerifyCodeGenImpl;
import com.yanzhen.codeutil.VerifyCode;
import com.yanzhen.pojo.User;
import com.yanzhen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * 登录 退出相关
 */
@Controller
public class LoginController {
    @Autowired
    private IUserService userService;

    /**
     * 获取验证码方法
     */
    @RequestMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            //获取验证码
            String code = verifyCode.getCode();
            //将VerifyCode绑定到session上,后续判断验证码是否输入正确就是通过session来实现的
            request.getSession().setAttribute("VerifyCode", code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            System.out.println("异常处理");
        }
    }


    /**
     * 登录验证
     */
    @RequestMapping("/loginIn")
    public String loginIndex(HttpServletRequest request, Model model){
        //通过request去获取用户名,密码,验证码
        //通过model把验证信息反馈到前台中去
        //获取用户名   <input type="text" name="username" >
        String username = request.getParameter("username");
        //获取密码     <input type="password" name="password" >
        String password = request.getParameter("password");
        //获取验证码 <input type="text" name="code" >
        String code = request.getParameter("code");
        //验证登录是否超时
        HttpSession session = request.getSession();
        if(session == null){
            model.addAttribute("msg","session超时了");
            //如果超时了就将你跳转到登录页面
            return "login";
        }
        //判断验证码
        //1.获取照片上显示的验证码
        String trueCode = (String) session.getAttribute("VerifyCode");
        //不区分大小写判断输入的验证码和图片中的验证码是否相等
        if(!trueCode.toLowerCase().equals(code.toLowerCase())){
            model.addAttribute("msg","验证码不正确,请重新输入");
            return "login";
        }
        //判断用户名和密码是否正确
        User user = userService.queryInfoByUsernameAndPassword(username, password);
        if(user == null){
            model.addAttribute("msg","用户名或密码不正确");
            return "login";
        }
        model.addAttribute("msg","登录成功");
        //用户名和密码正确的话,就把用户保存到session中去
        session.setAttribute("user",user);
        //重定向到主页去
        return "redirect: /index";
    }


    /**
     * 退出功能
     */
    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request){
        //退出功能就是注销session就可以了
        HttpSession session = request.getSession();
        session.invalidate();
        //然后重定向到登录页面
        return "redirect:/login";
    }


    /**
     * 登录页面的转发
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     *主页
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
