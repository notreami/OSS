package com.notreami.student1.annotation;

import com.notreami.student1.AsyncListenerTest;

import javax.servlet.AsyncContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by zhaobo04 on 15/11/30.
 */
/**
 *可插性支持,动态注册为一个可以用于服务的 Servlet
 * Servlet3.0支持使用注解配置Servlet。我们只需在Servlet对应的类上使用@WebServlet进行标注，
 * 我们就可以访问到该Servlet了，而不需要再在web.xml文件中进行配置。@WebServlet的urlPatterns
 * 和value属性都可以用来表示Servlet的部署路径，它们都是对应的一个数组。
 */
/**
 * 支持异步返回的Servlet
 * 对于Servlet的异步返回，首先我们必须指定@WebServlet的asyncSupported属性为true（默认是false），同时在它之前的Filter
 * 的asyncSupported属性也必须是true，否则传递过来的request就是不支持异步调用的。
 *
 */
/**
 * 带初始化参数的Servlet
 * WebServlet的属性initParams可以用来指定当前Servlet的初始化参数，它是一个数组，
 * 里面每一个@WebInitParam表示一个参数。
 */
@WebServlet(urlPatterns = {"/servletAnnotationTest"}, asyncSupported = true, loadOnStartup = 1, name = "ServletAnnotationTest", displayName = "描述",
        initParams = {@WebInitParam(name = "username", value = "ServletAnnotationTest")})
public class ServletAnnotationTest extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("ServletAnnotationTest 初始化");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("username="+config.getInitParameter("username"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletAnnotationTest doGet");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletAnnotationTest doPost");

        String keyword = req.getParameter("keyword");
        System.out.println("读取的数据:" + keyword);

        PrintWriter out = resp.getWriter();
        out.println("结束Servlet的时间：" + new Date() + ".</br>");
        out.flush();
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("ServletAnnotationTest 结束");
    }
}