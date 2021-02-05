<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 프로그램</title>
</head>
<body>
	<form action="JoinServlet" method="post" name="joinform">
		이름: <input type="text" name="name" size="10" value="${member.name }"/><br/>
		아이디: <input type="text" name="id" size="10" /><span style="color:red">${msg }</span><br/>
		비밀번호: <input type="password" name="pw" size="10"/><span style="color:red">${msg }</span><br/>
		전화번호: 
			<select name="phone1">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
			</select>
		- <input type="text" name="phone2" size="4" value="${member.phone2 }"/>
		- <input type="text" name="phone3" size="4"value="${member.phone3 }"/><br/>
		성별: <input type="radio" name="gender" value="men" value=""/>남
			 <input type="radio" name="gender" value="women"/>여<br/>
		<input type="submit" value="회원가입"/>
	</form>
</body>
</html>