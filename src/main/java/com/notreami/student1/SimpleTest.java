package com.notreami.student1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhaobo04 on 15/11/30.
 */
public class SimpleTest extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet 初始化");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet doGet");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet doPost");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Servlet 结束");
    }
}
