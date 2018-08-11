<%@ page import="sda.java6.twitter.dto.TweetDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: michalr
  Date: 2018-04-21
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
<c:import url="/tweets_jstl/tweet_nav.jsp">
    <c:param name="activeTab">tweet edit</c:param>
</c:import>
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
        <!-- JSTL PAGE -->
        <tbody>
            <c:forEach items="${tweetsModel}" var="tweet">
                <tr>
                    <td>${tweet.id}</td>
                    <td>${tweet.title}</td>
                    <td><a href="/tweet?tweetId=${tweet.id}">Edit tweet</a></td>
                    <td><a href="/deleteTweet?tweetId=${tweet.id}">Delete tweet</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
