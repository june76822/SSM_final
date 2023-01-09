<%@page import="item.CartDTO"%>
<%@page import="item.ItemDAO"%>
<%@page import="item.ItemDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/project/css/cart.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>Document</title>
</head>

<body>
	<div class="wrap">
		<div class="header">
			<%@include file="../header/header.jsp"%>
		</div>
		<%
		ItemDAO dao = ItemDAO.getInstance();
		ArrayList<CartDTO> cartList = dao.getCartList(member);
		int totalPay = 0;
		int totalQuantity = 0;
		%>
		<div class="contants_wrap">
			<%if (member != null) {%>
			<div class="cartlist">
				장바구니
				<%if (cartList.size() == 0) {%>
				<span>상품이 존재하지 않습니다.</span>
				<%} else {%>

				<form method="post" id="cart" action="./action">
					<input type="hidden" name="command" id="command" value="order">
					<%
					for (CartDTO cart : cartList) {
						ItemDTO item = dao.getItem(cart.getItem_Code());
						totalPay += item.getPrice();
						totalQuantity += Integer.parseInt(cart.getQuantity());
					%>
					<div class="item">
						<input type="checkbox" name="cartItem_code"
							value="<%=cart.getCartItem_Code()%>"> <a
							href="./detail_page?code=<%=cart.getItem_Code()%>">
							<div class="item_img">
								<img src="<%=item.getImage()%>" alt="" style="width: 200px; height: 300px;">
							</div></a>
							<div class="item_info">
								<div class="item_name"><%=item.getName()%></div>
								<div class="item_pricing">가격:<%=item.getPrice()%></div>
								<div class="item_quantity">수량:<%=cart.getQuantity()%></div>
								<div class="item_rating" hidden>별점</div>
								<!-- <div class="product_rating" hidden>별점</div> asd-->
							</div>
						
					</div>
					<%}%>
					<div class="buttons">
						<input type="submit" value="결제하기">
						<input type="button" value="삭제하기" onclick="changeCommand()">
					</div>
				</form>
				<%
				}
				} else {
				%>
				<script>
					logAlert()
				</script>
				<%}%>
			</div>
		</div>
		<div class="footer"><%@include file="../footer/footer.jsp"%></div>

	</div>
</body>
<script>
	function changeCommand() {
		$('#command').val('removeCart');
		$('form').submit();
	}
</script>

</html>