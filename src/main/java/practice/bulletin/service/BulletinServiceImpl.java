package practice.bulletin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import practice.bulletin.dao.IBulletinDao;
import practice.bulletin.model.bulletinVo;
import practice.util.model.pageVo;
@Service("bulletinService")
public class BulletinServiceImpl implements IBulletinSerivce{
	@Resource(name="bulletinDao")
	private IBulletinDao BulletinDao;
	public BulletinServiceImpl(){
}

	@Override
	public int insertBulletin(bulletinVo vo) {
		int bulletinVo= BulletinDao.insertBulletin( vo);
		return bulletinVo;

	}

	@Override
	public int deleteBulletin(bulletinVo Bulletin_title) {
		int deleteBulletin= BulletinDao.deleteBulletin( Bulletin_title);		
		return deleteBulletin;
	}


	@Override
	public int updateBulletin(bulletinVo Bulletin_title) {
		int updateBulletin= BulletinDao.updateBulletin(Bulletin_title);
		return updateBulletin;
	}

	@Override
	public bulletinVo selectBulletin(String selectBulletin) {
		bulletinVo Bulletin= BulletinDao.selectBulletin(selectBulletin);
		return Bulletin;
	}

	@Override
	public List<bulletinVo> BulletinSelectList(String selectBulletin) {
		List<bulletinVo> Bulletin= BulletinDao.bulletinSelectAll(selectBulletin);
		return Bulletin;
	}

	@Override
	public List<bulletinVo> bulletinReply(String selectBulletin) {
		List<bulletinVo> bulletinReply= BulletinDao.bulletinReply(selectBulletin);

		return bulletinReply;
	}

	@Override
	public int updateLevel(bulletinVo Bulletintitle) {
		int updateLevel= BulletinDao.updateLevel(Bulletintitle);
		return updateLevel;
	}

	@Override
	public Map<String,Object> BulletinPagingList(pageVo pageVo) {
		Map<String,Object> resultMap =new HashMap<String, Object>();
		resultMap.put("bulletinList", BulletinDao.BulletinPagingList(pageVo));
		resultMap.put("bulletinCnt", BulletinDao.bulletinCnt());
		
		return resultMap;
	}

	@Override
	public int bulletinCnt() {
		int bulletinCnt= BulletinDao.bulletinCnt();
		return bulletinCnt;
	}

}
