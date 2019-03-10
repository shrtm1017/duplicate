package bulletin;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import practice.bulletin.dao.IBulletinDao;
import practice.bulletin.model.bulletinVo;
import practice.util.model.pageVo;
import test.LogicTestConfig;

public class bulletinDaotest extends LogicTestConfig{
	@Resource(name="bulletinDao")
	private	IBulletinDao bulletinDao;
	@Test
	public void testBulletinPagingListt(){
		/***Given***/
		//페이지 번호 , 페이지 사이즈 
		pageVo pageVo =new pageVo(1, 10);
		/***When***/
		List<bulletinVo> BulletinPagingList= bulletinDao.BulletinPagingList(pageVo);
		/***Then***/
		assertNotNull(BulletinPagingList);
		assertEquals(10,BulletinPagingList.size());

		
	}
	@Test
	public void testgetBulletinCnt(){
		/***Given***/
		/***When***/
		int bulletinCnt =bulletinDao.bulletinCnt();
		/***Then***/
		assertEquals(3, bulletinCnt);
		
	}
}
