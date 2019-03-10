package practice.user.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import practice.user.model.UserVo;
import test.LogicTestConfig;


public class userDaoTest extends LogicTestConfig{
@Resource(name="userDao")
private	IUserDao userDao;
	@Test
	public void testGetAllUser() {
		/***Given***/
		
		/***When***/
		List<UserVo>userlist=userDao.userGetAll();
		
		/***Then***/
		assertTrue(100>userlist.size());
	}

	@Test
	public void testGetUser() {
		/***Given***/
		
		/***When***/
		UserVo userlist=userDao.selectUser("admin");
		
		/***Then***/
		assertNotNull(userlist);
	}

}
