package practice.bulletin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import practice.bulletin.model.bulletinVo;

public class BulletinDaoImpl implements IBulletinDao{

	@Override
	public int insertBulletin(SqlSession openSession, bulletinVo vo) {
		int insertBulletin = openSession.insert("bulletin.insertbulletin", vo );
		return insertBulletin;
	}

	@Override
	public List<bulletinVo> BulletinGetAll(SqlSession openSession) {
		List<bulletinVo> BulletinList = openSession.selectList("bulletin.getAllbulletin");
		return BulletinList;
	}

	@Override
	public int deleteBulletin(SqlSession openSession, bulletinVo Bulletintitle) {
		int deleteBulletin = openSession.delete("bulletin.deleteBulletin", Bulletintitle );
		return deleteBulletin;
	}

	@Override
	public int updateBulletin(SqlSession openSession, bulletinVo Bulletintitle) {
		int updateBulletin= openSession.update("bulletin.updateBulletin", Bulletintitle );
		return updateBulletin;
	}

	@Override
	public bulletinVo selectBulletin(SqlSession openSession, String selectBulletin) {
		bulletinVo selectBulletinList = openSession.selectOne("bulletin.bulletinDetail", selectBulletin);
		return selectBulletinList ;
	}

	@Override
	public List<bulletinVo> bulletinSelectAll(SqlSession openSession,String selectAll) {
		List<bulletinVo> selectBulletinList = openSession.selectList("bulletin.selectbulletin",selectAll);
		return selectBulletinList ;
	}

	@Override
	public List<bulletinVo> bulletinReply(SqlSession openSession,
			String selectBulletin) {
		List<bulletinVo> bulletinReply = openSession.selectList("bulletin.bulletinRedirect",selectBulletin);
		return bulletinReply ;
	}

	@Override
	public int updateLevel(SqlSession openSession, bulletinVo Bulletintitle) {
		int updateLevel= openSession.update("bulletin.updateLevel", Bulletintitle );
		return updateLevel;
	}

}
