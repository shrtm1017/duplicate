package practice.bulletin.controller;

import java.io.IOException;
import java.util.List;

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
import practice.comment.model.commentVo;
import practice.comment.service.CommentServiceImpl;
import practice.comment.service.ICommentService;

/**
 * Servlet implementation class BulletinDetailServlet
 */
@WebServlet("/BulletinDetailServlet")
public class BulletinDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IBoardSerivce boardService;
	IBulletinSerivce bulletinService;
	ICommentService commentService;

	// private String board_no;
	@Override
	public void init() throws ServletException {
		boardService = new BoardServiceImpl();
		bulletinService = new BulletinServiceImpl();
		commentService = new CommentServiceImpl();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bulletin_no = request.getParameter("bulletin_no");
		HttpSession session = request.getSession();
		session.setAttribute("bulletin_no", bulletin_no);

		System.out.println(bulletin_no + "@@@@@@@");

		bulletinVo selectBulletinVo = bulletinService
				.selectBulletin(bulletin_no);
		request.setAttribute("selectbulletin", selectBulletinVo);
		request.setAttribute("boardAllList", boardService.boardList());
		List<commentVo> commentList = commentService.commentAll(bulletin_no);
		request.setAttribute("commentList", commentList);

		request.getRequestDispatcher("/bulletin/bulletinDetail.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
