<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>
<form action="/member/modify" method="post">
<input type="hidden" name="id" value="${ses.id}">
<table class="table">
<tbody>

<tr > 

    <th>ID</th>
    <td>${ses.id }</td>
   </tr>
   <tr>
    <th>password</th>
    <td><input type="text" name="pw"  placeholder="변경할 패스워드"></td>
   </tr>
   
     <tr>
    <th>name</th>
    <td><input type="text" name="name" value="${ses.name}"></td>
    </tr>
   <tr>
    <th>email</th>
    <td><input type="text" name="email" value="${ses.email}"></td>
    </tr>
  <tr>
    <th>home</th>
    <td><input type="text" name="home" value="${ses.home}"></td>
    </tr>
        <tr>
   
     <th>등록일</th>
    <td>${bvo.registerData}</td>
    </tr>


</tbody>
</table>

<button type="submit">수정완료하기</button>

</form>

<a href="/">index</a>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>