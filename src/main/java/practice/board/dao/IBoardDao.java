package practice.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import practice.board.model.boardVo;


public interface IBoardDao {
	int insertBoard (SqlSession openSession,boardVo vo);
	List<boardVo> boardGetAll(SqlSession openSession);
	
	int deleteBoard (SqlSession openSession,boardVo boardtitle);
	int	updateBoard(SqlSession openSession,boardVo boardtitle);
	boardVo selectBoard (SqlSession openSession,String boardtitle);
}
