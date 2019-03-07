package practice.bulletin.service;

import java.util.List;

import practice.bulletin.model.bulletinVo;


public interface IBulletinSerivce {
	int insertBulletin (bulletinVo vo);
	int deleteBulletin (bulletinVo Bulletin_title);
	List<bulletinVo>BulletinList();
	List<bulletinVo>BulletinSelectList(String selectBulletin);
	int updateBulletin (bulletinVo Bulletin_title);
	int	updateLevel(bulletinVo Bulletintitle);
	bulletinVo selectBulletin (String selectBulletin);
	List<bulletinVo> bulletinReply(String selectBulletin);
}
