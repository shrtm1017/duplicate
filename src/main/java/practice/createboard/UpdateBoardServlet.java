package practice.createboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.board.model.boardVo;
import practice.board.service.BoardServiceImpl;
import practice.board.service.IBoardSerivce;

/**
 * Servlet implementation class updateBoardServlet
 */
@WebServlet("/updateBoardServlet")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IBoardSerivce boardService;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/CreateBoardServlet");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String board_no = request.getParameter("updateBoard");
		String board_check = request.getParameter("selectBox2");
		String board_title = request.getParameter("listBoard");
		boardVo vo = new boardVo();
		System.out.println(board_check);
		System.out.println(board_title );
		vo.setBoard_check(board_check);
		vo.setBoard_no(board_no);
		vo.setBoard_title(board_title);
		int updateBoatd = boardService.updateBoatd(vo);
		if (updateBoatd == 1) {
			response.sendRedirect(request.getContextPath()
					+ "/CreateBoardServlet");
		} else {
			doGet(request, response);
		}
	}

	@Override
	public void init() throws ServletException {
		boardService = new BoardServiceImpl();
	}

}
