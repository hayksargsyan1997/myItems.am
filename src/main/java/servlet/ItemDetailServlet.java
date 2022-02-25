package servlet;

import manager.ItemManager;
import model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/itemDetail")
public class ItemDetailServlet extends HttpServlet {


    private ItemManager itemManager = new ItemManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String general = req.getParameter("Գլխավոր");
        String car = req.getParameter("Ավտոմեքենաներ");
        String house = req.getParameter("Տներ");
        String commercial = req.getParameter("Կոմերցիոն");
        String furniture = req.getParameter("Կահույք");

        if (car != null) {

            List<Item> cars = itemManager.getAllCars();
            req.setAttribute("cars", cars);
            req.getRequestDispatcher("/WEB-INF/allCars.jsp").forward(req, resp);

        } else if (house != null) {

            List<Item> houses = itemManager.getAllHouses();
            req.setAttribute("houses", houses);
            req.getRequestDispatcher("/WEB-INF/allHouses.jsp").forward(req, resp);

        } else if (commercial != null) {

            List<Item> commercials = itemManager.getAllCommercial();
            req.setAttribute("allCommercial", commercials);
            req.getRequestDispatcher("/WEB-INF/allCommercial.jsp").forward(req, resp);

        } else if (furniture != null) {

            List<Item> furnitureS = itemManager.getAllFurniture();
            req.setAttribute("allFurniture", furnitureS);
            req.getRequestDispatcher("/WEB-INF/allFurniture.jsp").forward(req, resp);

        } else if (general != null) {

            resp.sendRedirect("/");

        }
    }
}

