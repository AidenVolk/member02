<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연락처 프로그램</title>
</head>
<body>
	<form action="loginServlet" method="post">
		아이디: <input type="text" name="id"/><span style="color:red">${msg }</span><br/><br/>
		비밀번호: <input type="password" name="pw"/><span style="color:red">${msg }</span><br/><br/>
		<input type="submit" value="로그인">
	</form>
	<a href="JoinServlet">회원가입</a>
</body>
</html>