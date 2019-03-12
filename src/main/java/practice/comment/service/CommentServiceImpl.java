package practice.comment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import practice.comment.dao.ICommentDao;
import practice.comment.model.commentVo;
@Service("commentService")
public class CommentServiceImpl implements ICommentService{
@Resource(name="commentDao")
private ICommentDao commentDao;
	public CommentServiceImpl(){
}

	@Override
	public List<commentVo> commentAll(String bullentin_no) {
		List<commentVo> commentAll=commentDao.getCommentAll(bullentin_no);
		return commentAll;
	}

	@Override
	public int insertComment(commentVo vo) {
		int commentVo= commentDao.insertComment(vo);
		return commentVo;
	}

	@Override
	public int deleteComment(commentVo vo) {
		int commentVo= commentDao.deleteComment( vo);
		return commentVo;
	}

}


