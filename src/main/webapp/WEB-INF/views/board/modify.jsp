<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>
<form action="/board/modify" method="post"><br>
<table class="table">
<tbody>

<tr > 
    <th>게시물 번호</th>
    <td><input type="text" name="bno" value="${bvo.bno}" readonly="readonly" ></td>
   </tr>
   <tr>
    <th>제목</th>
    <td><input type="text" name="title" value="${bvo.title}"></td>
   </tr>
   <tr>
    <th>작성자</th>
    <td>${bvo.writer}</td>
    </tr>

    <tr>
    <th>내용</th>
    <td><textarea rows="5" cols="50" name="content">${bvo.content}</textarea></td>
    
    </tr>
        <tr>
   
     <th>등록일</th>
    <td>${bvo.registerData}</td>
    </tr>


</tbody>
</table>
<button type="submit" class="btn btn-outline-success">수정완료하기</button><br>

</form>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>
