package fragmentA.web.fragment;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by notreami on 15/12/28.
 */
public class ServletRequestListenerTest implements ServletRequestListener, ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent arg0) {
        System.out.println("Request范围中的属性:" + arg0.getName() + " 被添加,数值为:" + arg0.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent arg0) {
        System.out.println("Request范围中的属性:" + arg0.getName() + " 被删除,数值为:" + arg0.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent arg0) {
        System.out.println("Request范围中的属性:" + arg0.getName() + " 数值更新为:" + arg0.getValue());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent arg0) {
        HttpServletRequest request = (HttpServletRequest)arg0.getServletRequest();
        System.out.println("请求即将结束"  );
    }

    @Override
    public void requestInitialized(ServletRequestEvent arg0) {
        HttpServletRequest request = (HttpServletRequest)arg0.getServletRequest();
        System.out.println("请求即将开始,请求来自" + request.getHeader("Referer") + "发向" + request.getRequestURI());
    }
}
