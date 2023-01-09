<%@page import="item.OrderItemDTO"%>
<%@page import="item.ItemDAO"%>
<%@page import="item.ItemDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ONDERARMOR</title>
</head>
<body>
	<%
	int totalPay = 0;
	int totalQuantity = 0;
	ItemDAO dao = ItemDAO.getInstance();
	String orderCode = request.getParameter("code");
	ArrayList<OrderItemDTO> orderItemList = dao.getOrderItemList(orderCode);
	%>

	<div class="wrap">
		<div class="header">
			<%@include file="../header/header.jsp"%>
		</div>

		<div class="contants_wrap">
			<%if (member != null) {%>
			<div class="orderItemlist">
				<%if (orderItemList == null) {%>
				<span>상품이 존재하지 않습니다.</span>
				<%
				} else {
				for (OrderItemDTO orderItem : orderItemList) {
					ItemDTO item = dao.getItem(orderItem.getItem_code());
					totalPay += item.getPrice();
					totalQuantity += orderItem.getCount();
				%>
				<div class="item">
					<a href="./detail_page?code=<%=item.getItem_code()%>">
						<div class="item_img">
							<img src="<%=item.getImage()%>" alt="">
						</div>
						<div class="item_info">
							<div class="item_name"><%=item.getName()%></div>
							<div class="item_pricing"><%=item.getPrice()%></div>
							<div class="item_quantity"><%=orderItem.getCount()%></div>
							<div class="item_rating" hidden>별점</div>
						</div>
					</a>
				</div>
				<%
				}
				}
				} else {
				%>
				<script>
					logAlert()
				</script>
				<%}%>
			</div>
		</div>
		<div class="footer">
		<%@include file="../footer/footer.jsp"%>
		</div>

	</div>
</body>
</html>