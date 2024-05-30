<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Article Management Application</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 80%;
            margin: auto;
        }
        header {
            background: #f4f4f4;
            padding: 10px 0;
            text-align: center;
        }
        nav ul {
            padding: 0;
            list-style: none;
            background: #333;
        }
        nav ul li {
            display: inline;
            margin: 0;
        }
        nav ul li a {
            text-decoration: none;
            color: white;
            padding: 10px 20px;
            display: inline-block;
        }
        nav ul li a:hover {
            background: #444;
        }
        section {
            margin: 20px 0;
        }
        .search-form {
            text-align: center;
            margin: 20px 0;
        }
    </style>
</head>
<body>
<div class="container">
    <header>
        <h1>Article Management Application</h1>
    </header>
    <nav>
        <ul>
            <li><a href="category">Categories</a></li>
            <li><a href="addArticle.jsp">Add Article</a></li>
            <li><a href="profile?username=user1">User Profile</a></li>
        </ul>
    </nav>
    <section>
        <div class="search-form">
            <form action="search" method="get">
                <input type="text" name="query" placeholder="Search articles..."/>
                <input type="submit" value="Search"/>
            </form>
        </div>
    </section>
</div>
</body>
</html>
