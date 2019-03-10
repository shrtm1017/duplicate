package practice.login;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import practice.board.service.IBoardSerivce;
import practice.encrypt.kisa.sha256.KISA_SHA256;
import practice.user.model.UserVo;
import practice.user.service.IUserService;
@Controller
public class LoginPage {
	@Resource(name="userService")
	private IUserService userService;
	@Resource(name="boardService")
	private IBoardSerivce boardService;
	
	@RequestMapping(path= {"/loginPage"},method={RequestMethod.GET})
	public String loginView() {
		return "/login/login";
	}
	
		@RequestMapping(path= {"/loginPage"},method={RequestMethod.POST})
		public String mainView(UserVo userVo,HttpSession session,Model model) {
     			UserVo loginUser = userService.selectUser(userVo.getMem_id());
			
			if(loginUser.getMem_id().equals(userVo.getMem_id())&&
					loginUser.getMem_pass().equals(KISA_SHA256.encrypt(userVo.getMem_pass()))) {
				model.addAttribute("boardAllList",boardService.boardList());
				session.setAttribute("userVo", loginUser);
				
				return "main";
			}else
				
			
			return "/login/login";
			
		}
	}

