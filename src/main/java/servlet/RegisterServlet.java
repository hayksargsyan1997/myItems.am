package servlet;

import manager.UserManager;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private final UserManager userManager=new UserManager();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String name=request.getParameter("name");
         String surname=request.getParameter("surname");
         String email=request.getParameter("email");
         String password=request.getParameter("password");

         userManager.register(User.builder()
                 .name(name)
                 .surname(surname)
                 .email(email)
                 .password(password)
                 .build());

         response.sendRedirect("/home.jsp");

    }
}
