package com.notreami.student1.general;

import com.notreami.student1.AsyncListenerTest;
import com.notreami.student1.annotation.ExecutorWait;

import javax.servlet.AsyncContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Async Servlet</title></head>");
        out.println("<body><div id='progress'></div>");
        //在子线程中执行业务调用，并由其负责输出响应，主线程退出
        final AsyncContext ctx = req.startAsync() ;
        ctx.addListener(new AsyncListenerTest());
        ctx.setTimeout(60000);
        new Thread(new ExecutorRoll(ctx)).start();
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("ServletTest 结束");
    }
}
