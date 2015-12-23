package com.notreami.student1.annotation;

import com.notreami.student1.AsyncListenerTest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by notreami on 15/12/23.
 */
@WebFilter(filterName = "FilterAnnotationTest", urlPatterns = ("/servletAnnotationTest"),asyncSupported = true,
        initParams = {@WebInitParam(name = "encoding", value = "GBK")})
public class FilterAnnotationTest implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterAnnotationTest 初始化");
        System.out.println("encoding="+filterConfig.getInitParameter("encoding"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("FilterAnnotationTest拦截 URL=" + request.getRequestURL());
        System.out.print("请求参数=");
        for (Enumeration e = request.getParameterNames(); e.hasMoreElements(); ) {
            String param = e.nextElement().toString();
            String value = servletRequest.getParameter(param);
            System.out.print(param + ":" + value + "  ");
        }
        System.out.println("");

        servletResponse.setContentType("text/html;charset=UTF-8");
        PrintWriter out = servletResponse.getWriter();
        out.println("ServletAnnotationTest</br>");
        out.println("进入Servlet的时间：" + new Date() + ".</br>");
        out.flush();

        //在子线程中执行业务调用，并由其负责输出响应，主线程退出
        AsyncContext ctx = servletRequest.startAsync();
        ctx.addListener(new AsyncListenerTest());
        ctx.setTimeout(10000);
        new Thread(new ExecutorWait(ctx)).start();

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("FilterAnnotationTest 结束");
    }
}
