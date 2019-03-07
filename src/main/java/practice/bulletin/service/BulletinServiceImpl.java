package practice.bulletin.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import practice.bulletin.dao.BulletinDaoImpl;
import practice.bulletin.dao.IBulletinDao;
import practice.bulletin.model.bulletinVo;
import practice.db.mybatis.MybatisSqlSessionFactoy;

public class BulletinServiceImpl implements IBulletinSerivce{
	private IBulletinDao BulletinDao;
	public BulletinServiceImpl(){
		BulletinDao = new BulletinDaoImpl();
}

	@Override
	public int insertBulletin(bulletinVo vo) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		int bulletinVo= BulletinDao.insertBulletin(sqlSession, vo);
		sqlSession.commit();
		sqlSession.close();
		return bulletinVo;

	}

	@Override
	public List<bulletinVo> BulletinList() {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		List<bulletinVo> BulletinList= BulletinDao.BulletinGetAll(sqlSession);
		sqlSession.close();
		return BulletinList;
	}

	@Override
	public int deleteBulletin(bulletinVo Bulletin_title) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		int deleteBulletin= BulletinDao.deleteBulletin(sqlSession, Bulletin_title);
		sqlSession.commit();
		sqlSession.close();
		return deleteBulletin;
	}


	@Override
	public int updateBulletin(bulletinVo Bulletin_title) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		int updateBulletin= BulletinDao.updateBulletin(sqlSession, Bulletin_title);
		sqlSession.commit();
		sqlSession.close();
		return updateBulletin;
	}

	@Override
	public bulletinVo selectBulletin(String selectBulletin) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		bulletinVo Bulletin= BulletinDao.selectBulletin(sqlSession, selectBulletin);
		sqlSession.close();
		return Bulletin;
	}

	@Override
	public List<bulletinVo> BulletinSelectList(String selectBulletin) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		List<bulletinVo> Bulletin= BulletinDao.bulletinSelectAll(sqlSession, selectBulletin);
		sqlSession.close();
		return Bulletin;
	}

	@Override
	public List<bulletinVo> bulletinReply(String selectBulletin) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		List<bulletinVo> bulletinReply= BulletinDao.bulletinReply(sqlSession, selectBulletin);
		sqlSession.close();

		return bulletinReply;
	}

	@Override
	public int updateLevel(bulletinVo Bulletintitle) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactoy.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		int updateLevel= BulletinDao.updateLevel(sqlSession, Bulletintitle);
		sqlSession.commit();
		sqlSession.close();
		return updateLevel;
	}

}
