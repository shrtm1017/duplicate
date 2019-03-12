package practice.comment.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import practice.comment.model.commentVo;
@Repository("commentDao")
public class CommentDaoImpl implements ICommentDao {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<commentVo> getCommentAll(String bullentin_no) {
		List<commentVo> CommentAll =sqlSessionTemplate.selectList("comment.getAllcomment",bullentin_no);
		return CommentAll;
	}


@Override
public int insertComment(commentVo vo) {
	int insertComment =sqlSessionTemplate.insert("comment.insertcmt", vo );
	return insertComment;
}


@Override
public int deleteComment(commentVo vo) {
	int deleteComment =sqlSessionTemplate.update("comment.updateComment",vo);
	return deleteComment;
}
}