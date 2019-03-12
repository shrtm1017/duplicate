package practice.bulletin.dao;

import java.util.List;

import practice.bulletin.model.bulletinVo;
import practice.util.model.pageVo;

public interface IBulletinDao {
	int insertBulletin (bulletinVo vo);
	List<bulletinVo> BulletinPagingList(pageVo pagevo);
	int bulletinCnt ();
	List<bulletinVo> bulletinSelectAll(String selectBulletin);
	List<bulletinVo> bulletinReply(pageVo pagevo);
	int deleteBulletin (bulletinVo Bulletintitle);
	int	updateBulletin(bulletinVo Bulletintitle);
	int	updateLevel(bulletinVo Bulletintitle);
	bulletinVo selectBulletin (String Bulletintitle);
}
