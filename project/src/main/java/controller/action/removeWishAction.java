package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import item.ListDAO;
import user.UserDTO;

public class removeWishAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ListDAO lDao = ListDAO.getInstance();

		UserDTO dto = (UserDTO) request.getSession().getAttribute("members");
		String[] wishItemCode = request.getParameterValues("wishItem_code");

		String url = "./wishList_page"; // 주문내역 페이지로 이동

		if (dto == null) {
			url = "./login_page";
		} else {
			if (lDao.removeWishItem(wishItemCode)) {
				System.out.println("remove done");
			} else {
				System.out.println("remove fail");
			}
		}

		request.getRequestDispatcher(url).forward(request, response);

	}
}
