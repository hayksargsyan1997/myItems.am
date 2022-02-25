package servlet;

import manager.CategoryManager;
import model.Category;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/adsMod")
public class AdsModServlet extends HttpServlet {
    private final CategoryManager categoryManager = new CategoryManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<Category> allCategories = categoryManager.getAllCategory();
        req.setAttribute("categories", allCategories);

        req.getRequestDispatcher("/WEB-INF/items.jsp").forward(req, resp);

    }
}
