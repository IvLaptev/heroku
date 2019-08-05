package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static main.Server2.users;

public class SignInServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException {
        if(users.logIn(request.getParameter("login"),
                request.getParameter("password"))) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("Authorized: "+
                    request.getParameter("login"));
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("Unauthorized");
        }
    }
}
