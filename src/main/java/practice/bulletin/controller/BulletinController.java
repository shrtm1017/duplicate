package practice.bulletin.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import practice.board.model.boardVo;
import practice.board.service.IBoardSerivce;
import practice.bulletin.model.bulletinVo;
import practice.bulletin.service.IBulletinSerivce;
import practice.util.model.pageVo;
@RequestMapping("/bulletin")
@Controller
public class BulletinController {
	@Resource(name="bulletinService")
	private IBulletinSerivce bulletinService;
	
	@Resource(name="boardService")
	private IBoardSerivce boardService;
	
	@RequestMapping(path= {"/freeboard"},method= {RequestMethod.GET})
	public String freeboard(boardVo boardVo , bulletinVo bulletinvo,Model model,pageVo pageVo) {
		
		Map<String, Object> resultMap = bulletinService.BulletinPagingList(pageVo);
		model.addAllAttributes(resultMap);
		model.addAttribute("pageSize",pageVo.getPageSize());
		model.addAttribute("page",pageVo.getPage());
		model.addAttribute("board_no",boardVo.getBoard_no());
		
		return "/board/freeboard2";
		
	}
	@RequestMapping("/freeboardView")
	public String userPagingListAjaxView(pageVo pageVo, Model model) {
		return "freeboard";
	}

}
