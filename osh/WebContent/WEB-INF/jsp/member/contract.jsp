<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>2023. 3. 15.오후 9:01:30</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script> 
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
 	
 	<script language="javascript">
function agree_submit(frm)
{

	  if (frm.checkButton.disabled==true) {
		    frm.checkButton.disabled=false
		    document.getElementById("con").style.color = "white";
		    
	  }	else {
		    frm.checkButton.disabled=true
		    document.getElementById("con").style.color = "black";
	}	
		    
}
</script>
</head>
<body>
<jsp:include page="../common/header.jsp" />

	<div class="con-box">
		<div class="con-title">이용약관</div>
		<div class="con-text">
제 1장 총칙

제 1조 (목적)

본 약관은 음악커뮤니티 웹사이트(이하 "ohalfmoon")가 제공하는 모든 서비스(이하 "서비스")의 이용조건 및 절차, 회원과 ohalfmoon포털의 권리, 의무, 책임사항과 기타 필요한 사항을 규정함을 목적으로 합니다.

제 2조 (약관의 효력과 변경)
1. ohalfmoon포털은 이용자가 본 약관 내용에 동의하는 경우, ohalfmoon포털의 서비스 제공 행위 및 회원의 서비스 사용 행위에 본 약관이 우선적으로 적용됩니다.
2. ohalfmoon포털은 약관을 개정할 경우, 적용일자 및 개정사유를 명시하여 현행약관과 함께 국가공간정보포털의 초기화면에 그 적용일 7일 이전부터 적용 전일까지 공지합니다. 단, 회원에 불리하게 약관내용을 변경하는 경우에는 최소한 30일 이상의 사전 유예기간을 두고 공지합니다. 이 경우 ohalfmoon포털은 개정 전 내용과 개정 후 내용을 명확하게 비교하여 회원이 알기 쉽도록 표시합니다.
3. 변경된 약관은 ohalfmoon포털 홈페이지에 공지하거나 e-mail을 통해 회원에게 공지하며, 약관의 부칙에 명시된 날부터 그 효력이 발생됩니다. 회원이 변경된 약관에 동의하지 않는 경우, 회원은 본인의 회원등록을 취소(회원탈퇴)할 수 있으며, 변경된 약관의 효력 발생일로부터 7일 이내에 거부의사를 표시하지 아니하고 서비스를 계속 사용할 경우는 약관 변경에 대한 동의로 간주됩니다.

제 3 조(약관 외 준칙)

본 약관에 명시되지 않은 사항은 전기통신기본법, 전기통신사업법, 정보통신윤리위원회심의규정, 정보통신 윤리강령, 프로그램보호법 및 기타 관련 법령의 규정에 의합니다.
		</div>
		<div class="con-bottom">
		<form name="agree_form" id="agree_form" method="post" action="javascript:agree_submit()" >
			<div class="input__check">
				<input type="checkbox" id="agree" name="agree" onclick="agree_submit(this.form)"> 
				<label for="agree">위의 이용약관에 동의합니다.</label>
			</div>	
			<div class="next-box">
				<button type="submit" class="con-next"  id="con" name="checkButton" 
				onclick="location.href='${pageContext.request.contextPath}/member/signup'" disabled>회원가입</button>
			</div>
		</form>			
		</div>
	</div> 	 	
</body>
</html>