package com.notreami.student1.annotation;

import javax.servlet.AsyncContext;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by notreami on 15/12/23.
 */
public class ExecutorWait implements Runnable {
    private AsyncContext ctx = null;
    public ExecutorWait(AsyncContext ctx){
        this.ctx = ctx;
    }

    public void run(){
        try {
            //等待十秒钟，以模拟业务方法的执行
            Thread.sleep(5000);
            PrintWriter out = ctx.getResponse().getWriter();
            out.println("业务处理完毕的时间：" + new Date() + ".</br>");
            out.flush();
            ctx.complete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
