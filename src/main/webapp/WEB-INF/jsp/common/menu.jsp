<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/14
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/meta.jsp" %>
<%@include file="/WEB-INF/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html class="menu">
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content=="IE=edge"/>
    <meta name="google" value="notranslate"/>
</head>
<body>

</div>
<nav class="main-menu">

    <div class="logo"></div>
    <div class="settings"></div>
    <ul>
        <li>
            <a href="http://startific.com">
                <i class="fa fa-home fa-lg"></i>
                <span class="nav-text">Home</span>
            </a>
        </li>
        <li class="has-subnav">
            <a href="${baseUrl}login/menuPage">
                <i class="fa fa-clock-o fa-lg"></i>
                           <span class="nav-text">
                            News
                        </span>
            </a>
        </li>
        <li>
            <a href="${baseUrl}login/welcome">
                <i class="fa fa-desktop fa-lg"></i>
                        <span class="nav-text">
                            Technology
                        </span>
            </a>
        </li>
        <li class="has-subnav">
            <a href="${baseUrl}activeMQ/welcome">
                <i class="fa fa-plane fa-lg"></i>
                        <span class="nav-text">
                            Active.MQ
                        </span>
            </a>
        </li>

        <li>
            <a href="#">
                <i class="fa fa-shopping-cart"></i>
                        <span class="nav-text">
                            Shopping
                        </span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class="fa fa-microphone fa-lg"></i>
                        <span class="nav-text">
                            Film & Music
                        </span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class="fa fa-flask fa-lg"></i>
                        <span class="nav-text">
                            Web Tools
                        </span>
            </a>
        </li>

        <li>
            <a href="#">
                <i class="fa fa-picture-o fa-lg"></i>
                        <span class="nav-text">
                            Art & Design
                        </span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class="fa fa-align-left fa-lg"></i>
                        <span class="nav-text">
                            Magazines
                        </span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class="fa fa-gamepad fa-lg"></i>
                        <span class="nav-text">
                            Games
                        </span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class="fa fa-glass fa-lg"></i>
                        <span class="nav-text">
                            Life & Style
                        </span>
            </a>
        </li>
        <li class="has-subnav">
            <a href="#">
                <i class="fa fa-rocket fa-lg"></i>
                        <span class="nav-text">
                            Fun
                        </span>
            </a>

        </li>
    </ul>

    <ul class="logout">
        <li>
            <a href="#">
                <i class="fa fa-lightbulb-o fa-lg"></i>
                        <span class="nav-text">
                            BLOG
                        </span>

            </a>
        </li>
    </ul>
</nav>
<div style="text-align:center;clear:both">
</div>
</body>
</html>


