package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import user.UserDAO;
import user.UserDTO;

public class JoinAction  implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao=UserDAO.getInstance();
		UserDTO user=null;
		
		
		String contact_1=request.getParameter("contact_1");
		String contact_2=request.getParameter("contact_2");
		String contact_3=request.getParameter("contact_3");
		
		String e_mail_1=request.getParameter("e_mail_1");
		String e_mail_2=request.getParameter("e_mail_2");
		
		int year=Integer.parseInt( request.getParameter("year"));
		int month=Integer.parseInt( request.getParameter("month"));
		int day=Integer.parseInt( request.getParameter("day"));
		
		
		

		String id=request.getParameter("id");
		
		String password=request.getParameter("password");
		
		String name=request.getParameter("name");
		
		String contact=contact_1+contact_2+contact_3;
		
		String email=e_mail_1+"@"+e_mail_2;
		
		int gender=Integer.parseInt(request.getParameter("gender"));

		
		String address_1=request.getParameter("address_1");
		String address_2=request.getParameter("address_2");
		String address_3=request.getParameter("address_3");
		
		String address=address_1+"/"+address_2+"/"+address_3;
		System.out.println("address : "+ address);
		
		

		
		
		
		user = new UserDTO(id, password, name, contact, email, gender, address, year, month, day);
		
		String url="";
		if(dao.joinMember(user)) {
			
			url="./login_page?success=success";
		}else {
			System.out.print("ddddddddd");
			url="./join_page?check=check";

			
		

		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
}
