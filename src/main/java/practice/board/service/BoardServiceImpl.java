package practice.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import practice.board.dao.BoardDaoImpl;
import practice.board.dao.IBoardDao;
import practice.board.model.boardVo;
import practice.db.mybatis.MybatisSqlSessionFactoy;

public class BoardServiceImpl implements IBoardSerivce{
	private IBoardDao boardDao;
	public BoardServiceImpl(){
		boardDao = new BoardDaoImpl();
}

	@Override
	public int insertBoard(boardVo vo) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		int boardVo= boardDao.insertBoard(sqlSession, vo);
		sqlSession.commit();
		sqlSession.close();
		return boardVo;

	}

	@Override
	public List<boardVo> boardList() {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		List<boardVo> boardList= boardDao.boardGetAll(sqlSession);
		sqlSession.close();
		return boardList;
	}

	@Override
	public int deleteBoatd(boardVo board_title) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		int deleteBoatd= boardDao.deleteBoard(sqlSession, board_title);
		sqlSession.commit();
		sqlSession.close();
		return deleteBoatd;
	}


	@Override
	public int updateBoatd(boardVo board_title) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		int updateBoard= boardDao.updateBoard(sqlSession, board_title);
		sqlSession.commit();
		sqlSession.close();
		return updateBoard;
	}

	@Override
	public boardVo selectBoard(String selectBoard) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		boardVo board= boardDao.selectBoard(sqlSession, selectBoard);
		sqlSession.close();
		return board;
	}

}
