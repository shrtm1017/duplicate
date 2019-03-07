package practice.board.service;

import java.util.List;

import practice.board.model.boardVo;

public interface IBoardSerivce {
	int insertBoard (boardVo vo);
	int deleteBoatd (boardVo board_title);
	List<boardVo>boardList();
	int updateBoatd (boardVo board_title);
	boardVo selectBoard (String selectBoard);
}
