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
	<div class="wrap"></div>
	<div class="header">
		<%@include file="../header/header.jsp"%>
	</div>
	<%
	ItemDAO iDao = ItemDAO.getInstance();

	ArrayList<OrderDTO> list = iDao.getOrderList(member);
	%>
	<div class="contants_wrap">
		<div class="product_result" id="item_result">
			주문내역
			<%
		if (list == null) {
		%>
			<div class="error">주문내역이 존재하지 않음</div>
			<%
			} else {
			for (int i = 0; i < list.size(); i++) {
			%>
			<div class="order">
				<a href="/orderResult_page?code=<%=list.get(i).getOrderCode()%>">
					<div class="order_info">
						주문내역<%=i + 1%>
						<div class="product_name"><%=list.get(i).getOrderDate()%></div>
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