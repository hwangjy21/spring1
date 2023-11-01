<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>

<!-- 검색 라인 -->
<div class="col-sm-12 col-md-6">
    <form action="/board/list" method="get">
        <div class="input-group mb-3">
            <c:set value="${ph.pgvo.type}" var="typed"></c:set>
            <select name="type">
                <option ${typed == null ? 'selected' : ''}>Choose...</option>
                <option value="t" ${typed eq 't' ? 'selected' : ''}>title</option>
                <option value="w" ${typed eq 'w' ? 'selected' : ''}>writer</option>
                <option value="c" ${typed eq 'c' ? 'selected' : ''}>content</option>
                <option value="tw" ${typed eq 'tw' ? 'selected' : ''}>title+writer</option>
                <option value="tc" ${typed eq 'tc' ? 'selected' : ''}>title+content</option>
                <option value="wc" ${typed eq 'wc' ? 'selected' : ''}>writer+content</option>
                <option value="twc" ${typed eq 'twc' ? 'selected' : ''}>title+writer+content</option>
            </select>
            <input class="form-control" type="text" name="keyword" value="${ph.pgvo.keyword}" placeholder="Search...">
            <input type="hidden" name="qty" value="${ph.pgvo.qty}">
            <button type="submit" class="btn btn-success position-relative">
                search
                <span class="badge text-bg-secondary">${ph.totalCount}</span>
            </button>
        </div>
    </form>
</div>
<table class="table table-hover">
<thead>
<tr>
	<th>#</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>
	<th>댓글 수</th>
	<th>파일 수</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list }" var="bvo">
	<tr>
		<td>${bvo.bno }</td>
		<td><a href="/board/detail?bno=${bvo.bno }">${bvo.title }</a></td>
		<td>${bvo.writer }</td>
		<td>${bvo.registerData }</td>
		<td>${bvo.read_count }</td>
		<td>${bvo.commentCount }</td>
		<td>${bvo.fileCount }</td>
		<td>
	</tr>
</c:forEach>
</tbody>

</table>

<!-- 페이징 처리 라인 -->
<nav aria-label="Page navigation">
    <ul class="pagination">
        <c:if test="${ph.prev}">
            <li class="page-item">
                <a class="page-link" href="/board/list?pageNo=${ph.startPage - 1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}" aria-label="Previous">
                    <span aria-hidden="true"><i class="bi bi-caret-left-fill"></i></span>
                </a>
            </li>
        </c:if>
        <c:forEach begin="${ph.startPage}" end="${ph.endPage}" var="i">
            <li class="page-item">
                <a class="page-link" href="/board/list?pageNo=${i}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">${i}</a>
            </li>
        </c:forEach>
        <c:if test="${ph.next}">
            <li class="page-item">
                <a class="page-link" href="/board/list?pageNo=${ph.endPage + 1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}" aria-label="Next">
                    <span aria-hidden="true"><i class="bi bi-caret-right-fill"></i></span>
                </a>
            </li>
        </c:if>
    </ul>
</nav>


<script type="text/javascript">
const isOk = `<c:out value="${isOk}" />`;
console.log(isOk);
if(isOk == 1){
	alert('삭제완료!!');
}
</script>

<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>