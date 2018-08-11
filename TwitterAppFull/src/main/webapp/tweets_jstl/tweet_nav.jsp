<%--
  Created by IntelliJ IDEA.
  User: michalr
  Date: 2018-05-05
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Twitter App</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/tweets">List of tweets</a></li>
            <li><a href="/addTweet">Tweet Add</a></li>
            <li><a href="/tweet/search">Tweet Search</a></li>
            <li><a href="/login">Login</a></li>
            <c:if test="${not empty sessionScope.email}">
                <li><a href="/logout">Logout</a> </li>
                <li><a>Hello ${sessionScope.email}</a></li>
            </c:if>
            <li><a href="/language?lang=pl">Polish</a></li>
            <li><a href="/language?lang=en">English</a></li>
            <c:if test="${not empty cookie.lang}">
                <li>Chosen language ${cookie.lang.value}</li>
            </c:if>
        </ul>
    </div>
</nav>
