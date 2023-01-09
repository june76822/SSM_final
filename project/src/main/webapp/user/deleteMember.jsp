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

<%if(request.getParameter("deleteFail")
		!=null){ %>
<script>
alert("아이디 비밀번호가 맞지 않습니다.");
</script>
<% }%>



	<div class="wrap">
		<div class="header">
			<%@include file="../header/header.jsp"%>
		</div>


		<div class="contants_wrap">

			<span> 회원탈퇴 후에는 해당 계정 및 관련 개인정보가 모두 삭제됩니다.<br> 탈퇴 후에는 해당
				계정의 개인정보가 모두 삭제됩니다.<br> 구매 내역이 있으실 경우, 탈퇴 후 주문정보는 소비자보호에 관한 법률이
				지정한 방법으로 보존기간(5년) 동안 보관/관리 됩니다.<br> 탈퇴 이후에는 어떠한 방법으로도 삭제된 계정
				정보를 복원할 수 없습니다.<br> 최근 14일 이내 구매한 내역이 있을 경우, 교환/반품을 위해 고객센터로 연락
				부탁 드립니다.<br> 회원 탈퇴를 위해 아래 탈퇴를 원하는 계정의 아이디와 비밀번호를 입력해 주세요.
			</span>
			<form method="post" action="./action">
				<input type="hidden" name="command" value=deleteMember>
				<div>
					아이디 <input type="text" name="id" placeholder="아이디" class="id">
				</div>

				<div>
					비밀번호 <input type="password" name="password" placeholder="비밀번호" class="password">
				</div>
				<div>
					<input type="submit" value="회원탈퇴">
				</div>
			</form>
		</div>
		<div class="footer"><%@include file="../footer/footer.jsp"%></div>
	</div>
</body>

</html>