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
<!--  	<script language="javascript">
 	
 	
 	function check_pw(){  //비밀번호 확인 
 	    var p = document.getElementById('pw').value; 
 	    var p2 = document.getElementById('pw2').value; 
 	 
 	    if (p!=p2) { 
 	      document.getElementById('pw_check_msg').innerHTML = "비밀번호가 다릅니다. 다시 확인해 주세요."; 
 	    } 
 	    else { 
 	        document.getElementById('pw_check_msg').innerHTML = ""; 
 	    } 
 	    if (p_cf=="") { 
 	      document.getElementById('pw_check_msg').innerHTML = ""; 
 	    } 
 	 } 
 	
 	function checked(){  //form 유효성 검사 
 		var p = document.getElementById('pw'); 
 		var p2 = document.getElementById('pw2'); 
 		if (p.value != p2.value) {  //비밀번호 확인 
 			  alert("비밀번호가 일치하지 않습니다. 확인해 주세요"); 
 			  p2.focus(); 
 			  return false; 
 			}
 		else { 
 			  return true; 
 			} 
 			 
	}
</script> -->
</head>
<body>
<jsp:include page="../common/header.jsp" />
  
  <div class="signup-box">
    <form name ="user_form" id="user_form" method="post" >
      <div class="sign-id-box">
        <label for="id">ID</label><br>
        <input type="text" id="id" name="id" placeholder="아이디를 입력하세요"><br>
      </div>
      <div class="sign-pw-box">
        <label for="pw">비밀번호</label><br>
        <input type="password" id="pw" name="pw"  placeholder="비밀번호를 입력하세요" required ><br>
      </div>
      <div class="sign-re-pw-box">
        <label for="userpw2">비밀번호 확인</label><br>
        <input type="password" id="pw2" name="pw2"  placeholder="비밀번호를 다시 입력하세요" required ><br>
      </div>
      <div class="sign-name">
        <label for="name">이름</label><br>
        <input type="text" id="name" name="name" placeholder="이름을 입력하세요"><br>
      </div>
      <div class="causion">
		<p class="text-danger small">${param.msg}</p>
      </div>
      <div>
        <button type="submit" class="signup" id="signup" name="signupButton" >회원가입 </button>
      </div>
      <br>
      <br>    
    </form>
  </div> 
  
  
  <script>
    $(function() {
      $(".signup").click(function (){
        event.preventDefault();
        if($("#id").val() == "") {
          alert("아이디를 입력해주세요");
        }
        else if($("#id").val().length < 4) {
          alert("아이디를 4글자 이상 입력해주세요");          
        }
        else if(($("#pw").val() == "") || ($("#pw2").val() == ""))  {
          alert("비밀번호를 입력해주세요");
        }
        else if(($("#pw").val().length < 4) || ($("#pw2").val().length < 4)) {
          alert("비밀번호를 4글자 이상 입력해주세요");
        }
        else if($("#pw").val() != $("#pw2").val()) {
         alert("비밀번호의 값이 일치하지 않습니다")
        }
        else if($("#name").val() == "") {
          alert("이름을 입력해주세요")
        }
        else {
          alert("가입이 완료되었습니다");
          $("#user_form").submit();
        }     
      }) 
    })
  </script>	
</body>
</html>