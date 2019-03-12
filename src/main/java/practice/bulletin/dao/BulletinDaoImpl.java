package practice.bulletin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import practice.bulletin.model.bulletinVo;
import practice.util.model.pageVo;
@Repository("bulletinDao")
public class BulletinDaoImpl implements IBulletinDao {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int insertBulletin( bulletinVo vo) {
		int insertBulletin = sqlSessionTemplate.insert("bulletin.insertbulletin", vo);
		return insertBulletin;
	}

	@Override
	public List<bulletinVo> BulletinPagingList(pageVo pagevo) {
		List<bulletinVo> BulletinList =sqlSessionTemplate.selectList("bulletin.bulletinPagingList",pagevo);
		return BulletinList;
	}

	@Override
	public int deleteBulletin( bulletinVo Bulletintitle) {
		int deleteBulletin = sqlSessionTemplate.delete("bulletin.deleteBulletin", Bulletintitle);
		return deleteBulletin;
	}

	@Override
	public int updateBulletin( bulletinVo Bulletintitle) {
		int updateBulletin = sqlSessionTemplate.update("bulletin.updateBulletin", Bulletintitle);
		return updateBulletin;
	}

	@Override
	public bulletinVo selectBulletin( String selectBulletin) {
		bulletinVo selectBulletinList = sqlSessionTemplate.selectOne("bulletin.bulletinDetail", selectBulletin);
		return selectBulletinList;
	}

	@Override
	public List<bulletinVo> bulletinSelectAll( String selectAll) {
		List<bulletinVo> selectBulletinList = sqlSessionTemplate.selectList("bulletin.selectbulletin", selectAll);
		return selectBulletinList;
	}

	@Override
	public List<bulletinVo> bulletinReply(pageVo pagevo) {
		List<bulletinVo> bulletinReply = sqlSessionTemplate.selectList("bulletin.bulletinRedirect",pagevo);
		return bulletinReply;
	}

	@Override
	public int updateLevel( bulletinVo Bulletintitle) {
		int updateLevel = sqlSessionTemplate.update("bulletin.updateLevel", Bulletintitle);
		return updateLevel;
	}

	@Override
	public int bulletinCnt() {
		int bulletinCnt = sqlSessionTemplate.selectOne("bulletin.bulletinCnt");
		return bulletinCnt;
	}

}
