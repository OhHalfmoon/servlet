<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
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

  <div class="sign-box">
    <form name ="user_form" id="user_form" method="post">
      <div class="id-box">
        <label for="id">ID</label><br>
        <input type="text" id="id" name="id" placeholder="아이디를 입력하세요"><br>
      </div>
      <div class="pw-box">
        <label for="pw">Password</label><br>
        <input type="password" id="pw" name="pw" placeholder="비밀번호를 입력하세요">
      </div>
        <div class="causion">
            <p class="text-danger small">${param.msg}</p>
        </div>
      <div>
        <button type="submit" class="sign-login">로그인</button>
      </div>
      <br>
      <br>    
    </form>  
  </div>
</body>
</html>