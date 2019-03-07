package practice.bulletin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
import practice.file.model.fileVo;
import practice.file.service.FileSerivceImpl;
import practice.file.service.IFileSerivce;
import practice.user.model.UserVo;

/**
 * Servlet implementation class freeBoardServlet
 */
@WebServlet("/BulletinServlet")
@MultipartConfig(maxFileSize=5 * 1024 *1024, maxRequestSize=5*5 * 1024 *1024)
public class BulletinServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    IBoardSerivce boardService;
    IBulletinSerivce bulletinService;
    IFileSerivce fileService;
//    private String board_no;
	@Override
	public void init() throws ServletException {
		boardService = new BoardServiceImpl();
		bulletinService = new BulletinServiceImpl();
		fileService = new FileSerivceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.sendRedirect(request.getContextPath()+"/pagingboardservlet?board_no="+board_no);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		bulletinVo vo = new bulletinVo();
		fileVo fileVo = new fileVo();
		
		HttpSession session = request.getSession();
		String board_no = (String) session.getAttribute("board_no");
		String file_title = request.getParameter("uploadFile");
		UserVo attribute = (UserVo) session.getAttribute("userVo");
		String mem_id = attribute.getMem_id();
		
		String bulletin_title = request.getParameter("bulletin_title");
		String bulletin_content = request.getParameter("smarteditor");
		System.out.println(bulletin_content);
		
		vo.setBoard_no(board_no);
		vo.setBulletin_content(bulletin_content);
		vo.setBulletin_title(bulletin_title);
		vo.setMem_id(mem_id);
		int insertVo = bulletinService.insertBulletin(vo);
		
		
		fileVo.setFile_title(file_title);
		fileVo.setBulletin_no(vo.getBulletin_no());
		int insertFileVo = fileService.insertBoard(fileVo);
		
		if (insertVo == 1) {
			response.sendRedirect("/pagingboardservlet?"+"board_no="+board_no);
		} else {
			doGet(request, response);
		}
		
		
		
//		RequestDispatcher rd = request.getRequestDispatcher("/board/freeboard.jsp"); rd.forward(request, response);
	
		
		
		
	}

}
