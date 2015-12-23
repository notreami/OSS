package com.notreami.student1.annotation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by zhaobo04 on 15/11/30.
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

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.append("ServletAnnotationTest");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("ServletAnnotationTest 结束");
    }
}