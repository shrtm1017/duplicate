package practice.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import practice.board.service.BoardServiceImpl;
import practice.board.service.IBoardSerivce;
import practice.user.model.UserVo;
import practice.user.service.IUserService;
import practice.user.service.UserServiceImpl;


/**
 * Servlet implementation class LoginServlet
 */
// web.xml�뿉 �꽕�젙�븳 servlet-mapping�쓣 ���떊�븯�뒗 annotation
@WebServlet("/loginPage")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUserService userService;
	IBoardSerivce boardService;
	private Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
		 boardService = new BoardServiceImpl();
	}
	  
     
	

	



	// �쎒 釉뚮씪�슦�� 二쇱냼以꾩뿉 localhost/login url�쓣 �엯�젰�븯�뿬 �슂泥�
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// /login/login.jsp濡� reqyest dispatch forward
		RequestDispatcher rd = request
				.getRequestDispatcher("/logins/login.jsp");
		rd.forward(request, response);

	}

	// login.jsp sign in 踰꾪듉�쓣 �닃���쓣�븣 �슂泥� 泥섎━(濡쒓렇�씤 �슂泥� 泥섎━)
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("memId");
		String password = request.getParameter("password");
		request.setAttribute("boardAllList", boardService.boardList());
		UserVo UserVo = userService.selectUser(userId);
		if(UserVo==null){
			logger.debug("uservo = null");
			response.sendRedirect("/logins/login.jsp");
			return;
		}
		
		if (UserVo.getMem_id().equals(userId)
				&& UserVo.getMem_pass().equals((password))) {
			
			HttpSession session = request.getSession();
			session.setAttribute("userVo",UserVo);
			
			
			logger.debug("login success");
			
			RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response);
		}

		else {
			logger.debug("password wrong");
			
			response.sendRedirect("/logins/login.jsp");
		}
	}

	/**
	 * Method : getUserFromDb �옉�꽦�옄 : PC03 蹂�寃쎌씠�젰 :
	 * 
	 * @param userId
	 * @return Method �꽕紐� : db�뿉�꽌 議고쉶媛� �릺�뿀�떎怨� 媛��젙�븯怨� �엫�쓽�쓽 Uservo媛앹껜瑜� �깮�꽦/諛섑솚
	 */
	private UserVo getUserFromDb(String userId) {
		UserVo userVo = new UserVo();
		userVo.setMem_id(userId);
		userVo.setMem_pass("asdasd");
		return userVo;

	}

	

}
