<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>
<!--  검색 라인-->
<div  class="col-sm-12 col-md-6">
<form action="/board/list" method="get">
	<div class="input-group mb-3">
	<c:set value="${ph.pgvo.type }" var="typed"></c:set>
		<select name="type">
			<option ${typed == null? 'selected':'' }>Choose...</option>
			<option value="t" ${typed eq 't'? 'selected':'' } >title</option>
			<option value="w" ${typed eq 'w'? 'selected':'' }>writer</option>
			<option value="c" ${typed eq 'c'? 'selected':'' }>content</option>
			<option value="tw" ${typed eq 'tw'? 'selected':'' }>title+writer</option>
			<option value="tc" ${typed eq 'tc'? 'selected':'' }>title+content</option>
			<option value="wc" ${typed eq 'wc'? 'selected':'' }>writer+content</option>
			<option value="twc" ${typed eq 'twc'? 'selected':'' }>title+writer+content</option>
		</select>
		<input class="form-control" type="text" name="keyword" value="${ph.pgvo.keyword }" placeholder="Search...">
		<input type="hidden" name="pageNo" value="${ph.pgvo.pageNO }">
		<input type="hidden" name="qty" value="${ph.pgvo.qty }">
		<button type="submit" class="btn btn-success position-relative">
			search
			<span class="badge text-bg-secondary">${ph.totalCount }</span>
    	</button>
    	
    	
	</div>
</form>
</div>
<table class="table">
<thead>
<tr>
<th>bno</th>
<th>제목</th>
<th>작성자</th>
<th>등록일</th>
<th>조회수</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="bvo">
<tr>
<td>${bvo.bno }</td>
<td><a href="/board/detail?bno=${bvo.bno }">${bvo.title }</a></td>
<td>${bvo.writer }</td>
<td>${bvo.registerData }</td>
<td>${bvo.read_count }</td>

</tr>
</c:forEach>
</tbody>
</table>

<!-- <script type="text/javascript"></script>
 -->
<!--  페이징 라인-->

<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:if test="${ph.prev}">
            <li class="page-item">
                <a class="page-link" href="/board/list?pageNO=${ph.startPage - 1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}" aria-label="Previous">
                    <span aria-hidden="true"><i class="bi bi-caret-left-fill"></i></span>
                </a>
            </li>
        </c:if>
        <c:forEach begin="${ph.startPage}" end="${ph.endPage}" var="i">
            <li class="page-item">
                <a class="page-link" href="/board/list?pageNO=${i}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">${i}</a>
            </li>
        </c:forEach>
        <c:if test="${ph.next}">
            <li class="page-item">
                <a class="page-link" href="/board/list?pageNO=${ph.endPage + 1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">
                    <span aria-hidden="true"><i class="bi bi-caret-right-fill"></i></span>
                </a>
            </li>
        </c:if>
    </ul>
</nav>
 <script type="text/javascript">
 const isOK =`<c:out value="${isOK}" />`;
 console.log(isOK);
 if(isOK==1){
	 alert("삭제완료");
	 
 }
 
 </script>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>


댓글개수와 파일개수를 


    SELECT count(bno)
    FROM board
    WHERE bno=628  IN (
        SELECT bno
        FROM file
        WHERE uuid IS NOT NULL
    )

<select id="getFileCount" parameterType="com.ezen.myProject.domain.BoardVO" resultType="int">
    SELECT count(bno)
    FROM board
    WHERE bno=631 and bno IN (
        SELECT bno
        FROM file
        WHERE uuid IS NOT NULL
    )


SELECT COUNT(*)
FROM board
WHERE  631 IN (
    SELECT 631
    FROM file
    WHERE uuid IS NOT NULL
);


SELECT count(*)
    FROM board
    WHERE bno=630 and bno IN (
        SELECT bno
        FROM file
        WHERE uuid IS NOT NULL
    )


update board set commentCount = (select count(cno) from comment where bno = board.bno);

<update id="countComment" parameterType="com.ezen.myProject.domain.BoardVO">
  update board set CommentCount = (select count(cno) from comment where bno = #{bno});
</update>

update board set  fileCount=(select count(uuid) from file where bno=board.bno);


update board set CommentCount = (select count(cno) from comment where 310);