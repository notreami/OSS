package com.notreami.student3.web.controller;

import com.notreami.student3.generatordomain.User;
import com.notreami.student3.service.UserServiceI;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by notreami on 16/1/2.
 *
 * @WebServlet是Servlet3.0提供的注解，目的是将一个继承了HttpServlet类的普通java类标注为一个Servlet UserServlet使用了@WebServlet标注之后，就不需要在web.xml中配置了
 */
@WebServlet(urlPatterns = {"/userServlet"})
public class UserServlet extends HttpServlet {
    //处理业务逻辑的userService
    private UserServiceI userService;

    @Override
    public void init() throws ServletException {
        System.out.println("UserServlet 初始化");
        //在Servlet初始化时获取Spring上下文对象(ApplicationContext)
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        //从ApplicationContext中获取userService
        userService = (UserServiceI) ac.getBean("userService");//@Service("userService")
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);//会405
        System.out.println("UserServlet doGet");
        //获取所有的用户信息
        List<User> lstUsers = userService.getAllUser();
        req.setAttribute("lstUsers", lstUsers);
        req.getRequestDispatcher("student3/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);//会405
        System.out.println("UserServlet doPost");
        doGet(req, resp);
    }
}
