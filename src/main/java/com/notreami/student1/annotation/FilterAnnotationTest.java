package com.notreami.student1.annotation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by notreami on 15/12/23.
 */
@WebFilter(filterName = "FilterAnnotationTest", urlPatterns = ("/servletAnnotationTest"),
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

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("FilterAnnotationTest 结束");
    }
}
