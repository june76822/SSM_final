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

public class addWishAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ItemDAO iDao = ItemDAO.getInstance();
		ListDAO lDao = ListDAO.getInstance();

		UserDTO dto = (UserDTO) request.getSession().getAttribute("members");
		String code = request.getParameter("code");
		ItemDTO item = iDao.getItem(code);

		String size = request.getParameter("size");

		String url = "";
		url = "index.jsp";
		if (dto == null) {
			System.out.println("로그인 필요");
			url = "./login_page";
		} else {
			if (lDao.addWishList(dto, item, size)) {
				System.out.println("addWish done");
				url = "/wishList_page";
			} else {
				System.out.println("addWish fail");
			}
		}

		request.getRequestDispatcher(url).forward(request, response);
	}
}