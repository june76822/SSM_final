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
<link rel="stylesheet" href="css/join.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<title>ONDERARMOR</title>
</head>
<body>
<%if(request.getParameter("check")!=null){ %>
<script>
alert("이미 있는 회원입니다.");
</script>
<% }%>

	<div class="wrap">
		<div class="header">
			            <%@include file="../header/header.jsp" %>
        </div>
        <div class="contants_wrap">
            <div id="join_box">
                <h1>회원가입</h1>
                <Form class="join_form" method="post" action="./action">
                <input type="hidden" name="command" value="join">
                    <Div class="input">
                        <label>ID</label><br>
                        <input type="text" placeholder="id" name="id"
                          pattern="^[a-zA-Z0-9]{5,9}"
                           required title="아이디는 5글자에서 10글자를 입력해주세요 영문 대소문자, 숫자만 입력 가능합니다">
                    </Div>
                    <Div class="input">
                        <label>PassWord</label><br>
                        <input type="password" placeholder="password" name="password"
                         pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}"
                          required title="비밀번호는 영문, 숫자, 특수문자를 조합하여 최소8자리 이상을 입력해주세요">
                    </Div>
                    <Div class="input">
                        <label>Name</label><br>
                        <input type="text" placeholder="name" name="name">
                    </Div>
                    <div class="input">
                        <label>생년월일</label><br>
                        <div class="init">
                            <input type="number" name="year" id="year" placeholder="년(4자)" pattern="{4,4}"
                            required title="생년월일은 4자리로 입력해주세요">
                            <select id="mm" class="sel" aria-label="월" name="month">
                                <option value="">월</option>
                                <option value="01">1</option>
                                <option value="02">2</option>
                                <option value="03">3</option>
                                <option value="04">4</option>
                                <option value="05">5</option>
                                <option value="06">6</option>
                                <option value="07">7</option>
                                <option value="08">8</option>
                                <option value="09">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select> <input type="text" name="day" id="day" placeholder="일" pattern=".{2,2}"
                            required title="날짜는 2자리로 입력해주세요 1일이면 01">
                        </div>
                    </div>
                     <Div class="input">
                        <label>address</label><br>
                        <input type="text" placeholder="우편번호" name="address_1" class="address_1" id="address_1" readonly>
                        <input type="button" value="우편번호 찾기" onclick="find_address()" id="find_button"> <br>
                        <input type="text" name="address_2"  class="address_2" placeholder="도로명주소" readonly><br>
                        <input type="text" name="address_3"  class="address_3" placeholder="상세주소" required="상세주소를 입력해주세요">

                    </Div>
                    <Div class="input">
                        <label>Contact</label><br>
                        <select name="contact_1" id="contact_1" required title="전화번호를 선택해주세요">
                            <option value="010">010</option>
                            <option value="010">011</option>
                            <option value="010">017</option>
                        </select> <span>-</span> <input type="number" placeholder="0000" name="contact_2" id="contact_2"
                        pattern=".{3,4}" required title="전화번호를 3자리에서 4자리 입력해주세요">
                        <span>-</span> <input type="number" placeholder="0000" name="contact_3" id="contact_3"
                        pattern=".{4,4}" required title="전화번호를 4자리 입력해주세요">
                    </Div>
                    <Div class="input">
                        <label>e_mail</label><br>
                        <input type="text" id="e_mail_1" name="e_mail_1" required title="이메일을 입력해주세요"> <span class="@"> @ </span> <input type="text"
                        id="e_mail_2" name="e_mail_2" required title="이메일을 입력해주세요"> 
                    </Div>
                    <Div class="input">
                        <label>gender</label><br>
                        <select name="gender" id="gender" required title="성별을 선택해주세요"> 
                            <option value="0">성별</option>
                            <option value="1">남자</option>
                            <option value="2">여자</option>
                        </select>
                    </Div>
                    <div class="form_submit" >
                        <input type="submit" value="회원 가입">
                    </div>
                    
                </form>
            </div>
        </div>
        <div class="footer">
		<%@include file="../footer/footer.jsp"%>
		</div>
    </div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	function find_address(){
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요..
            $('.address_1').val( data.zonecode); 
            $('.address_2').val( data.address);
        }
    }).open();
    }
</script>
</body>
</html>