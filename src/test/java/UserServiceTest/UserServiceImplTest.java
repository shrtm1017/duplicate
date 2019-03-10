package UserServiceTest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import practice.user.model.UserVo;
import practice.user.service.IUserService;
import practice.util.model.pageVo;
import test.LogicTestConfig;

public class UserServiceImplTest extends LogicTestConfig{
	private Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);
	@Resource(name="userService")
	private IUserService userService;

	@Before
	public void setup() {
	}

	@After
	public void tearDown() {
	}

	// @Test
	// public void testUserDaoImpl() {
	// /***Given***/
	// IUserService dao = new UserServiceImpl();
	// /***When***/
	// List<UserVo> userList = dao.usergetAll();
	// for(UserVo userVo : userList)
	// System.out.println(userVo);
	// /***Then***/
	// assertEquals(5, userList.size());
	// assertNotNull(userList);
	// }

	@Test
	public void testUserServiceImpl() {
		/*** Given ***/
		/*** When ***/
		UserVo userVo = new UserVo();
		userVo.setMem_id("admin");
		UserVo user = userService.selectUser(userVo.getMem_id());

		/*** Then ***/
		assertEquals("admin", user.getMem_id());
		assertNotNull(user);
	}

//	@Test
//	public void testSelectUserPagingList() {
//		/*** Given ***/
//		pageVo pageVo = new pageVo(1, 10);
//
//		/*** When ***/
//		Map<String, Object> resultMap = userService.selectUserPagingList(pageVo);
//
//		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
//		int userCnt = (int) resultMap.get("userCnt");
//
//		for (UserVo user : userList) {
//			System.out.println(user);
//		}
//		System.out.println(userCnt);
//
//		/*** Then ***/
//
//		// userList
//		assertNotNull(userList);
//		assertEquals(10, userList.size());
//
//		// userCnt
//		assertEquals(117, userCnt);
//
//	}

//	@Test
//	public void testUserUpdate() {
//		/*** Given ***/
//		/*** When ***/
//		UserVo vo = new UserVo();
//		vo.setUserId("aaa");
//		vo.setUserNm("a");
//		vo.setZipcode("1");
//		vo.setAddr1("aa");
//		vo.setAddr2("bb");
//		vo.setAlias("aaaaa");
//		vo.setPass("bbbb");
//		int userUpdate = userService.updateUser(vo);
//
//		/*** Then ***/
//		assertEquals(1, userUpdate);
//
//	}
//	@Test
//	public void testUserinsert() {
//		/*** Given ***/
//		/*** When ***/
//		UserVo vo = new UserVo();
//		vo.setUserId("aaaTest");
//		vo.setUserNm("a");
//		vo.setZipcode("1");
//		vo.setAddr1("aa");
//		vo.setAddr2("bb");
//		vo.setAlias("aaaaa");
//		vo.setPass("bbbb");
//		int insertUser = userService.insertUser(vo);
//
//		/*** Then ***/
//		assertEquals(1, insertUser);
//
//	}

//	@Test
//	public void encryptPass() {
//		
//		int encryptPass = userService.encryptPass();
//		logger.debug("a"+"encryptPass");
//		assertEquals(114, encryptPass);
//
//	}

}
