<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="me.wuxun.weitter.data.*" %>
<%@ page import="java.util.List" %>
    
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

<a href="<%=request.getContextPath() %>/recommend">推荐</a> <br />

<%
List<Weitter> weitters = (List<Weitter>)request.getAttribute("weitters");
for(Weitter weitter : weitters) {
	out.println(weitter);
}
%>

</body>

<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/userHomepage.js"></script>

</html>