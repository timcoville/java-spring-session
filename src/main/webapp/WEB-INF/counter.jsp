<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Counter</title>
</head>
<body>
	<% Integer count = (Integer) session.getAttribute("count"); %>
	<h2>You have visited Counter Index <c:out value="${count}"/> times.</h2>
	<h5><a href="/">Test another visit...</a></h5>
	<h6><a href="/clear">Clear Count</a></h6>
</body>
</html>