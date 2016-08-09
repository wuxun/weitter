<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>weitter</title>
        <link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=request.getContextPath() %>/css/home.css" rel="stylesheet">
	</head>
	<body>
        <div class="container">
            <form class="form-signin" method="post" action="<%=request.getContextPath() %>/login">
                <label for="inputUsername" class="sr-only">用户名</label>
                <input name="username" type="text" id="inputUsername" class="form-control" placeholder="用户名" required autofocus>
                <label for="inputPassword" class="sr-only">密码</label>
                <input name="password" type="password" id="inputPassword" class="form-control" placeholder="密码" required>
                <div>
                <button class="btn btn-lg btn-primary home-submit" type="submit">登录</button>
                <a class="btn btn-lg btn-warning home-register" href="<%=request.getContextPath() %>/register">注册</a>
                </div>
            </form>
        </div>
        <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.1.0.min.js"></script>
        <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
    </body>
</html>