<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/board.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>ONDERARMOR</title>
</head>
<body>
	<div class="wrap">
		<div class="header">
		<%@include file="../header/header.jsp" %>
		</div>
		<div class="contants_wrap">
			
				<div class="board_wrap">
					<form method="post" action="./action">
						<input type="hidden" name="command" value="writeBoard"> <input
							type="text" id="title" name="title" placeholder="title" required><br>
						<textarea name="contents" placeholder="contents text" required></textarea>
						<div class="button_box">
							<button onclick="location.href='./board_page'">뒤로가기</button>
							<button onclick="location.href='./action">글쓰기</button>
						</div>
						<br>
					</form>
				</div>
			
		</div>
		<div class="footer"><%@include file="../footer/footer.jsp"%></div>
	</div>

</body>
</html>