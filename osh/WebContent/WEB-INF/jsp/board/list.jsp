<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>2023. 3. 15.오후 7:14:56</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp" />

    <div class="view">
    <c:set var="amounts" value="5,10,25,50,100" />
      <select class="form-select amount"> 
     <c:forTokens items="${amounts}" delims="," var="amount">
        <option value="${amount}" ${page.cri.amount == amount ? 'selected' : ''}>${amount}개씩 보기</option>
      </c:forTokens> 
      </select>
    </div>
    <form class="search-form">                
		<input type="hidden" name="page" value="1">
		<input type="hidden" name="amount" value="${page.cri.amount}">
		<input type="hidden" name="category" value="${page.cri.category}">
        <div class="float-start mx-5 row">
        <p></p>
          	<div class="ckbox">
				<input class="form-check-input" type="checkbox" id="check1" name="type" value="title" ${fn:contains(fn:join(page.cri.type,','), 'title') ? 'checked' : ''}>
				<label class="form-check-label" for="check1">제목</label>
				<input class="form-check-input" type="checkbox" id="check2" name="type" value="content" ${fn:contains(fn:join(page.cri.type,','), 'content') ? 'checked' : ''}>
				<label class="form-check-label" for="check2">내용</label>
				<input class="form-check-input" type="checkbox" id="check3" name="type" value="writer" ${fn:contains(fn:join(page.cri.type,','), 'writer') ? 'checked' : ''}>
				<label class="form-check-label" for="check3">작성자</label>						
			</div>
          	<div class="search-box">
               <input type="text" class="form-control" placeholder="search" name="keyword" value="${page.cri.keyword}">
    			<button class="search-button" type="submit">search</button>
			</div>						
		</div>
		<a class="nc-write" href="${pageContext.request.contextPath}/board/write">글쓰기</a>
	</form>
     <div class="board-content">
	     <c:forEach var="board" items="${boards}" varStatus="stat">
	       <a href="view?bno=${board.bno}&${page.cri.fullQueryString}" class="thumbnail-tag">
	         <div class="thumbnail ${stat.last ? '' :'border-bottom'}">
	           <div class="mb-4 text-truncate">${board.title} <span>[${board.replyCnt}]</span></div>
	           <div class="row text-muted small">
	             <div class="col-7">${board.writer}</div>
	             <div class="col text-end small"><span class="mr-3">${board.regdate}</span><span class="ml-3">조회수 ${board.hitcount}</span></div>
	           </div>
	         </div>
	      	</a>
	      </c:forEach>
	      <div id="idx">
	        <ul>              
	       	 <c:if test= "${page.doublePrev}">
	           <li class="page-item"><a class="page-link" href="list?pageNum=${page.startPage-1}&${page.cri.queryString}">[&#60;&#60;]  </a></li>
	         </c:if>
	         <c:if test="${page.prev}">  
	           <li class="page-item"><a class="page-link" href="list?pageNum=${page.cri.pageNum-1}&${page.cri.queryString}">[&#60;]</a></li>
	         </c:if>
	         <c:forEach begin="${page.startPage}" end="${page.endPage}" var="i">
	           <li class="page-item"><a class="page-link ${page.cri.pageNum == i ? 'active' : ''}" href="list?pageNum=${i}&${page.cri.queryString}">[${i}]</a></li>
	         </c:forEach>
	         <c:if test="${page.next}"> 
	           <li class="page-item"><a class="page-link" href="list?pageNum=${page.cri.pageNum+1}&${page.cri.queryString}">[&#62;]</a></li>
	         </c:if>  
	         <c:if test= "${page.doubleNext}">
	           <li class="page-item"><a class="page-link" href="list?pageNum=${page.endPage+1}&${page.cri.queryString}"> [&#62;&#62;] </a></li>
	         </c:if>
	        </ul> 
		  </div>  
     </div>
</body>

<script>
$(".amount").change(function() {
//		console.log($(this).val());
		
	let page = '${page.cri.pageNum}';
	let amount = $(this).val();
	let category = '${page.cri.category}'
	let type = '${page.cri.typeStr}'
	
	let obj = {pageNum:page, amount:amount, category:category};
	location.search = $.param(obj) + type;
})
$(".list-header:checkbox:checked").length ? '' : $(".list-header:checkbox:eq(0)").prop("checked", true);

$(".list-header form").submit(function(){
	if(!$(this).find(":checkbox:checked").length || !$(this).find(":text").val().trim()) {
	
		alert("검색 타입을 지정하고 검색어를 입력하세요");
		return false;
	}
});
</script>
</html>