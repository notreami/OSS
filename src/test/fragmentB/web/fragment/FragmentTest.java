package fragmentB.web.fragment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by notreami on 15/12/29.
 */
@WebServlet(urlPatterns = {"/fragmentTest"}, asyncSupported = false, loadOnStartup = 1, name = "fragmentTest", displayName = "描述")
public class FragmentTest  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FragmentTest doGet");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FragmentTest doPost");

        req.getRequestDispatcher("fragmentB.jsp").forward(req, resp);
    }
}
