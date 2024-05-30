package wiki.models;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ArticleDAOTest {
    private FileWriter fileWriter;
    private ArticleDAO articleDAO;

    @BeforeEach
    void setUp() {
        articleDAO = new ArticleDAO();
    }

    @AfterEach
    void tearDown() {
        File file = new File("articles.json");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSearch() throws IOException {
        String data = "[{\"id\":1,\"title\":\"Sample Article\",\"content\":\"This is a sample article.\",\"category\":\"Tech\",\"tags\":[\"sample\",\"tech\"]}]";
        fileWriter = new FileWriter("articles.json");
        fileWriter.write(data);
        fileWriter.close();

        JSONArray articles = articleDAO.search("Sample", "Tech");

        assertEquals(1, articles.length());
        assertEquals("Sample Article", articles.getJSONObject(0).getString("title"));
    }
}
