<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="me.wuxun.weitter.data.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${user.name}" /></title>

<link href="<c:out value="${pageContext.request.contextPath}"/>/css/bootstrap.min.css"
    rel="stylesheet">
<link href="<c:out value="${pageContext.request.contextPath}"/>/css/userHomePage.css"
    rel="stylesheet">

</head>

<body>
    <div class="container">
        <div class="user-info" style="float: left">
            <div class="headpic">
                <c:choose>
                    <c:when test="${user.avatar != null && user.avatar != \"\"}">
                        <img class="headimg" alt="header"
                            src="${pageContext.request.contextPath}/avatar/${user.avatar}">
                    </c:when>
                    <c:otherwise>
                        <img class="avatar" alt="header"
                            src="${pageContext.request.contextPath}/img/default_head.jpg">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="user-info-name">${user.name}</div>
            <ul class="user-detail">
                <li><a> <strong node-type="follow">265</strong> <span class="head-text">关注</span>
                </a></li>
                <li><a> <strong node-type="follow">365</strong> <span class="head-text">粉丝</span></a></li>
                <li><a> <strong node-type="follow">565</strong> <span class="head-text">微博</span></a></li>
            </ul>
        </div>

        <div class="timeline">
            <div class="input_area">
                <textarea class="input" id="weitter"></textarea>
                <button class="btn btn-lg btn-primary send_btn" type="button"
                    onclick="submitWeitter()">发送</button>
            </div>
            <br /> <br /> <a href="${pageContext.request.contextPath}/recommend">推荐</a> <br />
            <c:forEach var="weitter" items="${weitters}">
                <div class="weitter_item">
                    <div class="avatar_block">
                        <c:choose>
                            <c:when
                                test="${weitter.user.avatar != null && weitter.user.avatar != \"\"}">
                                <img class="avatar" alt="header"
                                    src="${pageContext.request.contextPath}/avatar/${weitter.user.avatar}">
                            </c:when>
                            <c:otherwise>
                                <img class="avatar" alt="header"
                                    src="${pageContext.request.contextPath}/img/default_head.jpg">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="weitter_detail">
                        <div class="weitter_username">
                            <c:out value="${weitter.user.name}"></c:out>
                        </div>
                        <div class="weitter_timestamp">
                            <fmt:formatDate value="${weitter.timestamp}" pattern="MM-dd  HH:mm:ss" />
                        </div>
                        <div class="weitter_content">
                            <c:out value="${weitter.content}"></c:out>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>

<script type="text/javascript"
    src="<c:out value="${pageContext.request.contextPath}"/>/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript"
    src="<c:out value="${pageContext.request.contextPath}"/>/js/bootstrap.min.js"></script>
<script type="text/javascript"
    src="<c:out value="${pageContext.request.contextPath}"/>/js/userHomePage.js"></script>

</html>