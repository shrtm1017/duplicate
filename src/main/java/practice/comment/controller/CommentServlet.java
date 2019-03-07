package practice.comment.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICommentService commentService;

	@Override
	public void init() throws ServletException {
		commentService = new CommentServiceImpl();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		String mem_id = request.getParameter("mem_id");

		String bulletin_no = (String) session.getAttribute("bulletin_no");
		String board_no = (String) session.getAttribute("board_no");
		String cmt_save = request.getParameter("commentsave");
		commentVo vo = new commentVo();
		vo.setBoard_no(bulletin_no);
		vo.setMem_id(mem_id);
		vo.setCmt_content(cmt_save);
		vo.setCmt_del_check("del");
		List<commentVo> commentList = commentService.commentAll(vo.getBoard_no());
		request.setAttribute("commentList", commentList);
		int insertComment = commentService.insertComment(vo);

		if (insertComment == 1) {
			response.sendRedirect("/BulletinDetailServlet?bulletin_no="+bulletin_no);
		} else {
			
			doGet(request, response);
		}
	}

}
