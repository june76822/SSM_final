<%@page import="item.OrderItemDTO"%>
<%@page import="item.OrderDTO"%>
<%@page import="item.ListDAO"%>
<%@page import="user.UserDTO"%>
<%@page import="item.ItemDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="item.ItemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/main.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>ONDERARMOR</title>
</head>

<body>

	<%
	ItemDAO dao = ItemDAO.getInstance();
	UserDTO dto = (UserDTO) session.getAttribute("members");
	String orderCode = request.getParameter("code");

	ArrayList<OrderItemDTO> list = dao.getOrderItemList(orderCode);

	int totalPay = 0;
	int totalQuantity = 0;
	%>

	<div class="wrap"></div>
	<div class="header">
		<div class="header_1">
			<div class="logo">
				<a href="index.jsp">
					<h1>InderAmer</h1>
				</a>
			</div>
			<div class="member_wrap">
				<div class="myPage">
					<a href="">내 계정</a>
				</div>
				<div class="login">
					<%
					if (dto == null) {
					%>
					<p onclick="location.href='./login_page'">로그인</p>
					<%
					} else {
					%>
					<form class="logoutButton" method="post" action="./action">
						<input type="hidden" name="command" value="logout"> <input
							type="submit" value="로그아웃">
					</form>
					<%
					}
					%>

				</div>
				<div class="cart">
					<img src="resource/cart.png" alt="">
				</div>
			</div>
		</div>
		<div class="header_2">
			<div class="nav"></div>
			<div class="search">
				<form method="get" action="" class="search_form">
					<input type="text" placeholder="검색"> <input type="image"
						class="search_submit" src="resource/search.png" width="20px">
				</form>
			</div>
		</div>
	</div>
	<div class="contants_wrap">
		<div class="requirementPilter">
			<ul>
				<span>검색조건</span>
				<li>카테고리</li>
				<li>컬러</li>
				<li>사이즈</li>
				<li>가격</li>
			</ul>
		</div>
		<div class="product_result" id="item_result">
			<!-- 아이템 추가 해주는 구역 -->
			주문내역
			<%
			if (list == null) {
			%>
			<div class="error">주문내역이 존재하지 않음</div>
			<%
			} else {
			for (int i = 0; i < list.size(); i++) {
				ItemDTO item = dao.getItem(list.get(i).getItem_code());
				totalPay += item.getPrice();
				totalQuantity += list.get(i).getCount();
			%>
			<div class="item">
				<a href="./detail_page?code=<%=item.getItem_code()%>">
					<div class="item_img">
						<img src="<%=item.getImage()%>" alt="">
					</div>
					<div class="item_info">
						<div class="item_name"><%=item.getName()%></div>
						<div class="item_pricing"><%=item.getPrice()%></div>
						<div class="item_size"><%=list.get(i).getSize()%></div>
						<div class="item_count"><%=list.get(i).getCount()%></div>
						<div class="item_rating" hidden>별점</div>
						<!-- <div class="product_rating" hidden>별점</div> -->
					</div>
				</a>
			</div>
			<%
			}
			}
			%>
		</div>
	</div>
		<div class="footer"><%@include file="../footer/footer.jsp"%></div>

	<script src="script/main.js"></script>
</body>
</html>