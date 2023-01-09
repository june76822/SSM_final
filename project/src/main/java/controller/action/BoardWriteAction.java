package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardDTO;
import controller.Action;
import user.UserDTO;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getInstance();
		BoardDTO bDto = null;

		UserDTO dto = (UserDTO) request.getSession().getAttribute("members");

		String b_code = request.getParameter("b_code");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");

		String url = "";

		String mb_code = dto.getMb_code();
		bDto = new BoardDTO(b_code, mb_code, title, contents);
		if (bDao.addBoard(bDto)) {
			url = "./board_page";
		} else {
			url = "./boardWrite_page";
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

}
