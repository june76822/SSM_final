<%@page import="user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/login.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>ONDERARMOR</title>
</head>
<body>

<%if(request.getParameter("success")!=null){ %>
<script>
alert("회원가입에 성공 했습니다!");
</script>
<% }%>

<%if(request.getParameter("check")!=null){ %>
<script>
alert("회원정보를 확인해주세요.");
</script>
<% }%>
	<div class="wrap">
		<div class="header">
            <%@include file="../header/header.jsp" %>
            
		</div>
		<div class="contants_wrap">
			<div class="log_main">
				<div class="section-set">
					<h1 class="log_font_fir" id="join_log">회원로그인</h1>
					<form method="post" action="./action">
					<input type="hidden" name="command" value="login">
						<h2 class="log_font">
							아이디<span id="essential">*</span>
						</h2>
						<input id="bnt_logjoin" type="text" id="input" name="id" placeholder="id" required>
						<h2 class="log_font">
							비밀번호<span id="essential">*</span>
						</h2>
						<input id="bnt_logjoin" type="password" id="input" name="password"
							placeholder="password" required>
						<div class="buttons">
							<input id="bnt_logjoin" type="submit" value="로그인">
						</div>
					</form>
					<form action="findPassword_page">
					<div>
						<input type="submit" class="findPasswordButton" value="비밀번호찾기">					
					</div>
					</form>
					
				</div>
				<div>
					<div>
						<h3 class="log_font_fir">신규고객</h3>
						
						<p class="detail">지금 계정을 만들고 Onder Armour<br>회원만의 혜택을 누리세요.</p>
					</div>
					<div>
						<form method="post" action="./join_page">
							<input id="bnt_logjoin" type="button" id="input" value="ONDER ARMOUR 간편 회원가입" onclick="location.href='./join_page'">
						</form>
					</div>
				</div>
			</div>
		</div>
			<div class="footer">
			<%@include file="../footer/footer.jsp"%>
			</div>
	</div>

</body>
</html>