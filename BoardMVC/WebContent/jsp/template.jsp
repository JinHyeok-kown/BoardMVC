<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stlyesheet" href="common.css">
<link rel="stlyesheet" href="${content}.css">
</head>
<body>
	
	<jsp:include page="top.jsp"/> 
	<jsp:include page="${content}.jsp"/>
	<jsp:include page="bottom.jsp"/>	
</body>
</html>