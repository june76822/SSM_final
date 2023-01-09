<%@page import="user.UserDAO"%>
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
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>ONDERARMOR</title>
<link rel="stylesheet" href="css/myPage.css">
</head>

<body>



	<div class="wrap">
		<div class="header">
			<%@include file="../header/header.jsp" %>
			
			
		</div>
		<% 
		UserDAO dao = UserDAO.getInstance();
		//내 정보를 수정한 후 세션에 있는 정보를 바꿔주는 기능 
		UserDTO memberDto = dao.getUser(member.getMb_code());
		request.getSession().setAttribute("members", memberDto);
		//System.out.println("memberDto :"+ memberDto.getPassword());
		%>
		
		
		<div class="contants_wrap">

		

			 <h1 class="myInfo">마이페이지</h1>
		
			   
			    <div class="holeInfo">
			    
			 <div class="profile">
			    <form action="./profile_page">
			    
			    <input type="submit" class="profileButton" value="내 정보">
			    
			    </form>
			    </div>
			    
			    
			    <div class="orderHistory">
			    <form action="./orderHistory_page">
			    
			    <input type="submit" class="orderHistoryButton" value="내 주문내역">
			
			    </form>
			    
			         </div>
			    
			    
			     <div class="withList">
			    <form action="./wishList_page">
			   
			    <input type="submit" class="withListButton" value="내 위시리스트">
			    
			    </form>
			     </div>
			    
				</div> 
			    
		</div>
		<div class="footer"><%@include file="../footer/footer.jsp"%></div>
	</div>


</body>

</html>