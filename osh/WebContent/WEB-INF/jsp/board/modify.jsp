<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
  
    <div id="write-zone">
    	<form method="post">
		    <div class="write-head">
		        <div id="line"></div>   
		        <label for="write-title" class="form-label">title</label> 
		        <input type="text" id="write-title" name="title" placeholder="제목을 입력하세요" value="${board.title}">
		        <div id="line"></div>
		        <label for="content" class="form-label">content</label>
		        <textarea id="content" name="content" placeholder="내용을 입력하세요">${board.content}</textarea>
		        <div id="line"></div>
		        <label for="writer" class="form-label">writer</label>
			    <input type="text" class="form-control" id="writer" name="writer" placeholder="Enter writer" value="${board.writer}" readonly>
		        <div id="line"></div>
		        <label for="file" class="form-label">files</label>
			    <input type="file" class="form-control" id="file" name="file" multiple>	
		        <div id="line"></div>
		        <div class="text-center">
						<input type="hidden" name="bno" value="${board.bno}">
						<input type="hidden" name="PageNum" value="${cri.pageNum}">
						<input type="hidden" name="amount" value="${cri.amount}">
						<input type="hidden" name="category" value="${cri.category}">
						<c:if test="${not empty cri.type}"> 
							<c:forEach items="${cri.type}" var="type">
								<input type="hidden" name="type" value="${type}">
							</c:forEach>
								<input type="hidden" name="keyword" value="${cri.keyword}">
						</c:if>												
		        <button class="finish" id="finish" formaction="modify">수정</button>
		        <a href="list?${cri.fullQueryString}" id="cancel">이전</a>
		    </div>
	    </form>
  </div>

</body>
</html>