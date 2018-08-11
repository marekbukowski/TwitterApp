<%@ page import="sda.java6.twitter.dto.TweetDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: michalr
  Date: 2018-04-21
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweet Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Twitter App</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/tweets">List of tweets</a></li>
            <li><a href="#">Page 2</a></li>
            <li><a href="#">Page 3</a></li>
        </ul>
    </div>
</nav>
<h1>Tweet Search Page</h1>
<div class="container-fluid">
    <form class="form-inline" action="/tweet/search">
    <div class="form-group">
        <label for="keyword">Keyword:</label>
        <input type="text" class="form-control" id="keyword" name="keyword" value="${param.keyword}">
    </div>
    <div class="form-group">
        <label for="title">Title:</label>
        <input type="text" class="form-control" id="title" name="title" value="${param.title}">
    </div>
    <div class="form-group">
        <label for="message">Message:</label>
        <input type="text" class="form-control" id="message" name="message" value="${param.message}">
    </div>
    <button type="submit" class="btn btn-default">Search tweets</button>
</form>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Tweet Id</th>
        <th>Tweet title</th>
        <th>Tweet message</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (request.getAttribute("foundTweetsModel")!=null) {
            for (TweetDto tweetDto : (List<TweetDto>) request.getAttribute("foundTweetsModel")) {
                out.print("<tr>");
                out.print("<td>" + tweetDto.getId() + "</td>");
                out.print("<td>" + tweetDto.getTitle() + "</td>");
                out.print("<td>" + tweetDto.getMessage() + "</td>");
                out.print("</tr>");
            }
        }
        %>
    </tbody>
</table>
</div>
</body>
</html>
