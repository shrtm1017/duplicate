package practice.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import practice.board.model.boardVo;

@Repository("boardDao")
public class BoardDaoImpl implements IBoardDao{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public int insertBoard( boardVo vo) {
		int insertBoard = sqlSessionTemplate.insert("board.insertBoard", vo );
		return insertBoard;
	}

	@Override
	public List<boardVo> boardGetAll() {
		List<boardVo> boardList = sqlSessionTemplate.selectList("board.getallBoard");
		return boardList;
	}

	@Override
	public int deleteBoard(boardVo boardtitle) {
		int deleteBoard = sqlSessionTemplate.delete("board.deleteBoard", boardtitle );
		return deleteBoard;
	}

	@Override
	public int updateBoard( boardVo boardtitle) {
		int updateBoard= sqlSessionTemplate.update("board.updateBoard", boardtitle );
		return updateBoard;
	}

	@Override
	public boardVo selectBoard(String selectBoard) {
		boardVo selectBoardList = sqlSessionTemplate.selectOne("board.selectBoard", selectBoard);
		return selectBoardList ;
	}
	

}
