<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="me.wuxun.weitter.data.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserHomepage</title>
</head>
<body>

<%
User user = (User)request.getAttribute("user");
//out.println("" + user.toString());
%>

<br />

<textarea id="weitter" rows="5" cols="50"></textarea> <br />
<button type="button" onclick="submitWeitter()">发送</button> <br />

</body>

<script type="text/javascript" src="<%=request.getContextPath() %>/js/userHomepage.js"></script>

</html>