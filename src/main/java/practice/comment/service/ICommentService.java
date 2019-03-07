package practice.comment.service;

import java.util.List;

import practice.comment.model.commentVo;

public interface ICommentService {
	List<commentVo>commentAll(String bullentin_no);
	int insertComment (commentVo vo);
	int deleteComment (commentVo vo);
}
