
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="./layout/header.jsp"></jsp:include>
<h1>
	Hello world!  
</h1>

<P>My Spring Project </P>

<c:if test="${ses.id ne null }">

${ses.id }(${ses.email }) login 하였습니다.<br>


</c:if>


<script type="text/javascript">
const msg_login = `<c:out value="${msg_login}" />`;
const msg_logout = `<c:out value="${msg_logout}" />`;

const msg_modify = `<c:out value="${msg_modify}" />`;
if(msg_login==1){

	alert("로그인 실패");
}

if(msg_modify==2){
	alert("수정되었습니다.");
}

if(msg_logout==1){
	alert("로그아웃되었습니다.");
}


</script>
<jsp:include page="./layout/footer.jsp"></jsp:include>