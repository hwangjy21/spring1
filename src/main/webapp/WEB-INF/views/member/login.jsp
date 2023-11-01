<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>
<form action="/member/login" method="post">
id :<input type="text" name="id" placeholder="아이디 입력"><br>
비밀번호<input type="password" name="pw" placeholder="비밀번호 입력"><br>
<button type="submit">로그인</button>

</form>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>