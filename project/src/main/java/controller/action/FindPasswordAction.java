package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import user.UserDAO;
import user.UserDTO;

public class FindPasswordAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO uDao = UserDAO.getInstance();

		
		String id = request.getParameter("id");
		UserDTO dto = (UserDTO) request.getSession().getAttribute("members");
		String url = "";

		

			if (uDao.CheckId(id)) {
				System.out.println("성공");
				url = "./phoneCheck_page";
			
			} else {
				System.out.println("아이디 불일치");
				url = "./findPassword_page?checkFail=checkFail";
			}

	
		request.getRequestDispatcher(url).forward(request, response);

	
		
	}

}
