<% JSONObject user = UserDAO.getUser(request.getParameter("username")); %>
<%@ page import="org.json.JSONArray, org.json.JSONObject" %>
<%@ page import="wiki.models.UserDAO" %>
<html>
<head><title>
    <%= user.getString("username") %>'s Profile
</title></head>
<body>
<h2>
    <%= user.getString("username") %>'s Profile
</h2>
<h3>Browsing History</h3>
<ul>
    <%
        JSONArray history = user.getJSONArray("browsingHistory");
        for (int i = 0; i < history.length(); i++) {
            JSONObject article = history.getJSONObject(i);
    %>
    <li><a href="viewArticle?id=<%= article.getInt("id") %>"><%= article.getString("title") %></a></li>
    <%
        }
    %>
</ul>
<h3>Favorites</h3>
<ul>
    <%
        JSONArray favorites = user.getJSONArray("favorites");
        for (int i = 0; i < favorites.length(); i++) {
            JSONObject article = favorites.getJSONObject(i);
    %>
    <li><a href="viewArticle?id=<%= article.getInt("id") %>"><%= article.getString("title") %></a></li>
    <%
        }
    %>
</ul>
</body>
</html>
