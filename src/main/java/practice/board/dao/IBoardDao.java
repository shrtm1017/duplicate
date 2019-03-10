package practice.board.dao;

import java.util.List;


import practice.board.model.boardVo;


public interface IBoardDao {
	int insertBoard (boardVo vo);
	List<boardVo> boardGetAll();
	
	int deleteBoard (boardVo boardtitle);
	int	updateBoard(boardVo boardtitle);
	boardVo selectBoard (String boardtitle);
}
