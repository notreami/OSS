package com.notreami.student1;

import javax.servlet.ServletException;
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
@WebServlet("/annotationTest")
public class AnnotationTest extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("AnnotationTestServlet 初始化");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AnnotationTestServlet doGet");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AnnotationTestServlet doPost");

        String keyword = req.getParameter("keyword");
        System.out.println("读取的数据:" + keyword);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.append("test");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("AnnotationTestServlet 结束");
    }
}