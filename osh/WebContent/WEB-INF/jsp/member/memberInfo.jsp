<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>2023. 3. 15.오후 8:54:05</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp" />
  
  <div class="signup-box">
    <form name ="user_form" id="user_form" method="post">
      <div class="sign-id-box">
        <label for="id">ID</label><br>
        <input type="text" id="id" name="id" value="${member.id}" readonly><br>
      </div>
            <div class="sign-pw-box">
        <label for="pw">가입일자</label><br>
        <input type="text" id="pw" name="pw" value="${member.regdate}" readonly ><br>
      </div>
      <div class="sign-name">
        <label for="name">이름</label><br>
        <input type="text" id="name" name="name" value="${member.name}" readonly><br>
      </div>
      <div>
        <a class="backpage" href="${pageContext.request.contextPath}/" >이전 </a>
      </div>
      <br>
      <br>    
    </form>
  </div>
  
  
	
</body>
</html>