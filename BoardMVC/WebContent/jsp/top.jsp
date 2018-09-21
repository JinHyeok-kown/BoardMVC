<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String title = (String) request.getAttribute("title");
%>
<link rel="stylesheet" href="./css/top.css">
<div class="container">
	<header>
		<h1>게시판</h1>
	</header>
	<nav>
		<ul class="outer">
			<li>이미지</li>
			<li class = "innerli">메뉴
				<ul class = "inner">
					<li>공지</li>
					<li>자유</li>
					<li>유머</li>
				</ul>
			</li>
		</ul>
 
	</nav>
</div>
