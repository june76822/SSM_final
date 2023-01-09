<%@page import="user.UserDTO"%>
<%@page import="item.ItemDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="item.ItemDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/sales.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>ONDERARMOR</title>
</head>

<body>

	<%
	ArrayList<ItemDTO> list;
	ItemDAO dao = ItemDAO.getInstance();

	if (request.getParameter("keyword") != null) {
		String keyword = request.getParameter("keyword");
		list = dao.searchItemList(keyword);
	} else if (request.getParameter("cate") != null) {
		String cate = request.getParameter("cate");
		list = dao.getItemList(cate);
	} else {
		list = dao.getItemList("");
	}
	%>

	<div class="wrap">
		<div class="header">
			  <%@include file="../header/header.jsp" %>
		</div>
		<div class="contants_wrap">

			<div class="product_result" id="item_result">
				<!-- 아이템 추가 해주는 구역 -->
				
					<%if (list == null) {%><div class="error">상품이 존재하지 않음</div>
					<%} else {
						for (ItemDTO i : list) {%>
					<div class="product">
						<a href="./detail_page?code=<%=i.getItem_code()%>">
							<div class="product_img">
								 <img src="<%=i.getImage()%>" alt="">
							</div>
							<div class="product_info">
								<div class="product_name"><%=i.getName()%></div>
								<div class="product_pricing"><%=i.getPrice()%></div>
								<div class="product_rating" hidden>별점</div>
								<!-- <div class="product_rating" hidden>별점</div> -->
							</div>
						</a>
					</div>
						<%}
					}%>
				
			</div>

		</div>
			<div class="footer">
			<%@include file="../footer/footer.jsp"%>
			</div>
	</div>

</body>
</html>


<!-- 기본 item funtion 24개 생성 이후  -->
<!--  컨텐츠 박스가 12개씩 로딩됨 if scroll == contents_end -->
<!-- 버튼의 이름을 ++ 해서 h1에 뿌려줌 
ex) 남성 - 상의 = <h1>남성상의<h1>
 
    페이지 구현 x 정렬 구현.
    -->