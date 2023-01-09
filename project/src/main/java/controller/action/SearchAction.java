package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import item.ItemDAO;
import item.ItemDTO;
import user.UserDAO;

public class SearchAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		
		String url = "./sales_page?keyword="+keyword; 
		
		response.sendRedirect(url);
		
	}

}
