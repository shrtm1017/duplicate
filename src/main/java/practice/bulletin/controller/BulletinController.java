package practice.bulletin.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import practice.board.model.boardVo;
import practice.board.service.IBoardSerivce;
import practice.bulletin.model.bulletinVo;
import practice.bulletin.service.IBulletinSerivce;
import practice.comment.service.ICommentService;
import practice.util.model.pageVo;

@RequestMapping("/bulletin")
@Controller
public class BulletinController {
	@Resource(name = "bulletinService")
	private IBulletinSerivce bulletinService;

	@Resource(name = "boardService")
	private IBoardSerivce boardService;

	@Resource(name="commentService")	
	private ICommentService commentService;
	
	@RequestMapping(path = { "/freeboard" }, method = { RequestMethod.GET })
	public String freeboard(boardVo boardVo, bulletinVo bulletinVo, Model model, pageVo pageVo,HttpSession session) {
		String board_no =(String) session.getAttribute("board_no");
		pageVo.setBoard_no(board_no);
		Map<String, Object> resultMap = bulletinService.bulletinReply(pageVo);
		model.addAllAttributes(resultMap);
		model.addAttribute("pageSize", pageVo.getPageSize());
		model.addAttribute("page", pageVo.getPage());


		return "/board/freeboardAjax";

	}

	@RequestMapping("/freeboardView")
	public String freeboardView(bulletinVo bulletinVo, boardVo boardVo, pageVo pageVo, Model model,
			HttpSession session) {
		session.setAttribute("board_no", boardVo.getBoard_no());
		model.addAttribute("boardAllList", boardService.boardList());
		model.addAttribute("board_no", boardVo.getBoard_no());
		model.addAttribute("mem_id", session.getAttribute("userVo"));
	
		return "freeboard";
	}

	@RequestMapping(path = { "/detailBulletin" }, method = { RequestMethod.GET })
	public String detailBulletin(bulletinVo bulletin_no,Model model) {
		model.addAttribute("boardAllList", boardService.boardList());
		model.addAttribute("selectBulletinList",bulletinService.selectBulletin(bulletin_no.getBulletin_no()));
		model.addAttribute("commentList", commentService.commentAll(bulletin_no.getBulletin_no()));
		return "detailBulletin";

	}

	@RequestMapping("/createBulletin")
	public String createBulletin(Model model, boardVo boardVo) {
		model.addAttribute("boardAllList", boardService.boardList());
		model.addAttribute("board_no", boardVo.getBoard_no());
		return "createBulletin";

	}

	@RequestMapping(path = { "/createBulletin" }, method = { RequestMethod.POST })
	public String registerBulletin(Model model, bulletinVo bulletinVo, boardVo boardVo) {
		model.addAttribute("boardAllList", boardService.boardList());
		bulletinService.insertBulletin(bulletinVo);
		return "freeboard";

	}
	@RequestMapping(path = { "/updateBulletin" }, method = { RequestMethod.GET })
	public String updateBulletin(Model model, bulletinVo bulletinVo) {
		model.addAttribute("boardAllList", boardService.boardList());
		model.addAttribute("selectBulletinList",bulletinService.selectBulletin(bulletinVo.getBulletin_no()));
		return "updateBulletin";

	}
	@RequestMapping(path = { "/updateBulletin" }, method = { RequestMethod.POST })
	public String updateBulletinView(Model model, bulletinVo bulletinVo,HttpServletResponse response,HttpServletRequest request) throws IOException {
		model.addAttribute("boardAllList", boardService.boardList());
		int updateBulletin =bulletinService.updateBulletin(bulletinVo);
		if(updateBulletin==1){
			response.sendRedirect(request.getContextPath()+"/bulletin/freeboardView");
		}	
		return "updateBulletin";

	}
	@RequestMapping(path = { "/deleteBulletin" }, method = { RequestMethod.POST })
	public String deleteBulletin(Model model, bulletinVo bulletinVo) {
		model.addAttribute("boardAllList", boardService.boardList());
		bulletinVo.setBulletin_del_check("del");
		bulletinService.deleteBulletin(bulletinVo);
		return "freeboard";

	}
	@RequestMapping(path = { "/bulletinReply" }, method = { RequestMethod.GET })
	public String bulletinReply(Model model, bulletinVo bulletinVo) {
		model.addAttribute("boardAllList", boardService.boardList());
		model.addAttribute("bulletinList",bulletinService.selectBulletin(bulletinVo.getBulletin_no()));
		return "replyBulletin";

	}
	@RequestMapping(path = { "/bulletinReply" }, method = { RequestMethod.POST })
	public String bulletinReplyView(Model model, bulletinVo bulletinVo,HttpServletResponse response,HttpServletRequest request) throws IOException {
		model.addAttribute("boardAllList", boardService.boardList());
		bulletinVo.setBulletin_no2(bulletinVo.getBulletin_no());
		int replyBulletin = bulletinService.insertBulletin(bulletinVo);
		if(replyBulletin==1){
			response.sendRedirect(request.getContextPath()+"/bulletin/freeboardView?board_no="+bulletinVo.getBoard_no());
		}	
		return "replyBulletin";
	}
//	@RequestMapping(path = { "/bulletinReplyView" }, method = { RequestMethod.GET })
//	public String bulletinReplyView(Model model, bulletinVo bulletinVo,boardVo board_no) {
//		model.addAttribute("bulletinList",bulletinService.selectBulletin(bulletinVo.getBulletin_no()));
//		return "replyBulletin";
//
//	}
	
}
