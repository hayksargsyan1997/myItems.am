package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/RegisterMedServlet")
public class RegisterMedServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);

    }
}
