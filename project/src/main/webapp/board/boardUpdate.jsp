<%@page import="board.BoardDAO"%>
<%@page import="board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/board.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>ONDERARMOR</title>
</head>
<body>
	<%
	BoardDTO board = BoardDAO.getInstance().getBoard(request.getParameter("b_code"));
	String b_code = board.getB_code();
	String title = board.getTitle();
	String contents = board.getContents();
	%>

	<div class="wrap">
		<div class="header">
			<%@include file="../header/header.jsp" %>
		</div>
		<div class="contants_wrap">
			
				<div class="board_wrap">
					<form method="post" action="./action">
						<input type="hidden" name="command" value="updateBoard">
						<input type="hidden" name="b_code" value="<%=b_code%>">
						<input type="text" id="title" name="title" placeholder="title" required   value="<%=title%>"><br>
						<textarea name="contents" placeholder="contents text" required><%=contents %></textarea>
						<div class="button_box">
							<button onclick="location.href='./boardview_page'">뒤로가기</button>
							<input type="submit" value="수정하기">
						</div>
						<br>
					</form>
				</div>
			
		</div>
		<div class="footer"><%@include file="../footer/footer.jsp"%></div>
	</div>

	<script>
		
	
	</script>
</body>
</html>