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
<form action="/member/signup" method="post">
id :<input type="text" name="id" placeholder="아이디"><br>
비밀번호:<input type="password" name="pw" placeholder="비밀번호"><br>
이름:<input type="text" name="name" placeholder="이름"><br>
email:<input type="email" name="email" placeholder="이메일"><br>
home:<input type="text" name="home" placeholder="주소"><br>
이름:<input type="text" name="age" placeholder="나이"><br>
<button type="submit">회원가입</button>

</form>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>