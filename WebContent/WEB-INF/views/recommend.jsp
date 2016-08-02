<%@page import="java.util.ListIterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="me.wuxun.weitter.data.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>推荐</title>
</head>
<body>

<% List<User> userList = (List<User>)request.getAttribute("userList"); %>
<% ListIterator<User> ite = userList.listIterator(); %>

<% while(ite.hasNext()) { %>
    <% User user = ite.next(); %>
       <div><%=user.getName() %></div><button userId=<%=user.getId() %> onclick="follow(this)">关注</button><br />
<% } %>
</body>

<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/recommend.js"></script>

</html>