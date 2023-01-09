<%@page import="item.WishItemDTO"%>
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
<title>Document</title>
</head>

<body>

	<div class="wrap"></div>
	<div class="contants_wrap">
		<div class="header">
			<%@include file="../header/header.jsp"%>
		</div>
		<div class="product_result" id="item_result">
			<%
			ItemDAO iDao = ItemDAO.getInstance();

			ArrayList<WishItemDTO> list = iDao.getWishList(member);
			if (list == null) {
			%>
			<div class="error">위시리스트에 아이템이 존재하지 않음</div>
			<%
			} else {
			%>
			<form method="post" id="cart" action="./action">
				<input type="hidden" name="command" value="removeWish">
				<%
				for (WishItemDTO wish : list) {
					ItemDTO item = iDao.getItem(wish.getItem_code());
				%>
				<div class="item">
					<input type="checkbox" name="wishItem_code"
						value="<%=wish.getWishItem_code()%>"> <a
						href="./detail_page?code=<%=item.getItem_code()%>">
						<div class="item_img">
							<img src="<%=item.getImage()%>" alt="">
						</div>
						<div class="item_info">
							<div class="item_name"><%=item.getName()%></div>
							<div class="item_pricing"><%=item.getPrice()%></div>
							<div class="item_rating" hidden>별점</div>
						</div>
					</a>
				</div>
				<%
				}
				%>
				<div class="wish_wrap">
					<button type="submit">삭제</button>
				</div>
				<%
				}
				%>
			</form>

		</div>
		<div class="footer"><%@include file="../footer/footer.jsp"%></div>
	</div>

	<script src="script/main.js"></script>
</body>
<script>
	function changeCommand() {
		$('#command').val('removeWish');
		$('form').submit();
	}
</script>
</html>