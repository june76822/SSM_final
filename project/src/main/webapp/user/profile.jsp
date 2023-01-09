<%@page import="user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">


<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/main.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>ONDERARMOR</title>
<link rel="stylesheet" href="css/profile.css">
</head>

<body>

	<div class="wrap">
		<div class="header">
			<%@include file="../header/header.jsp"%>
		</div>
		<div class="contants_wrap">
			<%
			String fullAddress[] = member.getAddress().split("/");
			%>
			<div class="myName"><%=member.getName()%>님 반갑습니다.
			</div>
			<form method="post" action="./action">
				<input type="hidden" name="command" value="modifyProfile"> <input
					type="hidden" name="mb_code" value="<%=member.getMb_code()%>">

				<div class="holeInfo">

					<div class="password">
						<p>비밀번호</p>
						<input type="password" name="password"
							pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}"
							required title="비밀번호는 영문, 숫자, 특수문자를 조합하여 최소8자리 이상을 입력해주세요"
							value="<%=member.getPassword()%>">
					</div>

					<div class="name">
						<p>이름</p>
						<input type="text" name="name" value="<%=member.getName()%>">
					</div>

					<div class="contact">
						<p>연락처</p>
						<input type="text" name="contact" value="<%=member.getContact()%>">
					</div>

					<div class="email">
						<p>이메일</p>
						<input type="text" name="email" value="<%=member.getEmail()%>">
					</div>

					<div class="gender">
						<p>성별</p>
						<select name="gender">
							<%
							if (member.getGender() == 1) {
							%>
							<option value="1">남자</option>
							<option value="2">여자</option>
							<%
							} else {
							%>
							<option value="2">여자</option>
							<option value="1">남자</option>
							<%
							}
							%>
						</select>
					</div>

					<div class="fullAddress">
						<div class="address_1">
							<p>우편번호</p>
							<input type="text" placeholder="우편번호" name="address_1"
								class="address_1" value="<%=fullAddress[0]%>" readonly>
							<input type="button" value="우편번호 찾기" onclick="find_address()"
								id="find_button" readonly>
						</div>
						<div class="address_2">
							<p>기본주소</p>
							<input type="text" name="address_2" class="address_2"
								placeholder="기본주소" value="<%=fullAddress[1]%>" readonly>
						</div>
						<div class="address_3">
							<p>상세주소</p>
							<input type="text" value="<%=fullAddress[2]%>" name="address_3"
								class="address_3" placeholder="상세주소" required="상세주소를 입력해주세요">
						</div>
					</div>

					<div class="birth">
						<p>생년월일</p>
						<input type="text" name="birth_1"
							value="<%=String.valueOf(member.getBirth()).substring(0, 4)%>">
						<span>-</span><input type="text" name="birth_2"
							value="<%=String.valueOf(member.getBirth()).substring(5, 7)%>">
						<span>-</span><input type="text" name="birth_3"
							value="<%=String.valueOf(member.getBirth()).substring(8, 10)%>">
					</div>
			</form>
			<div class="buttons_">
				<form action="./myPage_page">
					<input type="submit" value="뒤로 가기" class="cancle">
				</form>

				<div class="buttons">
					<input type="submit" value="변경 사항 저장" class="update">

				</div>


				<form action="./deleteMember_page">
					<input type="submit" value="회원 탈퇴하기" class="delete">
				</form>
			</div>

		</div>
	</div>





	<div class="footer"><%@include file="../footer/footer.jsp"%></div>
	</div>

	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		function find_address() {
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
					// 예제를 참고하여 다양한 활용법을 확인해 보세요.
					$('.address_1').val(data.zonecode);
					$('.address_2').val(data.address);
				}
			}).open();
		}
	</script>
</body>


</html>