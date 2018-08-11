<%@ page import="sda.java6.twitter.dto.TweetDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: michalr
  Date: 2018-04-21
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweet list page</title>
    <!-- Latest compiled and minified CSS -->
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
            <li class="active"><a href="/tweets">List of tweets</a></li>
            <li><a href="/addTweet">Tweet Add</a></li>
            <li><a href="/tweet/search">Tweet Search</a></li>
            <li><a href="#">Page 3</a></li>
        </ul>
    </div>
</nav>
<div class="container-fluid">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Tweet Id</th>
            <th>Tweet title</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% for (TweetDto tweetDto : (List<TweetDto>) request.getAttribute("tweetsModel")) {
            out.print("<tr>");
            out.print("<td>"+tweetDto.getId()+"</td>");
            out.print("<td>"+tweetDto.getTitle()+"</td>");
            out.print("<td><a href=\"/tweet?tweetId=" + tweetDto.getId() + "\">Edit tweet</a></td>");
            out.print("<td><a href=\"/deleteTweet?tweetId=" + tweetDto.getId() + "\">Delete tweet</a></td>");
            out.print("</tr>");
        } %>
        </tbody>
    </table>
</div>
</body>
</html>
