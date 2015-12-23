package com.notreami.student1;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

/**
 * Created by notreami on 15/12/23.
 */
public class AsyncListenerTest implements AsyncListener {
    //注意：onStartAsync()不会被调用。因为是startAsync()之后才添加的监听对象
    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
        System.out.println("在刚启动一个异步操作时调用这个方法");
    }

    @Override
    public void onComplete(AsyncEvent event) throws IOException {
        System.out.println("当一个异步操作已经完成时调用这个方法");
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
        System.out.println("当一个异步操作失败时调用这个方法");
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
        System.out.println("当一个异步操作已经超时的时候调用这个方法，即当它没能在规定时限内完成的时候。");
    }


}
