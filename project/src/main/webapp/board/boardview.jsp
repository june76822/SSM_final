
<%@page import="user.UserDTO"%>
<%@page import="user.UserDAO"%>
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
	String b_code = request.getParameter("b_code");
	BoardDTO board = BoardDAO.getInstance().getBoard(b_code);

	String mb_code = board.getMb_code();
	String title = board.getTitle();
	String contents = board.getContents();
	System.out.print("mb_code ; " + mb_code);
	%>
	<div class="wrap">
		<div class="header">
			<%@include file="../header/header.jsp"%>
		</div>

		<div class="contants_wrap">
			
				<div class="board_wrap">
					<%
					if (member != null && member.getMb_code().equals(mb_code)) {
					%>
					<form method="post" action="./action">
						<input type="hidden" name="command" value="deleteBoard">
						<input type="hidden" name="b_code" value="<%=b_code%>">

						<%}%>
						<input type="text" id="title" name="title" value="<%=title%>"
							required readonly><br>
						<textarea name="contents" required readonly><%=contents%></textarea>
						<br>
						<div class="button_box">
							<input type="button" value="뒤로가기" onclick="location.href='./board_page'">
							
						</div>
						<%
						if (member != null && member.getMb_code().equals(mb_code)) {
						%>
						<div class="button_box">
						<input type="button" value="수정하기" onclick="location.href='./boardUpdate_page?b_code=<%=b_code%>'">
						<input type="submit" value="삭제하기" >
						</div>
					</form>
					<%}%>
				</div>
			
		</div>
		<div class="footer"><%@include file="../footer/footer.jsp"%></div>
	</div>
</body>
</html>

