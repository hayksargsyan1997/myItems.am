package filter;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/userHomeServlet")
public class UserFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpSession session = request1.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            ((HttpServletResponse) response).sendRedirect("/home.jsp");
        } else {
            chain.doFilter(request, response);
        }

    }
}
