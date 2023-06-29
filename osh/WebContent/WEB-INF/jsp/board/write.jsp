<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    	<form method="post" enctype="multipart/form-data">
		    <div class="write-head">
		        <div id="line"></div>   
		        <label for="write-title" class="form-label">title</label> 
		        <input type="text" id="write-title" name="title" placeholder="제목을 입력하세요">
		        <div id="line"></div>
		        <label for="content" class="form-label">content</label>
		        <textarea id="content" name="content" placeholder="내용을 입력하세요"></textarea>
		        <div id="line"></div>
		        <label for="writer" class="form-label">writer</label>
			    <input type="text" class="form-control" id="writer" name="writer" placeholder="Enter writer" value="${member.id}" readonly>
		        <div id="line"></div>
		        <label for="file" class="form-label">files</label>
			    <input type="file" class="form-control" id="file" name="file" multiple>	
		        <div id="line"></div>
		        <button id="finish">글쓰기</button>
		        <a href="javascript:history.back()" id="cancel">취소</a>
		    </div>
	    </form>
  </div>

</body>
</html>