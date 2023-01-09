package controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import user.UserDAO;
import user.UserDTO;

public class ModifyProfileAction implements Action{

	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO dao=UserDAO.getInstance();
		UserDTO user=null;
		
		
		
		
		String mb_code =request.getParameter("mb_code");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String contact=request.getParameter("contact");
		String email=request.getParameter("email");
		int gender=Integer.parseInt(request.getParameter("gender"));
		
		String address_1=request.getParameter("address_1");
		String address_2=request.getParameter("address_2");
		String address_3=request.getParameter("address_3");
		
		String address=address_1+"/"+address_2+"/"+address_3;

		String birth_1=request.getParameter("birth_1");
		String birth_2=request.getParameter("birth_2");
		String birth_3=request.getParameter("birth_3");
		
		String birth_=birth_1+"-"+birth_2+"-"+birth_3+" 00:00:00.0";
		
		Timestamp birth=Timestamp.valueOf(birth_);

		String  url="";
		
		user = new UserDTO(mb_code ,password, name, contact, email, gender, address, birth);
		
		if(dao.modifyProfile(user)) {
			System.out.println("마이페이지로이동");
			url="./myPage_page";
			request.getRequestDispatcher(url).forward(request, response);
		}
		else {
			System.out.println("프로필페이지");
			url="./profile_page";
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}

}
