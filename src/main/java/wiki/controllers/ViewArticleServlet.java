package wiki.controllers;

import wiki.models.ArticleDAO;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewArticleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int articleId = Integer.parseInt(request.getParameter("id"));
        JSONArray articles = ArticleDAO.readArticlesFromFile();
        JSONObject article = null;

        for (int i = 0; i < articles.length(); i++) {
            JSONObject obj = articles.getJSONObject(i);
            if (obj.getInt("id") == articleId) {
                article = obj;
                break;
            }
        }

        if (article != null) {
            request.setAttribute("article", article);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewArticle.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Article not found");
        }
    }
}

