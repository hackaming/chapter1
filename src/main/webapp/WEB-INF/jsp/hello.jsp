<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello</title>
</head>
<body>
	<h1>当前时间</h1>
	<h2>${currentTime}</h2>
	<h3>
		<%
			String curr = (String)request.getAttribute("currentTime");
			System.out.println("Currenttime in request of jsp:"+request.getAttribute("currentTime"));
			System.out.println("Currenttime in variable of jsp:"+curr);
			System.out.println(request.getAttribute("aa"));
			System.out.println("Why there is no output?");
		%>
		<%=curr%>
	</h3>
</body>
</html>