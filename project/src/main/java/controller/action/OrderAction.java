package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import item.ItemDAO;
import item.ListDAO;
import user.UserDTO;

public class OrderAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListDAO lDao = ListDAO.getInstance();
		ItemDAO iDao = ItemDAO.getInstance();

		UserDTO dto = (UserDTO) request.getSession().getAttribute("members");
		String[] orderItemCode = request.getParameterValues("cartItem_code");

		// 주문정보 form

//		String name = getParameter로 빼옴
//		String add = dto로 빼옴;
//		String contact = dto로 빼옴;

//		ListDAO addorder 로 dto, name, orderItemCode를 보내줌
//
//		order
//		1. 랜덤코드
//		2. dto.getMb_Code
//		3. time
//		4. name
//		5. dto.getAdd
//		6. dto.getContact
//		
//		orderItemList
//		for문(orderItemCode 사이즈 만큼){
//		1. 랜덤코드
//		2. 1에서 만든 랜덤코드 그대로 넣어줌
//		3. orderItemCode의 코드
//		------
//		4,5,6. cartItemList에서 SELECT문을 돌려서
//		orderItemCode[i],dto.getMb_code가 일치하는 아이템의
//		사이즈, 컬러, 숫자를 받아와서 넣어준 후
//		해당 아이템의 code를 사용해서 cartItemList에서 삭제해줌
//		}

		String url = "index.jsp"; // 주문내역 페이지로 이동
		String orderCode = "";

		if (dto == null) {
			url = "./login_page";
		} else {
			orderCode = lDao.addOrder(dto, orderItemCode);
			if (orderCode != null) {
				url = "/orderResult_page?code=" + orderCode;
				System.out.println("Order done");
			} else {
				url = "/cart_page";
				System.out.println("Order fail");
			}
		}

		request.getRequestDispatcher(url).forward(request, response);
	}
}