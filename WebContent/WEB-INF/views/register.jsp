<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/register.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        <form class="form-horizontal register-form" method="post"
            action="<%=request.getContextPath()%>/login">
            <div class="form-group">
                <label for="inputUsername" class="col-sm-3 control-label">用户名</label>
                <div class="col-sm-9">
                    <input name="name" type="text" id="inputUsername" class="form-control"
                        placeholder="用户名" required autofocus>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-sm-3 control-label">密码</label>
                <div class="col-sm-9">
                    <input name="password" type="password" id="inputPassword" class="form-control"
                        placeholder="密码" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-10">
                    <button class="btn btn-lg btn-primary" type="submit">注册</button>
                </div>
            </div>
        </form>
    </div>
</body>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.0.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/register.js"></script>

</html>