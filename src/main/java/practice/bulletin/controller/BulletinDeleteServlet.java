package practice.bulletin.controller;

import java.io.IOException;

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
 * Servlet implementation class BulletinDeleteServlet
 */
@WebServlet("/BulletinDeleteServlet")
public class BulletinDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IBoardSerivce boardService;
	IBulletinSerivce bulletinService;

	// private String board_no;
	@Override
	public void init() throws ServletException {
		boardService = new BoardServiceImpl();
		bulletinService = new BulletinServiceImpl();
	}
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session =  request.getSession();
		
		String mem_id = request.getParameter("delete_memId");
	
		String bulletin_no = (String) session.getAttribute("bulletin_no");
		String board_no = (String) session.getAttribute("board_no");
		bulletinVo vo = new bulletinVo();
		vo.setBulletin_no(bulletin_no);
		vo.setMem_id(mem_id);
		vo.setBoard_no(board_no);
		vo.setBulletin_del_check("del");
		int deleteBulletin=  bulletinService.deleteBulletin(vo);
		if (deleteBulletin == 1) {
			response.sendRedirect("/pagingboardservlet?"+"board_no="+board_no);
		} else {
			doGet(request, response);
		}
		
	}

}
