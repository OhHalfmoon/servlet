<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  
  <div id="detail-zone">
  <form method="post">
    <div class="detail-head">
      <div id="line"></div>    
      <div id="detail-title">
      <label for="title" class="form-label">title</label>
      <input type="text"  id="detail-title" placeholder="Enter title" name="title" readonly value="${board.title}">
      </div> 
    </div>
    <div id="line"></div>
    <div class="detail-body">
      <div id="detail-content">
      <label for="content" class="form-label" id="detail-label">content</label>
      <textarea id="detail-content" placeholder="Enter content" name="content" readonly>${board.content}</textarea>	
      </div> 
    </div>
    <div class="view-writer">
      <label for="writer" class="form-label"> writer</label>
      <input type="text" class="form-control" id="view-writer" name="writer" placeholder="Enter writer" value="${board.writer}" readonly>
    </div>
     <div class="file-view">
		<p class="form-label">files</p>
		<c:forEach items="${board.attachs}" var="attach">
		<p><a href="${pageContext.request.contextPath}/download?${attach.queryString}">${attach.origin}</a></p>
		</c:forEach>              						    
    </div>
    <a href="modify?bno=${board.bno}&${cri.fullQueryString}" id="view-finish">수정</a>
    <a href="remove?bno=${board.bno}&${cri.fullQueryString}" id="view-remove">삭제</a>
    <a href="list?${cri.fullQueryString}" id="view-cancel">목록</a>
    <div id="replyArea">
  		<p class="reply-zone"> replies</p>
		<div class="write-reply">
			<textarea  id="commentArea" placeholder="Enter comments"></textarea>
			<button type="button" id="reply-finish">댓글 작성</button>
 		</div>
  			<ul class="container replies">
    			<li class="replyList">                  
      				<div class="reply">
       					<p>댓글이 없습니다</p>
      				</div>
    			</li>
  			</ul>
	</div>
  </form>
  </div>  
  <script>
	$(".btn-remove").click(function() {
		return confirm("정말 삭제 하시겠습니까?");		
	});
	let contextPath = '${pageContext.request.contextPath}';
	let replyPath = contextPath + "/reply"
	let bno = '${board.bno}';
	let writer = '${member.id}';
	
	showList();
	function showList() {
		$.ajax({
			url : replyPath,
			data : {bno:bno},
			success : list
		});
	}

	
	// 댓글 목록	
	function list(replies) {  
		let str = "";
		if(!replies.length) {
			str = `<li class="replyList">                  
				<div class="reply">
              <p>댓글이 없습니다</p>
            </div>
          </li>`;
			$(".replies").html(str);
			return;
		}
		
		for (let i in replies) {
			let r = replies[i];
			let isMine = writer === r.writer
			str +=`
				<li class="replyList" data-rno="\${r.rno}">
					<div class="row">
						<a class="reply-date" href="">
							<span class="fs-6 fw-bold">\${r.writer}</span>
							<span class="mx-5">\${r.regDate}</span>
						</a>
						<div class="col text-end">`;
				str +=	isMine ? '<a href="" class="remove-reply">x</a>' : ''
				str +=	`</div>
					</div>
					<div class="reply">
						<p>\${r.content}</p>
					</div>
				</li>
			`;
	}
    $(".replies").html(str);
  }
	
	// 댓글작성
	$("#commentArea").next().click(function() {    
	let content = $("#commentArea").val();
		if(!writer) {
			alert("로그인 후 작성하세요");
			location.href = contextPath + "/member/signin?href=" + encodeURIComponent(location.pathname + location.search + '#replyArea');
			return;
		}
		else if(!content) {
			alert("댓글 내용을 입력하세요");
			return;
		}
		$.ajax({
			url : replyPath,
			data : {bno:bno, content:content, writer:writer},
			method : "POST",
			success : function(data) {
				alert("댓글이 성공적으로 작성되었습니다");
				$("#commentArea").val("");
				showList();				
			}
		})
	})
		
	//댓글 삭제
	$(".replies").on("click", "li a.remove-reply", function() {
		event.preventDefault();
		if(!confirm("댓글을 삭제하시겠습니까?")) {
			return false;
		}
		/* console.log($(this).closest("li").data("rno")); */
		let rno = $(this).closest("li").data("rno");
		$.ajax({
			url : replyPath + "?rno=" + rno,
			method : "DELETE",
			success : function(data) {
				if(data==1) {
					alert("댓글이 성공적으로 삭제되었습니다");
					showList();	
				}							
			}
		})
	})

</script>
</body>
</html>