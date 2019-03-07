package practice.createboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.board.model.boardVo;
import practice.board.service.BoardServiceImpl;
import practice.board.service.IBoardSerivce;

/**
 * Servlet implementation class CreateBoardServlet
 */
@WebServlet("/CreateBoardServlet")
public class CreateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       IBoardSerivce boardService;
	@Override
	public void init() throws ServletException {
		boardService = new BoardServiceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("boardAllList", boardService.boardList());
		RequestDispatcher rd = request
				.getRequestDispatcher("/board/createBoard.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String boardTitle = request.getParameter("board_title");
		String select_option= request.getParameter("selectBox");
		boardVo vo  = new boardVo();
		vo.setBoard_title(boardTitle);
		vo.setBoard_check(select_option);
		int board = boardService.insertBoard(vo);
		if(board == 1){
		response.sendRedirect(request.getContextPath()+"/CreateBoardServlet");
		}else{
			doGet(request, response);
		}
	
		
	}

	

}
