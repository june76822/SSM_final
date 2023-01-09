<%@page import="user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/main.css">

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>ONDERARMOR</title>
</head>

<body>

<%if(request.getParameter("deleteSuccess")!=null){ %>
<script>
alert("회원 탈퇴가 완료 되었습니다.");
</script>
<% }%>


<%if(request.getParameter("myPageFail")!=null){ %>
<script>
alert("비밀번호가 틀립니다.");
</script>
<% }%>





	<div class="wrap">

		<div class="header">
			<%@include file="header/header.jsp"%>
		</div>

		<div class="contants_wrap">
			<div class="banner_image_fir">
				<div class="image_box" id="point">
					<a href='./sales_page?keyword=top'><img  class="image" src="https://images.unsplash.com/photo-1607962815887-33784b34dc9e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1769&q=80"  ></a>
				</div>
			</div>
			<div class="banner_image_sec">
				<div class="image_box" id="point">
					<a href='./sales_page?keyword=Bottoms'><img class="image" src="https://images.unsplash.com/photo-1513593771513-7b58b6c4af38?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2232&q=80"  ></a>
				</div>
			</div>
		</div>
			<div class="footer">
				<%@include file="footer/footer.jsp"%>
			</div>
	</div>

</body>

</html>