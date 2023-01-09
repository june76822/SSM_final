
addNav();// 네비게이션 처리 


// 네비게이션 처리 
function addNav() {
	$('.nav').append(` <ul class="gnb">
    <li>
        <p class="depth1_title">
            <a href="./sales_page?cate=m_">남성</a>
        </p>
        <div class="depth2_tot_wrap">
            <div class="depth2_menu_box">
                <p class="depth2_title"><a href="./sales_page?cate=m_top_">상의</a></p>
                <ul>
                    <li><a href="./sales_page?cate=m_top_longSleeves">긴팔</a></li>
                    <li><a href="./sales_page?cate=m_top_shotSleeves">반팔</a></li>
                    <li><a href="./sales_page?cate=m_top_sweatShirt">맨투맨</a></li>
                </ul>
            </div>
            <div class="depth2_menu_box">
                <p class="depth2_title">
                    <a href="./sales_page?cate=m_Bottoms_"> 하의</a>
                </p>
                <ul>
                    <li><a href="./sales_page?cate=m_Bottoms_longPants">바지</a></li>
                    <li><a href="./sales_page?cate=m_Bottoms_shortPants">반바지</a></li>
                    <li><a href="./sales_page?cate=m_Bottoms_leggings">레깅스</a></li>
                </ul>
            </div>
        </div>
    </li>

    <li>
        <p class="depth1_title">
            <a href="./sales_page?cate=f_">
                여성
            </a>
        </p>
        <div class="depth2_tot_wrap">
        <div class="depth2_menu_box">
            <p class="depth2_title">
                <a href="./sales_page?cate=f_top_">
                    상의
                </a>
            </p>
            <ul>
                <li><a href="./sales_page?cate=f_top_longSleeves">긴팔</a></li>
                <li><a href="./sales_page?cate=f_top_shotSleeves">반팔</a></li>
                <li><a href="./sales_page?cate=f_top_sweatShirt">맨투맨</a></li>
            </ul>
        </div>
        <div class="depth2_menu_box">
            <p class="depth2_title">
                <a href="./sales_page?cate=f_Bottoms_">
                    하의
                </a>
            </p>
            <ul>
                <li><a href="./sales_page?cate=f_Bottoms_longPants">바지</a></li>
                <li><a href="./sales_page?cate=f_Bottoms_shortPants">반바지</a></li>
                <li><a href="./sales_page?cate=f_Bottoms_leggings">레깅스</a></li>
            </ul>
        </div>
        </div>
    </li>
    
</ul>`);
}

function logAlert() {
	alert("로그인 후 이용해주세요.");
	location.href = "./login_page";
}


