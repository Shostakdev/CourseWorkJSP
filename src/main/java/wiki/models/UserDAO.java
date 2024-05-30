package wiki.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UserDAO {
    private static final String USER_FILE_PATH = "path/to/users.json";

    public static JSONObject getUser(String username) {
        try (FileReader reader = new FileReader(USER_FILE_PATH)) {
            char[] buffer = new char[(int) new File(USER_FILE_PATH).length()];
            reader.read(buffer);
            String content = new String(buffer);
            JSONArray users = new JSONArray(content);

            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);
                if (user.getString("username").equals(username)) {
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
