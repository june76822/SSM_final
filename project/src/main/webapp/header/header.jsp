<%@page import="user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/main.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
	<%
	UserDTO member = (UserDTO) session.getAttribute("members");
	%>
	<div class="header_1">
		<div class="logo">
			<a href="index.jsp">
				<h1>ONDERARMOR</h1>
			</a>
		</div>
		<div class="member_wrap">
			<div class="free_board">
				<a href="./board_page">게시판</a>
			</div>
			<div class="myPage">
				<form class="myPageButton" method="post" action="./passwordCheck_page">
				 
					
					<%if(member == null) {%>
						<span onclick=logAlert() style="cursor: pointer"> 내 계정</span>
					<%}else{ %>
 					<input class="Page_bnt" type="submit" value="내 계정" style="background-color:rgb(26, 24, 24)">
					<%} %>
				</form>
			</div>
			<div class="login">
				<%if (member == null) {%>
				<a href="./login_page">로그인</a>
				<%} else {%>
				<form class="logoutButton" method="post" action="./action">
					<input type="hidden" name="command" value="logout">
					<input class="Page_bnt" type="submit" value="로그아웃" style="background-color:rgb(26, 24, 24)">
			</form><%}%>
			</div>
			<div class="cart" >		
				<%if(member== null){ %>		
					<input type="image" src="resource/cart.png" width="30px"  onclick=logAlert()>
				<%}else{%>
					<a href="./cart_page"><img src="resource/cart.png" ></a>	
				<%}%>
			</div>
		</div>
	</div>
	<div class="header_2">
		<div class="nav"></div>
		<div class="search">
			<form method="get" action="./sales_page" class="search_form">
				<input type="text" placeholder="검색" name="keyword"style="color: black;"> 
				<input type="image"
					class="search_submit" src="resource/search.png" width="20px" >
			</form>
		</div>
	</div>
		<script src="script/main.js"></script>
