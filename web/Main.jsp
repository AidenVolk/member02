<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 프로그램</title>
</head>
<body>
<h1>회원관리 프로그램</h1>
<h3>${name }님 회원목록</h3>
<a href="logoutServlet">로그아웃</a>
<a href="ModifyServlet">정보수정</a>
<table border="1">
	<tr>
		<th>이름</th><th>연락처</th><th>성별</th><th>수정</th><th>삭제</th>
	</tr>
	<c:forEach items="${members }" var="member">
		<tr>
			<td>${member.name }</td>
			<td>${member.phone1} - ${member.phone2} - ${member.phone3 }</td>
			<td>${member.gender }</td>
			<td><a href="ModifyServlet?id=${member.id }">수정</a></td>
			<td><a href="DeleteServlet?id=${member.id }">삭제</a></td>
		</tr>
	</c:forEach>

</table>	
</body>
</html>