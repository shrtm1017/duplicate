package practice.board.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import practice.board.model.boardVo;
import practice.board.service.IBoardSerivce;
@RequestMapping("/board")
@Controller
public class BoardController {
	@Resource(name="boardService")
	private IBoardSerivce boardSerivce;
	

@RequestMapping(path={"/makeMenu"},method= {RequestMethod.GET})
	public String viewMenu(Model model) {
		model.addAttribute("boardAllList",boardSerivce.boardList());
		return "createBoard";
	}
@RequestMapping(path= {"/makeMenu"},method= {RequestMethod.POST})
	public String makeMenu(boardVo boardvo,Model model, HttpServletResponse response,HttpServletRequest request) throws IOException {
		int insertBoard = boardSerivce.insertBoard(boardvo);
		model.addAttribute("boardAllList",boardSerivce.boardList());
		
	if(insertBoard ==1) {
		response.sendRedirect(request.getContextPath()+"/board/makeMenu");
	}
	return "main";
	}
@RequestMapping(path= {"/updateMenu"},method= {RequestMethod.POST})
	public String updateMenu(boardVo boardvo,Model model) {
		int updateBoard = boardSerivce.updateBoatd(boardvo);
		model.addAttribute("boardAllList",boardSerivce.boardList());
		return "createBoard";
	
}

//@RequestMapping(path= {"/bulletinPagingList"},method= {RequestMethod.POST})
//	public String bulletinPagingList () {
//		return null;
//	
//}
	

}
