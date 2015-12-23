package com.notreami.student1.annotation;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by notreami on 15/12/23.
 */
@WebListener("This is only a demo listener")
public class ServletContextAnnotationListener implements ServletContextListener {
    /**
     * 当Servlet 容器启动Web 应用时调用该方法。在调用完该方法之后，容器再对Filter 初始化，
     * 并且对那些在Web 应用启动时就需要被初始化的Servlet 进行初始化。
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("当Servlet 容器启动Web 应用时调用该方法。在调用完该方法之后，容器再对Filter 初始化，并且对那些在Web 应用启动时就需要被初始化的Servlet 进行初始化。");
        System.out.println("namespace="+sce.getServletContext().getInitParameter("namespace"));
    }

    /**
     * 当Servlet 容器终止Web 应用时调用该方法。在调用该方法之前，容器会先销毁所有的Servlet 和Filter 过滤器。
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("当Servlet 容器终止Web 应用时调用该方法。在调用该方法之前，容器会先销毁所有的Servlet 和Filter 过滤器。");
    }
}
