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
<title>Document</title>
</head>

<body>
	<div class="wrap">
	
		<div class="header">
			<%@include file="../header/header.jsp"%>
		</div>

		<div class="contants_wrap">
		
		<form action="./action">
		<input type="hidden" name="command" value="findPassword">
			아이디를 입력해주세요
			<input type="text" name="id" style="border-color: black;">
			<input type="submit" value="찾기">
			
			</form>
			</div>
			<div class="footer"><%@include file="../footer/footer.jsp"%></div>
		</div>
	

</body>

</html>





