package wiki.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArticleDAO {
    private static final String ARTICLE_FILE_PATH = "articles.json";

    public static JSONArray search(String query, String category) {
        JSONArray allArticles = readArticlesFromFile();
        JSONArray result = new JSONArray();

        for (int i = 0; i < allArticles.length(); i++) {
            JSONObject article = allArticles.getJSONObject(i);
            boolean matchesQuery = query == null || article.getString("title").contains(query);
            boolean matchesCategory = category == null || article.getString("category").equalsIgnoreCase(category);

            if (matchesQuery && matchesCategory) {
                result.put(article);
            }
        }
        return result;
    }

    public static JSONArray readArticlesFromFile() {
        try (FileReader reader = new FileReader(ARTICLE_FILE_PATH)) {
            char[] buffer = new char[(int) new File(ARTICLE_FILE_PATH).length()];
            reader.read(buffer);
            String content = new String(buffer);
            return new JSONArray(content);
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    public static void writeArticlesToFile(JSONArray articles) {
        try (FileWriter writer = new FileWriter(ARTICLE_FILE_PATH)) {
            writer.write(articles.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

