<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>
	<table class="table">
		<tbody>

			<tr>
				<th>게시물 번호</th>
				<td>${bvo.bno}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${bvo.title}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${bvo.writer}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>${bvo.registerData}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${bvo.content}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${bvo.read_count}</td>
			</tr>

		</tbody>
	</table>

	<a href="/board/modify?bno=${bvo.bno }"><button type="button"
			class="btn btn-outline-success">수정</button></a>



	<a href="/board/delete?bno=${bvo.bno }"><button type="button"
			class="btn btn-outline-success">삭제</button></a>
	<br>
	<br>

	<div>
		<!-- 댓글 작성 라인-->
		<div>
			<span id="cmtWriter">${ses.id }</span> <input type="text"
				id="cmtText" placeholder="add comment">

			<button type="button" id="cmtPostBtn" class="btn btn-outline-success">댓글등록</button>

		</div>

		<!-- 댓글 표시 라인 -->
		<div>

			<ul id="cmtlistArea">
				<li>
					<div>
						<div>Writer</div>
						Content
					</div> <span>reg_date</span>
				</li>
			</ul>
		</div>
	</div>
	<script type="text/javascript">
	
	const cnowriter = `<c:out value="${ses.id}"/>`;
	console.log(cnowriter);
	
	</script>

	<script type="text/javascript">
		const bnoVal = `<c:out value="${bvo.bno}"/>`;
		
		console.log(bnoVal);
	
	</script>
<script src="/resources/js/boardComment.js"></script>
	
	<script>
	getCommentList(bnoVal);
	</script>
	<jsp:include page="../layout/footer.jsp"></jsp:include>
	
	
</body>


</html>