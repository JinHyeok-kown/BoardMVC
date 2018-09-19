<%@page import="kr.itedu.boardmvc.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>

<% ArrayList<BoardVO> result = (ArrayList<BoardVO>) 
   	  request.getAttribute("data");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="jsp/css/common.css" >
<link rel="stylesheet" type="text/css" href="jsp/css/boardList.css" >

<%@ page errorPage="errorpage.jsp" %>
<title>Insert title here</title>
</head>
<body>
 	
	<div class="container">
	
	<h1>게시판</h1>
	<%if(result.size()>0) { %>
		<table>	
		<thead>
			<tr>
				<th>번호</th>
				<th class="a">제목</th>
				<th>등록일시</th>
			</tr>
		</thead>
	<tbody>
	
	<% for(BoardVO vo: result) { 
	%>
	<tr>
		
		<td><%=vo.getBid() %></td>
		<td><a href="boardDetail?bid=<%=vo.getBid() %>"><%=vo.getBtitle() %></a></td>
		<td><%=vo.getBregdate() %></td>
	</tr>
	<% } 
	} else {
	%>
	게시글이 없습니다.
	<% } %>
	</tbody>

</table><br>
<button onclick="location.href='boardRegMod?bid=0'">글쓰기
	
	</button>
</div>

</body>
</html>