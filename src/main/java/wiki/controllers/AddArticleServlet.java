package wiki.controllers;

import wiki.models.ArticleDAO;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String tags = request.getParameter("tags");

        JSONObject newArticle = new JSONObject();
        newArticle.put("id", generateNewId());
        newArticle.put("title", title);
        newArticle.put("content", content);
        newArticle.put("tags", tags);

        JSONArray articles = ArticleDAO.readArticlesFromFile();
        articles.put(newArticle);
        ArticleDAO.writeArticlesToFile(articles);

        response.sendRedirect("viewArticle?id=" + newArticle.getInt("id"));
    }

    private int generateNewId() {
        JSONArray articles = ArticleDAO.readArticlesFromFile();
        int maxId = 0;
        for (int i = 0; i < articles.length(); i++) {
            int id = articles.getJSONObject(i).getInt("id");
            if (id > maxId) {
                maxId = id;
            }
        }
        return maxId + 1;
    }
}
