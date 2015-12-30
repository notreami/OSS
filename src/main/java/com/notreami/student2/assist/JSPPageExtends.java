package com.notreami.student2.assist;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * Created by notreami on 15/12/30.
 */
public abstract class JSPPageExtends extends HttpServlet {
    public String show() {
        return this.getClass().getCanonicalName();
    }

}
