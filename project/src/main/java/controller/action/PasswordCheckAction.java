package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import user.UserDTO;

public class PasswordCheckAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		UserDTO dto = (UserDTO) request.getSession().getAttribute("members");
		String password = request.getParameter("password");
		String url="";
		if(dto.getPassword().equals(password)) {
			url="./myPage_page";
		}else {
			url="index.jsp?myPageFail=myPageFail";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
