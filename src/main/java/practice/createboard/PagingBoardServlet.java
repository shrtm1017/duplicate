package practice.createboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import practice.board.service.BoardServiceImpl;
import practice.board.service.IBoardSerivce;
import practice.bulletin.model.bulletinVo;
import practice.bulletin.service.BulletinServiceImpl;
import practice.bulletin.service.IBulletinSerivce;

/**
 * Servlet implementation class freeBoardServlet
 */
@WebServlet("/pagingboardservlet")
public class PagingBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IBoardSerivce boardService;
    IBulletinSerivce bulletinService; 
	@Override
	public void init() throws ServletException {
		boardService = new BoardServiceImpl();
		bulletinService = new BulletinServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bulletinVo vo =new bulletinVo();
		String board_no =request.getParameter("board_no");
		System.out.println("board_no"+board_no);
		List<bulletinVo>  bulletin = bulletinService.bulletinReply(board_no);
		for (int i = 0; i < bulletin.size(); i++) {
			vo.setGroup_no(bulletin.get(i).getGroup_no());
			vo.setBoard_no(board_no);
			bulletinService.updateLevel(vo);
		}
		List<bulletinVo>  bulletin2 = bulletinService.bulletinReply(board_no);
		
		
		System.out.println("vo.getGroup_no()"+vo.getGroup_no());
		
		HttpSession session =  request.getSession();
		session.setAttribute("board_no",board_no);
		request.setAttribute("bulletin", bulletin2);
		request.setAttribute("boardAllList", boardService.boardList());
		RequestDispatcher rd = request.getRequestDispatcher("/board/freeboard.jsp");
		rd.forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/pagingboardservlet?board_no="+board_no);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		
	}

}
