package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import item.ItemDAO;
import item.ItemDTO;
import item.ListDAO;
import user.UserDTO;

public class addCartAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ItemDAO iDao = ItemDAO.getInstance();
		ListDAO lDao = ListDAO.getInstance();

		UserDTO dto = (UserDTO) request.getSession().getAttribute("members");
		String code = request.getParameter("code"); // 아이템의 코드
		ItemDTO item = iDao.getItem(code);

		// Size_1== "xl",
		// quantity
		
		String quantity = request.getParameter("quantity");
		String size = request.getParameter("size_1"); // XL, XXL

		String url = "";

		if (lDao.addCart(dto, item, quantity, size)) {
			url = "./cart_page";
		} else {
			System.out.println("addCart fail");
			url = "./detail_page?code=" + code; // 다시 코드를 가지고 돌아온다 .
		}

		response.sendRedirect(url);

	}

}
