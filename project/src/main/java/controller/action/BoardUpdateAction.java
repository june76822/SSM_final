package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardDTO;
import controller.Action;
import user.UserDTO;

public class BoardUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getInstance();
		BoardDTO bDto = null;

		UserDTO dto = (UserDTO) request.getSession().getAttribute("members");

		String b_code = request.getParameter("b_code");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");

		String url = "";
		if (dto == null) {
			url = "./login_page";
		}
		else {
			bDto = new BoardDTO(b_code, title, contents);
//			System.out.println("b_code"+bDto.getB_code());
			if (bDao.upDateBoard(bDto)) {
				url = "./boardview_page";
			} else {
				url = "./boardUpdate_page";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
