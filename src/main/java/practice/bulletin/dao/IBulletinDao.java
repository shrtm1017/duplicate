package practice.bulletin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import practice.bulletin.model.bulletinVo;

public interface IBulletinDao {
	int insertBulletin (SqlSession openSession,bulletinVo vo);
	List<bulletinVo> BulletinGetAll(SqlSession openSession);
	List<bulletinVo> bulletinSelectAll(SqlSession openSession,String selectBulletin);
	List<bulletinVo> bulletinReply(SqlSession openSession,String selectBulletin);
	
	int deleteBulletin (SqlSession openSession,bulletinVo Bulletintitle);
	int	updateBulletin(SqlSession openSession,bulletinVo Bulletintitle);
	int	updateLevel(SqlSession openSession,bulletinVo Bulletintitle);
	bulletinVo selectBulletin (SqlSession openSession,String Bulletintitle);
}
