<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-type">
<title>글 상세</title>
</head>
<body>
<h3>게시글 상세</h3>
<hr>
<form action="updateBoard" method="post">
<input name="seq" type="hidden" value="${board.seq}"> 
<table border="1" cellpadding="0" cellspacing="0" style="text-align: center;">
	<tr>
		<td bgcolor="#e3e3e3" width="70">제목</td>
		<td align="left"><input type="text" name="title" value="${board.title}"/></td>
	</tr>
	<tr>
		<td bgcolor="#e3e3e3" width="70">작성자</td>
		<td align="left">${board.writer}</td>
	</tr>
	<tr>
		<td bgcolor="#e3e3e3" width="70">내용</td>
		<td align="left"><textarea name="content" cols="40" rows="10">${board.content }</textarea></td>
	</tr>
	<tr>
		<td bgcolor="#e3e3e3" width="70">등록일</td>
		<td align="left"><fmt:formatDate value="${board.createDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
	</tr>
		<tr>
		<td bgcolor="#e3e3e3" width="70">조회수</td>
		<td align="left">${board.cnt }</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정하기"/>
		</td>
	</tr>
</table>
</form>
<hr>
<a href="insertBoardView">글 등록</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="deleteBoard?seq=${board.seq }">글 삭제</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="getBoardList">리스트</a>&nbsp;&nbsp;&nbsp;&nbsp;
</body>
</html>