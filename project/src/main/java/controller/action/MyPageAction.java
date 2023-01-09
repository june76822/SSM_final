package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import user.UserDAO;
import user.UserDTO;

public class MyPageAction implements Action  {

	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		

		
	
		
		

		
		String url="";
		
		
		
		url = "./myPage_page";
		request.getRequestDispatcher(url).forward(request, response);
		
		
		
		
		
		
	
	
		
	}
}
