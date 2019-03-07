package practice.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import practice.board.model.boardVo;

public class BoardDaoImpl implements IBoardDao{

	@Override
	public int insertBoard(SqlSession openSession, boardVo vo) {
		int insertBoard = openSession.insert("board.insertBoard", vo );
		return insertBoard;
	}

	@Override
	public List<boardVo> boardGetAll(SqlSession openSession) {
		List<boardVo> boardList = openSession.selectList("board.getallBoard");
		return boardList;
	}

	@Override
	public int deleteBoard(SqlSession openSession, boardVo boardtitle) {
		int deleteBoard = openSession.delete("board.deleteBoard", boardtitle );
		return deleteBoard;
	}

	@Override
	public int updateBoard(SqlSession openSession, boardVo boardtitle) {
		int updateBoard= openSession.update("board.updateBoard", boardtitle );
		return updateBoard;
	}

	@Override
	public boardVo selectBoard(SqlSession openSession, String selectBoard) {
		boardVo selectBoardList = openSession.selectOne("board.selectBoard", selectBoard);
		return selectBoardList ;
	}
	

}
