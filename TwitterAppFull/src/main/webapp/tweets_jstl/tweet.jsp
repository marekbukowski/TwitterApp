<%@ page import="sda.java6.twitter.dto.TweetDto" %><%--
  Created by IntelliJ IDEA.
  User: michalr
  Date: 2018-04-21
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
<c:import url="/tweets_jstl/tweet_nav.jsp"></c:import>
<c:choose>
    <c:when test="${not empty tweet and not tweet.isNew()}">
        <h1>Tweet Edit Page</h1>
    </c:when>
    <c:otherwise>
        <h1>Tweet Add Page</h1>
    </c:otherwise>
</c:choose>

<!-- TWEET JSTL -->

<c:choose>
    <c:when test="${not empty errorMsg}">
        <div>${errorMsg}</div>
    </c:when>
    <c:otherwise>
        <form action="/saveTweet" method="post">
            <c:if test="${not empty tweet and tweet.id!=0}">
                <div class="form-group">
                    Tweet id: ${tweet.id}
                </div>
            </c:if>
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
    </c:otherwise>
</c:choose>


</body>
</html>
