package wiki.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CategoryDAO {
    private static final String CATEGORY_FILE_PATH = "path/to/categories.json";

    public static JSONArray getAllCategories() {
        try (FileReader reader = new FileReader(CATEGORY_FILE_PATH)) {
            char[] buffer = new char[(int) new File(CATEGORY_FILE_PATH).length()];
            reader.read(buffer);
            String content = new String(buffer);
            return new JSONArray(content);
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }
}

