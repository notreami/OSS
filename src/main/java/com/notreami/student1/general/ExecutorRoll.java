package com.notreami.student1.general;

import javax.servlet.AsyncContext;
import java.io.PrintWriter;

/**
 * Created by notreami on 15/12/23.
 */
public class ExecutorRoll implements Runnable {
    private AsyncContext ctx = null;

    public ExecutorRoll(AsyncContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void run() {
        try {
            System.out.println("new thread:" + Thread.currentThread());
            PrintWriter writer = ctx.getResponse().getWriter();
            for (int i = 0; i < 10; i++) {
                writer.println("<script>");
                writer.println("document.getElementById('progress').innerHTML = '" + (i * 10) + "% complete'");
                writer.println("</script>");
                writer.flush();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            writer.println("<script>");
            writer.println("document.getElementById('progress').innerHTML='DONE'");
            writer.println("</script>");
            writer.println("</body></html>");
            ctx.complete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
