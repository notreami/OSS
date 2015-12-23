package com.notreami.student1.general;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by notreami on 15/12/20.
 */
public class SessionListener implements HttpSessionListener {

    //当session被创建时执行这个方法
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("当session被创建时执行这个方法="+se.getSession().getId());
    }

    //当session被销毁时执行这个方法
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("当session被销毁时执行这个方法="+se.getSession().getId());
    }
}
