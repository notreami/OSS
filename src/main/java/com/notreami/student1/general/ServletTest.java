package com.notreami.student1.general;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhaobo04 on 15/11/30.
 */
public class ServletTest extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("ServletTest 初始化");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("username=" + config.getInitParameter("username"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletTest doGet");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletTest doPost");

        String keyword = req.getParameter("keyword");
        System.out.println("读取的数据:" + keyword);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.append("ServletTest");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("ServletTest 结束");
    }
}
