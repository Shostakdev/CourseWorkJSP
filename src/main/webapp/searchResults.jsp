<%@ page import="org.json.JSONArray, org.json.JSONObject" %>
<html>
<head><title>Search Results</title></head>
<body>
<h2>Search Results</h2>
<%
    JSONArray articles = (JSONArray) request.getAttribute("articles");
    for (int i = 0; i < articles.length(); i++) {
        JSONObject article = articles.getJSONObject(i);
%>
<div>
    <h3><a href="viewArticle?id=<%= article.getInt("id") %>"><%= article.getString("title") %></a></h3>
</div>
<%
    }
%>
</body>
</html>
