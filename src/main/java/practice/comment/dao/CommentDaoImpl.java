package practice.comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import practice.comment.model.commentVo;

public class CommentDaoImpl implements ICommentDao {

	@Override
	public List<commentVo> getCommentAll(SqlSession openSession,String bullentin_no) {
		List<commentVo> CommentAll = openSession.selectList("comment.getAllcomment",bullentin_no);
		return CommentAll;
	}


@Override
public int insertComment(SqlSession openSession, commentVo vo) {
	int insertComment = openSession.insert("comment.insertcmt", vo );
	return insertComment;
}


@Override
public int deleteComment(SqlSession openSession, commentVo vo) {
	int deleteComment = openSession.update("comment.updateComment",vo);
	return deleteComment;
}
}