<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <header class="header">    
    <h1 class="title"> MUSIC STORE </h1>
    <a href="${pageContext.request.contextPath}/" class="logo"></a>      
    <div class="wrapper">
      <a href="${pageContext.request.contextPath}/" class="home">홈<a>   
      <div class="board">게시판
        <div class="toggle-wrap">
          <a class="toggle1" href="${pageContext.request.contextPath}/board/list"></a>
          <a class="toggle2" href="${pageContext.request.contextPath}/board/list"></a>
        </div>
      </div>
    </div>    
  </header>