<%@page import="item.StockDAO"%>
<%@page import="item.StockDTO"%>
<%@page import="item.ItemDTO"%>
<%@page import="item.ItemDAO"%>
<%@page import="user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/detail.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>ONDERARMOR</title>
</head>
<body>
	<%
	ItemDAO dao = ItemDAO.getInstance();
	String itemCode = request.getParameter("code");
	ItemDTO thisItem = dao.getItem(itemCode);
	StockDTO sizeStock = StockDAO.getInstance().getStock(itemCode);
	%>

	<div class="wrap">
		<div class="header">
			<%@include file="../header/header.jsp"%>
		</div>
		<div class="contants_wrap">
		<div class="contants_detail">
			<div class="detail_img">
				<img alt="" src="<%=thisItem.getImage()%>">
			</div>
			
			<div class="detail_text">
				<form method="get" action="./action">
					<input type="hidden" id="command" name="command" value="addCart">
					<input type="hidden" id="code" name="code" value="<%= itemCode%>">
					<div class="size_result">
					
					</div>
					<div class="detail_item_name"><h2><%=thisItem.getName()%></h2></div>
					<div class="detail_text_text"> <h5>상세설명</h5><%=thisItem.getDes() %></div>
					<div class="size_select"><h5>사이즈</h5>
						<select name='size' class="size">
							<option selected>-- 사이즈를 선택하세요 --</option>
							
							<%if(sizeStock.getXS() !=0){ %>
							<option value="<%=sizeStock.getXS()%>"><div class="asefasdfsfda">XS</div></option>
							<%}
							
							if(sizeStock.getS() !=0){  %>
							<option value="<%=sizeStock.getS()%>">S</option>	
							<%}
							
							if(sizeStock.getM() !=0){ %>
							<option value='<%=sizeStock.getM()%>'>M</option>
							<%}
							
							if(sizeStock.getL() !=0){ %>
							<option value='<%=sizeStock.getL()%>'>L</option>
							<%}
							
							if(sizeStock.getXL() !=0){ %>
							<option value='<%=sizeStock.getXL()%>'>XL</option>
							<%}
							
							if(sizeStock.getXXL() !=0){ %>
							<option value='<%=sizeStock.getXL()%>'>XXL</option>
							<%} %>

						</select>
					</div>
						<div class="quantity_check">
						<h5>수량 체크</h5>
						 <select name='quantity' class="quantity">
							<option value='' selected>-- 수량을 선택하세요 --</option>
							
						</select>
						</div>
					

					
						<div class="buttons">
							<%if(member == null){%>
								<button type="button" onclick=logAlert()>장바구니 추가</button>
							<%}else{%>
							<input type="submit" value="장바구니 추가">
							<button type="button" onclick="changeCommand()">위시리스트 추가</button>
							<%} %>
						
					</div>
				</form>
				</div>
				</div>
			</div>
			
		</div>
	
	<div class="footer"><%@include file="../footer/footer.jsp"%></div>
</body>
<script>
	//console.log($('.test_wrap').html());
	//console.log($('.wrap').html());

	function changeCommand() {
		$('#command').val('addWish');
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