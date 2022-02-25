package servlet;

import manager.CategoryManager;
import manager.ItemManager;
import model.Category;
import model.Item;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/AdsServlet")
@MultipartConfig()
public class AdsServlet extends HttpServlet {
    private final String UPLOAD_DIR = "C:\\Users\\Hayk\\IdeaProjects\\myItems.am\\upload";
    private final ItemManager itemManager = new ItemManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        double price = Double.parseDouble(req.getParameter("price"));
        int categoryId = Integer.parseInt(req.getParameter("category_id"));
        int userId = Integer.parseInt(req.getParameter("user_id"));

        Item item = Item.builder()
                .title(title)
                .price(price)
                .categoryId(categoryId)
                .userId(userId)
                .build();
        for (Part part : req.getParts()) {
            if (getFileName(part) != null) {
                String fileName = System.currentTimeMillis() + getFileName(part);
                String fullFileName = UPLOAD_DIR + File.separator + fileName;
                part.write(fullFileName);
                item.setPicUrl(fileName);
            }
        }
        itemManager.create(item);

        resp.sendRedirect("/userHomeServlet");
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return null;
    }
}
