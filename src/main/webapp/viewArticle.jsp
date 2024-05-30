<% JSONObject article = (JSONObject) request.getAttribute("article"); %>x
<%@ page import="org.json.JSONObject" %>
<html>
<head>
    <title>
        <%= article.getString("title") %>
    </title>
    <style>
        .content { font-size: 14px; }
        .content.large { font-size: 18px; }
    </style>
    <script>
        function enlargeFont() {
            document.getElementById('content').classList.toggle('large');
        }
    </script>
</head>
<body>
<h1>
    <%= article.getString("title") %>
</h1>
<button onclick="enlargeFont()">Enlarge Font</button>
<div id="content" class="content">
    <%= article.getString("content") %>
</div>
</body>
</html>
