package practice.comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import practice.comment.model.commentVo;

public interface ICommentDao {
	List<commentVo> getCommentAll (SqlSession openSession,String bullentin_no);
	int insertComment (SqlSession openSession,commentVo vo);
	int deleteComment (SqlSession openSession,commentVo vo);

}
