<%@page import="item.StockDAO"%>
<%@page import="item.StockDTO"%>
<%@page import="item.WishItemDTO"%>
<%@page import="item.ItemDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="item.ItemDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/project/css/cart.css">
<title>ONDERARMOR</title>
</head>
<body>

	<div class="wrap"></div>
	<div class="header">
		<%@include file="../header/header.jsp"%>
	</div>
	<div class="contants_wrap">
		<p>내 위시리스트</p>
		<div class="product_result" id="item_result">
			<%
			ItemDAO iDao = ItemDAO.getInstance();

			ArrayList<WishItemDTO> list = iDao.getWishList(member);

			if (list.size() == 0) {
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
					StockDTO sizeStock = StockDAO.getInstance().getStock(item.getItem_code());
				%>
				<div class="item">
					<input type="checkbox" name="wishItem_code"
						value="<%=wish.getWishItem_code()%>"> <a
						href="./detail_page?code=<%=item.getItem_code()%>">
						<div class="item_img">
							<img src="<%=item.getImage()%>" alt=""
								style="width: 200px; height: 200px;">
						</div>
					</a>
					<div class="item_info">
						<div class="item_name"><%=item.getName()%></div>
						<div class="item_pricing">
							가격:<%=item.getPrice()%></div>
						<div class="item_rating" hidden>별점</div>
					</div>
				</div>
				<div class="size_select">
					<h5>사이즈--</h5>
					<select name='size' class="size">
						<option selected>-- 사이즈를 선택하세요 --</option>

						<%
						if (sizeStock.getXS() != 0) {
						%>
						<option value="<%=sizeStock.getXS()%>"><div
								class="asefasdfsfda">XS</div>
						</option>
						<%
						}

						if (sizeStock.getS() != 0) {
						%>
						<option value="<%=sizeStock.getS()%>">S</option>
						<%
						}

						if (sizeStock.getM() != 0) {
						%>
						<option value='<%=sizeStock.getM()%>'>M</option>
						<%
						}

						if (sizeStock.getL() != 0) {
						%>
						<option value='<%=sizeStock.getL()%>'>L</option>
						<%
						}

						if (sizeStock.getXL() != 0) {
						%>
						<option value='<%=sizeStock.getXL()%>'>XL</option>
						<%
						}

						if (sizeStock.getXXL() != 0) {
						%>
						<option value='<%=sizeStock.getXL()%>'>XXL</option>
						<%
						}
						%>

					</select>
				</div>
				<div>
					<h5>수량 체크--</h5>
					<select name='quantity' class="quantity">
						<option value='' selected>-- 수량을 선택하세요 --</option>
					</select>
				</div>
				<%
				}
				%>
				<div class="wish_wrap">
					<div class="buttons">
						<input type="button" value="장바구니 추가" onclick="changeCommand()">
						<input type="submit" value="삭제하기">
					</div>
					<%
					}
					%>
				
			</form>

		</div>
	</div>
	<div class="footer"><%@include file="../footer/footer.jsp"%></div>
</body>
<script>
	function changeCommand() {
		$('#command').val('wishToCart');
		$('form').submit();
	}
	
	$('.size').change(e => {
		let max = $('select[name="size"]').val();//max 수량
		// Number(바꿔야하는애)
		$('.quantity').children().remove();
		$('.quantity').append('<option value="" selected>-- 수량을 선택하세요 --</option>');
		for(let i = 1; i <= max; i++) {
			$('.quantity').append('<option value='+i+'> '+i+' </option>');
		}
	
		//console.log($(e.target).children('option:selected').text());
		//console.log(e.target.children('option:selected'));
		let size =$(e.target).children('option:selected').text();
		console.log(size); 
		$('.size_result').empty();
		//$('.size_result').html('<input type="hidden" name="size_1" value="'+size+'">');asdfsdaf
		
		$('.size_result').append('<input type="hidden" name="size_1" value="' + size + '">');
	});

</script>

</html>