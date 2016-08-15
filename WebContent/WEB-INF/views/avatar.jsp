<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>头像上传</title>
<link href="<c:out value="${pageContext.request.contextPath}"/>/css/bootstrap.min.css"
    rel="stylesheet">
<link href="<c:out value="${pageContext.request.contextPath}"/>/css/cropper.min.css"
    rel="stylesheet">
<link href="<c:out value="${pageContext.request.contextPath}"/>/css/avatar.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="edit-container">
            <div class="edit">
                <img id="image" src="">
            </div>
            <div class="preview">
                <img id="preview-img" src="">
            </div>
        </div>
        <div class="controls">
            <label class="btn btn-default" for="inputImage"> 选择图片 <input type="file"
                class="select-img" id="inputImage" name="file" accept="image/*">
            </label>
            <button id="finish" class="btn btn-primary">确定</button>
            <button id="cancel" class="btn btn-warning">取消</button>
        </div>
    </div>
</body>

<script type="text/javascript"
    src="<c:out value="${pageContext.request.contextPath}"/>/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript"
    src="<c:out value="${pageContext.request.contextPath}"/>/js/bootstrap.min.js"></script>
<script type="text/javascript"
    src="<c:out value="${pageContext.request.contextPath}"/>/js/cropper.min.js"></script>
<script type="text/javascript"
    src="<c:out value="${pageContext.request.contextPath}"/>/js/avatar.js"></script>
</html>