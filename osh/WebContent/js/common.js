$(function() {
  $(".board").hover(function() {
    $(".toggle1, .toggle2").stop().slideDown(500); 
  }, function() {
    $(".toggle1, .toggle2").stop().slideUp(500);
  })   
});
$(document).ready(function(){
	  $('.slider').bxSlider({
	  });
});
