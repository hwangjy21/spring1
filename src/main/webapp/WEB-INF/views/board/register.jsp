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

<h2>게시글 등록</h2>
<!-- mapping 상태는 get/ post가 별도의 mapping을 가짐 -->
<form action="/board/register" method="post" enctype="multipart/form-data"><br>
title : <input type="text" name="title"><br>
writer: <input type="text" name="writer" value="${ses.id }" readonly="readonly"><br>
content: <textarea rows="5" cols="50" name="content"></textarea><br>
file: <input type="file" id="file" name="files" multiple="multiple" style="display:none">
<button type="button" id="trigger"  class="btn btn-outline-success">FileUpload</button><br>
<div id="fileZone"></div>


<button type="submit" class="btn btn-outline-success" id="regBtn">글쓰기 완료</button><br><br>
</form>
<br>

<button type="button" class="btn btn-outline-success" id="home">홈으로 가기</button>

<a href="/board/list">
<button type="button" class="btn btn-outline-success">리스트로 가기</button></a>

<script type="text/javascript">


document.getElementById('home').addEventListener('click', function() {
  
    const confirmation = confirm('홈으로 이동하시겠습니까?');
    
 
    if (confirmation) {
        window.location.href = '/'; // 홈 페이지의 URL을 여기에 입력하세요.
    }
});

</script>
<script src="/resources/js/boardRegister.js"></script>
<jsp:include page="../layout/footer.jsp"></jsp:include>

</body>
</html>