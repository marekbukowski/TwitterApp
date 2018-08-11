<%@ page import="sda.java6.twitter.dto.TweetDto" %><%--
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
<%
    TweetDto tweetDto = (TweetDto) request.getAttribute("tweet");
    if (tweetDto!=null && !tweetDto.isNew()) {
%>
<h1>Tweet Edit Page</h1>
<%
} else {
%>
<h1>Tweet Add Page</h1>
<%
    }
%>
<%
    if (request.getAttribute("errorMsg") != null) {
%>
<div>${errorMsg}</div>
<%
} else {
%>

<form action="/saveTweet" method="post">
    <%
        if (tweetDto!=null && !tweetDto.isNew()) {
    %>
    <div class="form-group">
        Tweet id: ${tweet.id}
    </div>
    <%
        }
    %>
    <div class="form-group">
        <label for="title">Tweet title:</label>
        <input type="text" class="form-control" id="title" name="title" value="${tweet.title}">
    </div>
    <div class="form-group">
        <label for="message">Message:</label>
        <textarea class="form-control" rows="5" id="message" name="message">${tweet.message}</textarea>
    </div>
    <button type="submit" class="btn btn-default">Save tweet</button>
</form>

<%
    }
%>
</body>
</html>
