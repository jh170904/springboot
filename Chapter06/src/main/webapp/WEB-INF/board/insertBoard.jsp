<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-type">
<title>글 작성</title>
</head>
<body>
<h3>게시글 등록</h3>
<hr>
<form action="insertBoard" method="post">
<table border="1" cellpadding="0" cellspacing="0" style="text-align: center;">
	<tr>
		<td bgcolor="#e3e3e3" width="70">제목</td>
		<td align="left"><input type="text" name="title"/></td>
	</tr>
	<tr>
		<td bgcolor="#e3e3e3" width="70">작성자</td>
		<td align="left"><input type="text" name="writer" size="10"/></td>
	</tr>
	<tr>
		<td bgcolor="#e3e3e3" width="70">내용</td>
		<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
	</tr>
		<tr>
		<td colspan="2" align="center">
			<input type="submit" value="등록하기"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>