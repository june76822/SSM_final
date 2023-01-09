<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ONDERARMOR</title>
</head>
<body> 
<%if(request.getParameter("CheckFail")!=null){ %>
<script>
alert("아이디가 맞지 않습니다.");
</script>
<% }%>

<div class="wrap">
		<div class="header">
			<%@include file="../header/header.jsp" %>
		</div>

		<div class="contants_wrap">
			<div class="input" style="font-size: 1.2em; font-style: italic; margin-left:30px; ">비밀번호를 입력해주세요</div>
		<form action="./action">
		<input type="hidden" name="command" value="passwordCheck">
		
			
			<input type="password" name="password" class="password" style="margin-left:30px;">
			<input type="submit" value="확인" class="check" style="font-size: 1.2em; font-style: italic;">
			

		</form>
		</div>
		<div class="footer"><%@include file="../footer/footer.jsp"%></div>
</div>










</body>
</html>