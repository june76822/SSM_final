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
<link rel="stylesheet" href="../css/main.css">
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
			<div class="cartlist">
				장바구니

				<%
			if (member != null) {
				if (cartList == null) {
			%>
				<span>상품이 존재하지 않습니다.</span>
				<%
				} else {%>
					여기 아래 form 하고 checkbox 수정 필요
				
				<form >
					<%
					for (CartDTO cart : cartList) {
						ItemDTO item = dao.getItem(cart.getItem_Code());
						totalPay += item.getPrice();
						totalQuantity += Integer.parseInt(cart.getQuantity());
					%>
					<div class="item">
						<input type="checkbox" name="item_code" value="<%= item.getItem_code()%>">
						<a href="./detail_page?code=<%=cart.getItem_Code()%>">
							<div class="item_img">
								<img src="<%=item.getImage()%>" alt="">
							</div>
							<div class="item_info">
								<div class="item_name"><%=item.getName()%></div>
								<div class="item_pricing"><%=item.getPrice()%></div>
								<div class="item_quantity"><%=item.getPrice()%></div>
								<div class="item_rating" hidden>별점</div>
								<!-- <div class="product_rating" hidden>별점</div> -->
							</div>
						</a>
					</div>
					<%
					}
					%>
				</form>
				<%
				}
				} else {
				%>
				<div>로그인 필요</div>
				<%
				}
				%>

			</div>
			<div class="Payment_wrap">
			버튼 넣고 orderAction으로 넘겨줌
			</div>
		
		</div>
		<div class="footer"><%@include file="../footer/footer.jsp"%></div>
	</div>
</body>

</html>