package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import controller.Action;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String b_code = request.getParameter("b_code");
		BoardDAO board = BoardDAO.getInstance();

		String url = "";

		if (board.delete(b_code)) {
			System.out.println("삭제가 됐는데!");
			url = "./board_page";
		} else {
			url = "./boardview_page";
			System.out.println("삭제가 안됐는데!");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
