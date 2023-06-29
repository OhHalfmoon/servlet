<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">    
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
</head>
<body>

  <jsp:include page="common/header.jsp" />
  
  <main class="slider-wrapper">
    <div class="slider-body">
      <div class="slider">
        <img src="img/slider/Ephipone.png">
        <img src="img/slider/Gibson.png">
        <img src="img/slider/Fender.png">   
        <img src="img/slider/Yamaha.png">
        <img src="img/slider/Zildjian.png">
      </div>
    </div>  
    
    <% if(session.getAttribute("member") == null) { %>
    <div class="in">
      <div class="login"><a href="${pageContext.request.contextPath}/member/signin">로그인</a></div>
      <div class="join"><a href="${pageContext.request.contextPath}/member/contract">회원가입</a></div>
      <div class="find"><a href="#" onclick="alert('미구현 서비스입니다.')">찾기</a></div>
    </div>
    <% } else { %>    
    <div class="in">    
    <div class="welcome"><p>${member.name}님 
환영합니다</p></div>
    <div class="my"><a href="${pageContext.request.contextPath}/member/memberInfo">마이페이지</a></div>
    <div class="out"><a href="member/logout">로그아웃</a></div>
    </div>
      <% } %>
  </main>
    <div class="main-frame" >
      <div class="mb-title">
        <a class="main-board" href="${pageContext.request.contextPath}/board/list">  인기 게시글</a>
      </div>      
      <div id="main">
        <div id="img-box" class="box1">
          <img src="img/gibson.jpg">
        </div>
        <div id="text-box" class="text1">
          브랜드 : 깁슨 U.S.A

          유형 : 일렉기타, 레스폴

          상품 : 깁슨 트레디셔널 2012       

          가격 : 1,85,000원

          지역 : 서울 구로구
        </div>
      </div>
      <div id="main" >
        <div id="img-box" class="box2">
          <img src="img/Charvel.jpg">
        </div>
        <div id="text-box" class="text2">
          브랜드 : 샤벨

          유형 : 일렉기타, 스트랫

          상품 : 샤벨 DK-24         

          가격 : 1,00,000원

          지역 : 서울 마포구
        </div>
      </div>
      <div id="main" >
        <div id="img-box" class="box3">
          <img src="img/fender.jpg">
        </div>
        <div id="text-box" class="text3">          
          브랜드 : 펜더 (제팬)

          유형 : 일렉기타, 텔레케스터

          상품 : 트레디셔널 60's         

          가격 : 85,000원

          지역 : 강원도 춘천시
        </div>
      </div>
      <div id="main" >
        <div id="img-box" class="box4">
          <img src="img/tyler.png">
        </div>
        <div id="text-box" class="text4">
          브랜드 : 제임스타일러

          유형 : 일렉기타, 스트렛

          상품 : jtv-69        

          가격 : 1,200,000원

          지역 : 경기도 부천시
        </div>
      </div>       
    </div>
    <div id="offer">
      <div class="offer-title">
        <a class="offer-board" href="${pageContext.request.contextPath}/board/list">  밴드생활</a>
      </div>    
      <div id="offerbox" class="offer1">
        <img src="img/poster1.png">
      </div>
      <div id="offerbox" class="offer2">
        <img src="img/poster2.png">
      </div>
      <div id="offerbox" class="offer3">
        <img src="img/poster3.png">
      </div>
    </div> 
  <jsp:include page="common/footer.jsp" />
</body>
</html>