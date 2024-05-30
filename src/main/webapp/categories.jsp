<%@ page import="org.json.JSONArray, org.json.JSONObject" %>
<html>
<head><title>Categories</title></head>
<body>
<h2>Categories</h2>
<%
    JSONArray categories = (JSONArray) request.getAttribute("categories");
    for (int i = 0; i < categories.length(); i++) {
        JSONObject category = categories.getJSONObject(i);
%>
<li><a href="search?category=<%= category.getString("name") %>"><%= category.getString("name") %></a></li>
<%
    }
%>
</body>
</html>
