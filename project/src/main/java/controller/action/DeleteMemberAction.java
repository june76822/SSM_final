package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import user.UserDAO;
import user.UserDTO;

public class DeleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO uDao = UserDAO.getInstance();

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		UserDTO dto = (UserDTO) request.getSession().getAttribute("members");
		String url = "";

		if (dto.getId().equals(id) && dto.getPassword().equals(password)) {

			if (uDao.deleteMember(id, password)) {
			
				url = "index.jsp?deleteSuccess=deleteSuccess";
				request.getSession().setAttribute("members", null);
			} else {
				
				url = "./deleteMember_page?deleteFail=deleteFail";
			}

		} else {
		
			url = "./deleteMember_page?deleteFail=deleteFail";

		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}