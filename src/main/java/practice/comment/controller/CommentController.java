package practice.comment.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import practice.comment.model.commentVo;
import practice.comment.service.ICommentService;


@Controller
public class CommentController {
@Resource(name="commentService")	
private ICommentService commentService;
@RequestMapping(path= {"/comment"},method= {RequestMethod.POST})
public String comment(commentVo cvo,HttpSession session,Model model,HttpServletResponse resp,HttpServletRequest req) throws IOException {
	List<commentVo> commentList =commentService.commentAll(cvo.getBulletin_no());
	model.addAttribute("commentList",commentList);
	int insertComment =commentService.insertComment(cvo);

	if(insertComment==1) {
		resp.sendRedirect(req.getContextPath()+"/bulletin/detailBulletin?bulletin_no="+cvo.getBulletin_no());
	}
	return "commentView";
	
	}
@RequestMapping(path= {"/commentDelete"},method= {RequestMethod.POST})
public String commentDelete(commentVo cvo,HttpSession session,Model model,HttpServletResponse resp,HttpServletRequest req) throws IOException {
	List<commentVo> commentList =commentService.commentAll(cvo.getBulletin_no());
	model.addAttribute("commentList",commentList);
	cvo.setCmt_del_check("y");
	int deleteComment =commentService.deleteComment(cvo);

	if(deleteComment==1) {
		resp.sendRedirect(req.getContextPath()+"/bulletin/detailBulletin?bulletin_no="+cvo.getBulletin_no());
		}
	return "commentView";
	}
}
