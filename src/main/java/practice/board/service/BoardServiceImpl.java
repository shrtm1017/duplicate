package practice.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import practice.board.dao.BoardDaoImpl;
import practice.board.dao.IBoardDao;
import practice.board.model.boardVo;
import practice.db.mybatis.MybatisSqlSessionFactoy;
@Service("boardService")
public class BoardServiceImpl implements IBoardSerivce{
	@Resource(name="boardDao")
	private IBoardDao boardDao;
	public BoardServiceImpl(){
}

	@Override
	public int insertBoard(boardVo vo) {
		int boardVo= boardDao.insertBoard(vo);
		return boardVo;

	}

	@Override
	public List<boardVo> boardList() {
		List<boardVo> boardList= boardDao.boardGetAll();
		return boardList;
	}

	@Override
	public int deleteBoatd(boardVo board_title) {
		int deleteBoatd= boardDao.deleteBoard(board_title);
		return deleteBoatd;
	}


	@Override
	public int updateBoatd(boardVo board_title) {
		int updateBoard= boardDao.updateBoard(board_title);
		return updateBoard;
	}

	@Override
	public boardVo selectBoard(String selectBoard) {
		boardVo board= boardDao.selectBoard(selectBoard);
		return board;
	}

}
