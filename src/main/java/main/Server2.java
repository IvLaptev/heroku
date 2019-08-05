package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInServlet;
import servlets.SignUpServlet;
import user.AccountService;

public class Server2 {
    public static AccountService users;

    public static void main(String[] args) throws Exception {
        users = new AccountService();
        SignInServlet signInServlet = new SignInServlet();
        SignUpServlet signUpServlet = new SignUpServlet();

        ServletContextHandler handler = new ServletContextHandler(
                ServletContextHandler.SESSIONS
        );
        handler.addServlet(new ServletHolder(signInServlet), "/signin");
        handler.addServlet(new ServletHolder(signUpServlet), "/signup");

        Server server = new Server(8080);
        server.setHandler(handler);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
