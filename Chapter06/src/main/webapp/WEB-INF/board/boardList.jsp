<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-type">
<title>글 목록</title>
</head>
<body>
<h1>게시글 목록</h1>
<table style="text-align: center;">
	<tr>
		<th bgcolor="#e3e3e3" width="100">번호</th>
		<th bgcolor="#e3e3e3" width="100">제목</th>
		<th bgcolor="#e3e3e3" width="100">작성자</th>
		<th bgcolor="#e3e3e3" width="100">등록일</th>
		<th bgcolor="#e3e3e3" width="100">조회수</th>
	</tr>
	<c:forEach var="vo" items="${boardList }">
	<tr>
		<td>${vo.seq}</td>
		<td align="left"><a href="getBoard?seq=${vo.seq}">${vo.title}</a></td>
		<td>${vo.writer}</td>
		<td><fmt:formatDate value="${vo.createDate}" pattern="yyyy-MM-dd"/></td>
		<td>${vo.cnt}</td>
	</tr>
	</c:forEach>
</table>
<a href="/insertBoard">새글 등록</a>
</body>
</html>