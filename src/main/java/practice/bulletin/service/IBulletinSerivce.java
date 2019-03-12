package practice.bulletin.service;

import java.util.List;
import java.util.Map;

import practice.bulletin.model.bulletinVo;
import practice.util.model.pageVo;

public interface IBulletinSerivce {
	int insertBulletin(bulletinVo vo);

	int deleteBulletin(bulletinVo Bulletin_title);

	public Map<String,Object> BulletinPagingList(pageVo pageVo);

	List<bulletinVo> BulletinSelectList(String selectBulletin);

	int updateBulletin(bulletinVo Bulletin_title);

	int updateLevel(bulletinVo Bulletintitle);

	bulletinVo selectBulletin(String selectBulletin);

	public Map<String,Object> bulletinReply(pageVo pagevo);
	
	int bulletinCnt ();
}
