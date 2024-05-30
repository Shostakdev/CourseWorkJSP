package wiki.controllers;

import org.json.JSONArray;
import org.json.JSONObject;
import wiki.models.CategoryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONArray categories = CategoryDAO.getAllCategories();

        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/categories.jsp");
        dispatcher.forward(request, response);
    }
}

