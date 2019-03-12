package practice.comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import practice.comment.model.commentVo;

public interface ICommentDao {
	List<commentVo> getCommentAll (String bullentin_no);
	int insertComment (commentVo vo);
	int deleteComment (commentVo vo);

}
