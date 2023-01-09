
<%@page import="java.sql.Timestamp"%>
<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDAO"%>
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
	<div class="wrap">
		<div class="header">
			<%@include file="../header/header.jsp"%>
		</div>
		<div class="contants_wrap">

			<div class="board_wrap">
				<div>
					<p class="title_font">Free Board</p>
				</div>
				<table border="1" class="board_change">
					<thead>
						<tr>
							<td>no</td>
							<td>b_code</td>
							<td>mb_code</td>
							<td>title</td>
							<td>viewCnt</td>
							<td>createdAt</td>
							<td>modifiedAt</td>
						</tr>
					</thead>
					<%
					BoardDAO boardDao = BoardDAO.getInstance();
					ArrayList<BoardDTO> list = boardDao.getboardList();
					/* 	System.out.println("size : " + list.size()); */
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
							String b_code = list.get(i).getB_code();
							String mb_code = list.get(i).getMb_code();
							String title = list.get(i).getTitle();
							int viewCnt = list.get(i).getViewCnt();
							Timestamp createdAt = list.get(i).getCreatedAt();
							Timestamp modifiedAt = list.get(i).getModifiedAt();
					%>
					<tbody>
						<tr class="board_box"
							onclick="location.href='./boardview_page?b_code=<%=b_code%>'">
							<td><%=i + 1%></td>
							<td><%=b_code%></td>
							<td><%=mb_code%></td>
							<td><%=title%></td>
							<td><%=viewCnt%></td>
							<td><%=createdAt%></td>
							<td><%=modifiedAt%></td>
						</tr>
						<%
						}
						} else {
						%>
						<tr>
							<td>-</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<%}%>
					</tbody>
				</table>
				<div class="button_box">
					<%
					UserDTO log = (UserDTO) request.getSession().getAttribute("members");
					if (log != null) {
					%>
					<!-- 로그값이 널이 아니면 글쓰기 페이지로 이동  -->
					<button type="button" onclick="location.href='./boardWrite_page'">글쓰기</button>
					<%
					} else {
					%>


					<!-- 로그값이 널이면 로그인 페이지로 이동 -->
					<button type="button" onclick=logAlert()>글쓰기</button>
					<%
					}
					%>
				</div>
			</div>

		</div>
		<div class="footer"><%@include file="../footer/footer.jsp"%></div>
	</div>
<!-- 	<script>
		function logAlert(){
			alert("로그인 후 이용해주세요.");
 			location.href= "./login_page";
	</script> -->
</body>
</html>