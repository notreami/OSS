package com.notreami.student1;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by zhaobo04 on 15/11/30.
 */
public class FilterTest  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        System.out.println("拦截 URL="+request.getRequestURL());
        System.out.print("请求参数=");
        for (Enumeration e = request.getParameterNames() ; e.hasMoreElements() ;) {
            String param=e.nextElement().toString();
            String value=servletRequest.getParameter(param);
            System.out.print(param+":"+value+"  ");
        }
        System.out.println("");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Filter 结束");
    }
}
