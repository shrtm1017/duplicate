//package practice.user.dao;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import practice.user.dao.IUserDao;
//import practice.user.dao.UserDaoImpl;
//import practice.user.model.UserVo;
//import test.LogicTestConfig;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//
//public class UserDaoImplTest  extends LogicTestConfig{
//	@Resource(name="userDao")
//	private IUserDao dao ;
//	@Before
//	public void setup(){
//	}
//	@After
//	public void tearDaow(){
//		
//	}
//
////	@Test
////	public void testUserDaoImpl() {
////		/***Given***/
////		/***When***/
////		List<UserVo> userList = dao.getAllUser();
////		for(UserVo userVo : userList)
////			System.out.println(userVo);
////		/***Then***/
////		assertEquals(5, userList.size());
////		assertNotNull(userList);
////	}
//	@Test
//	public void testUserDaoImpl() {
//		/***Given***/
//		/***When***/
//		UserVo userVo =new UserVo();
//		userVo.setMem_id("admin");
//		UserVo user = dao.selectUser(userVo.getMem_id());
//		
//		
//		/***Then***/
//		assertEquals(1, user);
//		assertNotNull(user);
//	}
//	
//	/**
//	* Method : testSelctUserPagingList
//	* 작성자 : PC03
//	* 변경이력 :
//	* Method 설명 : 사용자 페이징 리스트 조회 테스트
//	*/
//	@Test
//	public void testSelctUserPagingList(){
//		/***Given***/
//		//페이지 번호 , 페이지 사이즈 
//		pageVo pageVo =new pageVo(1, 10);
//		/***When***/
//		List<UserVo> userList= dao.selectUserPagingList(pageVo);
//		/***Then***/
//		assertNotNull(userList);
//		assertEquals(10,userList.size());
//
//		
//	}
//	
//	/**
//	* Method : testgetUserCnt
//	* 작성자 : PC03
//	* 변경이력 :
//	* Method 설명 :전체 사용 자수
//	*/
//	@Test
//	public void testgetUserCnt(){
//		/***Given***/
//		/***When***/
//		int userCnt =dao.getUserCnt();
//		/***Then***/
//		assertEquals(117, userCnt);
//		
//	}
//	
//	@Test
//	public void testPagination(){
//		/***Given***/
//		int userCnt =105;
//		int pageSize =10;
//		/***When***/
//		
//		int lastPage =userCnt/pageSize + (userCnt%pageSize > 0 ? 1 :0);
//		/***Then***/
//		assertEquals(11,lastPage);
//
//		
//		
//	}
//	
//	@Test
//	public void testUserInsert(){
//		/***Given***/
//		/***When***/
//		UserVo vo =new UserVo();
//		vo.setUserNm("a");
//		vo.setUserId("b");
//		vo.setZipcode("1");
//		vo.setAddr1("aa");
//		vo.setAddr2("bb");
//		vo.setAlias("aaaaa");
//		vo.setPass("bbbb");
//		int userInsert = dao.insertUser(vo);
//		
//		dao.deleteUser("b");
//		/***Then***/
//		assertEquals(1, userInsert);
//
//		
//	}
//	@Test
//	public void testUserUpdate(){
//		/***Given***/
//		/***When***/
//		UserVo vo =new UserVo();
//		vo.setUserId("aaa");
//		vo.setUserNm("a");
//		vo.setZipcode("1");
//		vo.setAddr1("aa");
//		vo.setAddr2("bb");
//		vo.setAlias("aaaaa");
//		vo.setPass("bbbb");
//		int userUpdate = dao.updateUser(vo);
//		
//		/***Then***/
//		assertEquals(1, userUpdate);
//
//		
//	}
//
//
//}
