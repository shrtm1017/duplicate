package practice.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import practice.comment.model.commentVo;
import practice.comment.service.CommentServiceImpl;
import practice.comment.service.ICommentService;

/**
 * Servlet implementation class commentDeleteServlet
 */
@WebServlet("/commentdeleteservlet")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICommentService commentService;

	@Override
	public void init() throws ServletException {
		commentService = new CommentServiceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String deleteCmt = request.getParameter("cmtdelete");
		String mem_id = request.getParameter("mem_id");
		String bulletin_no =(String) session.getAttribute("bulletin_no");
		String cmt_no = request.getParameter("cmt_no");
		commentVo vo = new commentVo();
		vo.setCmt_del_check(deleteCmt);
		vo.setBoard_no(bulletin_no);
		vo.setMem_id(mem_id);
		vo.setCmt_no(cmt_no);
		int deleteComment = commentService.deleteComment(vo);
		if( deleteComment  ==1){
			response.sendRedirect("/BulletinDetailServlet?bulletin_no="+bulletin_no);
		}else{
			doGet(request, response);
		}
		
//		request.getRequestDispatcher("/bulletin/bulletinDetail.jsp").forward(request, response);
	}

}
