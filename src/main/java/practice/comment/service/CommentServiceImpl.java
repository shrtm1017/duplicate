package practice.comment.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import practice.comment.dao.CommentDaoImpl;
import practice.comment.dao.ICommentDao;
import practice.comment.model.commentVo;
import practice.db.mybatis.MybatisSqlSessionFactoy;

public class CommentServiceImpl implements ICommentService{
	private ICommentDao CmtDao;
	public CommentServiceImpl(){
		CmtDao = new CommentDaoImpl();
}

	@Override
	public List<commentVo> commentAll(String bullentin_no) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		List<commentVo> commentAll=CmtDao.getCommentAll(sqlSession,bullentin_no);
		sqlSession.close();
		return commentAll;
	}

	@Override
	public int insertComment(commentVo vo) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		int commentVo= CmtDao.insertComment(sqlSession, vo);
		sqlSession.commit();
		sqlSession.close();
		return commentVo;
	}

	@Override
	public int deleteComment(commentVo vo) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		int commentVo= CmtDao.deleteComment(sqlSession, vo);
		sqlSession.commit();
		sqlSession.close();
		return commentVo;
	}

}


