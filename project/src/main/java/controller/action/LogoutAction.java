package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import controller.Action;
import user.UserDAO;
import user.UserDTO;

public class LogoutAction implements Action  {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubasdfsdafsda
		
		
		
		
		
		request.getSession().setAttribute("members", null);
		
		String url="";
		url = "index.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}
